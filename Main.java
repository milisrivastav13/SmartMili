 import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println(Colors.NEW+"👋 Hello Mr! I'm SmartMili 🤖"+Colors.RESET);
        System.out.println(Colors.NEW+"Type 'help' to see what I can do.\n"+Colors.RESET);

        CommandProcessor processor = new CommandProcessor();
        Scanner scanner = new Scanner(System.in);
        

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            processor.processCommand(input);
        }
    }
}
