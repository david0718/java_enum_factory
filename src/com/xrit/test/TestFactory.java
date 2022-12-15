package com.xrit.test;

import com.xrit.factory.BillVOConverterFactory;
import com.xrit.inter.VOConverter;
import org.junit.Test;

public class TestFactory {
    /**
     * 测试工厂模式
     */
    @Test
    public void test01() throws Exception {
        VOConverter converter = this.getConverter("fThree");
        converter.convert();
    }


    private VOConverter getConverter(String billType) throws Exception {
        VOConverter converter = BillVOConverterFactory.createConverter("my.properties",billType);
        return converter;
    }
}
