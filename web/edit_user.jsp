<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>修改个人信息</title>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <h1>Hello, ${user.name}!</h1>
    </div>
    <div class="page-header">
        <h3><small>个人信息</small></h3>
    </div>
    <form class="form-horizontal" action="/editUser.do" method="post">
        <input id="id" name="id" type="hidden" value="${user.id}">
        <div class="form-group">
            <label for="name" class="col-sm-2 control-label">用户 ：</label>
            <div class="col-sm-6">
                <input name="name" class="form-control" id="name" value="${user.name}" readonly>
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">密码 ：</label>
            <div class="col-sm-6">
                <input name="password" class="form-control" id="password" value="${user.password}">
            </div>
        </div>

        <div class="form-group">
            <label for="phone" class="col-sm-2 control-label">电话 ：</label>
            <div class="col-sm-8">
                <input name="phone"  class="form-control" id="phone" value="${user.phone}">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
    </form>
</div>
</body>
</html>
