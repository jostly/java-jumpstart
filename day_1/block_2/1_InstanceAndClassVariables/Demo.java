public class Demo {
	private static int classInt;
	private int memberInt;

	private void printState(String header) {
		System.out.println(header + ": classInt = " + classInt + ", memberInt = " + memberInt);
	}

	public static void main(String[] args) {
		Demo a = new Demo();
		Demo b = new Demo();

		a.printState("a before setting values");
		b.printState("b before setting values");

		a.classInt = 42;
		a.memberInt = 7;

		a.printState("a after setting a");
		b.printState("b after setting a");

		b.classInt = 12;
		b.memberInt = 19;

		a.printState("a after setting b");
		b.printState("b after setting b");
	}
}





