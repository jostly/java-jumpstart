public class HelloCommandline {
  public static void main(String[] args) throws Exception {
  	int numberOfArguments = args.length;

		for (int i = 0; i < numberOfArguments; i += 1) {
			String argument = args[i];

			System.out.println("Hello, " + argument);
		}

	}
}
