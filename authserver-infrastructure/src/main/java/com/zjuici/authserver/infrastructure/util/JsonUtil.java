package com.zjuici.authserver.infrastructure.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

@Slf4j
public class JsonUtil {


    /**
     * object mapper
     */
    private static final ObjectMapper mapper = new ObjectMapper();


    /**
     * 时间格式化
     */
    private static final String DATE_TIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";


    /**
     * 初始化配置
     */
    static {
        //对象的所有字段全部列入
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        //取消默认转换timestamps形式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //忽略空Bean转json的错误
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        //所有的日期格式都统一为以下的样式，即yyyy-MM-dd HH:mm:ss
        mapper.setDateFormat(new SimpleDateFormat(DATE_TIME_FORMATTER));
        //忽略 在json字符串中存在，但是在java对象中不存在对应属性的情况。防止错误
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    /**
     * 功能描述：把JSON数据转换成指定的java对象
     * @param jsonData JSON数据
     * @param clazz 指定的java对象
     * @return 指定的java对象
     */
    public static <T> T jsonToObject(String jsonData, Class<T> clazz) {
        try {
            if (StringUtil.isEmpty(jsonData)){
                return null;
            }
            return mapper.readValue(jsonData, clazz);
        }catch (Exception e){
            log.error("read from json failed ...", e);
        }
        return null;
    }

    /**
     * 功能描述：把java对象转换成JSON数据
     * @param object java对象
     * @return JSON数据
     */
    public static String toJson(Object object) {
        try{
            if (object == null){
                return null;
            }
            return mapper.writeValueAsString(object);
        }catch (Exception e){
            log.error("read from json failed ...", e);
        }
        return null;
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象列表
     * @param jsonData JSON数据
     * @param clazz 指定的java对象
     * @return List<T>
     */
    public static <T> List<T> getJsonToList(String jsonData, Class<T> clazz) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(List.class, clazz);
        try {
            return mapper.readValue(jsonData, javaType);
        } catch (Exception e) {
            log.error("Parse String to list error..." , e);
        }
        return Collections.emptyList();
    }


    /**
     * String对象转集合
     * @param str
     * @param collectionClazz
     * @param elementClazzes
     * @param <T>
     * @return
     */
    public static <T> T jsonToCollection(String str, Class<?> collectionClazz, Class<?>... elementClazzes) {
        JavaType javaType = mapper.getTypeFactory().constructParametricType(collectionClazz, elementClazzes);
        try {
            return mapper.readValue(str, javaType);
        } catch (IOException e) {
            log.error("Parse String to Object error..." , e);
        }
        return null;
    }

}
