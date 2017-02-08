<#include "../layouts.ftl">
<@layouts cur="access_list">
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
        <ol class="breadcrumb">
            <li><a href="#">RBAC</a></li>
            <li><a href="#">系统设置</a></li>
            <li class="active">权限列表</li>
        </ol>
    </div>
</div>
<div class="row">
    <div class="col-xs-12 col-sm-12 col-md-12  col-lg-12">
        <a href="${context! }/access/add" class="btn btn-link pull-left">添加权限</a>
    </div>
</div>
<hr/>
<div class="table-responsive">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>权限名称</th>
            <th>权限Url地址</th>
            <th>权限状态</th>
            <th>创建时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
            <#if listResource?exists && listResource?has_content>
                <#list listResource as item>
                <tr>
                    <td>${item.name}</td>
                    <td>${item.urls}</td>
                    <td>${item.statsText}</td>
                    <td>${(item.createdTime)?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td>
                        <a href="${context! }/access/${item.id}/edit">编辑</a>
                    </td>
                </tr>
                </#list>
            <#else>
            <tr>
                <td colspan="5">暂无权限</td>
            </tr>
            </#if>
        </tbody>
    </table>
</div>
</@layouts>