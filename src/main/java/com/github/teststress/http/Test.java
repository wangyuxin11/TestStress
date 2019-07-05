package com.github.teststress.http;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

public class Test {

	
	//模拟并发测试
	public static void main(String[] args) throws InterruptedException, ExecutionException{

        //模拟并发数
        int concurrencyNumber = 1000;
        
        List<String>  resList = Lists.newArrayList();
        
        //执行线程池
        ExecutorService ex = Executors.newFixedThreadPool(100);
        
        String url = "www.baidu.com";
        
        Map<String, String> mapPatam = new HashMap<>();
        mapPatam.put("name", "测试");
        
        for(int i =0 ; i< concurrencyNumber; i++){
            Future<String> callRes = ex.submit(new HttpCallable(url, JSON.toJSONString(mapPatam)));
            resList.add(i + ">>>" + callRes.get());
        }
        
        for(String s : resList){
            System.out.println("------>" + s);
        }
    
	}

}
