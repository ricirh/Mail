package com.petty.merchant.service.impl;

import com.petty.merchant.service.MerchantService;
import com.petty.merchant.vo.MerchantLoginVO;
import org.apache.dubbo.config.annotation.Service;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

@Service
public class MerchantServiceImpl implements MerchantService {
    @Override
    public void login(MerchantLoginVO loginVO) {
        UsernamePasswordToken token = new UsernamePasswordToken(loginVO.getUsername(), loginVO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }
}
