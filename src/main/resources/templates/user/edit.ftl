<#include "../layouts.ftl">
<@layouts cur="user_edit">
<div class="row">
    <div class="col-xs-9 col-sm-9 col-md-9  col-lg-9">
        <ol class="breadcrumb">
            <li><a href="#">RBAC</a></li>
            <li><a href="#">系统设置</a></li>
            <li class="active">新增用户</li>
        </ol>
    </div>
</div>
<hr/>
<div class="row">
    <form id="editForm" action="${context! }/user/save" method="post">
        <div class="form-horizontal user_set_wrap" role="form">
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">登录名称</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <input type="text" class="form-control" name="username" placeholder="请输入登录名称"
                           value="${(user.loginName)! }"
                           <#if user.id?has_content && user.loginName?has_content>disabled</#if>>
                </div>
            </div>
            <#if !user.id?has_content>
                <div class="form-group">
                    <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">登录密码</label>
                    <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                        <input type="text" class="form-control" name="password" placeholder="请输入登录密码" value="">
                    </div>
                </div>
            </#if>
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">用户状态</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="checkbox">
                        <label>
                            <input type="radio" name="stats" value="1"
                                   <#if user.userStats?default(1) == 1>checked</#if>/>启用
                        </label>
                        <label>
                            <input type="radio" name="stats" value="0"
                                   <#if user.userStats?default(1) == 0>checked</#if>/>禁用
                        </label>
                    </div>
                </div>
            </div>

            <!--所属角色-->
            <div class="form-group">
                <label class="col-xs-2 col-sm-2 col-md-2 col-lg-2 control-label">所属角色</label>
                <div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
                    <div class="checkbox">
                        <#assign rids = listRoleId />
                        <#if listRoles?exists>
                            <#list listRoles as item>
                                <label>
                                    <input type="checkbox" name="role_ids[]" value="${(item.id)! }"
                                           <#if rids?seq_contains(item.id)>checked</#if>/>
                                ${(item.name)! }
                                </label>
                            </#list>
                        </#if>
                    </div>
                </div>
            </div>

            <div class="col-xs-6 col-xs-offset-2 col-sm-6 col-sm-offset-2 col-md-6  col-md-offset-2 col-lg-6 col-sm-lg-2 ">
                <input type="hidden" name="id" value="${(user.id)! }">
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