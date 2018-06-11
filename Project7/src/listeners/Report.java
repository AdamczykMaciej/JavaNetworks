package listeners;
import java.util.*;

public class Report {
   private static List<String> rep = new ArrayList();

   public static void add(String s) {
     rep.add(s);
   }

   public static List<String> get() { return rep; }
}