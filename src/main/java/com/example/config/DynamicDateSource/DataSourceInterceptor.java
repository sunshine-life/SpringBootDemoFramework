package com.example.config.DynamicDateSource;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect    // for aop
@Component // for auto scan
@Order(0)  // execute before @Transactional
public class DataSourceInterceptor {
    @Pointcut("execution(public * com.example.service..*.showDao(..))")
    public void dataSourceSlave(){};

    @Before("dataSourceSlave()")
    public void before(JoinPoint jp) {
        System.out.println("选择读取");
        DataSourceTypeManager.set(DataSources.SLAVE);
    }


    @Pointcut("execution(public * com.example.service..*.selectBycondition(..))")
    public void dataSourceMaster(){};


    @Before("dataSourceMaster()")
    public void beforeMaster(JoinPoint jp) {
        System.out.println("选择写入");
        DataSourceTypeManager.set(DataSources.MASTER);
    }
    // ... ...
}
