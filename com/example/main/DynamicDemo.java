package com.example.main;

import com.example.cglibdynamic.UserDemoInterceptor;
import com.example.democlass.UserDemo;
import com.example.democlass.UserService;
import com.example.democlass.UserServiceImpl;
import com.example.jdkdynamic.UserServiceInvocationHandler;
import com.example.jdkdynamic.UserServiceProxy;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class DynamicDemo {
        public static void main(String[] args) {
            UserService userService = new UserServiceImpl();
            userService.save();
            UserService userService1 =(UserService) Proxy.newProxyInstance(userService.getClass().getClassLoader(),userService.getClass().getInterfaces(),
                    new UserServiceInvocationHandler(userService));
            userService1.save();
            UserService userService2 = new UserServiceProxy(userService, new UserServiceInvocationHandler(userService));
            userService2.save();
            System.out.println(userService2.add(1,2));

            UserDemo userDemo = new UserDemo();
            userDemo.save();
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(UserDemo.class);
            enhancer.setCallback(new UserDemoInterceptor());
            UserDemo userDemoProxy = (UserDemo) enhancer.create();
            userDemoProxy.save();
        }
}
