package stack;

public class StackDemo {
	public static void main(String args[]) {
		Stack<String> stringStack = new Stack<>();
		stringStack.push("e");
		stringStack.push("d");
		stringStack.push("c");
		stringStack.push("b");
		stringStack.push("a");
		stringStack.printStack();
		
		stringStack.pop();
		stringStack.printStack();
		stringStack.pop();
		stringStack.printStack();
		stringStack.pop();
		stringStack.printStack();
		
		Stack<Integer> intStack = new Stack<>();
		for(int i=10;i>0;i--) {
			intStack.push(i);
		}
		intStack.pop();
		intStack.printStack();
		intStack.pop();
		intStack.printStack();
		intStack.pop();
		intStack.printStack();
	}
}
