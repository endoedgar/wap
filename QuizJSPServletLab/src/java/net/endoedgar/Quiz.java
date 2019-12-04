package net.endoedgar;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    final private String[] questions;
    final private int[] answers;
    final private String[] tips;
    private int currentQuestion;
    private int score;
    private int tries;
    private boolean showAnswerForPastQuestion;
    
    public Quiz() {
        this.questions = new String[]{
            "3, 1, 4, 1, 5", // pi
            "1, 1, 2, 3, 5", // fibonacci
            "1, 4, 9, 16, 25", // squares
            "2, 3, 5, 7, 11", // primes
            "1, 2, 4, 8, 16" // powers of 2
        };
        
        this.tips = new String[]{
            "pi",
            "fibonacci",
            "squares",
            "primes",
            "powers of 2"
        };
        this.answers = new int[]{
            9, 8, 36, 13, 32
        };
        
        this.currentQuestion = 0;
        this.score = 0;
        this.tries = 0;
        this.showAnswerForPastQuestion = false;
    }
    
    public boolean isFinished() {
        return this.currentQuestion >= questions.length;
    }
    
    public String getCurrentTip() {
        if(!isFinished()) {
            return this.tips[this.currentQuestion];
        }
        return "";
    }
    
    public List<String> getCurrentQuestion() {
        List<String> output = new ArrayList<>();
        output.add("Your current score is " + this.score);
        if(this.showAnswerForPastQuestion) {
            output.add("The answer for the sequence:");
            output.add(this.questions[this.currentQuestion-1]);
            output.add("was: " + this.answers[this.currentQuestion-1]);
            this.showAnswerForPastQuestion = false;
        }
        if(isFinished()) {
            output.add("You have completed the Number Quiz! Your final grade is: ");
            String grade;
            if(this.score >= 45) {
                grade = "A";
            } else if(this.score >= 35) {
                grade = "B";
            } else if(this.score >= 25) {
                grade = "C";
            } else {
                grade = "NC";
            }
            output.add("<span style=\"color: red; font-size: 200pt;\">" + grade + "<span>");
        } else {
            output.add("Guess the next number in sequence.");
            output.add(this.questions[this.currentQuestion]);
        }
        return output;
    }
    
    public void guess(int guess) {
        if(!isFinished()) {
            this.tries++;
            if(this.answers[this.currentQuestion] == guess || this.tries > 3) {
                switch(this.tries) {
                    case 1:
                        this.score += 10;
                        break;
                    case 2:
                        this.score += 5;
                        break;
                    case 3:
                        this.score += 2;
                        break;
                    case 4:
                        this.showAnswerForPastQuestion = true;
                        break;
                }
                this.tries = 0;
                this.currentQuestion++;
            }
        }
    }
}
