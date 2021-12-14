package com.zayats.repository.comparators;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.logics.Calculator;
import java.util.Comparator;

public class AreaComparator implements Comparator<QuadrangleObservable> {

    @Override
    public int compare(QuadrangleObservable firstQuad, QuadrangleObservable secondQuad) {
        Calculator calculator = new Calculator();
        Double firstQuadArea = calculator.calculateQuadrangleArea(firstQuad);
        Double secondQuadArea = calculator.calculateQuadrangleArea(firstQuad);
        return firstQuadArea.compareTo(secondQuadArea);
    }
}
