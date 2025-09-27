import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/quiz")
public class QuizControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String level = req.getParameter("level");
        int totalTries = Level.fromString(level).getTries();

        session.removeAttribute("currentQuestionIndex");
        session.removeAttribute("tries");
        session.removeAttribute("questions");
        session.removeAttribute("totalTries");

        List<Question> questions = QuestionsBase.getInstance().getQuestions();

        if (!questions.isEmpty()) {
            session.setAttribute("questions", questions);
            session.setAttribute("currentQuestionIndex", 0);
            session.setAttribute("tries", 0);
            session.setAttribute("totalTries", totalTries);

            showQuestion(req, resp, 0);

        } else {
            resp.getWriter().println("Error: No questions available.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String answer = req.getParameter("answer");

        List<Question> questions = (List<Question>) session.getAttribute("questions");
        int currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
        int tries = (int) session.getAttribute("tries");
        int totalTries = (int) session.getAttribute("totalTries");

        Question currentQuestion = questions.get(currentQuestionIndex);
        String correctAnswer = currentQuestion.getCorrectAnswer();

        if (answer.equals(correctAnswer)) {
            currentQuestionIndex++;
            session.setAttribute("currentQuestionIndex", currentQuestionIndex);

            if (currentQuestionIndex < questions.size()) {
                showQuestion(req, resp, currentQuestionIndex);
            } else {
                req.getRequestDispatcher("/result.jsp").forward(req, resp);
            }
        } else {
            tries++;
            session.setAttribute("tries", tries);
            if (tries >= totalTries) {
                req.getRequestDispatcher("/fail.jsp").forward(req, resp);
            } else {
                showQuestion(req, resp, currentQuestionIndex);
            }
        }
    }

    private void showQuestion(HttpServletRequest req, HttpServletResponse resp, int index) throws ServletException, IOException {
        HttpSession session = req.getSession();
        List<Question> questions = (List<Question>) session.getAttribute("questions");
        Question currentQuestion = questions.get(index);

        req.setAttribute("image", currentQuestion.getImage());
        req.setAttribute("options", currentQuestion.getOptions());
        req.setAttribute("currentQuestionIndex", index);
        req.setAttribute("tries", session.getAttribute("tries"));
        req.setAttribute("questionsCount", questions.size());

        req.getRequestDispatcher("/quiz.jsp").forward(req, resp);
    }
}