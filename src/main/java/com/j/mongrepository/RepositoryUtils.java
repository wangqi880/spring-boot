package com.j.mongrepository;

import com.j.model.mongodb.BaseDO;
import com.querydsl.core.types.Predicate;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version 1.0 created by xxxx on 2018/5/10 23:44
 */
@Component
public class RepositoryUtils {

    private static Map<String, BaseRepository> beanMap = new HashMap<>();

    public static void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(Repository.class);
        for (String s : beansWithAnnotation.keySet()) {
            Object o = beansWithAnnotation.get(s);
            if (o instanceof BaseRepository) {
                Type[] genericInterfaces = o.getClass().getGenericInterfaces();
                Class type = (Class) genericInterfaces[0];
                Class type1 = (Class) ((ParameterizedType) type.getGenericInterfaces()[0]).getActualTypeArguments()[0];
                beanMap.put(type1.getSimpleName(), (BaseRepository) o);
            }
        }
    }

    public static <T> T findOne(Predicate predicate, Class<T> cls) {
        return (T) beanMap.get(cls.getSimpleName()).findOne(predicate);
    }

    public static <T> List<T> findAll(Class<T> cls) {
        return (List<T>) beanMap.get(cls.getSimpleName()).findAll();
    }
    public static <T> List<T> findAll(Predicate predicate, Class<T> cls) {
        return (List<T>) beanMap.get(cls.getSimpleName()).findAll(predicate);
    }

    public static <T> List<T> findAll(Sort sort, Class<T> cls) {
        return (List<T>) beanMap.get(cls.getSimpleName()).findAll(sort);
    }

    public static <T> Page<T> findAll(Predicate predicate, Pageable pageable, Class<T> cls) {
        return (Page<T>) beanMap.get(cls.getSimpleName()).findAll(predicate, pageable);
    }

    public static <T> Page<T> findAll(Pageable pageable, Class<T> cls) {
        return (Page<T>) beanMap.get(cls.getSimpleName()).findAll(pageable);
    }

    public static <T extends BaseDO> T save(T t) {
        return (T) beanMap.get(t.getClass().getSimpleName()).save(t);
    }

    public static void delete(Class cls, Serializable id) {
        beanMap.get(cls.getSimpleName()).delete(id);
    }

    public static <T> List<T> save(List<T> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            T t = list.get(0);
            return (List<T>) beanMap.get(t.getClass().getSimpleName()).save(list);
        }
        return null;
    }
}

