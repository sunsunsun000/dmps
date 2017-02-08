<#include "../layouts.ftl">
<@layouts cur="role_edit">
<div class="row">
    <div class="col-xs-9 col-sm-9 col-md-9  col-lg-9">
        <ol class="breadcrumb">
            <li><a href="javascript:void(0);">RBAC</a></li>
            <li><a href="javascript:void(0);">系统设置</a></li>
            <li><a href="${context! }/role/list">角色管理</a></li>
            <li class="active">${title! }</li>
        </ol>
    </div>
</div>
<hr/>
<div class="row">
    <form id="editForm" action="${context! }/role/save" method="post">
        <div class="form-horizontal role_set_wrap" role="form">
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">角色名称</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <input type="text" class="form-control" name="roleName" placeholder="请输入角色"
                           value="${(role.name)! }">
                </div>
            </div>
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">角色状态</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="checkbox">
                        <label>
                            <input type="radio" name="stats" value="1"
                                   <#if role.roleStats?default(1) == 1>checked</#if>/>启用
                        </label>
                        <label>
                            <input type="radio" name="stats" value="0"
                                   <#if role.roleStats?default(1) == 0>checked</#if>/>禁用
                        </label>
                    </div>
                </div>
            </div>
            <#if role.createdTime?has_content>
                <div class="form-group">
                    <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">创建时间</label>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" disabled
                               value="${(role.createdTime?string("yyyy-MM-dd HH:mm:ss"))! }">
                    </div>
                </div>
            </#if>
            <div class="col-xs-6 col-xs-offset-2 col-sm-6 col-sm-offset-2 col-md-6  col-md-offset-2 col-lg-6 col-sm-lg-2 ">
                <input type="hidden" name="id" value="${(role.id)! }"/>
                <button type="button" class="btn btn-primary pull-right save">确定</button>
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