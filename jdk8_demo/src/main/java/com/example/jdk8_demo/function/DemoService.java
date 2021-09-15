package com.example.jdk8_demo.function;

public class DemoService {

    public void demoMethod() {
        FunctionUtil.lock("ceshi", this::success, this::failed);
    }


    public void success(String key) {
        System.out.println("成功执行");
    }

    public void failed(String key) {
        System.out.println("失败执行");
    }

}
