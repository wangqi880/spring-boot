package com.j.designpattern.publishsubscribe.resourcetest.observer;

import com.j.designpattern.publishsubscribe.resourcetest.model.Album;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.stereotype.Service;

import java.util.Observable;
import java.util.Observer;

/**
 * @version 1.0 created by xxxx on 2018/8/1 13:57
 */
@Service
public class AlbumObserver implements Observer {

    private String publishName="DALBUM_PUBLISH";
    @Override
    public void update(Observable o, Object arg) {



    }
}
