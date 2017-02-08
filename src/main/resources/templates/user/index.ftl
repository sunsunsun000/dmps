<#include "../layouts.ftl">
<@layouts cur="user_list">
<div class="row">
    <div class="col-xs-9 col-sm-9 col-md-9  col-lg-9">
        <ol class="breadcrumb">
            <li><a href="#">RBAC</a></li>
            <li><a href="#">系统设置</a></li>
            <li class="active">用户列表</li>
        </ol>
    </div>
    <div class="col-xs-3 col-sm-3 col-md-3  col-lg-3">
        <a href="${context! }/user/add" class="btn btn-link pull-right">添加用户</a>
    </div>
</div>
<hr/>
<div class="table-responsive">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>登录名称</th>
            <th>用户状态</th>
            <th>最后登录时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <#if listUser?exists>
                <#list listUser as item>
                <tr>
                    <td>${item.loginName}</td>
                    <td>${item.statsText}</td>
                    <td>${(item.modifiedTime)?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td>
                        <a href="${context! }/user/${item.id}/edit">编辑</a>
                    </td>
                </tr>
                </#list>
            <#else>
            <tr>
                <td colspan="3">暂无用户</td>
            </tr>
            </#if>
        </tbody>
    </table>
</div>
</@layouts>