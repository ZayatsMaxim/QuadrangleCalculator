package com.zayats.repository.specifications;


import com.zayats.entity.QuadrangleObservable;

public interface Specification {
    boolean specified(QuadrangleObservable quadrangle);
}
