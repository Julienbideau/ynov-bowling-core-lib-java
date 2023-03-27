package com.ynov;

import java.util.List;

public class BowlingScoreCalculation {

    public Integer calculateScoreWithLaunch(List<Launch> launches){
        return launches.stream().map(Launch::getScore)
                .mapToInt(Integer::valueOf).sum();
    }
}