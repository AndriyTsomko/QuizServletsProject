import java.util.ArrayList;
import java.util.List;

public class QuestionsBase {
    private static QuestionsBase instance;

    private List<Question> questions;

    public QuestionsBase() {
        this.questions = new ArrayList<>();

        questions.add(new Question("ali.jpg", "Олександр Усик",
                "Василь Ломаченко",
                "Флойд Мейвезер",
                "Мухаммед Алі", 4));

        questions.add(new Question("lomachenko.jpg",
                "Джервонта Девіс",
                "Олександр Усик",
                "Теофімо Лопес",
                "Василь Ломаченко", 4));

        questions.add(new Question("manny.jpg",
                "Менні Пакьяо",
                "Флойд Мейвезер",
                "Оскар Де Ла Хойя",
                "Мігель Котто", 1));

        questions.add(new Question("usyk.jpg",
                "Олександр Усик",
                "Тайсон Ф'юрі",
                "Ентоні Джошуа",
                "Володимир Кличко", 1));

        questions.add(new Question("maywether.jpg",
                "Менні Пакьяо",
                "Канело Альварес",
                "Конор МакГрегор",
                "Флойд Мейвезер", 4));

        questions.add(new Question("canelo.jpg",
                "Менні Пакьяо",
                "Канело Альварес",
                "Конор МакГрегор",
                "Флойд Мейвезер", 2)
        );
        questions.add(new Question("ggg.jpg",
                "Тайсон Ф'юрі",
                "Джо Фрейзер",
                "Генадій Головкін",
                "Дмитро Бівол", 3));
        questions.add(new Question("tyson.jpg",
                "Евандер Холіфілд",
                "Майк Тайсон",
                "Джо Луїс",
                "Наоя Іноуе", 2));
        questions.add(new Question("fury.jpg",
                "Олександр Гвоздик",
                "Флойд Мейвезер",
                "Тайсон Ф'юрі",
                "Ентоні Джошуа", 3));
        questions.add(new Question("bivol.jpg",
                "Джо Луїс",
                "Дмитро Бівол",
                "Олександр Гвоздик",
                "Наоя Іноуе", 2));
    }

    public static synchronized QuestionsBase getInstance() {
        if (instance == null) {
            instance = new QuestionsBase();
        }
        return instance;
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
