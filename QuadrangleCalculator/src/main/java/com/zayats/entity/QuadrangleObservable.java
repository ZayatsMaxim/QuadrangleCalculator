package com.zayats.entity;

import com.zayats.Observable;
import com.zayats.Observer;

import java.util.ArrayList;
import java.util.List;

public class QuadrangleObservable extends Quadrangle implements Observable {
    private final Integer id;
    private final List<Observer> observers = new ArrayList<>();
    public Integer getId() {
        return id;
    }

    public QuadrangleObservable(Integer id, ArrayList<Point> quadPoints) {
        super(quadPoints);
        this.id = id;
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws QuadrangleExceptions { //7
        for(Observer observer : observers){
            observer.update(this);
        }
    }

}
