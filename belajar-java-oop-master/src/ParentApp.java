public class ParentApp {
	public static void main(String[] args) {

		Child child = new Child();
		child.name = "Eko";
		child.doIt();
		System.out.println(child.name);

		System.out.println("-----------");

		Parent parent = child;
		parent.doIt();
		System.out.println(parent.name);

	}
}
