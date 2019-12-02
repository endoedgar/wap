package net.endoedgar;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    final private String[] questions;
    final private int[] answers;
    private int currentQuestion;
    private int score;
    
    public Quiz() {
        this.questions = new String[]{
            "3, 1, 4, 1, 5", // pi
            "1, 1, 2, 3, 5", // fibonacci
            "1, 4, 9, 16, 25", // squares
            "2, 3, 5, 7, 11", // primes
            "1, 2, 4, 8, 16" // powers of 2
        };
        
        this.answers = new int[]{
            9, 8, 36, 13, 32
        };
        
        this.currentQuestion = 0;
        this.score = 0;
    }
    
    public boolean isFinished() {
        return this.currentQuestion >= questions.length;
    }
    
    public List<String> getCurrentQuestion() {
        List<String> output = new ArrayList<>();
        output.add("Your current score is " + this.score);
        if(isFinished()) {
            output.add("You have completed the Number Quiz, with a score of " + this.score + " out of " + this.questions.length + ".");
        } else {
            output.add("Guess the next number in sequence.");
            output.add(this.questions[this.currentQuestion]);
        }
        return output;
    }
    
    public void guess(int guess) {
        if(!isFinished()) {
            if(this.answers[this.currentQuestion] == guess)
                this.score++;
            
            this.currentQuestion++;
        }
    }
}
