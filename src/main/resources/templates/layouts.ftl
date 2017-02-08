<#macro layouts cur="default">
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Title</title>

    <link rel="stylesheet" type="text/css" href="${static! }/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="${static! }/css/app.css">

    <script src="${static! }/jquery/jquery.min.js"></script>
</head>
<body>

<!--导航条-->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">RBAC</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
            <#--<li><a href="/">首页</a></li>-->
            </ul>
            <p class="navbar-text navbar-right">Hi, tanbobo</p>
        </div>
    </div>
</nav>

<!--菜单栏和内容区域-->
<div class="container-fluid">
    <div class="col-sm-2 col-md-2 col-lg-2 sidebar">
        <ul class="nav nav-sidebar">
            <li>权限演示页面</li>
            <li class="<#if cur?contains("page1")>active</#if>"><a href="${context! }/page1">测试页面一</a></li>
            <li class="<#if cur?contains("page2")>active</#if>"><a href="${context! }/page2">测试页面二</a></li>
            <li class="<#if cur?contains("page3")>active</#if>"><a href="${context! }/page3">测试页面三</a></li>
            <li class="<#if cur?contains("page4")>active</#if>"><a href="${context! }/page4">测试页面四</a></li>
            <li class="<#if cur?contains("page5")>active</#if>"><a href="${context! }/page5">测试页面五</a></li>
            <li>系统设置</li>
            <li class="<#if cur?contains("user_")>active</#if>"><a href="${context! }/user/list">用户管理</a></li>
            <li class="<#if cur?contains("role_")>active</#if>"><a href="${context! }/role/list">角色管理</a></li>
            <li class="<#if cur?contains("access_")>active</#if>"><a href="${context! }/access/list">权限管理</a></li>
        </ul>
    </div>
    <div class="col-sm-10 col-sm-offset-2 col-md-10  col-md-offset-2 col-lg-10 col-lg-offset-2 main">
        <#nested>

        <hr/>
        <footer>
            <p class="pull-left">@Tanbobo</p>
            <p class="pull-right">Power By boke网 www.tanbobo.com </p>
        </footer>
    </div>
</div>

</body>
</html>
</#macro>