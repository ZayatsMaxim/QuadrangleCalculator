package com.zayats.repository;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.repository.specifications.Specification;

import java.util.Comparator;
import java.util.List;

public interface QuadrangleRepository {
    void add(QuadrangleObservable quadrangle);

    void delete(QuadrangleObservable quadrangle);

    void update(QuadrangleObservable quadrangle);

    List<QuadrangleObservable> query(Specification specification);

    List<QuadrangleObservable> sort(Comparator<QuadrangleObservable> comparator);
}
