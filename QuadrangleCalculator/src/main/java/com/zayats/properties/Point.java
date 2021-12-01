package com.zayats.properties;

public class Point {
    private double xCoordinate;
    private double yCoordinate;

    public Point(){
        xCoordinate = 0;
        yCoordinate = 0;
    }

    public Point(double xCoordinate,double yCoordinate){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate(){
        return xCoordinate;
    }

    public double getYCoordinate(){
        return yCoordinate;
    }
}
