package list.others;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
	String name;
	Node next;

	public Node(String name, Node next) {
		this.name = name;
		this.next = next;
	}

	public String toString() {
		return "\n\t\tName: " + this.name + " | " + "Next: [" + (this.next == null ? null : this.next.name) + "]";
	}
}

class NodeList {
	Node[] nodes;

	public NodeList(Node[] nodes) {
		this.nodes = nodes;
	}
}

public class LinkedListMenu {

	static Scanner sc = new Scanner(System.in);
	static NodeList root = new NodeList(new Node[0]);

	public static void append() {
		Node newNode = new Node(getNewNodeName(), null);
		Node[] nodesList = root.nodes;
		Node[] newNodesList = new Node[nodesList.length + 1];
		if (nodesList.length == 0) {
			root.nodes = new Node[1];
			root.nodes[0] = newNode;
			return;
		}
		for (int i = 0; i < nodesList.length; i++) {
			newNodesList[i] = nodesList[i];
		}
		newNodesList[nodesList.length - 1].next = newNode;
		newNodesList[nodesList.length] = newNode;
		root.nodes = newNodesList;
	}

	public static void readAll() {
		alert("Printing nodes:");
		readNode(root.nodes[0]);
	}

	public static void readNode(Node node) {
		if (node != null) {
			alert("\tNode: " + node.toString());
			if (node.next != null) {
				readNode(node.next);
			}
		}
	}

	public static void menu() {
		List<String> options = new ArrayList<>();
		options.add("Append");
		options.add("Remove");
		options.add("Read all");
		options.add("Exit");
		do {
			System.out.println("Menu:");
			for (int i = 1; i <= options.size(); i++) {
				String menu = options.get(i - 1);
				System.out.format("  %d) %s\n", i, menu);
			}
			System.out.print("Option: ");
			int option = sc.nextInt();

			if (option > options.size()) {
				System.out.println("Invalid option. Try again...");
				System.out.println("***************************************");
				continue;
			}

			String method = "";
			boolean first = true;
			for (String word : options.get(option - 1).split(" ")) {
				if (first) {
					method += word.toLowerCase();
					first = false;
					continue;
				}
				String firstChar = word.substring(0, 1);
				String capitalFistChar = firstChar.toUpperCase();
				word = word.replace(firstChar, capitalFistChar);
				method += word;
			}

			System.out.println("    Choosen menu: " + method);

			try {
				Method m = LinkedListMenu.class.getDeclaredMethod(method);
				m.invoke(0);
			} catch (Exception e) {
				System.err.println(e);
				;
			}
			System.out.println("***************************************");
		} while (true);
	}

	public static String getNewNodeName() {
		sc = new Scanner(System.in);
		String newNodeName = null;
		do {
			System.out.print("Node name: ");
			newNodeName = sc.nextLine();
		} while (newNodeName == null || "".equals(newNodeName.trim()));
		return newNodeName;
	}

	public static void main(String[] args) {
		menu();
	}

	public static void alert(String message) {
		System.out.println(message);
	}

	public static void exit() {
		System.out.println("EXITING\n************************************");
		System.exit(0);
	}

}
