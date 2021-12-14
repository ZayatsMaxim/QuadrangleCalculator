package com.zayats.test.data;

import com.zayats.data.DataException;
import com.zayats.entity.Point;
import com.zayats.entity.Quadrangle;
import com.zayats.entity.QuadrangleExceptions;
import com.zayats.logics.Creator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class CreatorTests {
    private final static String LINE = "1 2 3 4 5 6 7 8";

    @Test
    public void testCreateQuadrangleWhenLineIsValid() throws DataException, QuadrangleExceptions {
        //given
        Creator creator = new Creator();
        Point firstPoint = new Point(1,2);
        Point secondPoint = new Point(3,4);
        Point thirdPoint = new Point(5,6);
        Point fourthPoint = new Point(7,8);
        ArrayList<Point> testPoints = new ArrayList<>();
        testPoints.add(firstPoint);
        testPoints.add(secondPoint);
        testPoints.add(thirdPoint);
        testPoints.add(fourthPoint);

        Quadrangle expected = new Quadrangle(testPoints);

        //when
        Quadrangle actual = creator.createQuadrangle(LINE);

        //then
        Assert.assertEquals(expected, actual);
    }
}
