package Algorithm;

/**
 *
 * @author Savinda Keshan
 */
import Beans.Question;
import Beans.User;
import DB.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class GenPassword {

    final int numGenQuestions = 5;

    public int getNumCustomQuestion(String userId) {
        return 5;
    }

    public int getRandNum(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }

    public int getCustomQsnum(int numAllCustomQs) {
        if (numAllCustomQs > 4) {
            return getRandNum(2, 4);
        } else if (numAllCustomQs > 0) {
            return getRandNum(1, numAllCustomQs);
        } else {
            return 0;
        }
    }

    public int getGenQsNum(int numCustomQs) {
        if (numCustomQs == 0) {
            return numGenQuestions;
        } else if (numCustomQs < 3) {
            return getRandNum(3, 5);
        } else {
            return getRandNum(1, 3);
        }
    }

    public ArrayList getCustomQs(String userId, int num) {
        ArrayList<Question> list = new ArrayList<Question>();
        User user = new User();

        try {
            DBConnection dbconn = new DBConnection();
            Connection myconnection = dbconn.connection();

            PreparedStatement ps = myconnection.prepareStatement("SELECT * FROM custom_question WHERE user_id=? ORDER BY RAND() LIMIT ?");

            ps.setString(1, userId);
            ps.setString(2, num + "");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question temp = new Question(rs.getString("id"), "CUSTOM", rs.getString("question"), rs.getString("answer"), Integer.parseInt(rs.getString("answer_length")));
                list.add(temp);
            }

            myconnection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }

    public ArrayList getGenQs(String userId, int num) {
        ArrayList<Question> list = new ArrayList<Question>();
        User user = new User();

        try {
            DBConnection dbconn = new DBConnection();
            Connection myconnection = dbconn.connection();

            PreparedStatement ps = myconnection.prepareStatement("SELECT general_question_answer.id, general_question_answer.answer, general_question_answer.answer_length, general_question.question FROM general_question_answer INNER JOIN general_question ON general_question_answer.question_id=general_question.id WHERE user_id=? ORDER BY RAND() LIMIT ?");

            ps.setString(1, userId);
            ps.setString(2, num + "");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Question temp = new Question(rs.getString("id"), "CUSTOM", rs.getString("question"), rs.getString("answer"), Integer.parseInt(rs.getString("answer_length")));
                list.add(temp);
            }

            myconnection.close();
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Question> genPassword(String userId) {

        int numAllCustomQs = getNumCustomQuestion("0");   //number of all custom questions
        int numCustomQs = getCustomQsnum(numAllCustomQs); //number of custom qustion going to select
        int numGenQs = getGenQsNum(4);          //number of general questions going to select

        System.out.println("Number of Custom questions : " + numCustomQs);
        System.out.println("Number of General questions : " + numGenQs);

        ArrayList<Question> customQs = getCustomQs(userId, numCustomQs); //selected custom questions
        ArrayList<Question> genQs = getGenQs(userId, numGenQs);          //selected general questions

        //selected custom questions and general questions
        ArrayList<Question> allQs = new ArrayList<Question>();

        //count custom questions and general questions
        int j = 0;
        int k = 0;

        //get random value between 0 and 1
        double rand = Math.random();
        String password = "";

        //take both custom and general questions to array list 
        for (int i = 0; i < numCustomQs + numGenQs; i++) {
            if (rand < 0.5) {
                if (j < numCustomQs) {
                    Question temp = customQs.get(j);
                    temp.setRand();
                    password += temp.getRandAnswer();
                    allQs.add(temp);
                    System.out.println("No : " + i + " Answer : " + temp.getAnswer() + " From : " + temp.getFrom() + " Order : " + temp.getOrder() + " Rand answer : " + temp.getRandAnswer());
                    j++;
                    rand = Math.random();
                    if (Math.random() < 0.2) {
                        String charString = "<>?!@#$%^&*";
                        Random random = new Random();
                        int index = random.nextInt(charString.length());
                        password += charString.charAt(index);
                        System.out.println(charString.charAt(index));
                        Question nw = new Question("none", "CHAR", "none", charString.charAt(index) + "", 1);
                        allQs.add(nw);
                    }
                } else {
                    Question temp = genQs.get(k);
                    temp.setRand();
                    password += temp.getRandAnswer();
                    allQs.add(temp);
                    System.out.println("No : " + i + " Answer : " + temp.getAnswer() + " From : " + temp.getFrom() + " Order : " + temp.getOrder() + " Rand answer : " + temp.getRandAnswer());
                    k++;
                    rand = Math.random();
                    if (Math.random() < 0.2) {
                        String charString = "<>?!@#$%^&*";
                        Random random = new Random();
                        int index = random.nextInt(charString.length());
                        password += charString.charAt(index);
                        System.out.println(charString.charAt(index));
                        Question nw = new Question("none", "CHAR", "none", charString.charAt(index) + "", 1);
                        allQs.add(nw);
                    }
                }
            } else if (k < numGenQs) {
                Question temp = genQs.get(k);
                temp.setRand();
                password += temp.getRandAnswer();
                allQs.add(temp);
                System.out.println("No : " + i + " Answer : " + temp.getAnswer() + " From : " + temp.getFrom() + " Order : " + temp.getOrder() + " Rand answer : " + temp.getRandAnswer());
                k++;
                rand = Math.random();
                if (Math.random() < 0.2) {
                    String charString = "<>?!@#$%^&*";
                    Random random = new Random();
                    int index = random.nextInt(charString.length());
                    password += charString.charAt(index);
                    System.out.println(charString.charAt(index));
                    Question nw = new Question("none", "CHAR", "none", charString.charAt(index) + "", 1);
                    allQs.add(nw);
                }
            } else {
                Question temp = customQs.get(j);
                temp.setRand();
                password += temp.getRandAnswer();
                allQs.add(temp);
                System.out.println("No : " + i + " Answer : " + temp.getAnswer() + " From : " + temp.getFrom() + " Order : " + temp.getOrder() + " Rand answer : " + temp.getRandAnswer());
                j++;
                rand = Math.random();
                if (Math.random() < 0.2) {
                    String charString = "<>?!@#$%^&*";
                    Random random = new Random();
                    int index = random.nextInt(charString.length());
                    password += charString.charAt(index);
                    System.out.println(charString.charAt(index));
                    Question nw = new Question("none", "CHAR", "none", charString.charAt(index) + "", 1);
                    allQs.add(nw);
                }
            }
        }
        return allQs;
    }
}
