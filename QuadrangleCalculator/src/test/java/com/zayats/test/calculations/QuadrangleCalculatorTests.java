package com.zayats.test.calculations;

import com.zayats.entity.Quadrangle;
import com.zayats.entity.Point;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.logics.Calculator;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class QuadrangleCalculatorTests {

    private final Calculator TEST_CALCULATOR = new Calculator();
    private final ArrayList<Point> TEST_QUAD_POINTS = new ArrayList<>();

    @Test
    public void testCalculatePerimeterWhenQuadIsSquare(){
        //given

        TEST_QUAD_POINTS.add(new Point(1,1));
        TEST_QUAD_POINTS.add(new Point(5,1));
        TEST_QUAD_POINTS.add(new Point(5,5));
        TEST_QUAD_POINTS.add(new Point(1,5));

        QuadrangleObservable testQuad = new QuadrangleObservable(1, TEST_QUAD_POINTS);

        //when
        double testPerimeter = TEST_CALCULATOR.calculateQuadranglePerimeter(testQuad);

        //then
        Assert.assertEquals(16, testPerimeter, 0.001);
    }

    @Test
    public void testCalculatePerimeterWhenQuadIsRectangle(){
        //given

        TEST_QUAD_POINTS.add(new Point(2,1));
        TEST_QUAD_POINTS.add(new Point(8,1));
        TEST_QUAD_POINTS.add(new Point(8,4));
        TEST_QUAD_POINTS.add(new Point(2,4));

        QuadrangleObservable testQuad = new QuadrangleObservable(1, TEST_QUAD_POINTS);

        //when
        double testPerimeter = TEST_CALCULATOR.calculateQuadranglePerimeter(testQuad);

        //then
        Assert.assertEquals(18, testPerimeter, 0.01);
    }

    @Test
    public void testCalculatePerimeterWhenQuadIsRandom(){
        //given

        TEST_QUAD_POINTS.add(new Point(1,1));
        TEST_QUAD_POINTS.add(new Point(6,2));
        TEST_QUAD_POINTS.add(new Point(3,3));
        TEST_QUAD_POINTS.add(new Point(1,7));

        QuadrangleObservable testQuad = new QuadrangleObservable(1, TEST_QUAD_POINTS);

        //when
        double testPerimeter = TEST_CALCULATOR.calculateQuadranglePerimeter(testQuad);

        //then
        Assert.assertEquals(18.73, testPerimeter, 0.01);
    }

    @Test
    public void testCalculateVectorLengthWhenVectorIsRandom(){
        //given
        Point testFirstPoint = new Point(1,6);
        Point testSecondPoint = new Point(1,1);

        //when
        double testVectorLength = TEST_CALCULATOR.calculateVectorLength(testFirstPoint, testSecondPoint);

        //then
        Assert.assertEquals(5, testVectorLength, 0.01);
    }

    @Test
    public void testCalculateAreaWhenQuadIsSquare(){
        //given

        TEST_QUAD_POINTS.add(new Point(1,1));
        TEST_QUAD_POINTS.add(new Point(6,1));
        TEST_QUAD_POINTS.add(new Point(6,6));
        TEST_QUAD_POINTS.add(new Point(1,6));

        QuadrangleObservable testQuad = new QuadrangleObservable(1, TEST_QUAD_POINTS);

        //when
        double testSquare = TEST_CALCULATOR.calculateQuadrangleArea(testQuad);

        //then
        Assert.assertEquals(25, testSquare, 0.01);
    }

    @Test
    public void testCalculateVectorAngleWhenVectorIsRandom(){
        //given
        Point testFirstPoint = new Point(1,1);
        Point testSecondPoint = new Point(6,6);

        //when
        double testVectorAngle = TEST_CALCULATOR.calculateVectorAngle(testFirstPoint, testSecondPoint);

        //then
        Assert.assertEquals(0.78, testVectorAngle, 0.01);
    }

    @Test
    public void testIsQuadrangleWhenQuadIsRandom(){
        //given
        TEST_QUAD_POINTS.add(new Point(1,1));
        TEST_QUAD_POINTS.add(new Point(6,2));
        TEST_QUAD_POINTS.add(new Point(3,3));
        TEST_QUAD_POINTS.add(new Point(1,7));

        QuadrangleObservable testQuad = new QuadrangleObservable(1, TEST_QUAD_POINTS);

        //when
        boolean actual = TEST_CALCULATOR.isQuadrangle(testQuad);

        //then
        Assert.assertTrue(actual);
    } // перенести в тесты validator-a

    @Test
    public void testIsSquareWhenQuadIsRandom(){
        //given
        TEST_QUAD_POINTS.add(new Point(1,1));
        TEST_QUAD_POINTS.add(new Point(6,1));
        TEST_QUAD_POINTS.add(new Point(6,6));
        TEST_QUAD_POINTS.add(new Point(1,6));

        QuadrangleObservable testQuad = new QuadrangleObservable(1, TEST_QUAD_POINTS);

        //when
        boolean actual = TEST_CALCULATOR.isSquare(testQuad);

        //then
        Assert.assertTrue(actual);
    } // перенести в тесты validator-a

    @Test
    public void testCalculateScalarProductWhenPointsAreRandom(){
        //given
        Point testFirstPoint = new Point(1,1);
        Point testSecondPoint = new Point(1,5);
        Point testThirdPoint = new Point(3,3);

        //when
        double testVectorAngle = TEST_CALCULATOR.calculateScalarProduct(testFirstPoint, testSecondPoint, testThirdPoint);

        //then
        Assert.assertEquals(8, testVectorAngle, 0.01);
    }

    @Test
    public void testCalculateAngleBetweenVectorsWhenPointsAreRandom(){
        //given
        Point testFirstPoint = new Point(1,1);
        Point testSecondPoint = new Point(6,1);
        Point testThirdPoint = new Point(1,6);

        //when
        double testVectorAngle = TEST_CALCULATOR.calculateAngleBetweenVectors(testFirstPoint, testSecondPoint, testThirdPoint);

        //then
        Assert.assertEquals(1.57, testVectorAngle, 0.01);
    }
}
