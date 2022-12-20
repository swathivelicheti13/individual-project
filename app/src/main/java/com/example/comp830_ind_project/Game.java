package com.example.comp830_ind_project;

import android.widget.TextView;

public class Game{
    private Game yesQuestion;
    private Game noQuestion;
    public String question;

    public Game GetYesQuestion(){
        return yesQuestion;
    }

    public Game GetNoQuestion(){
        return noQuestion;
    }

    public String GetString(){
        return question;
    }

    private TextView questionView;
    public Game(String question) {
        this.question = question;
    }

    public void setYesQuestion(Game yesQuestion){
        this.yesQuestion = yesQuestion;
    }

    public void setNoQuestion(Game noQuestion){
        this.noQuestion = noQuestion;
    }

}

