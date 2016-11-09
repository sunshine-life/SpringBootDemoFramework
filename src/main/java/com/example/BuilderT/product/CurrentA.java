package com.example.BuilderT.product;

import com.example.BuilderT.factory.ProductConfigFactory;
import com.example.controller.ProductController;
import com.example.domain.Tender;
import com.example.mapper.TenderMapper;
import com.example.utils.GetProductConfig;
import org.jdom.JDOMException;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by life on 16-10-25.
 * 活期罐A
 */
@Component
public class CurrentA extends Tender implements Current {

    protected static Logger logger= LoggerFactory.getLogger(CurrentA.class);

    @Autowired
    private TenderMapper tenderMapper;

    @Override
    public List<Tender> getProduct() {
        List<Tender> products = new ArrayList<>();
        System.out.println("活期产品A创建");
        //解析产品配置，开始解析数据
        Document doc = ProductConfigFactory.PRODUCT_CONFIG.getConfig();
        Elements distributionElem = doc.select("current");
        int productNum = Integer.parseInt( distributionElem.select("limitenum").text());
        logger.info("可以同时存在{}个产品",productNum);
        if(distributionElem==null){
              throw new RuntimeException("呵呵,傻逼,你配置文件写错了！");
        }else{
             products = tenderMapper.selectBycondition();
            if(products.size()<=productNum){
                for(int i=0;i<(productNum-products.size());i++){
                    Tender addTender = new Tender();
                    addTender.setName("活期1号");
                    addTender.setInvestdays(0);
                    addTender.setStatus(1);
                    addTender.setView("随存随取");
                    //tenderMapper.insert(addTender);
                    products.add(addTender);
                }
            }
        }
        return products;
    }
}
