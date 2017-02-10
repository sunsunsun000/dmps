package com.tanbobo.dmps.base.security;

import com.tanbobo.dmps.common.util.IpUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: LoginSuccessHandler
 * Author: tandingbo
 * CreateTime: 2017-02-09 23:00
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {
        //获得授权后可得到用户信息   可使用SUserService进行数据库操作
        SysUserDetails userDetails = (SysUserDetails) authentication.getPrincipal();
       /* Set<SysRole> roles = userDetails.getSysRoles();*/
        //输出登录提示信息
        System.out.println("管理员 " + userDetails.getUsername() + " 登录");

        System.out.println("IP :" + IpUtil.ipAddress(request));

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
