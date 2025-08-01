import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

// Assuming these imports or classes exist in your project
// import javax.script.ScriptEngine;
// import javax.script.ScriptEngineManager;

public class CommandProcessor {
    private final Map<String, assistant> commands = new HashMap<>();

    public CommandProcessor(){
        registerCommand(new TimeCommand());
        registerCommand(new DateCommand());
        registerCommand(new JokeCommand());
        registerCommand(new ExitCommand());
        registerCommand(new HelpCommand(commands));  // pass the map itself
    }

    private void registerCommand(assistant command) {
        commands.put(command.getCommandName(), command);
    }

    public void process(String input) {
        assistant command = commands.get(input.toLowerCase());
        if (command != null) {
            try {
                command.execute();
            } catch (Exception e) {
                System.out.println(Colors.YELLOW + "Error while executing command: " + Colors.RESET + e.getMessage());
            }
        } else {
            System.out.println(Colors.YELLOW + "Unknown command. Type 'help' to see available commands." + Colors.RESET);
        }
    }

    public void processCommand(String input) {
        if (input == null || input.trim().isEmpty()) {
            return;
        }

        input = input.trim().toLowerCase();

        if (input.equals("date")) {
            handleDate();
        } else if (input.equals("time")) {
            handleTime();
        } else if (input.equals("joke")) {
            tellJoke();
        } else if (input.startsWith("calc ")) {
            handleCalc(input.substring(5)); // Extract the expression after "calc "
        } else if (input.equals("help")) {
            showHelp();
        } else if (input.equals("quiz")) {
            startQuiz(); }
        else if (input.startsWith("search:")) {
            handleSearch(input.substring(7).trim());
        } 
        else if (input.startsWith("ask:")) {
            handleAISearch(input.substring(4).trim());
}
         else if (input.equals("exit")) {
            handleExit();
        } 
        else if (input.startsWith("mood:")) {
            detectMood(input.substring(5).trim());
} 
        else if (input.startsWith("persona:")) {
    switchPersona(input.substring(8).trim());
   }
    else if (input.startsWith("music:")) {
    recommendMusic(input.substring(6).trim());
}
    else if (input.equals("fortune")) {
    handleFortune();
}
        else {
            System.out.println(Colors.RED + "Unknown command. Type 'help' to see available commands " + Colors.RESET);
        }
    }

    private void handleCalc(String input) {
        try {
            String[] parts = input.trim().split("\\s+");
            if (parts.length != 3) {
                throw new IllegalArgumentException("Format must be: number operator number (e.g. 5 * 2)");
            }

            double a = Double.parseDouble(parts[0]);
            String op = parts[1];
            double b = Double.parseDouble(parts[2]);

            double result;
            switch (op) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    if (b == 0) throw new ArithmeticException("Division by zero");
                    result = a / b;
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported operator: " + op);
            }

            System.out.println("= " + result);

        } catch (Exception e) {
            System.out.println("Invalid expression: " + e.getMessage());
        }
    }

    private void startQuiz() {
        Scanner scanner = new Scanner(System.in);

        String[][] questions = {
            {"What is the capital of India?", "delhi"},
            {"Which planet is known as the Red Planet?", "mars"},
            {"Who wrote 'Hamlet'?", "shakespeare"},
            {"What is 5 + 3?", "8"},
            {"What is the color of the sky on a clear day?", "blue"},
            {"Who is known as the father of computers?", "charles babbage"},
            {"What is the national animal of India?", "tiger"}
        };

        int score = 0;
        int totalQuestions = 3;

        System.out.println(Colors.YELLOW + "🎓 Welcome to the Quiz! Answer " + totalQuestions + " questions!" + Colors.RESET);

        Set<Integer> usedIndexes = new HashSet<>();

        for (int i = 1; i <= totalQuestions; i++) {
            int index;
            do {
                index = new Random().nextInt(questions.length);
            } while (usedIndexes.contains(index));
            usedIndexes.add(index);

            String question = questions[index][0];
            String correctAnswer = questions[index][1];

            System.out.println(Colors.CYAN + "\nQ" + i + ": " + question + Colors.RESET);
            System.out.print("> Your answer: ");
            String userAnswer = scanner.nextLine().trim().toLowerCase();

            if (userAnswer.equals(correctAnswer)) {
                System.out.println(Colors.GREEN + "✅ Correct!" + Colors.RESET);
                score++;
            } else {
                System.out.println(Colors.RED + "❌ Wrong! The correct answer was: " + correctAnswer + Colors.RESET);
            }
        }

        System.out.println(Colors.YELLOW + "\n🏁 Quiz Over!" + Colors.RESET);
        System.out.println(Colors.CYAN + "🎯 Your Score: " + score + " out of " + totalQuestions + Colors.RESET);
    }

    private void handleSearch(String argument) {
    if (argument.isEmpty()) {
        System.out.println(Colors.RED+"Please enter a search query."+Colors.RESET);
        return;
    }
    try {
        String query = argument.replace(" ", "+");
        String url = "https://www.google.com/search?q=" + query;
        java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        System.out.println(Colors.GREEN+"Opening Google search for: "+Colors.RESET + argument);
    } catch (Exception e) {
        System.out.println("Error opening browser: " + e.getMessage());
    }
}
     private void handleAISearch(String query) {
    System.out.println(Colors.NEW+"Thinking like ChatGPT... 🤔"+Colors.RESET);
    System.out.println(Colors.NEW+"🔍 Searching answer for: "+Colors.RESET + query);
    try {
        String url = "https://www.google.com/search?q=" + query.replace(" ", "+");
        java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        System.out.println("💡 (AI would say...) For a quick answer, check the first few links!");
    } catch (Exception e) {
        System.out.println("Error opening browser: " + e.getMessage());
    }
} 
private void handleFortune() {
    String[] fortunes = {
       Colors.CYAN+ "🔮 Fortune: A surprise project will bring great learning.",
        "🌟 Fortune: You will debug something successfully on the first try!",
        "💻 Fortune: A new tech skill is about to be unlocked.",
        "🧠 Fortune: Your creativity will shine today. Use it wisely.",
        "🔥 Fortune: You’re closer to your dream than you think."+Colors.RESET
    };
    int index = new Random().nextInt(fortunes.length);
    System.out.println(fortunes[index]);
}
    private void detectMood(String text) {
    text = text.toLowerCase();
    if (text.contains("happy") || text.contains("excited")) {
        System.out.println(Colors.GREEN+"😊 You seem cheerful! Keep smiling!"+Colors.RESET);
    } else if (text.contains("sad") || text.contains("depressed")) {
        System.out.println(Colors.YELLOW+"😢 It's okay to feel low. Sending virtual hugs!"+Colors.RESET);
    } else if (text.contains("angry")) {
        System.out.println(Colors.NEW_2+"😠 Try taking a deep breath... I’m here to listen."+Colors.RESET);
    } else {
        System.out.println(Colors.NEW_1+"🤖 I'm not sure, but I'm always here for you!"+Colors.RESET);
    }
}
    private void switchPersona(String style) {
    switch (style.toLowerCase()) {
        case "pirate":
            System.out.println( Colors.NEW_1+"☠️ Ahoy, Matey! Ye be talkin' to Cap’n Mili now!"+Colors.RESET);
            break;
        case "robot":
            System.out.println(Colors.NEW_1+"🤖 BEEP BOOP. Mili-AI protocol engaged. Hello human."+Colors.RESET);
            break;
        case "poet":
            System.out.println(Colors.NEW_1+"📝 Oh user of code, with fingers so swift,\nSmartMili greets you — a digital gift!"+Colors.RESET);
            break;
        default:
            System.out.println(Colors.RED+"🌈 Persona not found. Try: pirate, robot, poet."+Colors.RESET);
    }
}
    private void recommendMusic(String mood) {
    try {
        String url = "https://www.youtube.com/results?search_query=" + mood.replace(" ", "+") + "+playlist";
        java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        System.out.println(Colors.NEW_2+"🎧 Enjoy some music for your mood: " + Colors.RESET + mood);
    } catch (Exception e) {
        System.out.println("Error opening YouTube: " + e.getMessage());
    }
}
    private void tellJoke() {
        String[] jokes = {
            "Why did the java developer go broke? Because he used up all his cache!",
            "Why do programmers prefer dark mode? Because the light attracts bugs!",
            "What's a computer's favorite beat? An algo-rhythm!"
        };
        int index = (int) (Math.random() * jokes.length);
        System.out.println(Colors.YELLOW + " :D " + jokes[index] + Colors.RESET);
    }

    private void handleTime() {
        System.out.println(Colors.CYAN + "Current Time : " + java.time.LocalTime.now() + Colors.RESET);
    }

    private void handleExit() {
        System.out.println(Colors.YELLOW + "Goodbye! See you soon! " + Colors.RESET);
        System.exit(0);
    }

    private void showHelp() {
    System.out.println(Colors.CYAN + "Available commands:" + Colors.RESET);
    System.out.println(Colors.YELLOW + " date " + Colors.RESET + "- Show today's date");
    System.out.println(Colors.YELLOW + " time " + Colors.RESET + "- Show current time");
    System.out.println(Colors.YELLOW + " joke " + Colors.RESET + "- Tell a random joke");
    System.out.println(Colors.YELLOW + " calc <a op b> " + Colors.RESET + "- Calculate an expression (e.g. 5 * 2)");
    System.out.println(Colors.YELLOW + " quiz " + Colors.RESET + "- Take a short random quiz");
    System.out.println(Colors.YELLOW + " search:<query> " + Colors.RESET + "- Google the query in your browser");
    System.out.println(Colors.YELLOW + " mood:<your message> " + Colors.RESET + "- Analyze the mood of your message");
    System.out.println(Colors.YELLOW + " persona:<style> " + Colors.RESET + "- Switch assistant's personality (e.g. friendly, funny)");
    System.out.println(Colors.YELLOW + " music:<mood> " + Colors.RESET + "- Recommend music based on your mood");
    System.out.println(Colors.YELLOW + " fortune " + Colors.RESET + "- Get a random AI-generated fortune 🍀");
    System.out.println(Colors.YELLOW + " help " + Colors.RESET + "- Show this help message");
    System.out.println(Colors.YELLOW + " exit " + Colors.RESET + "- Exit this program");
}

    private void handleDate() {
        System.out.println(Colors.CYAN + "Today's Date : " + java.time.LocalDate.now() + Colors.RESET);
    }
}


