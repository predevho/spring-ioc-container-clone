package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ApplicationContext {
    private final Map<String, Object> beans = new HashMap<>();

    public <T> T genBean(String beanName) {
        if(beans.containsKey(beanName)) {
            return (T) beans.get(beanName);
        } else if (Objects.equals(beanName,"testPostRepository")) {
            Object bean = new TestPostRepository();
            beans.put(beanName, bean);
            return (T) bean;
        }
        Object bean = new TestPostService(genBean("testPostRepository"));
        beans.put(beanName, bean);
        return (T) bean;
    }
}
