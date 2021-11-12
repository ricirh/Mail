package com.petty.merchant.shiro;


import com.petty.merchant.dao.MerchantDao;
import com.petty.merchant.entity.Merchant;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    MerchantDao merchantDao;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof UsernamePasswordToken;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        Merchant merchant = merchantDao.findMerchantByNameAndPW(token.getUsername(), String.valueOf(token.getPassword()));
        if(null == merchant){
            throw new UnknownAccountException("用户名或密码错误");
        }
        return new SimpleAuthenticationInfo(merchant, token.getPassword(), "AuthRealm");
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
