package com.j.designpattern.publishsubscribe.resourcetest.observer;

import com.j.designpattern.publishsubscribe.resourcetest.model.Album;
import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.Observer;

/**
 * @version 1.0 created by xxxx on 2018/8/1 13:57
 */
@Service
public class DAlbumObserver implements Observer {

    private String publishName="ALBUM_PUBLISH";
    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof Album){
            System.out.println("数字专辑的处理状态发生改变："+o+"...."+arg );
        }

    }
}
