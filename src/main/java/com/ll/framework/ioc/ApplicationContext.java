package com.ll.framework.ioc;

import com.ll.domain.testPost.testPost.repository.TestPostRepository;
import com.ll.domain.testPost.testPost.service.TestPostService;

public class ApplicationContext {
    public ApplicationContext() {

    }

    public <T> T genBean(String beanName) {
        TestPostService testPostService = new TestPostService(new TestPostRepository());
        return (T) testPostService;
    }
}
