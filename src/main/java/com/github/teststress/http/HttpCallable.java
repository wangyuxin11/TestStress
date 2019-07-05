package com.github.teststress.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

/**
 * 异步执行HTTP请求
 */
public class HttpCallable implements Callable<String> {
    
    private String url;
    
    private String jsonParams;
    
    public HttpCallable(String url, String jsonParams){
        this.url = url;
        this.jsonParams = jsonParams;
    }

    /**
     * 执行并返回结果
     */
    @Override
    public String call() throws Exception {
        return HttpTool.requestPost(url, jsonParams);
    }
    

}