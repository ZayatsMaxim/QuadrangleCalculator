package com.zayats.repository.specifications;

import com.zayats.entity.Point;
import com.zayats.entity.QuadrangleObservable;

public class DistanceSpecification implements Specification{
    public double DISTANCE;

    public DistanceSpecification(double DISTANCE){
        this.DISTANCE = DISTANCE;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        Point firstPoint = quadrangle.getQuadPoint(0);
        Point secondPoint = quadrangle.getQuadPoint(1);
        Point thirdPoint = quadrangle.getQuadPoint(2);
        Point fourthPoint = quadrangle.getQuadPoint(3);

        return isPointInRange(firstPoint, DISTANCE) &&
                isPointInRange(secondPoint, DISTANCE) &&
                isPointInRange(thirdPoint, DISTANCE) &&
                isPointInRange(fourthPoint, DISTANCE);
    }

    public boolean isPointInRange(Point point, double Distance){
        double actualX = point.getXCoordinate();
        double actualY = point.getYCoordinate();
        return Math.abs(actualX) < Distance &&  Math.abs(actualY) < Distance;
    }
}
