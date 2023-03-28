import com.ynov.BowlingScoreCalculation;
import com.ynov.Frame;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
}
