package com.zayats.repository;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.repository.specifications.Specification;

import java.util.*;

public class QuadrangleRepositoryImpl implements QuadrangleRepository{
    private Map<Integer, QuadrangleObservable> STORE = new HashMap<>();

    @Override
    public void add(final QuadrangleObservable quadrangle) {
        Integer quadId = quadrangle.getId();
        STORE.put(quadId, quadrangle);
    }

    @Override
    public void delete(QuadrangleObservable quadrangle) {
        Integer quadId = quadrangle.getId();
        STORE.remove(quadId, quadrangle);
    }

    @Override
    public void update(QuadrangleObservable quadrangle) {
        Integer quadId = quadrangle.getId();
        STORE.replace(quadId, quadrangle);
    }

    @Override
    public List<QuadrangleObservable> query(final Specification specification) {
        List<QuadrangleObservable> quadrangles = new ArrayList<>();
        for (QuadrangleObservable quadrangle : STORE.values()) {
            if(specification.specified(quadrangle)){
                quadrangles.add(quadrangle);
            }
        }
        return quadrangles;
    }

    @Override
    public List<QuadrangleObservable> sort(Comparator<QuadrangleObservable> comparator) {
        List<QuadrangleObservable> quadrangles = new ArrayList<>(STORE.values());
        quadrangles.sort(comparator);
        return quadrangles;
    }
}
