package com.j;

import com.alibaba.fastjson.JSONObject;
import com.j.mapper.UserMapper;
import com.j.model.User;
import com.j.model.mongodb.MongUser;
import com.j.model.mongodb.QMongUser;
import com.j.mongrepository.RepositoryUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @version 1.0 created by xxxx on 2018/5/19 22:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class mongodbMongMongUserRepositoryTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    UserMapper userMapper;
    @Test
    public void test1(){
       /* MongUser u  = new MongUser();
        u.setUsername("wq");
        u.setPassword("1312312");
        RepositoryUtils.save(u);*/
       //全表查询
        List<MongUser> all = RepositoryUtils.findAll(MongUser.class);
        assert (all.size()==4);
        /*
        分页查询
         */
        Pageable pageable = new PageRequest(0,2);
        Page<MongUser> page = RepositoryUtils.findAll(pageable, MongUser.class);
        long totalElements = page.getTotalElements();
        int totalPages = page.getTotalPages();
        /*
        分页结束
         */
        /*
        根据条件查询
         */
        BooleanExpression booleanExpression = QMongUser.mongUser.username.like("wq");
        Page<MongUser> page1 = RepositoryUtils.findAll(booleanExpression, pageable, MongUser.class);
        long totalElements1 = page.getTotalElements();
        /*
        排序
         */
        Sort sort = new Sort(new Sort.Order(Sort.Direction.DESC,"_id"));
        sort=sort.and(new Sort(new Sort.Order(Sort.Direction.DESC,"name")));
        Pageable pageable3 = new PageRequest(0,2,sort);
        Page<MongUser> page2 = RepositoryUtils.findAll(booleanExpression, pageable3, MongUser.class);
        System.out.println("333");
    }

    @Test
    public void test(){
        List<User> users = userMapper.queryByall();
        System.out.println(JSONObject.toJSONString(users));
    }

}
