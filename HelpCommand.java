import java.util.Map;

public class HelpCommand implements assistant {
    private final Map<String, assistant> commands;

    public HelpCommand(Map<String, assistant> commands) {
        this.commands = commands;
    }

    @Override
    public void execute() {
        System.out.println(Colors.RED+"💡 Available commands:"+Colors.RESET);
        for (String cmd : commands.keySet()) {
            System.out.println("• " + cmd);
        }
    }

    @Override
    public String getCommandName() {
        return "help";
    }
}
