package com.bortnichuk.variant2;

public class Question {

    private String questionObj;

    public Question(String questionObj) {
        this.questionObj = questionObj;
    }

    public String getQuestionObj() {
        return questionObj;
    }

    public void setQuestionObj(String questionObj) {
        this.questionObj = questionObj;
    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + questionObj + '\'' +
                '}';
    }
}
