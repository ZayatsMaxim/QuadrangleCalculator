package com.zayats;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.logics.Calculator;

import java.util.HashMap;
import java.util.Map;

public class QuadrangleStore implements Observer{
    private static QuadrangleStore instance;

    private final Map<Integer, Parameters> PARAMETERS = new HashMap<>();

    private Calculator CALCULATOR = new Calculator();

    private QuadrangleStore(){}

    public void update(QuadrangleObservable quadrangle){
        double square = CALCULATOR.calculateQuadrangleArea(quadrangle);
        double perimeter = CALCULATOR.calculateQuadranglePerimeter(quadrangle);
        PARAMETERS.put(quadrangle.getId(), new Parameters(square, perimeter));
    }

    private static QuadrangleStore getInstance(){
        if (instance == null){
            instance = new QuadrangleStore();
        }
        return instance;
    }
}
