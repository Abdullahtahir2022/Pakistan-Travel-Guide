package com.example.quiz_app.Activities.models;

public class Question {
    String description;
    String option1;
    String option2;
    String option3;
    String option4;
    String cAnswer;
    String uAnswer;

    Question(    String description,
            String option1,
            String option2,
            String option3,
            String option4,
            String cAnswer,
            String uAnswer){


        this.cAnswer=cAnswer;
        this.description=description;
        this.option1=option1;
        this.option2=option2;
        this.option3=option3;
        this.option4=option4;
        this.uAnswer = uAnswer;
    }

}
