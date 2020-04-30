<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script src="http://lib.sinaapp.com/js/jquery/1.9.1/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/displayvideo.js"></script>
    <title>显示视频</title>
</head>
<body>
<table border="0"cellspacing="0" cellpadding="0">
    <tr>
        <td style="width:50px;text-align: center">序号</td>
        <td style="width:100px;text-align: center">视频内容</td>
        <td style="text-align: center">视频</td>
        <td style="text-align: center">课程代号</td>
        <td style="width:100px;text-align: center">课程名称</td>
    </tr>


    <c:forEach items="${list_displayVideo}" var="video" varStatus="i">
        <tr style="background: #FAEBD7">
            <td style="width:50px;text-align: center">${i.count} </td>
            <td style="text-align: center"><font style="font-size:12px;">${video.v_detail}</font></td>
            <td style="text-align: center">
                <div id="box">
                    <video id="video" controls preload="auto" width="100px" height="50px">
                        <source src="upload/${video.v_path}" type="video/mp4">
                    </video>
                </div>
            </td>
            <td style="width:100px;text-align: center">${video.c_id}</td>
            <td style="width:100px;text-align: center">${video.c_name}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>