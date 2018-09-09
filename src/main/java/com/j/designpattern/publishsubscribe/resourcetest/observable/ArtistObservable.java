package com.j.designpattern.publishsubscribe.resourcetest.observable;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * @version 1.0 created by xxxx on 2018/8/17 9:16
 * 艺人被观察者
 * 需要添加艺人，歌曲，专辑素材，mv素材，短视频
 */
@Data
@Service
public class ArtistObservable extends Observable implements ResourceObservable{
    String subjectName="Artist_SUBJECT";

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
