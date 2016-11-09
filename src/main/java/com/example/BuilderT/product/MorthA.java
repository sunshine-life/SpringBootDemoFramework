package com.example.BuilderT.product;

import com.example.domain.Tender;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by life on 16-10-25.
 */
@Component
public class MorthA extends Tender implements Morth {
    @Override
    public List<Tender> getProduct() {
        List<Tender> products = new ArrayList<>();
        System.out.println("月度产品A创建");
        return products;
    }
}
