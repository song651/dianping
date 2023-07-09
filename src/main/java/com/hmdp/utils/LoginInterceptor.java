package com.hmdp.utils;

import com.hmdp.dto.UserDTO;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        public class UserHolder {
//            private static final ThreadLocal<UserDTO> tl = new ThreadLocal<>();
//
//            public static void saveUser(UserDTO user){
//                tl.set(user);
//            }
//
//            public static UserDTO getUser(){
//                return tl.get();
//            }
//
//            public static void removeUser(){
//                tl.remove();
//            }
//        }
        // 1.判断是否需要拦截（ThreadLocal中是否有用户）
        if (UserHolder.getUser() == null) {
            // 没有，需要拦截，设置状态码
            response.setStatus(401);
            // 拦截
            return false;
        }
        // 有用户，则放行
        return true;
    }
}
