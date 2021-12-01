package com.zayats.properties;
import java.util.ArrayList;
import java.util.List;

public class Quadrangle {
    final int QUAD_POINTS_NUM = 4;
    private ArrayList<Point> quadranglePoints = new ArrayList<Point>();

    //private Point firstPoint;
    //private Point secondPoint;
    //private Point thirdPoint;
    //private Point fourthPoint;

    public Quadrangle(){
        /*Point firstPoint = new Point();
        Point secondPoint = new Point();
        Point thirdPoint = new Point();
        Point fourthPoint = new Point();*/

        for(int i=0;i < QUAD_POINTS_NUM; i++){
            Point point = new Point();
            quadranglePoints.add(point);
        }
    }

    public Quadrangle(ArrayList<Point> quadPoints){
        for(int i=0;i < QUAD_POINTS_NUM; i++){
            Point point = quadPoints.get(i);
            quadranglePoints.add(point);
        }
    }
    public Point getQuadPoint(int index){
        return quadranglePoints.get(index);
    }
    /*public Point getFirstPoint(){
        return firstPoint;
    }
    public Point getSecondPoint(){
        return secondPoint;
    }
    public Point getThirdPoint(){
        return thirdPoint;
    }
    public Point getFourthPoint(){
        return fourthPoint;
    }*/
}
