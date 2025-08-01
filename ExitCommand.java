public class ExitCommand implements assistant {
    @Override
    public void execute() {
        System.out.println(Colors.GREEN+"👋 Goodbye, Mr!"+Colors.RESET);
        System.exit(0);
    }

    @Override
    public String getCommandName() {
        return "exit";
    }
}
