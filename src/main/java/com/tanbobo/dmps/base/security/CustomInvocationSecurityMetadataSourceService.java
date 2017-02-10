package com.tanbobo.dmps.base.security;

import com.tanbobo.dmps.mapper.SysResourceMapper;
import com.tanbobo.dmps.mapper.SysRoleMapper;
import com.tanbobo.dmps.model.SysResource;
import com.tanbobo.dmps.model.SysRole;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。
 * ClassName: CustomInvocationSecurityMetadataSourceService
 * Author: tandingbo
 * CreateTime: 2017-02-10 23:40
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysResourceMapper sysResourceMapper;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

    /**
     * 被@PostConstruct修饰的方法会在服务器加载Servle的时候运行，并且只会被服务器执行一次。
     * PostConstruct在构造函数之后执行,init()方法之前执行。
     */
    @PostConstruct
    private void loadResourceDefine() {
        /*
         * 应当是资源为key， 权限为value。
         * 资源通常为url， 权限就是那些以ROLE_为前缀的角色。
         * 一个资源可以由多个权限来访问。
         */
        resourceMap = new HashMap<>();

        List<SysRole> listSysRole = sysRoleMapper.findAllSysRole();
        if (CollectionUtils.isNotEmpty(listSysRole)) {
            for (SysRole role : listSysRole) {
                ConfigAttribute ca = new SecurityConfig(role.getName());
                List<String> query = new ArrayList<>();

                List<SysResource> sysResourceList = sysResourceMapper.findByRoleId(role.getId());
                if (CollectionUtils.isNotEmpty(sysResourceList)) {
                    for (SysResource resource : sysResourceList) {
                        String url = resource.getUrls();
                        /*
                         * 判断资源文件和权限的对应关系，如果已经存在相关的资源url，
                         * 则要通过该url为key提取出权限集合，将权限增加到权限集合中。
                         */
                        if (resourceMap.containsKey(url)) {
                            Collection<ConfigAttribute> value = resourceMap.get(url);
                            value.add(ca);
                            resourceMap.put(url, value);
                        } else {
                            Collection<ConfigAttribute> atts = new ArrayList<>();
                            atts.add(ca);
                            resourceMap.put(url, atts);
                        }
                    }
                }
            }
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return new ArrayList<>();
    }

    /**
     * 根据URL，找到相关的权限配置。
     *
     * @param object
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //object 是一个URL，被用户请求的url。
        FilterInvocation filterInvocation = (FilterInvocation) object;
        if (resourceMap == null) {
            loadResourceDefine();
        }
        
        for (String resURL : resourceMap.keySet()) {
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if (requestMatcher.matches(filterInvocation.getHttpRequest())) {
                return resourceMap.get(resURL);
            }
        }

        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
