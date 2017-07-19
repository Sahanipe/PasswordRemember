package Beans;

import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Savinda Keshan
 */
public class GeneralQuestionAnswer {

    String questionId;
    String userId;
    String answer;
    int answerSize;

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnswerSize() {
        answerSize = answer.length();
    }

    public String getQuestionId() {
        return questionId;
    }

    public String getUserId() {
        return userId;
    }

    public String getAnswer() {
        return answer;
    }

    public int getAnswerSize() {
        return answerSize;
    }

    public ArrayList<String> getAllQuestions() {
        ArrayList<String> qsList = new ArrayList<String>();
        try {
            DBConnection dbconn = new DBConnection();
            Connection myconnection = dbconn.connection();

            PreparedStatement ps = myconnection.prepareStatement("select question from general_question");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                qsList.add(rs.getString("question"));
            }

            myconnection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return qsList;
    }

    public boolean addAnswer(String userId, ArrayList<String> answers) {
        if (checkAnswers(answers)) {
            try {
                DBConnection dbconn = new DBConnection();
                Connection myconnection = dbconn.connection();

                PreparedStatement ps = myconnection.prepareStatement("select id from general_question");
                PreparedStatement ps2 = myconnection.prepareStatement("INSERT INTO general_question_answer (question_id, user_id, answer, answer_length) VALUES (?, ?, ?,?),(?, ?, ?,?),(?, ?, ?,?),(?, ?, ?,?),(?, ?, ?,?),(?, ?, ?,?)");

                ResultSet rs = ps.executeQuery();
                int i = 0;
                while (rs.next()) {
                    ps2.setString((i * 4) + 1, rs.getString("id"));
                    ps2.setString((i * 4) + 2, userId);
                    ps2.setString((i * 4) + 3, answers.get(i));
                    ps2.setInt((i * 4) + 4, answers.get(i).length());
                }

                ps2.execute();

                myconnection.close();
                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean checkAnswers(ArrayList<String> answers) {
        for (int i = 0; i < answers.size(); i++) {
            if (answers.get(i).contains(" ")) {
                return false;
            }
        }
        return true;
    }

}
