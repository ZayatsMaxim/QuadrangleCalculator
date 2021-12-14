package com.zayats.test.data;

import com.zayats.data.DataException;
import com.zayats.entity.Point;
import com.zayats.entity.Quadrangle;
import com.zayats.logics.Validator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ValidatorTests {

    @Test
    public void testIsValidLineWhenQuadIsValid() throws DataException {
        //given
        Validator validator = new Validator();
        String validLine = "1 1 2 2 3 3 4 4";

        //when
        boolean expected = validator.isValidLine(validLine);

        //then
        Assert.assertTrue(expected);
    }
}
