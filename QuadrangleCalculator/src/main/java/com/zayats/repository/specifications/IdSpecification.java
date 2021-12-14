package com.zayats.repository.specifications;

import com.zayats.entity.QuadrangleObservable;

public class IdSpecification implements Specification {
    private final Integer id;

    public IdSpecification(final Integer id){
        this.id = id;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        return quadrangle.getId().equals(id);
    }
}
