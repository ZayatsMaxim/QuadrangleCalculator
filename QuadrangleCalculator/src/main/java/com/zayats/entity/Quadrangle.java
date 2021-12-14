package com.zayats.entity;

import java.util.ArrayList;

public class Quadrangle {
    private final int QUAD_POINTS_NUM = 4;
    private ArrayList<Point> quadranglePoints = new ArrayList<Point>();

    public Quadrangle(){
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

    public void setQuadPoint(Point point, int index){
        quadranglePoints.set(index, point);
    }
}
