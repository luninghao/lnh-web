<%@ page contentType="text/html;charset=UTF-8"%>
<body background="image/bk_hero.jpg">
<div id="upld" style="height:300px;width:300px;margin-left: 300px;margin-top: 100px;">
    <table>
        <form action="VideoServlet?method=upVideo" method="post" enctype="multipart/form-data" target="middle">
            <tr>
                <td style="text-align:center;"colspan="2"><font size="5">上传课程</font></td>
            </tr>
            <tr>
                <td height="40px"><div style="width:100px">视频内容:</div></td>
                <td><input type="text" name="v_detail" id="v_detail"></td>
            </tr>
            <tr>
                <td height="40px" >上传视频：</td>
                <td><input type="file" name="v_video" id="v_video"></td>
            </tr>

            <tr>
                <td height="40px">课程名称：</td>
                <td>
                    <select name="coursename" id="coursename">
                        <option value="0">请你选择以下数据</option>
                        <c:forEach items="${list_displaycourse_name}" var ="course">
                            <option value="${course.c_name}">${course.c_name}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>

            <tr>
                <td height="40px">课程代号：</td>
                <td>
                    <select name="c_id" id="c_id">
                        <option value="0">请你选择以下数据</option>
                        <c:forEach items="${list_displaycourse_name}" var ="course">
                            <option value="${course.c_id}">${course.c_id}</option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td><input type="reset" value="重置"></td>
                <td style="padding-left:100px"><input type="submit" value="上传"></td>
            </tr>
        </form>
    </table>
</div>
</body>