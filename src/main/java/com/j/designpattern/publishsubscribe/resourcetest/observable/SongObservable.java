package com.j.designpattern.publishsubscribe.resourcetest.observable;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * @version 1.0 created by xxxx on 2018/8/17 9:16
 * 歌曲素材
 * 专辑，演唱会，电台，创作笔记
 */
@Data
@Service
public class SongObservable extends Observable implements ResourceObservable{
    //这里也做成枚举维护
    String subjectName="Song_SUBJECT";
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
