package com.lnh.servlet;

import com.lnh.model.Video;
import com.lnh.model.VideoLink;
import com.lnh.service.videoService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.List;

public class VideoServlet extends HttpServlet{
    public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = null;
        // 获得磁盘文件条目工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 获取文件需要上传到的路径
        String path = request.getRealPath("/upload");
        factory.setRepository(new File(path));
        factory.setSizeThreshold(1024 * 1024);
        ServletFileUpload upload = new ServletFileUpload(factory);
        InputStream in =null;
        byte[] buf=null;
        try {
            List<FileItem> list = (List<FileItem>) upload.parseRequest(request);
            for (FileItem item : list) {
                String name = item.getFieldName();
                if (item.isFormField()) {
                    String value = item.getString("UTF-8");
                    request.setAttribute(name, value);
                }
                else {
                    String value = item.getName();
                    String suffix = value.substring(value.lastIndexOf("."));
                    filename = "pro"+String.valueOf(((new Date()).getTime())%10000000)+suffix;
                    request.setAttribute(name, filename);
                    OutputStream out = new FileOutputStream(new File(path,
                            filename));
                    in = item.getInputStream();
                    int length = 0;
                    buf = new byte[1024];
                    System.out.println("获取上传文件的总共的容量：" + item.getSize());
                    while ((length = in.read(buf)) != -1) {
                        out.write(buf, 0, length);
                    }
                    in.close();
                    out.close();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String v_detail=request.getAttribute("v_detail").toString();
        String coursename=request.getAttribute("coursename").toString();
        int c_id=Integer.parseInt(request.getAttribute("c_id").toString());
        Video video=new Video();
        video.setV_detail(v_detail);
        video.setC_id(c_id);
        video.setV_path(filename);
        boolean flag=videoService.uploadVideo(video);
        if(flag){
            request.getRequestDispatcher("user.jsp").forward(request, response);
        }else{
            request.getRequestDispatcher("uploadVideo.jsp").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method=request.getParameter("method");
        if("upVideo".equals(method)){
            upload(request,response);
        }else if("displayVideo".equals(method)){
            List<VideoLink> listVideo= videoService.displayVideo();
            request.setAttribute("list_displayVideo", listVideo);
            request.getRequestDispatcher("displayVideo.jsp").forward(request, response);
        }
    }
}
