import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswer;

    Question(String question, String[] options, int correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    boolean checkAnswer(int userAnswer) {
        return userAnswer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Questions
        Question[] quiz = new Question[4];
        quiz[0] = new Question(
                "What is the capital of India?",
                new String[]{"1. Mumbai", "2. New Delhi", "3. Chennai", "4. Kolkata"},
                2
        );

        quiz[1] = new Question(
                "Which language is platform independent?",
                new String[]{"1. C", "2. C++", "3. Java", "4. Python"},
                3
        );

        quiz[2] = new Question(
                "Which keyword is used to create object in Java?",
                new String[]{"1. class", "2. object", "3. new", "4. create"},
                3
        );

        quiz[3] = new Question(
                "Which company developed Java?",
                new String[]{"1. Google", "2. Microsoft", "3. Sun Microsystems", "4. Apple"},
                3
        );

        int score = 0;
        System.out.println("===== Welcome to Online Quiz System =====");

        for (int i = 0; i < quiz.length; i++) {
            Question q = quiz[i];
            System.out.println("\nQ" + (i + 1) + ": " + q.question);

            for (String option : q.options) {
                System.out.println(option);
            }

            int userAnswer = 0;
            boolean valid = false;

            while (!valid) {
                System.out.print("Enter your answer (1-4): ");
                if (sc.hasNextInt()) {
                    userAnswer = sc.nextInt();
                    if (userAnswer >= 1 && userAnswer <= 4) {
                        valid = true;
                    } else {
                        System.out.println("Please enter a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid input! Enter a number.");
                    sc.next(); // clear invalid input
                }
            }

            if (q.checkAnswer(userAnswer)) {
                System.out.println("Correct ✔");
                score++;
            } else {
                System.out.println("Wrong ❌");
            }
        }

        System.out.println("\n===== Quiz Finished =====");
        System.out.println("Your Score: " + score + "/" + quiz.length);

        if (score >= 3) {
            System.out.println("Result: PASS 🎉");
        } else {
            System.out.println("Result: FAIL 😐");
        }

        sc.close();
    }
}