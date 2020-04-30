<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta charset="UTF-8">
        <title>音乐视频网站</title>
    </head>
    <body>
        <h1>登录成功</h1>
        <header>
            <div class="container">

                <nav>
                    <a href="/userInfo.do">个人中心</a>
                </nav>
                <nav>
                    <a href="/comic.do">动漫类</a>
                </nav>
                <nav>
                    <a href="/music.do">音乐类</a>
                </nav>
                <nav>
                    <a href="/film.do">电影类</a>
                </nav>
                <nav>
                    <a href="/uploadVideo.jsp">视频上传</a>
                </nav>
                <nav>
                    <a href="/displayVideo.jsp">视频查看</a>
                </nav>

            </div>
        </header>
        <section class="page">
            <div class="container">
                <div id="pagefy">
                    <ul>
                        <form id="messageForm" action="/success.jsp" method="post">
                            <input type="hidden" id="page" name="page" value="${page}">
                            <input type="hidden" id="last" name="last" value="${last}">
                            <li><a href="javascript:void(0)" onclick="submitMessageForm('first')">首页</a></li>
                            <li><a href="javascript:void(0)" onclick="submitMessageForm('pre')">上一页</a></li>
                            <li><a href="javascript:void(0)">当前第${page}页</a></li>
                            <li><a href="javascript:void(0)" onclick="submitMessageForm('next')">下一页</a></li>
                            <li><a href="javascript:void(0)" onclick="submitMessageForm('last')">尾页</a></li>
                        </form>
                    </ul>
                </div>
            </div>
        </section>
    </body>
</html>