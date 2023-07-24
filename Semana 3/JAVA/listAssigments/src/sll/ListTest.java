package sll;

public class ListTest {

    public static void main(String[] args) {
        SinglyLinkedList lista = new SinglyLinkedList();

        lista.agregar(5);
        lista.agregar(10);
        lista.agregar(15);
        lista.agregar(34);
        lista.agregar(80);
        lista.eliminar(10);
        lista.imprimirValores();
    }
}