package com.springcloud.weather.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class XmlBuilder {

    /**
     * xml 转换 pojo
     * @return
     */
    public static Object xmlStrToObject(Class<?> clazz,String xmlStr) throws Exception {
        Object xmlObject = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        StringReader reader = new StringReader(xmlStr);

        xmlObject = unmarshaller.unmarshal(reader);

        if (null != reader) {
            reader.close();
        }

        return xmlObject;

    }



}
