package com.bortnichuk.variant2;
import java.util.ArrayList;
import java.util.List;

public class ExamImpl implements Exam {

    public Ticket getTicket(List<Variant> variants) {

        List<Question> questionsInTicket = new ArrayList<>();

        for (Variant variant: variants) {
            questionsInTicket.add(variant.getRandomQuestion());
        }

        return new Ticket(questionsInTicket);
    }

}
