package stack;

public class StackDemo {
	public static void main(String args[]) {
		Stack_Using_LinkedList<String> stringStack = new Stack_Using_LinkedList<>();
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
		
		Stack_Using_LinkedList<Integer> intStack = new Stack_Using_LinkedList<>();
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
