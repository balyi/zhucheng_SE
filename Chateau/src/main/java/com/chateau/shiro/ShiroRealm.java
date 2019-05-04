package com.chateau.shiro;

import com.chateau.pojo.User;
import com.chateau.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by tedu on 2017/11/29.
 */
@Controller
public class ShiroRealm extends SimpleAccountRealm {
    @Autowired
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        String pri = userService.findRoleById(((User)principalCollection.getPrimaryPrincipal()).getUserId());

        info.addStringPermission(pri);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();

        User user = userService.getByUserName(token.getUsername());
        if (user != null) {
            //设置用户session
            Session session = SecurityUtils.getSubject().getSession();
            session.setAttribute("user", user);
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        } else {
            return null;
        }
    }
}
