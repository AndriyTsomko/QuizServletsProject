import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Question {

    private final String boxerImage;
    private final String firstOption;
    private final String secondOption;
    private final String thirdOption;
    private final String fourthOption;
    private final int trueAnswer;

    public String getCorrectAnswer() {
        return switch (this.trueAnswer) {
            case 1 -> this.getFirstOption();
            case 2 -> this.getSecondOption();
            case 3 -> this.getThirdOption();
            case 4 -> this.getFourthOption();
            default -> "";
        };
    }

}