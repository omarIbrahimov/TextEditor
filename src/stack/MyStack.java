package stack;

public class MyStack {
    private Node last=null;

    public void push(String content) {
        Node new1= new Node(content);
        new1.next=last;
        last=new1;
    }

    public String pop() {
        String returning=last.getContent();
        last=last.getNext();
        return returning;
    }
    public boolean isEmpty(){
        if(last==null){
            return true;
        }
        return false;
    }

}
