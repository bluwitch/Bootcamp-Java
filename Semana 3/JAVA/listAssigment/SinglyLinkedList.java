public class SinglyLinkedList {
    public Node head;
    public Node tail;

    public SinglyLinkedList() {
        // Constructor
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node runner = head;
            while (runner.next != null) {
                runner = runner.next;
            }
            runner.next = newNode;
        }
    }

    public void remove(int value) {
        if (head == null) {
            // La lista está vacía, no hay nada que eliminar
            return;
        }

        if (head.value == value) {
            // El nodo a eliminar es el primer nodo (head)
            head = head.next;
            return;
        }

        Node prevNode = head;
        Node currentNode = head.next;

        while (currentNode != null) {
            if (currentNode.value == value) {
                prevNode.next = currentNode.next;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
    }

    public void printValues() {
        Node runner = head;
        while (runner != null) {
            System.out.println(runner.value);
            runner = runner.next;
        }
    }

}
