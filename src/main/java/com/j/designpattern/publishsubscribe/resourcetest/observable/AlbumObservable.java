package com.j.designpattern.publishsubscribe.resourcetest.observable;

import com.j.designpattern.publishsubscribe.resourcetest.observer.DAlbumObserver;
import com.j.designpattern.publishsubscribe.resourcetest.observer.SongObserver;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.util.Observable;

/**
 * @version 1.0 created by xxxx on 2018/8/17 9:16
 * 专辑被观察者
 * 需要添加歌曲观察者，创作笔记观察者，数字专辑产品观察者
 */
@Data
@Service
public class AlbumObservable extends Observable implements ResourceObservable{
    String subjectName="Album_SUBJECT";

    @Autowired
    SongObserver songObserver;
    @Autowired
    DAlbumObserver dAlbumObserver;
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
        super.addObserver(songObserver);
        super.addObserver(dAlbumObserver);

    }
}
