package com.j.mongrepository;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @version 1.0 created by xxxx on 2018/5/11 10:01
 */
@Component
public class BeanApplicationUtils implements InitializingBean {
    @Autowired
    private ApplicationContext applicationContext;

    private static ApplicationContext context;

    @Override
    public void afterPropertiesSet() throws Exception {
        BeanApplicationUtils.context = applicationContext;
        RepositoryUtils.setApplicationContext(applicationContext);
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(Class<T> clz) {
        return context.getBean(clz);
    }

    public static <T> T getBean(String beanName, Class<T> clz) {
        return context.getBean(beanName, clz);
    }

    public static <T> Object getBeanByClass(Class<T> tClass) {
        return context == null ? null : context.getBeansOfType(tClass);
    }

    public static <T> Map<String, T> getBeansByClass(Class<T> tClass) {
        return context == null ? null : context.getBeansOfType(tClass);
    }
}
