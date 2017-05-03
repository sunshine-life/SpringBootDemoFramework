package com.example.controller;

import com.example.domain.Tender;
import com.example.domain.TestPOJO;
import com.example.dto.TestModel;
import com.example.redis.RedisUtil;
import com.example.service.TestServices;
import com.example.utils.JsonUtils;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    protected static Logger logger= LoggerFactory.getLogger(com.example.controller.TestController.class);

    @Autowired
    private Environment env;

    @Autowired
    private TestServices testServices;

    @Autowired
    private RedisUtil redisUtil;


    @RequestMapping(value = "/apis/show2",method = RequestMethod.POST)
    public String show(){
        System.out.println("进入方法");
        return testServices.show();
    }

    @RequestMapping(value = "/showDao2")
    public Object showDao(){
        Integer page = 1;
        Integer pageSize = 5;
        if(page!= null && pageSize!= null){
            PageHelper.startPage(page, pageSize);
        }
        List<TestPOJO> list = testServices.showDao(13);
        List<Tender> list2 = testServices.selectBycondition();
        System.out.println("所有数据查询完成");
        Map<String,List> map = new HashMap<>();
        map.put("从数据库",list);
        map.put("主数据库",list2);
        //不处理异常时将会出发例外通知
        //testServices.testTransaction();

       /* try{
            testServices.testTransaction();
        }catch(Exception e){
            logger.info("===============================事务出现异常，抛出！=======================");
            new WebException("事务出现异常，抛出！");
        }*/
        return map;
    }



    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public String getTest(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(session.getAttribute("hehe")==null){
            System.out.println("session为空");
            session.setAttribute("hehe","大傻逼");
        }else{
            System.out.println("session不为空");
            System.out.println(session.getAttribute("hehe"));
        }

        System.out.println("进入方法");
        System.out.println(env.getProperty("db"));
        return "success";
    }



    @RequestMapping(value = "/testv2",method = RequestMethod.GET)
    public String  test2(HttpServletRequest request, HttpServletResponse response, String money, String expected_return, String min_return, String time){
        TestModel model = new TestModel();
        model.setExpected_return(expected_return);
        model.setMin_return(min_return);
        model.setMoney(money);
        model.setTime(time);
        Map<String,Object> result = new HashMap();
        result.put("msg","susccess");
        result.put("getdata",model);
        String json = JsonUtils.obj2JsonString(result);
        System.out.println(json.toString());


        StringBuilder results = new StringBuilder();
        //results.append(request.getParameter("jsoncallback")).append('(').append(result.toString()).append(')');
        results.append("success_jsonpCallback").append('(').append(json).append(')');
        System.out.println(results.toString());
        return results.toString();
    }



    @RequestMapping(value = "/testc",method = RequestMethod.GET)
    public String  test2(HttpServletRequest request, HttpServletResponse response){
        return "呵呵";
    }


    @RequestMapping("/")
    public String getSessionId(){
        redisUtil.set("123", "sb");
        System.out.println("进入了方法");
        String string= redisUtil.get("123").toString();
        return string;
    }
}
