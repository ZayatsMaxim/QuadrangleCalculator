package com.zayats;

import com.zayats.entity.QuadrangleExceptions;

public interface Observable {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers() throws QuadrangleExceptions;
}
