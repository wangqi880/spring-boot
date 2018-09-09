package com.j.designpattern.publishsubscribe.resourcetest.observer;

import com.j.designpattern.publishsubscribe.resourcetest.model.Album;
import com.j.designpattern.publishsubscribe.resourcetest.model.Song;
import com.j.designpattern.publishsubscribe.resourcetest.observable.AlbumObservable;
import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.Observer;

/**
 * @version 1.0 created by xxxx on 2018/8/1 13:57
 */
@Service
public class SongObserver implements Observer {

    private String publishName="SONG_PUBLISH";
    @Override
    public void update(Observable o, Object arg) {
        //这里说下为什么不发消息
        if (arg instanceof Album) {
            Album album = (Album) arg;
            System.out.println("我是歌曲处理状态发生改变："+o+"...."+album );
        }

    }
}
