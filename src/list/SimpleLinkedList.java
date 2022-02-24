package list;

import javax.swing.JOptionPane;

class Node {
	int id;
	Node next;

	public Node(int id, Node next) {
		this.id = id;
		this.next = next;
	}

	public String toString() {
		return "Node name: " + this.id + " | " + "Next: [" + (this.next == null ? null : this.next.id) + "]";
	}
}

class LinkedList {
	Node[] nodes;

	public LinkedList(Node[] nodes) {
		this.nodes = nodes;
	}
}

public class SimpleLinkedList implements ILinkedList {

	LinkedList root = new LinkedList(new Node[0]);

	public void menu() {
		String[] options = { "Exit", "Insert", "Delete", "Delete first", "Display", "Search" };
		String optionsMenu = "Menu: \n";
		for (int i = 0; i < options.length; i++) {
			optionsMenu += String.format("  %d) %s\n", i, options[i]);
		}
		optionsMenu += "Option: ";
		do {
			String option = JOptionPane.showInputDialog(null, optionsMenu);
			option = option == null ? "1" : option;
			switch (option) {
			case "0":
				this.exit();
			case "1":
				this.insert();
				break;
			case "2":
				this.delete(-1);
				break;
			case "3":
				this.deleteFirst();
				break;
			case "4":
				this.display();
				break;
			case "5":
				int id = this.readId("Search for id:");
				Node node = this.search(id);
				JOptionPane.showMessageDialog(null, "Node found: " + node.toString());
				break;
			default:
				invalidOptionAlert();
				continue;
			}
		} while (true);
	}

	@Override
	public void insert() {
		Node newNode = getNewNode();
		Node[] nodesList = this.root.nodes;
		Node[] newNodesList = new Node[nodesList.length + 1];
		if (nodesList.length == 0) {
			this.root.nodes = new Node[1];
			this.root.nodes[0] = newNode;
			return;
		}
		for (int i = 0; i < nodesList.length; i++) {
			newNodesList[i] = nodesList[i];
		}
		newNodesList[nodesList.length - 1].next = newNode;
		newNodesList[nodesList.length] = newNode;
		this.root.nodes = newNodesList;
	}

	@Override
	public void display() {
		String result = this.root.nodes.length == 0 ? "List is empty." : this.readNode(this.root.nodes[0], "");
		JOptionPane.showMessageDialog(null, result);
	}

	@Override
	public Node search(int id) {
		if (this.root.nodes.length == 0) {
			return null;
		}
		Node node = this.root.nodes[0];
		int i = 1;
		while (node != null && node.id != id) {
			node = node.next;
			i++;
		}
		return node;
	}

	@Override
	public void delete(int id) {
		System.out.println("TODO: implement \"Delete First\"");
	}

	@Override
	public void deleteFirst() {
		System.out.println("TODO: implement \"Delete First\"");
		Node[] nodes = this.root.nodes;
		Node[] aux = new Node[nodes.length - 2];
		for (int i = 0; i < nodes.length - 1; i++) {
			aux[i] = nodes[i + 1];
		}
		this.root.nodes = aux;
	}

	public String readNode(Node node, String text) {
		if (node != null) {
			text += "\n" + node.toString();
			text = this.readNode(node.next, text);
		}
		return text;
	}

	public Node getNewNode() {
		int nodeId;
		boolean found = false;
		do {
			nodeId = this.readId("Insert id: ");
			found = this.search(nodeId) == null ? false : true;
			if (found) {
				JOptionPane.showMessageDialog(null, "The name cannot be empty.");
			}
		} while (found);
		return new Node(nodeId, null);
	}

	public int readId(String message) {
		int id = 0;
		do {
			try {
				id = Integer.valueOf(JOptionPane.showInputDialog(null, message));
				break;
			} catch (Exception ex) {
				invalidOptionAlert();
			}
		} while (true);
		return id;
	}

	public void invalidOptionAlert() {
		JOptionPane.showMessageDialog(null, "Invalid option. Try again...");
	}

	public static void main(String[] args) {
		SimpleLinkedList sll = new SimpleLinkedList();
		sll.menu();
	}

	public void exit() {
		System.exit(0);
	}

}
