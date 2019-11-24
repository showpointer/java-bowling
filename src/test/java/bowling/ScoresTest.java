package bowling;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class ScoresTest {
    @Test
    void Scores_생성() {
        List<Score> list = Arrays.asList(new Score(2), new Score(8));
        Scores scores = new Scores(list);

        assertThat(scores).isEqualTo(new Scores(Arrays.asList(new Score(2), new Score(8))));
    }

    @Test
    void Scores_두개이상_Score생성불가() {
        List<Score> list = new ArrayList<>();
        Scores scores = new Scores(list);

        assertThatIllegalStateException().isThrownBy(() -> {
           scores.add(new Score(1));
           scores.add(new Score(3));
           scores.add(new Score(5));
        });
    }

    @Test
    void Scores_합10이상_불가() {
        List<Score> list = new ArrayList<>();
        Scores scores = new Scores(list);

        assertThatIllegalStateException().isThrownBy(() -> {
            scores.add(new Score(3));
            scores.add(new Score(8));
        });

    }
}
