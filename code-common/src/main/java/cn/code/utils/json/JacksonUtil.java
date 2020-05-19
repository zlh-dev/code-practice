package cn.code.utils.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

/**
 * Jackson工具类
 *
 * @author zlh-dev
 * @date 2020/05/09 21:01
 */
@Slf4j
public class JacksonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 对象返回Json字符串
     *
     * @param obj obj 对象
     * @return {@link String}
     */
    public static <T> String toString(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("parse object to string error", e);
            return null;
        }
    }

    /**
     * 对象返回格式化后的Json字符串
     *
     * @param obj obj 对象
     * @return {@link String}
     */
    public static <T> String toStringPretty(T obj) {
        if (obj == null) {
            return null;
        }
        try {
            return obj instanceof String ? (String) obj : objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
        } catch (Exception e) {
            log.warn("parse object to string error", e);
            return null;
        }
    }

    /**
     * Json字符串转成对象
     *
     * @param str   str json字符串
     * @param clazz clazz 类对象
     * @return {@link T}
     */
    public static <T> T toJavaBean(String str, Class<T> clazz) {
        if (StringUtils.isEmpty(str) || clazz == null) {
            return null;
        }
        try {
            return clazz.equals(String.class) ? (T) str : objectMapper.readValue(str, clazz);
        } catch (Exception e) {
            log.warn("parse string to object error", e);
            return null;
        }
    }

    /**
     * 泛型反序列化
     *
     * @param typeReference 对应返回值的类型
     * @param str           json字符串
     * @return {@link T}
     */
    public static <T> T toJavaBean(String str, TypeReference<T> typeReference) {
        if (StringUtils.isEmpty(str) || typeReference == null) {
            return null;
        }
        try {
            return (T) (typeReference.getType().equals(String.class) ? str : objectMapper.readValue(str, typeReference));
        } catch (IOException e) {
            log.warn("parse string to object error", e);
            return null;
        }
    }

    /**
     * 泛型反序列化
     *
     * @param collectionClass 集合的类型
     * @param elementClasses  集合中元素的类型
     * @param str             str
     * @return {@link T}
     */
    public static <T> T toCollection(String str, Class<?> collectionClass, Class<?>... elementClasses) {
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(collectionClass, elementClasses);
        try {
            return objectMapper.readValue(str, javaType);
        } catch (IOException e) {
            log.warn("parse string to object error", e);
            return null;
        }
    }

}
