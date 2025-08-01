
# SmartMili

SmartMili is a fun and interactive Java-based command-line assistant designed to make your terminal more engaging and productive. It responds to user commands with helpful tools, jokes, fun messages, quick calculations, quizzes, and more – right from your terminal!

🧠 Features 

🕒 Time & Date – Check current time and today’s date

😂 Joke Generator – Get a random programming or geeky joke

🧮 Calculator – Solve simple math expressions like 5 * 2

🎓 Quiz Mode – Answer random questions and get your score

🔍 Google Search – Search directly from terminal using search: your query

💬 Help Menu – Lists all available commands

🔮 Fortune Teller – Receive a fun and random fortune message

❌ Exit Command – Exit SmartMili gracefully


## Deployment
✅ Requirements

Java JDK (version 8 or above)

Any Java IDE (like IntelliJ IDEA, Eclipse, or VS Code)

📦 Step-by-Step Deployment

1. Open Project in IDE
Open your Java IDE.
Import the SmartMili folder as a Java project.

2. Compile and Run

Locate the file: Main.java (or the file with your main() method).

Right-click on it → Run or use Run button in your IDE.

3. Use SmartMili

Once it starts, type any of these commands in the terminal to use SmartMili:

date       # shows today's date

time       # shows current time

joke       # tells a random joke

calc 5 * 2 # performs calculation

quiz       # starts a fun quiz

fortune    # shows a random life quote

search: AI tools  # opens Google for "AI tools"

exit       # closes the app
📌 Note 
Make sure your system supports GUI/browser if you use the search: command.
  

## FAQs (Frequently Asked Questions)

1. What is SmartMili?

SmartMili is a simple Java-based command console assistant that can tell jokes, show date/time, calculate expressions, start quizzes, give fortunes, and even search Google — all through terminal commands.

2. How do I run SmartMili?

Just open the project in a Java IDE (like IntelliJ or VS Code), run the Main.java file, and start typing commands in the terminal.

3. What commands are available?

You can use commands like:

date – Show today’s date

time – Show current time

joke – Tell a random joke

calc 5 * 2 – Perform math calculations

quiz – Play a fun quiz

fortune – Show a motivational quote

search: your query – Open a Google search in your browser

help – Show all available commands

exit – Close the app

4. I typed a command but got 'Unknown command'. Why?

Check for typos or make sure you're using lowercase (e.g., joke, not JOKE). Use help to see valid commands.

5. Can I add my own commands to SmartMili?

Yes! You can create a new class that implements the assistant interface and register it in CommandProcessor.java.

6. Does it require an internet connection?

Only the search: command needs internet (it opens Google in your browser). All other features work offline.

7. Can SmartMili run on mobile?

Currently, it's built for desktop Java environments. You can port it to Android in the future using Java for Android.


## Color Reference

🎨 Color Reference for SmartMili Console 

SmartMili uses ANSI escape codes to make the terminal colorful and user-friendly.

 Color Name	Usage in SmartMili	ANSI Code Example 

🔵 Colors.CYAN	Used for questions, section headers	\u001B[36m
🟡 Colors.YELLOW	Prompts, messages, jokes, fortune text	\u001B[33m
🟢 Colors.GREEN	Correct answers, success messages	\u001B[32m
🔴 Colors.RED	Errors, wrong answers, unknown commands	\u001B[31m
⚪ Colors.RESET	Resets to normal terminal color	\u001B[0m

 💡 Example Usage 

System.out.println(Colors.CYAN + "Current Time: " + LocalTime.now() + Colors.RESET);
System.out.println(Colors.RED + "Unknown command!" + Colors.RESET);

This will print colored messages in the terminal. If your terminal doesn’t support ANSI codes (like on Windows cmd), try running in terminals like Git Bash, VS Code, or Terminal on Linux/Mac.


## Demo

🎬 SmartMili Terminal Demo

Suppose the user types:

> time

Your Java program would output:

🔵 Current Time: 17:45:22.123

But with colors using ANSI codes, it looks like this in a supported terminal:

System.out.println(Colors.CYAN + "Current Time: " + LocalTime.now() + Colors.RESET);

🟦 Colors.CYAN applies the cyan color to the text.
⚪ Colors.RESET brings it back to default after the message.


✅ Correct Answer Demo

System.out.println(Colors.GREEN + "✅ Correct!" + Colors.RESET);

🔽 Output:

✅ Correct!

(in green)



❌ Wrong Answer Demo

System.out.println(Colors.RED + "❌ Wrong! The correct answer was: blue" + Colors.RESET);

🔽 Output:

❌ Wrong! The correct answer was: blue

(in red)
