package com.example.BuilderT.factory;

import com.example.BuilderT.product.CurrentA;
import com.example.BuilderT.product.MorthA;
import com.example.domain.Tender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by life on 16-10-26.
 */
@Service
public class ProductService {
    @Autowired
    private CurrentA currentA;

    @Autowired
    private MorthA morthA;

    public List<Tender> createCurrent() {
        return currentA.getProduct();
    }

    public List<Tender> createMorth() {
        return morthA.getProduct();
    }
}
