<#include "../layouts.ftl">
<@layouts cur="role_access">
<div class="row">
    <div class="col-xs-9 col-sm-9 col-md-9  col-lg-9">
        <ol class="breadcrumb">
            <li><a href="javascript:void(0);">RBAC</a></li>
            <li><a href="javascript:void(0);">系统设置</a></li>
            <li><a href="${context! }/role/list">角色管理</a></li>
            <li class="active">${(role.name)! }角色-设置权限</li>
        </ol>
    </div>
</div>
<hr/>
<div class="row">
    <form id="editForm" action="${context! }/role/save/access" method="post">
        <div class="form-horizontal role_access_set_wrap" role="form">
            <div class="form-group">
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="checkbox">
                        <#if listResources?exists>
                            <#list listResources as item>
                                <label>
                                    <input type="checkbox" name="access_ids[]" value="${(item.id)! }"/>
                                ${(item.name)! }
                                </label>
                            </#list>
                        </#if>
                    </div>
                </div>
            </div>
            <div class="col-xs-6 col-xs-offset-2 col-sm-6 col-sm-offset-2 col-md-6  col-md-offset-2 col-lg-6 col-sm-lg-2 ">
                <input type="hidden" name="id" value="${(role.id)! }">
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