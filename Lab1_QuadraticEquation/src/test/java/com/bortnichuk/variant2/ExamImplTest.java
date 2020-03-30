package com.bortnichuk.variant2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ExamImplTest {

    private Exam exam = new ExamImpl();
    private List<Variant> variants;


    @Before
    public void setUp() {
        List<Question> questionsFirst = new ArrayList<>();
        List<Question> questionsSecond = new ArrayList<>();
        List<Question> questionsThird = new ArrayList<>();

        questionsFirst.add(new Question("Question A"));
        questionsFirst.add(new Question("Question B"));
        questionsFirst.add(new Question("Question C"));

        questionsSecond.add(new Question("Question D"));
        questionsSecond.add(new Question("Question E"));
        questionsSecond.add(new Question("Question F"));

        questionsThird.add(new Question("Question G"));
        questionsThird.add(new Question("Question H"));
        questionsThird.add(new Question("Question I"));

        Variant variant1 = new Variant(questionsFirst, "Math");
        Variant variant2 = new Variant(questionsSecond, "English");
        Variant variant3 = new Variant(questionsThird, "Physics");

        List<Variant> variants = new ArrayList<>();

        variants.add(variant1);
        variants.add(variant2);
        variants.add(variant3);

        this.variants = variants;
    }

    @Test
    public void checkNumberOfQuestionsInTicketTest() {

        int expectedSize = 3;

        int result = exam.getTicket(variants).getQuestions().size();

        Assert.assertEquals(expectedSize, result);

    }

}