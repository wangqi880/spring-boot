package com.j.designpattern.publishsubscribe.resourcetest.observable;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
* 主题
 * @version 1.0 created by xxxx on 2018/8/1 13:40
 */
@Data
@Service
public class ResourceSubject  extends Observable implements ResourceObservable {
    //这里也做成枚举维护
    String subjectName="RESOURCE_SUBJECT";
    @Override
    public synchronized void setChanged() {
        super.setChanged();
    }

    @Override
    public String getName() {
        return subjectName;
    }

    @Override
    public void addObservers() {

    }
}
