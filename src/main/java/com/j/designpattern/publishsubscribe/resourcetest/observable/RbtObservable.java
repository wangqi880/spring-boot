package com.j.designpattern.publishsubscribe.resourcetest.observable;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Observable;

/**
 * @version 1.0 created by xxxx on 2018/8/17 9:16
 * rbt
 * 歌曲素材，彩铃
 */
@Data
@Service
public class RbtObservable extends Observable implements ResourceObservable{
    String subjectName="Rbt_SUBJECT";

    @Override
    public void setChanged() {
        super.setChanged();
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void addObservers() {

    }
}
