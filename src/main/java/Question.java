import java.util.Objects;

public class Question {

    private final String boxerImage;
    private final String firstOption;
    private final String secondOption;
    private final String thirdOption;
    private final String fourthOption;
    private final Integer trueAnswer;

    public Question(String boxerImage, String firstOption, String secondOption, String thirdOption, String fourthOption, Integer trueAnswer) {
        this.boxerImage = boxerImage;
        this.firstOption = firstOption;
        this.secondOption = secondOption;
        this.thirdOption = thirdOption;
        this.fourthOption = fourthOption;
        this.trueAnswer = trueAnswer;
    }

    public String getBoxerImage() {
        return boxerImage;
    }

    public String getFirstOption() {
        return firstOption;
    }

    public String getSecondOption() {
        return secondOption;
    }

    public String getThirdOption() {
        return thirdOption;
    }

    public String getFourthOption() {
        return fourthOption;
    }

    public Integer getTrueAnswer() {
        return trueAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(boxerImage, question.boxerImage) && Objects.equals(firstOption, question.firstOption) && Objects.equals(secondOption, question.secondOption) && Objects.equals(thirdOption, question.thirdOption) && Objects.equals(fourthOption, question.fourthOption) && Objects.equals(trueAnswer, question.trueAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxerImage, firstOption, secondOption, thirdOption, fourthOption, trueAnswer);
    }
}