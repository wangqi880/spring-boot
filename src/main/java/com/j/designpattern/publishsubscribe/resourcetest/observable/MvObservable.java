package com.j.designpattern.publishsubscribe.resourcetest.observable;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * @version 1.0 created by xxxx on 2018/8/17 9:16
 * mv素材
 * 歌曲素材，视频彩铃，演唱会
 */
@Data
@Service
public class MvObservable extends Observable implements ResourceObservable{
    String subjectName="Mv_SUBJECT";

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
