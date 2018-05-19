package com.j.mongrepository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * @version 1.0 created by xxxx on 2018/5/10 23:43
 */
@NoRepositoryBean
public interface BaseRepository<T> extends MongoRepository<T, String>, QueryDslPredicateExecutor<T> {}
