<#include "../layouts.ftl">
<@layouts cur="role_list">
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <ol class="breadcrumb">
            <li><a href="#">RBAC</a></li>
            <li><a href="#">系统设置</a></li>
            <li class="active">角色列表</li>
        </ol>
    </div>
</div>
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12  col-lg-12">
        <a href="${context! }/role/add" class="btn btn-link pull-left">添加角色</a>
    </div>
</div>
<hr/>
<div class="table-responsive">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>角色名称</th>
            <th>角色状态</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <#if listRole?exists>
                <#list listRole as item>
                <tr>
                    <td>${item.name! }</td>
                    <td>${item.statsText! }</td>
                    <td>${(item.createdTime)?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td>
                        <a href="${context! }/role/${item.id}/edit">编辑</a>
                        <a href="${context! }/role/${item.id}/access">设置权限</a>
                    </td>
                </tr>
                </#list>
            <#else>
            <tr>
                <td colspan="2">暂无数据</td>
            </tr>
            </#if>
        </tbody>
    </table>
</div>
</@layouts>