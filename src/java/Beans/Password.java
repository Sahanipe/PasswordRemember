package Beans;

/**
 *
 * @author Savinda Keshan
 */
import java.util.*;

class Password {

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
        for (int i = 0; i < num; i++) {
            Question temp = new Question(i + "", "CUSTOM", "abcdefg", 7);
            list.add(temp);
        }
        return list;
    }

    public ArrayList getGenQs(String userId, int num) {
        ArrayList<Question> list = new ArrayList<Question>();
        for (int i = 0; i < num; i++) {
            Question temp = new Question(i + "", "GENERAL", "ijklmn", 6);
            list.add(temp);
        }
        return list;
    }

    public String genPassword() {

        int numAllCustomQs = getNumCustomQuestion("0");
        int numCustomQs = getCustomQsnum(numAllCustomQs);
        int numGenQs = getGenQsNum(numCustomQs);

        System.out.println("Number of Custom questions : " + numCustomQs);
        System.out.println("Number of General questions : " + numGenQs);

        ArrayList<Question> customQs = getCustomQs("0", numCustomQs);
        ArrayList<Question> genQs = getGenQs("0", numGenQs);
        ArrayList<Question> allQs = new ArrayList<Question>();

        int j = 0;
        int k = 0;
        double rand = Math.random();
        String password = "";

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
                        Question nw = new Question(i + "", "CHAR", charString.charAt(index) + "", 1);
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
                        Question nw = new Question(i + "", "CHAR", charString.charAt(index) + "", 1);
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
                    Question nw = new Question(i + "", "CHAR", charString.charAt(index) + "", 1);
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
                    Question nw = new Question(i + "", "CHAR", charString.charAt(index) + "", 1);
                    allQs.add(nw);
                }
            }
        }
        return "Password : " + password;
    }
}
