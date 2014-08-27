import java.util.Scanner;

public class HelloAgain {
  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    for (;;) {
      System.out.print("What's your name? ");
      String name = scanner.nextLine();
      if ("".equals(name)) {
        break;
      }
      System.out.println("Hello, " + name + ".");
    }
    System.out.println("Bye.");
    scanner.close();
  }
}
