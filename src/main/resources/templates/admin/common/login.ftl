<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>RBAC-基于角色的访问控制</title>      <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="${static! }/bootstrap/css/bootstrap.min.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->     <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>     <![endif]-->
    <style type="text/css">        * {
        margin: 0;
        padding: 0;
    }

    body {
        background: url(${static! }/images/wallpaper6_h600.jpg) center no-repeat;
        font-family: "宋体";
    }

    .loginBox {
        width: 420px;
        height: 280px;
        padding: 0 20px;
        border: 1px solid #fff;
        color: #000;
        border-radius: 8px;
        background: white;
        box-shadow: 0 0 15px #222;
        background: -moz-linear-gradient(top, #fff, #efefef 8%);
        background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6), to(#f4f4f4));
        font: 11px/1.5em 'Microsoft YaHei';
        position: absolute;
        left: 50%;
        top: 50%;
        margin-left: -210px;
        margin-top: -165px;
    }

    .loginBox h2 {
        height: 45px;
        font-size: 20px;
        font-weight: normal;
    }

    .loginBox .left {
        border-right: 1px solid #ccc;
        height: 100%;
        padding-right: 20px;
    }

    .regBtn {
        margin-top: 21px;
    }     </style>
</head>
<body>
<div class="container">
    <div class="loginBox row"><h2 class="text-center">RBAC-基于角色的访问控制</h2>
        <form id="wyccn" name="wyccn" action="${context! }/login" method="post" class="form-horizontal">
            <div class="form-group has-success">
                <label for="nick_name" class="col-sm-3 col-md-3 control-label">用户名</label>
                <div class="col-sm-8 col-md-8">
                    <input type="text" class="form-control" name="username" placeholder="用户名" value="">
                </div>
            </div>
            <div class="form-group has-success">
                <label for="user_password" class="col-sm-3 col-md-3 control-label">密码</label>
                <div class="col-sm-8 col-md-8">
                    <input type="password" class="form-control" name="password" placeholder="密码">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10" style="color: #990033;"></div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-4 col-sm-10 col-md-10">
                    <input type="hidden" name="url" value="${context! }/login"/>
                    <button class="btn btn-info" data-loading-text="正在登录..." type="submit">登 录</button>
                    <button class="btn btn-info" type="reset">清 空</button>
                </div>
            </div>
        </form>
    </div>
</div>    <!-- Bootstrap core JavaScript -->
<script src="${static! }/jquery/jquery.min.js"></script>
<script src="${static! }/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>