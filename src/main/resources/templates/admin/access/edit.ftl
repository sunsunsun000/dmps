<#include "../layouts.ftl">
<@layouts cur="access_edit">
<div class="row">
    <div class="col-xs-9 col-sm-9 col-md-9  col-lg-9">
        <ol class="breadcrumb">
            <li><a href="javascript:void(0);">RBAC</a></li>
            <li><a href="javascript:void(0);">系统设置</a></li>
            <li><a href="${context! }/role/list">权限管理</a></li>
            <li class="active">${title! }</li>
        </ol>
    </div>
</div>
<hr/>
<div class="row">
    <form id="editForm" action="${context! }/access/save" method="post">
        <div class="form-horizontal access_set_wrap" role="form">
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">权限名称</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <input type="text" class="form-control" name="name" placeholder="请输入权限名称"
                           value="${(access.name)! }">
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">Urls</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <textarea class="form-control" rows="5" placeholder="请输入url"
                              name="urls">${(access.urls)! }</textarea>
                </div>
            </div>
            <div class="col-xs-6 col-xs-offset-2 col-sm-6 col-sm-offset-2 col-md-6  col-md-offset-2 col-lg-6 col-sm-lg-2 ">
                <input type="hidden" name="id" value="${(access.id)! }">
                <button type="button" class="btn btn-primary pull-right  save">确定</button>
            </div>
        </div>
    </form>
</div>

    <#if msg?has_content>
    <div class="alert alert-danger" role="alert" style="margin-top: 20px;">
    ${msg! }
    </div>
    </#if>
<script>
    $(document).ready(function () {
        $(".save").click(function () {
            $("#editForm").submit();
        });
    });
</script>
</@layouts>