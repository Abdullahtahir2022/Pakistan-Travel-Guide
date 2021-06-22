package com.example.quiz_app.Activities.models;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Quiz {
    public String id;
    public String title;
    public Map<String,Question> quiz = new HashMap<String, Question>();

    public Quiz(String id, String title){
        this.id = id;
        this.title = title;



    }

}
