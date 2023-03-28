package com.ynov;

public class Frame {
    int firstLaunchScore;
    int secondLaunchScore;

    public Frame(int firstLaunchScore, int secondLaunchScore) {
        if(firstLaunchScore == 10 && secondLaunchScore > 0){
            throw new IllegalStateException("Can't have a second throw after a strike");
        }
        if (firstLaunchScore + secondLaunchScore > 10 || firstLaunchScore + secondLaunchScore < 0){
            throw new IllegalStateException("Can't have a sum of 10+ or -0");
        }
        this.firstLaunchScore = firstLaunchScore;
        this.secondLaunchScore = secondLaunchScore;
    }

    public int getScore() {
        return firstLaunchScore + secondLaunchScore;
    }


    public Boolean strike(){
        return firstLaunchScore == 10;
    }

    public Boolean spare(){
        return firstLaunchScore + secondLaunchScore == 10 && !strike();
    }
}
