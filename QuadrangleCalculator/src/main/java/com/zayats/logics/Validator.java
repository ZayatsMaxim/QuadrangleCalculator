package com.zayats.logics;

import com.zayats.data.DataException;
import com.zayats.entity.Point;
import com.zayats.entity.Quadrangle;
import org.apache.log4j.Logger;

public class Validator {
    private static final Logger LOGGER = Logger.getLogger(Creator.class);
    private static final String VALID_LINE_REGEX = "[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+";
    private static final String DELIMITER_REGEX = "\\s+";
    private static final int TOTAL_COORDINATES = 8;

    public boolean isValid(Quadrangle quadrangle){
        Point firstPoint = quadrangle.getQuadPoint(0);
        Point secondPoint = quadrangle.getQuadPoint(1);
        Point thirdPoint = quadrangle.getQuadPoint(2);
        Point fourthPoint = quadrangle.getQuadPoint(3);

        if(firstPoint == null || secondPoint == null || thirdPoint == null || fourthPoint == null){
            LOGGER.debug("This object is not a Quadrangle!");
            return false;
        }

        return true;
    }

    public boolean isValidLine(String line) throws DataException { // перегрузить?
        if (line == null || line.isEmpty()) {
            LOGGER.debug("This line is not Valid! : " + line);
            throw new DataException("Invalid line of data!");
        }
        String[] pointsFromLine = line.split(DELIMITER_REGEX);
        return line.matches(VALID_LINE_REGEX) && pointsFromLine.length == TOTAL_COORDINATES;
    }
}
