package com.zayats.repository.specifications;

import com.zayats.entity.Point;
import com.zayats.entity.QuadrangleObservable;

public class FirstQuadrantSpecification implements Specification{

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        Point firstPoint = quadrangle.getQuadPoint(0);
        Point secondPoint = quadrangle.getQuadPoint(1);
        Point thirdPoint = quadrangle.getQuadPoint(2);
        Point fourthPoint = quadrangle.getQuadPoint(3);
        return isPointInFirstQuadrant(firstPoint) &&
                isPointInFirstQuadrant(secondPoint) &&
                isPointInFirstQuadrant(thirdPoint) &&
                isPointInFirstQuadrant(fourthPoint);
    }

    public boolean isPointInFirstQuadrant(Point point){
        double pointX = point.getXCoordinate();
        double pointY = point.getXCoordinate();
        return pointX > 0 && pointY > 0;
    }
}
