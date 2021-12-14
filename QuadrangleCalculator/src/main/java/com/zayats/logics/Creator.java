package com.zayats.logics;

import com.zayats.entity.Quadrangle;
import com.zayats.entity.Point;
import com.zayats.data.DataException;
import com.zayats.entity.QuadrangleExceptions;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Creator {
    private static final Logger LOGGER = Logger.getLogger(Creator.class);

    public Quadrangle createQuadrangle(String line) throws QuadrangleExceptions, DataException{
        LOGGER.debug("Creating an object: " + line);
        String[] splitLines = line.split(" ");

        Double firstPointX = Double.parseDouble(splitLines[0]);
        Double firstPointY = Double.parseDouble(splitLines[1]);
        Double secondPointX = Double.parseDouble(splitLines[2]);
        Double secondPointY = Double.parseDouble(splitLines[3]);
        Double thirdPointX = Double.parseDouble(splitLines[4]);
        Double thirdPointY = Double.parseDouble(splitLines[5]);
        Double fourthPointX = Double.parseDouble(splitLines[6]);
        Double fourthPointY = Double.parseDouble(splitLines[7]);

        Point firstPoint = new Point(firstPointX, firstPointY);
        Point secondPoint = new Point(secondPointX, secondPointY);
        Point thirdPoint = new Point(thirdPointX, thirdPointY);
        Point fourthPoint = new Point(fourthPointX, fourthPointY);

        ArrayList<Point> createdPoints = new ArrayList<>();
        createdPoints.add(firstPoint);
        createdPoints.add(secondPoint);
        createdPoints.add(thirdPoint);
        createdPoints.add(fourthPoint);

        Quadrangle createdQuad = new Quadrangle(createdPoints);

        return createdQuad;
    }
}
