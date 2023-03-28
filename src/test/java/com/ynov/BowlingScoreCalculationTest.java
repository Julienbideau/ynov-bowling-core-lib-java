package com.ynov;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class BowlingScoreCalculationTest {

    BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation();

    @Test
    public void giveTenTimesOShouldGetOScore(){
        final List<Frame> frames = IntStream.range(0, 10).mapToObj(x -> new Frame(0,0)).toList();
        final Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(frames);
        assertEquals(0, score);
    }

    @Test
    public void giveTenTimes1And0ShouldGet10Score(){
        final List<Frame> frames = IntStream.range(0, 10).mapToObj(x -> new Frame(1,0)).toList();
        final Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(frames);
        assertEquals(10, score);
    }

    @Test
    public void giveTenTimes1And1ShouldGet20Score(){
        final List<Frame> frames = IntStream.range(0, 10).mapToObj(x -> new Frame(1,1)).toList();
        final Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(frames);
        assertEquals(20, score);
    }

    @Test
    public void handleInitializationErrorAfterStrike(){
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> new Frame(10, 1));
        assertEquals("Can't have a second throw after a strike", illegalStateException.getMessage());
    }

    @Test
    public void handleInitializationErrorOnTotalScoreMoreThan10(){
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> new Frame(9, 3));
        assertEquals("Can't have a sum of 10+ or -0", illegalStateException.getMessage());
    }

    @Test
    public void handleInitializationErrorOnTotalScoreLessThan0(){
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> new Frame(-1, -1));
        assertEquals("Can't have a sum of 10+ or -0", illegalStateException.getMessage());
    }

    @Test
    public void handleInitializationErrorOnLastFrame(){
        IllegalStateException illegalStateException = assertThrows(IllegalStateException.class, () -> new Frame(1, 1, 10));
        assertEquals("Can't have a third launch without a spare or strike before", illegalStateException.getMessage());
    }

    @Test
    public void isStrikeOk(){
        Frame frame = new Frame(10, 0);
        assertTrue(frame.strike());
        assertFalse(frame.spare());
    }

    @Test
    public void isSpare(){
        assertFalse(new Frame(7, 3).strike());
        assertTrue(new Frame(7, 3).spare());
    }

    @Test
    public void calculateScoreOfSingleFrameWithStrike(){
        Integer score = bowlingScoreCalculation.calculateScoreOfSingleFrame(new Frame(10, 0), 10, 10);
        assertEquals(30, score);
    }

    @Test
    public void calculateScoreOfSingleFrameWithSpare() {
        Integer score = bowlingScoreCalculation.calculateScoreOfSingleFrame(new Frame(8, 2), 10, 10);
        assertEquals(20, score);
    }

    @Test
    public void calculateScoreOfMultipleStrikes(){
        Frame firstFrame = new Frame(10, 0);
        Frame secondFrame = new Frame(10, 0);
        Frame thirdFrame = new Frame(7, 3);
        Frame forthFrame = new Frame(0, 0);
        Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(List.of(firstFrame, secondFrame, thirdFrame, forthFrame));
        assertEquals(57, score);
    }

    @Test
    public void calculateScoreOfMultipleSpares(){
        Frame firstFrame = new Frame(0, 10);
        Frame secondFrame = new Frame(0, 10);
        Frame thirdFrame = new Frame(0, 0);
        Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(List.of(firstFrame, secondFrame, thirdFrame));
        assertEquals(20, score);
    }

    @Test
    public void calculateScoreSolutionOfCodingTest(){
        Frame firstFrame = new Frame(10, 0);
        Frame secondFrame = new Frame(10, 0);
        Frame thirdFrame = new Frame(7, 3);
        Frame forthFrame = new Frame(10, 0);
        Frame fifthFrame = new Frame(10, 0);
        Frame sixthFrame = new Frame(9, 1);
        Frame seventhFrame = new Frame(9, 1);
        Frame eighthFrame = new Frame(6, 3);
        Frame ninthFrame = new Frame(10, 0);
        Frame lastFrame=  new Frame(9, 1, 7);

        Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(List.of(firstFrame, secondFrame, thirdFrame, forthFrame, fifthFrame, sixthFrame, seventhFrame, eighthFrame, ninthFrame, lastFrame));
        assertEquals(197, score);
    }

}
