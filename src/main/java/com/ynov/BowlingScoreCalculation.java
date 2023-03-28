package com.ynov;

import java.util.List;

public class BowlingScoreCalculation {

    public Integer calculateScoreWithLaunch(List<Frame> frames){
        return frames.stream().map(Frame::getScore)
                .mapToInt(Integer::valueOf).sum();
    }
}