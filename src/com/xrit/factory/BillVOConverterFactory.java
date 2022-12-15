package com.xrit.factory;

import com.xrit.inter.VOConverter;

import java.io.InputStream;
import java.util.Properties;

public class BillVOConverterFactory {
    /**
     * 工厂+反射，实现解耦
     */
    public static VOConverter createConverter(String firlLocation, String billType) throws Exception {
        //获取类的加载器(目的是我们要使用它来加载配置文件)
        ClassLoader classLoader = BillVOConverterFactory.class.getClassLoader();
        //读取配置文件
        InputStream is = classLoader.getResourceAsStream(firlLocation);
        //借助Properties对象加载流的数据
        Properties properties = new Properties();
        properties.load(is);
        //取数据
        String className = properties.getProperty(billType);
        //String classRuleName = "com.xrit.pojo." + billType + "Converter";
        //String classMapName = getValueByKey(billType)
        //反射获取对象
        Class<?> c = Class.forName(className);
        //直接简版创建对象
        VOConverter converter = (VOConverter) c.newInstance();
        return converter;
    }



}
