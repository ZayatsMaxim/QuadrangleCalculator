package com.zayats.repository.specifications;

import com.zayats.entity.Point;
import com.zayats.entity.QuadrangleObservable;

public class InRangeSpecification implements Specification{

    public double RANGE_X1;
    public double RANGE_X2;
    public double RANGE_Y1;
    public double RANGE_Y2;

    public InRangeSpecification(double RANGE_X1, double RANGE_X2, double RANGE_Y1, double RANGE_Y2){
        this.RANGE_X1 = RANGE_X1;
        this.RANGE_X2 = RANGE_X2;
        this.RANGE_Y1 = RANGE_Y1;
        this.RANGE_Y2 = RANGE_Y2;
    }

    @Override
    public boolean specified(QuadrangleObservable quadrangle) {
        Point firstPoint = quadrangle.getQuadPoint(0);
        Point secondPoint = quadrangle.getQuadPoint(1);
        Point thirdPoint = quadrangle.getQuadPoint(2);
        Point fourthPoint = quadrangle.getQuadPoint(3);

        return isPointInRange(firstPoint, RANGE_X1, RANGE_X2, RANGE_Y1, RANGE_Y2) &&
                isPointInRange(secondPoint, RANGE_X1, RANGE_X2, RANGE_Y1, RANGE_Y2) &&
                isPointInRange(thirdPoint, RANGE_X1, RANGE_X2, RANGE_Y1, RANGE_Y2) &&
                isPointInRange(fourthPoint, RANGE_X1, RANGE_X2, RANGE_Y1, RANGE_Y2);
    }

    public boolean isPointInRange(Point point, double x1Range, double x2Range, double y1Range, double y2Range){
        double actualX = point.getXCoordinate();
        double actualY = point.getYCoordinate();
        return actualX > x1Range && actualX < x2Range &&
                actualY > y1Range && actualY < y2Range;
    }
}
