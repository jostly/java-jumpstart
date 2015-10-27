import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

public class HelloAgain {

	public static void main(String[] args) {		
		handle(new ByteArrayInputStream("Olle\nKalle\n\n".getBytes()));
	}
	
	public static void handle(InputStream myInput) {
		try(Scanner scanner = new Scanner(myInput)) {
			while(true) {
				println("What's your name?");
				String line = scanner.nextLine();
				switch (line) {
				case "":
					return;
				case "Johan":
					println("Welcome, you have full access.");
					break;
				default:
					println("Hello, " + line + ".");
					break;
				}
			}
		} catch (Exception e) {
			println("Oh no! " + e.toString());
		} finally {
			println("Bye.");
		}		
	}
	
	private static void println(String s) {
		System.out.println(s);
	}


}
