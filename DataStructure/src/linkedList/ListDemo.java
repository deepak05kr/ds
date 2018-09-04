package linkedList;

public class ListDemo {

	public static  void main(String args[]) {
		List<Integer> intList = new List<>();
		for(int i=0;i<10;i++) {
			intList.add(i);
		}
		intList.printList();
		
		List<String> stringList  = new List<>();
		stringList.add("a");
		stringList.add("b");
		stringList.add("c");
		stringList.add("d");
		stringList.add("e");
		stringList.add("f");
		stringList.printList();
		
		
	}
	
}
