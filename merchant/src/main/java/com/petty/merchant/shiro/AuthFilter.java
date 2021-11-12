package com.petty.merchant.shiro;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthFilter extends AuthenticatingFilter {

    @Override
    protected AuthenticationToken createToken(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        return null;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpSession session = httpServletRequest.getSession();
        if (null == session) {
            HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
            httpResponse.setContentType("applcaiton/json");
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setStatus(201);
            JSONObject obj = new JSONObject();
            obj.put("status", 403);
            obj.put("msg", "请登录");
            httpResponse.getWriter().print(obj);
            return false;
        }
        return executeLogin(servletRequest, servletResponse);
    }
}
