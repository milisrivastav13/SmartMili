import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TestBrowser {
   public static void main(String[] var0) {
      try {
         String query = "best Java project ideas";
         String encodedQuery = URLEncoder.encode( query, StandardCharsets.UTF_8);
         String url = "https://www.google.com/search?q=" + encodedQuery;
         Desktop.getDesktop().browse(new URI(url));
      } catch (Exception e) {
         System.out.println("Error: " + e.getMessage());
      }

   }
}
