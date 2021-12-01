package com.zayats.logics;

import com.zayats.properties.Quadrangle;
import com.zayats.properties.Point;

public class Calculator {
    final int QUAD_POINTS_NUM = 4;

    public double calculateQuadranglePerimeter(Quadrangle quadrangle){
        Point firstPoint = quadrangle.getQuadPoint(0);
        Point secondPoint = quadrangle.getQuadPoint(1);
        Point thirdPoint = quadrangle.getQuadPoint(2);
        Point fourthPoint = quadrangle.getQuadPoint(3);

        double firstVector = calculateVectorLength(firstPoint, secondPoint);
        double secondVector = calculateVectorLength(secondPoint, thirdPoint);
        double thirdVector = calculateVectorLength(thirdPoint, fourthPoint);
        double fourthVector = calculateVectorLength(fourthPoint, firstPoint);

        return firstVector + secondVector + thirdVector + fourthVector;
    }

    public double calculateVectorLength(Point firstPoint, Point secondPoint){
        double firstPointX = firstPoint.getXCoordinate();
        double secondPointX = secondPoint.getXCoordinate();
        double firstPointY = firstPoint.getYCoordinate();
        double secondPointY = secondPoint.getYCoordinate();

        double result = Math.sqrt(Math.pow(secondPointX - firstPointX, 2) + Math.pow(secondPointY - firstPointY,2));
        return result;
    }

    public double calculateQuadrangleSquare(Quadrangle quadrangle){
        double result = 0;
        double square = 0;
        double[] XCoordinates = new double[QUAD_POINTS_NUM];
        double[] YCoordinates = new double[QUAD_POINTS_NUM];

        for (int i = 0; i < QUAD_POINTS_NUM; i++) {
            Point point = quadrangle.getQuadPoint(i);
            XCoordinates[i] = point.getXCoordinate();
            YCoordinates[i] = point.getYCoordinate();
        }

        for (int i = 0; i < QUAD_POINTS_NUM; i++) {
            switch (i){
                case (0):
                    square = XCoordinates[i]*(YCoordinates[QUAD_POINTS_NUM-1] - YCoordinates[i+1]);
                    result += square;
                    break;
                case(QUAD_POINTS_NUM-1):
                    square = XCoordinates[i]*(YCoordinates[i-1]-YCoordinates[0]);
                    result += square;
                    break;
                default:
                    square = XCoordinates[i]*(YCoordinates[i-1] - YCoordinates[i+1]);
                    result += square;
                    break;
            }
        }
        result = Math.abs(result/2);
        return result;
    }

    public double calculateVectorAngle(Point firstPoint, Point secondPoint){
        double vectorX = secondPoint.getXCoordinate() - firstPoint.getXCoordinate();
        double vectorY = secondPoint.getYCoordinate() - firstPoint.getYCoordinate();
        // вынести в метод?
        double cosAngle = vectorX / Math.sqrt(Math.pow(vectorX,2) + Math.pow(vectorY,2));
        double result = Math.acos(cosAngle);
        return result;
    }
}
