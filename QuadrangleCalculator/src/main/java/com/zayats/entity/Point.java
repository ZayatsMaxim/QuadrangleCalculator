package com.zayats.entity;

public class Point {
    final private double xCoordinate;
    final private double yCoordinate;

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
