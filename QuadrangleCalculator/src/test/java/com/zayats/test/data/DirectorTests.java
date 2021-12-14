package com.zayats.test.data;

import com.zayats.data.DataException;
import com.zayats.data.DataReader;
import com.zayats.entity.Quadrangle;
import com.zayats.entity.QuadrangleExceptions;
import com.zayats.logics.Director;
import com.zayats.logics.Validator;
import com.zayats.logics.Creator;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class DirectorTests {
    private final static String PATH = "test";
    private final static String LINE = "1 1 2 2 3 3 4 4";
    private final static String INVALID_LINE = "1/1! y 2 3 3 q 4";
    private final static Quadrangle QUADRANGLE = Mockito.mock(Quadrangle.class);

    @Test
    public void testReadShouldCreateWhenIsValid() throws DataException, QuadrangleExceptions {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenReturn(Arrays.asList(LINE));

        Validator validator = Mockito.mock(Validator.class);
        when(validator.isValidLine(anyString())).thenReturn(true);
        when(validator.isValid(any(Quadrangle.class))).thenReturn(true);

        Creator creator = Mockito.mock(Creator.class);
        when(creator.createQuadrangle(LINE)).thenReturn(QUADRANGLE);

        Director director = new Director(reader, validator, creator);

        //when
        List<Quadrangle> quadrangles = director.read(PATH);

        //then
        Assert.assertEquals(1, quadrangles.size());
        Assert.assertEquals(quadrangles.get(0), QUADRANGLE);
    }

    @Test
    public void testReadShouldCreateWhenIsInvalid() throws DataException, QuadrangleExceptions {
        //given
        DataReader reader = Mockito.mock(DataReader.class);
        when(reader.read(anyString())).thenReturn(Arrays.asList(INVALID_LINE));

        Validator validator = Mockito.mock(Validator.class);
        when(validator.isValidLine(INVALID_LINE)).thenReturn(true);
        when(validator.isValid(any(Quadrangle.class))).thenReturn(true);

        Creator creator = Mockito.mock(Creator.class);
        when(creator.createQuadrangle(INVALID_LINE)).thenReturn(QUADRANGLE);

        Director director = new Director(reader, validator, creator);

        //when
        List<Quadrangle> quadrangles = director.read(PATH);

        //then
        Assert.assertTrue(quadrangles.isEmpty());
    }
}
