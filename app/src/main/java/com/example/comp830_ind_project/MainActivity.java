package com.example.comp830_ind_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private TextView questionView;
    private Button yesButton;
    private Button noButton;
    private Button endButton;
    private Game rootQuestion, flexible, singleInstance, singleton, builder,
            adapter,correct_guess,wrong_guess,communication,large_struct,behavior,
            scheme,state,strategy,observer,notify,command,run_time,decorator;
    private Game currentQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        questionView = findViewById(R.id.question);
        yesButton = findViewById(R.id.button);
        noButton = findViewById(R.id.button2);
        endButton = findViewById(R.id.button4);

        rootQuestion= new Game("Welcome to the game! Think of a design pattern and answer " +
                "these following yes/no questions.Ready?");
        flexible = new Game("Does it provide the object creation mechanism that enhance " +
                "the flexible of the existing code?");
        singleInstance = new Game("Does it ensure you have at most one instance of a class in your application?");
        singleton = new Game("Is it Singleton Pattern?");
        correct_guess = new Game("Woohoo! I guessed it! Try again?");
        wrong_guess = new Game("OOPS! Something went wrong! Try again?");
        builder = new Game("Is it builder pattern?");
        communication = new Game("Is it responsible for how one class communicates with others?");
        behavior = new Game("Does it provide a mechanism to the context to changes its behavior?");
        scheme = new Game("Is changing behavior built into its scheme?");
        state = new Game("Is it State Pattern?");
        strategy = new Game("Is it Strategy Pattern?");
        notify = new Game("Does it allow a group of objects to be notified when some state changes?");
        observer = new Game("Is it Observer Pattern?");
        command = new Game("Is it Command Pattern?");
        run_time = new Game("Does it attach additional behvior to an object dynamically at run-time?");
        decorator = new Game("Is it Decorator Pattern?");
        large_struct = new Game("Does it explain how to assemble objects and classes into a " +
                "larger structure and simplifies the structure by identifying the relationships?");
        adapter = new Game("Is it adapter pattern?");

        rootQuestion.setYesQuestion(flexible);
        flexible.setYesQuestion(singleInstance);
        flexible.setNoQuestion(communication);
        communication.setYesQuestion(behavior);
        behavior.setYesQuestion(scheme);
        scheme.setYesQuestion(state);
        state.setYesQuestion(correct_guess);
        state.setNoQuestion(wrong_guess);
        scheme.setNoQuestion(strategy);
        strategy.setYesQuestion(correct_guess);
        strategy.setNoQuestion(wrong_guess);
        behavior.setNoQuestion(notify);
        notify.setYesQuestion(observer);
        observer.setYesQuestion(correct_guess);
        observer.setNoQuestion(wrong_guess);
        notify.setNoQuestion(command);
        command.setYesQuestion(correct_guess);
        command.setNoQuestion(wrong_guess);
        communication.setNoQuestion(large_struct);
        large_struct.setYesQuestion(run_time);
        run_time.setYesQuestion(decorator);
        decorator.setYesQuestion(correct_guess);
        decorator.setNoQuestion(wrong_guess);
        run_time.setNoQuestion(adapter);
        adapter.setYesQuestion(correct_guess);
        adapter.setNoQuestion(wrong_guess);
        large_struct.setNoQuestion(wrong_guess);
        wrong_guess.setYesQuestion(rootQuestion);
        correct_guess.setYesQuestion(rootQuestion);
        singleInstance.setYesQuestion(singleton);
        singleton.setYesQuestion(correct_guess);
        singleton.setNoQuestion(wrong_guess);
        singleInstance.setNoQuestion(builder);
        builder.setYesQuestion(correct_guess);
        builder.setNoQuestion(wrong_guess);
        currentQuestion = rootQuestion;
        questionView.setText(currentQuestion.GetString());

        yesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                currentQuestion = currentQuestion.GetYesQuestion();
                questionView.setText(currentQuestion.GetString());
            }
        });

        noButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                currentQuestion = currentQuestion.GetNoQuestion();
                questionView.setText(currentQuestion.GetString());
            }
        });

        endButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent myIntent = new Intent(getApplicationContext(), StartActivity.class);
                startActivity(
                        myIntent);
            }
        });



    }




    /*
    *
    *     // Create the questions for the game
    Question creationalQuestion = new Game("Is the pattern a creational design pattern?",
      new Game("Is the pattern the Singleton pattern?",
        new BinaryQuestion("The pattern is the Singleton pattern!"),
        new Game("Is the pattern the Builder pattern?",
          new BinaryQuestion("The pattern is the Builder pattern!"),
          new Game("Is the pattern the Prototype pattern?",
            new BinaryQuestion("The pattern is the Prototype pattern!"),
            new GiveUpQuestion())));
    Question structuralQuestion = new Game("Is the pattern a structural design pattern?",
      new Game("Is the pattern the Adapter pattern?",
        new BinaryQuestion("The pattern is the Adapter pattern!"),
        new Game("Is the pattern the Bridge pattern?",
          new BinaryQuestion("The pattern is the Bridge pattern!"),
          new GiveUpQuestion())));
    Question behavioralQuestion = new Game("Is the pattern a behavioral design pattern?",
      new Game("Is the pattern the Chain of Responsibility pattern?",


    *
    * */
}