package Beans;

/**
 *
 * @author Savinda Keshan
 */
public class Question {

    String qId;
    String type;
    String answer;
    int qSize;
    int start;
    int end;
    int randSize;
    String order;
    String randAnswer;
    String from;

    Question(String qId, String type, String answer, int qSize) {
        this.qId = qId;
        this.type = type;
        this.answer = answer;
        this.qSize = qSize;
    }

    public String getId() {
        return qId;
    }

    public String getType() {
        return type;
    }

    public String getAnswer() {
        return answer;
    }

    public int getSize() {
        return qSize;
    }

    public String getOrder() {
        return order;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getFrom() {
        return from;
    }

    public String getRandAnswer() {
        return randAnswer;
    }

    public void setStart(int num) {
        start = num;
    }

    public void setEnd(int num) {
        end = num;
    }

    public void setOrder(String order) {
        order = this.order;
    }

    public void setRand() {
        if (Math.random() < 0.5) {
            if (Math.random() < 0.5) {
                if (Math.random() < 0.5) {
                    order = "ACE";
                    randSize = 2;
                    from = "START";
                    randAnswer = answer.substring(0, 2);
                } else {
                    order = "DES";
                    randSize = 2;
                    from = "START";
                    randAnswer = new StringBuffer(answer.substring(0, 2)).reverse().toString();
                }
            } else if (Math.random() < 0.5) {
                order = "ACE";
                randSize = 2;
                from = "END";
                randAnswer = answer.substring(qSize - 2);
            } else {
                randSize = 2;
                order = "DES";
                from = "END";
                randAnswer = new StringBuffer(answer.substring(qSize - 2)).reverse().toString();
            }
        } else if (Math.random() < 0.5) {
            if (Math.random() < 0.5) {
                order = "ACE";
                randSize = 3;
                from = "START";
                randAnswer = answer.substring(0, 3);
            } else {
                order = "DES";
                randSize = 3;
                from = "START";
                randAnswer = new StringBuffer(answer.substring(0, 2)).reverse().toString();
            }
        } else if (Math.random() < 0.5) {
            order = "ACE";
            randSize = 3;
            from = "END";
            randAnswer = answer.substring(qSize - 3);
        } else {
            randSize = 3;
            order = "DES";
            from = "END";
            randAnswer = new StringBuffer(answer.substring(qSize - 3)).reverse().toString();
        }
    }

}