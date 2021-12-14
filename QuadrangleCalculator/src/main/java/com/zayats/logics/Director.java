package com.zayats.logics;

import com.zayats.data.DataException;
import com.zayats.data.DataReader;
import com.zayats.entity.Quadrangle;
import com.zayats.entity.QuadrangleExceptions;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Director {
    private static final Logger LOGGER = Logger.getLogger(Creator.class);
    private final DataReader reader;
    private final Validator validator;
    private final Creator creator;

    public Director(DataReader reader, Validator validator, Creator creator){
        this.reader = reader;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Quadrangle> read(String filePath){
        LOGGER.debug("Provided filePath: " + filePath);
        List <Quadrangle> quads = new ArrayList<>();
        try {
            for (String pointsLine : reader.read(filePath)) {
                Quadrangle quadrangle = creator.createQuadrangle(pointsLine);
                quads.add(quadrangle);
            }
        }catch (DataException | QuadrangleExceptions e) {
            LOGGER.warn(e);
        }
        LOGGER.info("Successfully created a list of quadrangles!");
        return quads;
    }
}
