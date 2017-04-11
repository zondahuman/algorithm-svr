package com.qunar.des.algorithm.common.json.jackson;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: abin
 * Date: 15-3-31 下午6:35
 */
public class JsonUtil {
    private static Logger logger = LoggerFactory.getLogger(JsonUtil.class);
    private static volatile ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
    }

    static {
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
        objectMapper.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * Object => String
     */
    public static <T> String toJson(T src) {
        if (src == null) {
            return null;
        }

        try {
            return src instanceof String ? (String) src : objectMapper.writeValueAsString(src);
        } catch (Exception e) {
            logger.error("op=ObjectToString", e);
            return null;
        }
    }

    /**
     * Object => byte[]
     */
    public static <T> byte[] object2Byte(T src) {
        if (src == null) {
            return null;
        }

        try {
            return src instanceof byte[] ? (byte[]) src : objectMapper.writeValueAsBytes(src);
        } catch (Exception e) {
            logger.error("op=ObjectToByte", e);
            return null;
        }
    }

    /**
     * String => Object
     */
    public static <T> T string2Object(String str, Class<T> clazz) {
        if (str == null || clazz == null) {
            return null;
        }
        str = escapesSpecialChar(str);
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            logger.error("op=ParseStringToObject String={} Class<T>={}", str, clazz.getName(), e);
            return null;
        }
    }

    /**
     * byte[] => Object
     */
    public static <T> T byte2Object(byte[] bytes, Class<T> clazz) {
        if (bytes == null || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(byte[].class) ? (T) bytes : objectMapper.readValue(bytes, clazz);
        } catch (Exception e) {
            logger.error("op=ParseByteToObject byte={} Class<T>={}", bytes, clazz.getName(), e);
            return null;
        }
    }

    /**
     * String => Object
     */
    public static <T> T string2Object(String str, TypeReference<T> typeReference) {
        if (str == null || typeReference == null) {
            return null;
        }
        str = escapesSpecialChar(str);
        try {
            return (T) (typeReference.getType().equals(String.class) ? str : objectMapper.readValue(str, typeReference));
        } catch (Exception e) {
            logger.error("op=ParseStringToObject String={} TypeReference<T>={}", str, typeReference.getType(), e);
            return null;
        }
    }

    /**
     * byte[] => Object
     */
    public static <T> T byte2Object(byte[] bytes, TypeReference<T> typeReference) {
        if (bytes == null || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(byte[].class) ? bytes : objectMapper.readValue(bytes,
                    typeReference));
        } catch (Exception e) {
            logger.error("op=ParseByteToObject byte={} TypeReference<T>={}", bytes, typeReference.getType(), e);
            return null;
        }
    }

    /**
     * Escapes Special Character
     */
    private static String escapesSpecialChar(String str) {
        return str.replace("\n", "\\n").replace("\r", "\\r");
    }
}
