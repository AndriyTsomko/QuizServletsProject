import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.InputStream;
import java.util.List;

@Getter
public class QuestionsBase {
    private static QuestionsBase instance;

    private final List<Question> questions;

    public QuestionsBase() {
        this.questions = loadQuestionsFromJson("/questions.json");
    }

    public static synchronized QuestionsBase getInstance() {
        if (instance == null) {
            instance = new QuestionsBase();
        }
        return instance;
    }

    private List<Question> loadQuestionsFromJson(String filePath) {
        try (InputStream is = getClass().getResourceAsStream(filePath)) {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(is, new TypeReference<>() {});
        } catch (Exception e) {
            System.out.println("Error loading questions from file " + filePath);
            return List.of();
        }
    }
}