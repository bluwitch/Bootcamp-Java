package sll;


public class SinglyLinkedList {

    public Nodo head;

    public SinglyLinkedList() {
        head = null;
    }

    public void agregar(int value) {
        Nodo nuevoNodo = new Nodo(value);
        if (head == null) {
            head = nuevoNodo;
        } else {
            Nodo current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(nuevoNodo);
        }

    }

    public void eliminar(int value) {
        if (head == null) {
            return;
        }
        if (head.getValue() == value) {
            head = head.getNext();
        }
        Nodo current = head;
        while (current.getNext() != null) {
            if (current.getNext().getValue() == value) {
                current.setNext(current.getNext().getNext());
                return;
            }
            current = current.getNext();
        }
    }

    public void imprimirValores() {
        Nodo current = head;
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

}
