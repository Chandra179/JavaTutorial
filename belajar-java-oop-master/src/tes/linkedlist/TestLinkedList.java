package tes.linkedlist;

public class TestLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList llist = new LinkedList();

		// Insert 6. So linked list becomes 6->NUllist
		llist.append(6);

		// Insert 7 at the beginning. So linked list becomes
		// 7->6->NUllist
		llist.push(7);

		// Insert 1 at the beginning. So linked list becomes
		// 1->7->6->NUllist
		llist.push(1);

		// Insert 4 at the end. So linked list becomes
		// 1->7->6->4->NUllist
		llist.append(4);

		// Insert 8, after 7. So linked list becomes
		// 1->7->8->6->4->NUllist
		llist.insertAfter(llist.head.next, 8);

		System.out.println("\nCreated Linked list is: ");
		llist.printList();

		System.out.println("\n");
		llist.deleteNode(7);
		llist.printList();

		llist.head = llist.new Node(65);
		llist.head.next = llist.new Node(15);
		llist.head.next.next = llist.new Node(4);
		llist.head.next.next.next = llist.new Node(20);
		llist.printList();

		llist.reverse(llist.head);
		System.out.println("\n");
		llist.printList();
	}

}
