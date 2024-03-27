package model;

/**
 *
 * @author hsuong
 * @param <T>
 */
public class MyList<T> {

    Node<T> head, tail;

    MyList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void add(T x) {
        if (isEmpty()) {
            head = tail = new Node(x, null);
        } else {
            Node<T> q = new Node(x, null);
            tail.setNext(q);
            tail = q;
        }
    }
    
    public void displayList() {
        Node<T> current = head;
        while (current != null) {
            System.out.println("" + current.toString());
            current = current.getNext();
        }
    }
    
    public void removeList(T x){
        Node<T> current = head;
        Node<T> pre = null;
        while (current != null) {
            if (current.getData() == x) {
                if (pre == null) {
                    head = head.getNext();
                    break;
                } else {
                    pre.setNext(current.getNext());
                    break;
                }
            } else {
                pre = current;
                current = current.getNext();
            }
        }
    }
    
    public boolean searchList(T x){
        if(isEmpty()){
            return false;
        }
        Node<T> current = head;
        while (current != null){
            if (current.getData().equals(x)){
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public T searchListReturn(T x){
        if(isEmpty()){
            return null;
        }
        Node<T> current = head;
        while (current != null){
            if (current.getData().equals(x)){
                return current.getData();
            }
            current = current.getNext();
        }
        return null;
    }

    
    public int getListSize(){
        Node<T> current = head;
        int i = 0;
        while (current != null){
            i += 1;
            current = current.getNext();
        }
        return i;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    
    public T[] toArray() {
        
        int count = 0;
        Node<T> current = head;
        while (current != null) {
            count++;
            current = current.getNext();
        }

        @SuppressWarnings("unchecked")
        T[] array = (T[]) new Object[count];
        current = head;
        for (int i = 0; i < count; i++) {
            array[i] = current.getData();
            current = current.getNext();
        }
        return array;
    }
    
    
}
