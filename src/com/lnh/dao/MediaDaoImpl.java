package com.lnh.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 70888
 */
public class MediaDaoImpl implements MediaDao {

    @Override
    public boolean isConvertFLV(String file) {
        boolean result = false;
        String ext = file.substring(file.lastIndexOf(".") + 1, file.length()).toLowerCase();
        if (ext.equals("avi")) {
            result = true;
        } else if (ext.equals("mpg")) {
            result = true;
        } else if (ext.equals("wmv")) {
            result = true;
        } else if (ext.equals("3gp")) {
            result = true;
        } else if (ext.equals("mov")) {
            result = true;
        } else if (ext.equals("mp4")) {
            result = true;
        } else if (ext.equals("asf")) {
            result = true;
        } else if (ext.equals("asx")) {
            result = true;
        } else if (ext.equals("flv")) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean isConvertAVI(String file) {
        boolean result = false;
        String ext = file.substring(file.lastIndexOf(".") + 1, file.length()).toLowerCase();
        if (ext.equals("wmv9")) {
            result = true;
        } else if (ext.equals("rm")) {
            result = true;
        } else if (ext.equals("rmvb")) {
            result = true;
        }
        return result;
    }

    @Override
    public boolean executeCodecs(String srcFilePath, String codcFilePath, String mediaPicPath) {
        String basePath = System.getProperty("user.dir");
        String mencoderPath = "C:\\Users\\70888\\IdeaProjects\\MusicVideo\\web\\tools\\mencoder.exe";
        String ffmpegPath = "C:\\Users\\70888\\IdeaProjects\\MusicVideo\\web\\tools\\ffmpeg.exe";
        boolean mark = true;
        String tempPath = basePath + File.separator + "temp" + File.separator + String.valueOf(System.currentTimeMillis())+ ".avi";
        if(isConvertAVI(srcFilePath)){
            mark = this.convertAVI(mencoderPath, srcFilePath, tempPath);
            srcFilePath = tempPath;
        }
        if(isConvertFLV(srcFilePath) && mark){
            mark = this.convertFLV(ffmpegPath, srcFilePath, codcFilePath);
            mark = this.cutPic(ffmpegPath, srcFilePath, mediaPicPath);
        }else{
            System.out.println("该视频格式无法转换");
            mark = false;
        }
        this.deleteAVIFile(tempPath);
        return mark;
    }

    private boolean convertFLV(String ffmpegPath,String srcFilePath, String codcFilePath) {
        File file = new File(ffmpegPath);
        File srcFile = new File(srcFilePath);
        if(file.exists()){
            System.out.println("转换工具存在");
        }
        if(srcFile.exists()){
            System.out.println("源视频存在");
        }
        List<String> convert = new ArrayList<String>();
        convert.add(ffmpegPath);
        convert.add("-i");
        convert.add(srcFilePath);
        convert.add("-ab");
        convert.add("128");
        convert.add("-ac");
        convert.add("2");
        convert.add("-qscale");
        convert.add("6");
        convert.add("-ar");
        convert.add("22050");
        convert.add("-r");
        convert.add("29.97");
        convert.add("-b");
        convert.add("5942.13");
        convert.add("-s");
        convert.add("1280x720");
        convert.add("-y");
        convert.add(codcFilePath);
        boolean mark = true;
        try {
            Process proc = new ProcessBuilder(convert).redirectErrorStream(true).start();
            BufferedReader stdout = new BufferedReader(
                    new InputStreamReader(proc.getInputStream()));
            String line;
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            mark = false;
            System.out.println(e);
            e.printStackTrace();
        }
        return mark;
    }

    private Boolean cutPic(String ffmpegPath, String srcFilePath, String mediaPicPath) {
        // 创建一个List集合来保存从视频中截取图片的命令
        List<String> cutpic = new ArrayList<String>();
        cutpic.add(ffmpegPath);
        cutpic.add("-i");
        cutpic.add(srcFilePath);
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss");
        cutpic.add("7");
        cutpic.add("-t");
        cutpic.add("0.001");
        cutpic.add("-s");
        cutpic.add("800*280");
        cutpic.add(mediaPicPath);

        boolean mark = true;
        ProcessBuilder builder = new ProcessBuilder();
        try {
            builder.command(cutpic);
            builder.redirectErrorStream(true);
            builder.start();
        } catch (Exception e) {
            mark = false;
            System.out.println(e);
            e.printStackTrace();
        }
        return mark;
    }

    private boolean convertAVI(String mencoderPath,String srcFilePath, String codcFilePath) {
        List<String> commend = new ArrayList<String>();
        commend.add(mencoderPath);
        commend.add(srcFilePath);
        commend.add("-oac");
        commend.add("lavc");
        commend.add("-lavcopts");
        commend.add("acodec=mp3:abitrate=64");
        commend.add("-ovc");
        commend.add("xvid");
        commend.add("-xvidencopts");
        commend.add("bitrate=600");
        commend.add("-of");
        commend.add("avi");
        commend.add("-o");
        commend.add(codcFilePath);
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(commend);
            builder.redirectErrorStream(true);
            Process p = builder.start();
            p.getInputStream();
            p.waitFor();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public void deleteAVIFile(String tempFile) {
        File file = new File(tempFile);
        if(file.exists()){
            file.delete();
        }
    }

}