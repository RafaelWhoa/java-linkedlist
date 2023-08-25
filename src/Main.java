public class Main {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> newList = new SinglyLinkedList<>();

        newList.addToFront(1);
        newList.addToFront(2);
        newList.addToFront(3);
        newList.addToBack(4);
        newList.addToBack(5);
        System.out.println("Removed element: " + newList.removeFromFront());

        rPrintElements(newList.getHead());
        System.out.println("Size: " + newList.size());
        System.out.println("Head: " + newList.getHead().getData());
        System.out.println("Tail: " + newList.getTail().getData());
    }

    private static void rPrintElements(SinglyLinkedListNode<Integer> currentNode){
        if (currentNode == null){
            System.out.println("null");
        }
        else {
            System.out.println(currentNode.getData());
            rPrintElements(currentNode.getNext());
        }
    }
}
