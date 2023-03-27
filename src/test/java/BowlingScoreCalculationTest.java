import com.ynov.BowlingScoreCalculation;
import com.ynov.Launch;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BowlingScoreCalculationTest {

    BowlingScoreCalculation bowlingScoreCalculation = new BowlingScoreCalculation();

    @Test
    public void giveTenTimesOShouldGetOScore(){
        final List<Launch> launches = IntStream.range(0, 10).mapToObj(x -> new Launch(0)).toList();
        final Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(launches);
        assertEquals(0, score);
    }

    @Test
    public void giveTenTimes1ShouldGet10Score(){
        final List<Launch> launches = IntStream.range(0, 10).mapToObj(x -> new Launch(1)).toList();
        final Integer score = bowlingScoreCalculation.calculateScoreWithLaunch(launches);
        assertEquals(10, score);
    }
}
