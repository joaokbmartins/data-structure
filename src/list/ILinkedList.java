package list;

import list.Node;

public interface ILinkedList {

	public void insert();

	public void display();

	public Node search(int id);

	public void delete(int id);

	public void deleteFirst();
}
