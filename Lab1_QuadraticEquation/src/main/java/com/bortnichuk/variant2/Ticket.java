package com.bortnichuk.variant2;

import java.util.List;

public class Ticket {

    private List<Question> questions;

    public Ticket(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "questions=" + questions +
                '}';
    }
}
