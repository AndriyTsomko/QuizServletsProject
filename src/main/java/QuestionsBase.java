import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.List;

@Getter
public class QuestionsBase {
    private static final Logger LOGGER = LogManager.getLogger(QuestionsBase.class);

    private static QuestionsBase instance;

    private final List<Question> questions;

    public QuestionsBase() {
        LOGGER.info("create questions instance");
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
            LOGGER.error("Error loading questions from file {}", filePath);
            return List.of();
        }
    }
}