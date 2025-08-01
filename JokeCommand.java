import java.util.Random;

public class JokeCommand implements assistant {
    private final String[] jokes = {
        Colors.YELLOW+"Why do Java developers wear glasses? Because they don't C#!",
        "How many programmers does it take to change a light bulb? None, that's a hardware problem.",
        "I'm not lazy, I'm just on energy-saving mode."+Colors.RESET
    };

    @Override
    public void execute() {
        Random random = new Random();
        System.out.println(Colors.GREEN+"😂 Joke: "+Colors.RESET + jokes[random.nextInt(jokes.length)]);
    }

    @Override
    public String getCommandName() {
        return "joke";
    }
}
