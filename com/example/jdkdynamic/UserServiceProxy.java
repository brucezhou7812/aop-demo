package com.example.jdkdynamic;

import com.example.democlass.UserService;

public class UserServiceProxy implements UserService {

    private final UserService userService;
    private final UserServiceInvocationHandler handler;

    public UserServiceProxy(UserService userService,UserServiceInvocationHandler handler) {
        this.userService = userService;
        this.handler = handler;
    }

    @Override
    public void save() {
        try {
            handler.invoke(this.userService, this.userService.getClass().getMethod("save"), null);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int add(int a, int b) {
        try {
            Object result = handler.invoke(this.userService, this.userService.getClass().getMethod("add", int.class,int.class), new Object[]{a,b});
            return (int) result;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
