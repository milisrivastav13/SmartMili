import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeCommand implements assistant {
    @Override
    public void execute() {
        LocalTime time = LocalTime.now();
        System.out.println(Colors.NEW+"🕒 Current time: "+Colors.RESET + time.format(DateTimeFormatter.ofPattern("hh:mm a")));
    }

    @Override
    public String getCommandName() {
        return "time";
    }
}