package com.j.designpattern.publishsubscribe.resourcetest.observable;

import javax.annotation.PostConstruct;
import java.util.Observer;

/**
 * @version 1.0 created by xxxx on 2018/8/1 15:46
 */
public interface ResourceObservable {
   public void addObserver(Observer observer);
   public void notifyObservers(Object obj);
   public void  setChanged();
   public String getName();
    public void addObservers();
}
