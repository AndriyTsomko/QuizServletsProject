import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Question {

    private String image;
    private List<String> options;
    private int trueAnswer;

    public String getCorrectAnswer() {
        return options.get(trueAnswer - 1);
    }

}