package editor;

public class TextEditor {

    private static class Node {
        String textState;
        Node prev;
        Node next;

        Node(String textState, Node prev, Node next) {
            this.textState = textState;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node currentNode;

    public TextEditor() {
        currentNode = new Node("", null, null);
    }

    public void add(String newText) {
        String updated = currentNode.textState + newText;
        currentNode.next = null;
        Node newNode = new Node(updated, currentNode, null);
        currentNode.next = newNode;
        currentNode = newNode;
    }

    public String undo() {
        if (currentNode.prev != null) {
            currentNode = currentNode.prev;
        }
        return currentNode.textState;
    }

    public String redo() {
        if (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return currentNode.textState;
    }

    public void printCurrent() {
        System.out.println(currentNode.textState);
    }
}
