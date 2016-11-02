package stacks;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack aStack = new Stack();
		aStack.push(2);
		aStack.push(3);
		aStack.push(6);
		aStack.push(5);
		System.out.println(aStack.size());
		aStack.pop();
		System.out.println(aStack.pop());
		System.out.println(aStack.top());
		System.out.println(aStack.size());

	}

}
