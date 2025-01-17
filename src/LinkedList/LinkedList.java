package LinkedList;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node
    {
        int value;
        Node next;

        Node(int value)
        {
            this.value = value;
        }
    }

    public LinkedList(int value)
    {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    // Print List
    public void printList()
    {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
    }

    // Get Index Of Node
    public Node get(int index)
    {
        if (index < 0 || index >= length)
        {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    // Set Index Of Node
    public boolean set(int index, int value)
    {
        Node temp = get(index);
        if (temp!= null) {
            temp.value = value;
            return true;
        }

        // If index was out of range
        return false;
    }


    // Insert Index Of Node
    public boolean insert(int index, int value)
    {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length){
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);  // index - 1 is used to find the node that currently precedes the position where we want to insert the new node.
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;

    }


    // Add New Node To List
    public void append(int value)
    {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
//            System.out.println(tail.next.value + " ");
            tail = newNode;
        }
        length++;
    }


    // Prepend Node To List
    public void prepend(int value)
    {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;    // Set newNode equal head, indicating that will be the first of list, head is current number (11)
            head = newNode;         // And then set head to the current newNode ( if set is 3)
        }
        length++;
    }

    public void addLastIndex(int value)
    {
        Node newNode  = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = null;   // Sets the next reference of the new node to null, indicating that it will be the last node in the list.
            tail.next = newNode;  // updates the current tail's next reference to point to the new node.
            tail = newNode;
//            System.out.println("tail" + tail.value);
        }
        length++;
    }

    // Remove Node from the list
    public Node remove(int index)
    {
        if (index < 0 || index >= length) return null;

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp;
    }


    // Remove Last Node

    public Node removeLast()
    {
        if (length == 0) return null;
        Node temp = head;
        Node prev = head;

        while (temp.next != null)
        {
            prev = temp;
            temp = temp.next;
        }

        // If temp is null
        tail = prev;
        tail.next = null;
        length--;       // If length set is null then equal to 0

        if (length == 0) {
            head = null;    // Set head, tail to null
            tail = null;
        }
        return temp;
    }

    // Remove First Node
    public Node removeFirst()
    {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }
        return temp;
    }

    // Reverse linked list
    public void reverse()
    {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after = temp.next;
        Node before = null;
        for (int i = 0; i < length; i++) {
           after = temp.next;
           temp.next = before;
           before = temp;
           temp = after;
        }
    }

    // PRINT OUT VALUE OF HEAD AND TAIL

    public void getHead()
    {
        System.out.println("Head: " + head.value);
    }

    public void getTail()
    {
        System.out.println("Tail: " + tail.value);
    }

    public int getLength()
    {
        System.out.println("Length: " + length);
        return 0;
    }
}

