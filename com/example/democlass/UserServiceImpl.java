package com.example.democlass;

public class UserServiceImpl implements UserService {
    @Override
    public void save() {
        System.out.println("save");
    }

    @Override
    public int add(int a, int b) {
        System.out.println("add");
        return a+b;
    }
}
