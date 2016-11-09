package com.example.v2.product.builder.factory;

import com.example.utils.GetProductConfig;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by life on 16-10-25.
 */
public enum  ProductConfigFactory {
    PRODUCT_CONFIG;

    private Document config;

    ProductConfigFactory(){
        try {
            this.config = GetProductConfig.testParseXmlData("/product.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Document getConfig() {
        return config;
    }

    public void setConfig(Document config) {
        this.config = config;
    }
}
