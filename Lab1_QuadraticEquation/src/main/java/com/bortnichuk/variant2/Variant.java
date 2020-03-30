package com.bortnichuk.variant2;

import java.util.List;
import java.util.Random;

public class Variant {
    private List<Question> questions;
    private String theme;

    Variant(List<Question> questions, String theme) {
        this.questions = questions;
        this.theme = theme;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    Question getRandomQuestion(){
        int index = new Random().nextInt(questions.size());
        return questions.get(index);
    }

    @Override
    public String toString() {
        return "Variant{" +
                "questions=" + questions +
                ", theme='" + theme + '\'' +
                '}';
    }
}
