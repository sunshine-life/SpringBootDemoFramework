package org.example;

import org.springframework.stereotype.Service;


@Service
public class OrgService {
    public OrgService(){
    }
    public String test(){
        System.out.println("测试服务");
        return "呵呵";
    }
}
