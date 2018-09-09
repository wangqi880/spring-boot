package com.j.designpattern.publishsubscribe.resourcetest.observable;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * @version 1.0 created by xxxx on 2018/8/17 9:16
 * 图片
 * 短视频 启动图片
 */
@Data
@Service
public class PictureObservable extends Observable implements ResourceObservable{
    String subjectName="Picture_SUBJECT";

    @Override
    public void setChanged() {
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
