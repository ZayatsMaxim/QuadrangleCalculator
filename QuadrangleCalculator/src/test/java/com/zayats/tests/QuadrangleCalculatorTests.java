package com.zayats.tests;

import com.zayats.properties.Quadrangle;
import com.zayats.properties.Point;
import com.zayats.logics.Calculator;
import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

public class QuadrangleCalculatorTests {

    private final Calculator testCalculator = new Calculator();
    private final ArrayList<Point> testQuadPoints = new ArrayList<Point>();

    @Test
    public void testCalculatePerimeterWhenQuadIsSquare(){
        //given

        testQuadPoints.add(new Point(1,1));
        testQuadPoints.add(new Point(5,1));
        testQuadPoints.add(new Point(5,5));
        testQuadPoints.add(new Point(1,5));

        Quadrangle testQuad = new Quadrangle(testQuadPoints);

        //when
        double testPerimeter = testCalculator.calculateQuadranglePerimeter(testQuad);

        //then
        Assert.assertEquals(16, testPerimeter, 0.001);
    }

    @Test
    public void testCalculatePerimeterWhenQuadIsRectangle(){
        //given

        testQuadPoints.add(new Point(2,1));
        testQuadPoints.add(new Point(8,1));
        testQuadPoints.add(new Point(8,4));
        testQuadPoints.add(new Point(2,4));

        Quadrangle testQuad = new Quadrangle(testQuadPoints);

        //when
        double testPerimeter = testCalculator.calculateQuadranglePerimeter(testQuad);

        //then
        Assert.assertEquals(18, testPerimeter, 0.001);
    }

    @Test
    public void testCalculatePerimeterWhenQuadIsRandom(){
        //given

        testQuadPoints.add(new Point(1,1));
        testQuadPoints.add(new Point(6,2));
        testQuadPoints.add(new Point(3,3));
        testQuadPoints.add(new Point(1,7));

        Quadrangle testQuad = new Quadrangle(testQuadPoints);

        //when
        double testPerimeter = testCalculator.calculateQuadranglePerimeter(testQuad);

        //then
        Assert.assertEquals(18.73, testPerimeter, 0.01);
    }

    @Test
    public void testCalculateVectorLengthWhenVectorIsRandom(){
        //given
        Point testFirstPoint = new Point(1,1);
        Point testSecondPoint = new Point(6,6);

        //when
        double testVectorLength = testCalculator.calculateVectorLength(testFirstPoint, testSecondPoint);

        //then
        Assert.assertEquals(7.07, testVectorLength, 0.01);
    }

    @Test
    public void testCalculateSquareWhenQuadIsSquare(){
        //given

        testQuadPoints.add(new Point(1,1));
        testQuadPoints.add(new Point(6,1));
        testQuadPoints.add(new Point(6,6));
        testQuadPoints.add(new Point(1,6));

        Quadrangle testQuad = new Quadrangle(testQuadPoints);

        //when
        double testSquare = testCalculator.calculateQuadrangleSquare(testQuad);

        //then
        Assert.assertEquals(25, testSquare, 0.01);
    }

    @Test
    public void testCalculateVectorAngleWhenVectorIsRandom(){
        //given
        Point testFirstPoint = new Point(1,1);
        Point testSecondPoint = new Point(6,6);

        //when
        double testVectorAngle = testCalculator.calculateVectorAngle(testFirstPoint, testSecondPoint);

        //then
        Assert.assertEquals(45, testVectorAngle, 0.01);
    }
}
