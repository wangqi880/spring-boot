package com.j;

import com.j.designpattern.publishsubscribe.resourcetest.PublishSubscribeControlCentre;
import com.j.designpattern.publishsubscribe.resourcetest.model.Album;
import com.j.designpattern.publishsubscribe.resourcetest.observable.AlbumObservable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @version 1.0 created by xxxx on 2018/8/1 15:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PublishSubscribeTest {

    @Autowired
    PublishSubscribeControlCentre publishSubscribeControlCentre;
    @Autowired
    AlbumObservable albumObservable;
    @Test
    public void test1(){

        publishSubscribeControlCentre.notifyObservers(albumObservable,new Album());
    }


}
