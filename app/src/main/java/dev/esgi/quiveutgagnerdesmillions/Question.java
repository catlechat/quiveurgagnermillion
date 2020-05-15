package dev.esgi.quiveutgagnerdesmillions;

public class Question {
    private String ask;
    private String ans1;
    private String ans2;
    private String ans3;
    private String ansTrue;

    public Question(String ask, String ans1, String ans2, String ans3, String ansTrue) {
        this.ask = ask;
        this.ans1 = ans1;
        this.ans2 = ans2;
        this.ans3 = ans3;
        this.ansTrue = ansTrue;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

    public String getAns1() {
        return ans1;
    }

    public void setAns1(String ans1) {
        this.ans1 = ans1;
    }

    public String getAns2() {
        return ans2;
    }

    public void setAns2(String ans2) {
        this.ans2 = ans2;
    }

    public String getAns3() {
        return ans3;
    }

    public void setAns3(String ans3) {
        this.ans3 = ans3;
    }

    public String getAnsTrue() {
        return ansTrue;
    }

    public void setAnsTrue(String ansTrue) {
        this.ansTrue = ansTrue;
    }
}
