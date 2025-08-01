// import java.time.LocalDate;
// import java.time.format.DateTimeFormatter;

// public class DateCommand implements assistant {
//     @Override
//     public void execute() {
//         LocalDate today = LocalDate.now();
//         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//         System.out.println(Colors.CYAN+"📅 Today's date: "+Colors.RESET + today.format(formatter));
//     }

//     @Override
//     public String getCommandName() {
//         return "date";
//     }
// }

public class DateCommand implements assistant {
    @Override
    public String getCommandName() {
        return "date";
    }

    @Override
    public void execute() {
        System.out.println(Colors.CYAN + "Today's Date : " + java.time.LocalDate.now() + Colors.RESET);
    }
}

