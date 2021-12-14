package com.zayats;

import com.zayats.entity.QuadrangleExceptions;
import com.zayats.entity.QuadrangleObservable;

public interface Observer {
    void update(QuadrangleObservable quadrangle) throws QuadrangleExceptions;
}
