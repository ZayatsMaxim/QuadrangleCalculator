package com.zayats.test.repository;

import com.zayats.entity.Point;
import com.zayats.entity.QuadrangleObservable;
import com.zayats.repository.QuadrangleRepositoryImpl;
import com.zayats.repository.comparators.PerimeterComparator;
import com.zayats.repository.specifications.DistanceSpecification;
import com.zayats.repository.specifications.IdSpecification;
import com.zayats.repository.specifications.InRangeSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepositoryTests {
    private final static QuadrangleRepositoryImpl REPOSITORY = new QuadrangleRepositoryImpl();
    private final ArrayList<Point> FIRST_QUAD_POINTS = new ArrayList<>();
    private final ArrayList<Point> SECOND_QUAD_POINTS = new ArrayList<>();

    @Test
    public void testQueryShouldReturnSpecifiedQuadranglesById(){
        //given
        FIRST_QUAD_POINTS.add(new Point(1,1));
        FIRST_QUAD_POINTS.add(new Point(5,1));
        FIRST_QUAD_POINTS.add(new Point(5,5));
        FIRST_QUAD_POINTS.add(new Point(1,5));
        QuadrangleObservable firstQuadrangle = new QuadrangleObservable(1, FIRST_QUAD_POINTS);

        SECOND_QUAD_POINTS.add(new Point(1,1));
        SECOND_QUAD_POINTS.add(new Point(6,1));
        SECOND_QUAD_POINTS.add(new Point(5,5));
        SECOND_QUAD_POINTS.add(new Point(1,5));
        QuadrangleObservable secondQuadrangle = new QuadrangleObservable(2, SECOND_QUAD_POINTS);

        REPOSITORY.add(firstQuadrangle);
        REPOSITORY.add(secondQuadrangle);

        List<QuadrangleObservable> expected = Arrays.asList(secondQuadrangle);

        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new IdSpecification(2));

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQueryShouldReturnSpecifiedQuadranglesByDistance(){
        //given
        FIRST_QUAD_POINTS.add(new Point(1,1));
        FIRST_QUAD_POINTS.add(new Point(5,1));
        FIRST_QUAD_POINTS.add(new Point(5,5));
        FIRST_QUAD_POINTS.add(new Point(1,5));
        QuadrangleObservable firstQuadrangle = new QuadrangleObservable(1, FIRST_QUAD_POINTS);

        SECOND_QUAD_POINTS.add(new Point(10,10));
        SECOND_QUAD_POINTS.add(new Point(60,10));
        SECOND_QUAD_POINTS.add(new Point(50,50));
        SECOND_QUAD_POINTS.add(new Point(10,50));
        QuadrangleObservable secondQuadrangle = new QuadrangleObservable(2, SECOND_QUAD_POINTS);

        REPOSITORY.add(firstQuadrangle);
        REPOSITORY.add(secondQuadrangle);

        List<QuadrangleObservable> expected = Arrays.asList(firstQuadrangle);

        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new DistanceSpecification(10));

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSortShouldReturnQuadranglesList(){
        //given
        FIRST_QUAD_POINTS.add(new Point(1,1));
        FIRST_QUAD_POINTS.add(new Point(5,1));
        FIRST_QUAD_POINTS.add(new Point(5,5));
        FIRST_QUAD_POINTS.add(new Point(1,5));
        QuadrangleObservable firstQuadrangle = new QuadrangleObservable(1, FIRST_QUAD_POINTS);

        SECOND_QUAD_POINTS.add(new Point(1,1));
        SECOND_QUAD_POINTS.add(new Point(4,1));
        SECOND_QUAD_POINTS.add(new Point(5,5));
        SECOND_QUAD_POINTS.add(new Point(1,3));
        QuadrangleObservable secondQuadrangle = new QuadrangleObservable(2, SECOND_QUAD_POINTS);

        REPOSITORY.add(firstQuadrangle);
        REPOSITORY.add(secondQuadrangle);

        List<QuadrangleObservable> expected = Arrays.asList(secondQuadrangle, firstQuadrangle);

        //when
        List<QuadrangleObservable> actual = REPOSITORY.sort(new PerimeterComparator());

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testQueryShouldReturnSpecifiedObjectsByRange(){
        //given
        FIRST_QUAD_POINTS.add(new Point(1,1));
        FIRST_QUAD_POINTS.add(new Point(5,1));
        FIRST_QUAD_POINTS.add(new Point(5,5));
        FIRST_QUAD_POINTS.add(new Point(1,5));
        QuadrangleObservable firstQuadrangle = new QuadrangleObservable(1, FIRST_QUAD_POINTS);

        SECOND_QUAD_POINTS.add(new Point(6,6));
        SECOND_QUAD_POINTS.add(new Point(9,6));
        SECOND_QUAD_POINTS.add(new Point(9,9));
        SECOND_QUAD_POINTS.add(new Point(6,9));
        QuadrangleObservable secondQuadrangle = new QuadrangleObservable(2, SECOND_QUAD_POINTS);

        REPOSITORY.add(firstQuadrangle);
        REPOSITORY.add(secondQuadrangle);

        List<QuadrangleObservable> expected = Arrays.asList(secondQuadrangle);

        //when
        List<QuadrangleObservable> actual = REPOSITORY.query(new InRangeSpecification(5,10,5,10));

        //then
        Assert.assertEquals(expected, actual);
    }
}
