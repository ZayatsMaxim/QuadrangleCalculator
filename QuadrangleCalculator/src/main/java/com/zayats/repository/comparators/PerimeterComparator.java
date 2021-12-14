package com.zayats.repository.comparators;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.logics.Calculator;

import java.util.Comparator;

public class PerimeterComparator implements Comparator<QuadrangleObservable> {

    @Override
    public int compare(QuadrangleObservable firstQuad, QuadrangleObservable secondQuad) {
        Calculator calculator = new Calculator();
        Double firstQuadPerimeter = calculator.calculateQuadranglePerimeter(firstQuad);
        Double secondQuadPerimeter = calculator.calculateQuadranglePerimeter(secondQuad);
        return firstQuadPerimeter.compareTo(secondQuadPerimeter);
    }
}
