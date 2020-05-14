package com.lustre.mall.core.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;
import java.util.Map;

public class MapperUtil {
    private static ObjectMapper objectMapper ;

    static {
        objectMapper = new JSONMapper();
    }

    public static String toJSON(Object object) {
        String jsonContent = null;

        try {
            jsonContent = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException var4) {
            var4.printStackTrace();
        }

        return jsonContent;
    }

    public static <T> List<T> toList(String json, Class<T> type) {
        List<T> list = null;

        try {
            list = objectMapper.readValue(json, new TypeReference<List<T>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return list;
    }


    public static <T> Map<String, T> toMap(String json, Class<T> type) {
        Map<String, T> map = null;
        try {
            map = objectMapper.readValue(json, new TypeReference<Map<String, T>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return map;
    }

    public static <T> T toObject(String json, Class<T> type) {
        T object = null;
        try {
            object = objectMapper.readValue(json, type);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return object;
    }


    private static class JSONMapper extends ObjectMapper{

        public JSONMapper() {
            super();
            // 从JSON到java object
            // 没有匹配的属性名称时不作失败处理
            this.configure(MapperFeature.AUTO_DETECT_FIELDS, true);

            // 反序列化
            // 禁止遇到空原始类型时抛出异常，用默认值代替。
            this.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
            this.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
            // 禁止遇到未知（新）属性时报错，支持兼容扩展
            this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            this.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
            this.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            // 按时间戳格式读取日期
            // this.configure(DeserializationFeature.READ_DATE_TIMESTAMPS_AS_NANOSECONDS, true);
            this.configure(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL, true);
            this.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
            this.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
            // 序列化
            // 禁止序列化空值
            this.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
            this.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
            this.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
            this.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, true);
            // 按时间戳格式生成日期
            // this.configure(SerializationFeature.WRITE_DATE_TIMESTAMPS_AS_NANOSECONDS, true);
            this.configure(SerializationFeature.FLUSH_AFTER_WRITE_VALUE, true);
            this.configure(SerializationFeature.WRITE_BIGDECIMAL_AS_PLAIN, true);
            // 不包含空值属性
            this.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
            this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            // this.configure(MapperFeature.USE_WRAPPER_NAME_AS_PROPERTY_NAME, true);
            // 是否缩放排列输出，默认false，有些场合为了便于排版阅读则需要对输出做缩放排列
            this.configure(SerializationFeature.INDENT_OUTPUT, false);
        }
    }
}
