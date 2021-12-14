package com.zayats.logics;

import com.zayats.entity.Point;
import com.zayats.entity.QuadrangleObservable;

public class Calculator {
    private final int QUAD_POINTS_NUM = 4;

    public double calculateQuadranglePerimeter(QuadrangleObservable quadrangle){
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

    public double calculateQuadrangleArea(QuadrangleObservable quadrangle){
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

    public boolean isQuadrangle(QuadrangleObservable quadrangle){
        Point firstPoint = quadrangle.getQuadPoint(0);
        Point secondPoint = quadrangle.getQuadPoint(1);
        Point thirdPoint = quadrangle.getQuadPoint(2);

        double firstVectorAngle = calculateVectorAngle(firstPoint, secondPoint);
        double secondVectorAngle = calculateVectorAngle(secondPoint, thirdPoint);

        return firstVectorAngle != secondVectorAngle;
    } // перенести в validator?

   public boolean isSquare(QuadrangleObservable quadrangle){
            final double RIGHT_ANGLE = 1.5707963267948966;
            Point firstPoint = quadrangle.getQuadPoint(0);
            Point secondPoint = quadrangle.getQuadPoint(1);
            Point thirdPoint = quadrangle.getQuadPoint(2);
            Point fourthPoint = quadrangle.getQuadPoint(3);

            double firstSideLength = calculateVectorLength(firstPoint, secondPoint);
            double secondSideLength = calculateVectorLength(secondPoint, thirdPoint);
            double thirdSideLength = calculateVectorLength(thirdPoint, fourthPoint);
            double fourthSideLength = calculateVectorLength(fourthPoint, firstPoint);

            double angle = calculateAngleBetweenVectors(firstPoint, secondPoint, thirdPoint);

            return angle != RIGHT_ANGLE && firstSideLength == secondSideLength && secondSideLength == thirdSideLength
                    && thirdSideLength == fourthSideLength;
    }

    public double calculateScalarProduct(Point firstPoint, Point secondPoint, Point thirdPoint){
        double firstX = firstPoint.getXCoordinate();
        double firstY = firstPoint.getYCoordinate();
        double secondX = secondPoint.getXCoordinate();
        double secondY = secondPoint.getYCoordinate();
        double thirdX = thirdPoint.getXCoordinate();
        double thirdY = thirdPoint.getYCoordinate();

        double firstVectorX = thirdX - firstX;
        double firstVectorY = thirdY - firstY;
        double secondVectorX = secondX - firstX;
        double secondVectorY = secondY - firstY;

        double result = firstVectorX*secondVectorX + firstVectorY*secondVectorY;
        return result;
    }

    public double calculateVectorLength(Point firstPoint, Point secondPoint){
        double firstX = firstPoint.getXCoordinate();
        double secondX = secondPoint.getXCoordinate();
        double firstY = firstPoint.getYCoordinate();
        double secondY = secondPoint.getYCoordinate();

        double result = Math.sqrt(Math.pow(secondX - firstX, 2) + Math.pow(secondY - firstY,2));
        return result;
    }

    public double calculateAngleBetweenVectors(Point firstPoint, Point secondPoint, Point thirdPoint){
        double firstLength = calculateVectorLength(firstPoint, secondPoint);
        double secondLength = calculateVectorLength(firstPoint, thirdPoint);
        double scalarProduct = calculateScalarProduct(firstPoint, secondPoint, thirdPoint);

        double cosAngle = scalarProduct/(firstLength*secondLength);
        double result = Math.acos(cosAngle);
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
