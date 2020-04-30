package com.lnh.service;

public interface MediaService {

    /**
     * 视频转码
     * @param srcFilePath  用于指定要转换格式的文件,要截图的视频源文件
     * @param codcFilePath 格式转换后的的文件保存路径
     * @param mediaPicPath 截图保存路径
     * @return
     */
    public boolean executeCodecs(String srcFilePath, String codcFilePath, String mediaPicPath);
}
