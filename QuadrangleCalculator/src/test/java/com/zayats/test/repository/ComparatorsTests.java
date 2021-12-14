package com.zayats.test.repository;

import com.zayats.entity.QuadrangleObservable;
import com.zayats.repository.comparators.AreaComparator;
import com.zayats.repository.comparators.IdComparator;
import com.zayats.repository.comparators.PerimeterComparator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

public class ComparatorsTests {
    private static final QuadrangleObservable FIRST_QUADRANGLE = Mockito.mock(QuadrangleObservable.class);
    private static final QuadrangleObservable SECOND_QUADRANGLE = Mockito.mock(QuadrangleObservable.class);

    @Test
    public void testIdComparatorShouldCompareById(){
        IdComparator comparatorEqual = Mockito.mock(IdComparator.class);
        when(comparatorEqual.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(0);
        IdComparator comparatorFirstIsMore = Mockito.mock(IdComparator.class);
        when(comparatorFirstIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(1);
        IdComparator comparatorSecondIsMore = Mockito.mock(IdComparator.class);
        when(comparatorSecondIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        int actualFirsMore = comparatorFirstIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        int actualSecondMore = comparatorSecondIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
    }

    @Test
    public void testAreaComparatorShouldCompareByArea(){
        AreaComparator comparatorEqual = Mockito.mock(AreaComparator.class);
        when(comparatorEqual.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(0);
        AreaComparator comparatorFirstIsMore = Mockito.mock(AreaComparator.class);
        when(comparatorFirstIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(1);
        AreaComparator comparatorSecondIsMore = Mockito.mock(AreaComparator.class);
        when(comparatorSecondIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        int actualFirsMore = comparatorFirstIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        int actualSecondMore = comparatorSecondIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
    }

    @Test
    public void testPerimeterComparatorShouldCompareByPerimeter(){
        //given
        PerimeterComparator comparatorEqual = Mockito.mock(PerimeterComparator.class);
        when(comparatorEqual.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(0);
        PerimeterComparator comparatorFirstIsMore = Mockito.mock(PerimeterComparator.class);
        when(comparatorFirstIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(1);
        PerimeterComparator comparatorSecondIsMore = Mockito.mock(PerimeterComparator.class);
        when(comparatorSecondIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE)).thenReturn(-1);
        //when
        int actualEqual = comparatorEqual.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        int actualFirsMore = comparatorFirstIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        int actualSecondMore = comparatorSecondIsMore.compare(FIRST_QUADRANGLE, SECOND_QUADRANGLE);
        //then
        Assert.assertEquals(0, actualEqual);
        Assert.assertEquals(1, actualFirsMore);
        Assert.assertEquals(-1, actualSecondMore);
    }
}
