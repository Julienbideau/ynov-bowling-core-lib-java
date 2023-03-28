package com.ynov;

import java.util.List;

public class BowlingScoreCalculation {

    public Integer calculateScoreWithLaunch(List<Frame> frames){
        int totalScore = 0;
        for(int i = 0; i < frames.size(); i++){
            Frame frame = frames.get(i);
            if (i == frames.size() -1){
                totalScore += calculateScoreOfLastFrame(frame);
                continue;
            }
            Frame nextFrame = frames.get(i + 1);
            Integer nextLaunchScore = getNextLaunch(nextFrame);
            if (i == frames.size() -2) {
                Integer secondNextLaunch = getSecondNextLaunch(nextFrame, nextFrame.secondLaunchScore);
                totalScore+= calculateScoreOfSingleFrame(frame, nextLaunchScore, secondNextLaunch);
                continue;
            }

            Frame secondNextFrame = frames.get(i + 2);
            Integer secondNextLaunch = getSecondNextLaunch(nextFrame, secondNextFrame.firstLaunchScore);
            totalScore+= calculateScoreOfSingleFrame(frame, nextLaunchScore, secondNextLaunch);

        }
        return totalScore;
    }

    private Integer getNextLaunch(Frame nextFrame){
        return nextFrame.firstLaunchScore;
    }

    private Integer getSecondNextLaunch(Frame nextFrame, Integer secondLaunch){
        if (nextFrame.strike()){
            return secondLaunch;
        }
        return nextFrame.secondLaunchScore;
    }

    protected Integer calculateScoreOfSingleFrame(Frame frame, Integer nextLaunchScore, Integer secondNextLaunchScore){
        if (frame.strike()){
            return 10 + nextLaunchScore+ secondNextLaunchScore;
        }
        if (frame.spare()){
            return 10 + nextLaunchScore;
        }
        return frame.getScore();
    }

    private Integer calculateScoreOfLastFrame(Frame frame){
        return frame.getScore();
    }
}