package com.j;

import com.j.model.mongodb.MongUser;
import com.j.mongrepository.RepositoryUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0 created by xxxx on 2018/5/19 22:27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class mongodbMongMongUserRepositoryTest {

    @Test
    public void test1(){
        MongUser u  = new MongUser();
        u.setUsername("www");
        u.setPassword("aaa");
        RepositoryUtils.save(u);
    }

}
