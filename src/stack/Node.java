package stack;

class Node {
    String content;
    Node next;

    public Node(String content) {
        this.content=content;
        this.next=null;
    }

    public String getContent() {
        return content;
    }

    public Node getNext() {
        return next;
    }
}