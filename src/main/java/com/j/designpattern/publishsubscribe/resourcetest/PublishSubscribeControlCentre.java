package com.j.designpattern.publishsubscribe.resourcetest;

import com.j.designpattern.publishsubscribe.resourcetest.observable.ResourceObservable;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Observer;

/**
 * @version 1.0 created by xxxx on 2018/8/1 15:21
 */
@Service
public class PublishSubscribeControlCentre {



    @Autowired
    List<ResourceObservable> observableList;

    @PostConstruct
    public void init(){
        if (CollectionUtils.isNotEmpty(observableList)) {
            for (ResourceObservable resourceObservable : observableList) {
                resourceObservable.addObservers();
            }
        }
    }

    //通知更新
    public boolean notifyObservers(ResourceObservable resourceObservable,Object obj){
        resourceObservable.setChanged();
        resourceObservable.notifyObservers(obj);
        return true;
    }
}
