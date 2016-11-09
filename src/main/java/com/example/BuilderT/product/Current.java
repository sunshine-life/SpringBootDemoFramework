package com.example.BuilderT.product;

import com.example.domain.Tender;
import org.jdom.JDOMException;

import java.io.IOException;
import java.util.List;

/**
 * Created by life on 16-10-25.
 * 活期罐接口
 */
public interface Current {
    List<Tender> getProduct() throws JDOMException, IOException;

}
