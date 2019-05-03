package com.springcloud.weather.service;

import com.springcloud.weather.utils.XmlBuilder;
import com.springcloud.weather.weatherPojo.city.City;
import com.springcloud.weather.weatherPojo.city.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
@Service
public class CityDataServiceImpl implements CityDataService{


    @Override
    public List<City> listCity() throws Exception{

        //读取城市xml文件
        Resource resource = new ClassPathResource("citylist.xml");

        BufferedReader bf = new BufferedReader(new InputStreamReader(resource.getInputStream(),"utf-8"));

        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line = bf.readLine()) != null){
            stringBuffer.append(line);
        }
        bf.close();

        //xml转成JAVA对象
        CityList cityList = (CityList) XmlBuilder.xmlStrToObject(CityList.class, stringBuffer.toString());

        return cityList.getCityList();
    }
}
