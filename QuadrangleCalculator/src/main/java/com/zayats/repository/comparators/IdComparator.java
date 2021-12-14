package com.zayats.repository.comparators;

import com.zayats.entity.QuadrangleObservable;

import java.util.Comparator;

public class IdComparator implements Comparator<QuadrangleObservable> {
    @Override
    public int compare (QuadrangleObservable firstQuad, QuadrangleObservable secondQuad){
        Integer firstId = firstQuad.getId();
        Integer secondId = secondQuad.getId();
        return firstId.compareTo(secondId);
    }
}
