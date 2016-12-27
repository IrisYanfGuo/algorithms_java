
/**
 * ClassName:DoubleLinkedList
 * Version:1.0
 * Time : 13:45 28.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public class DoubleLinkedList<E> {
    private class DoubleLinkedListEl {
        private E data;
        private DoubleLinkedListEl next;
        private DoubleLinkedListEl prev;

        public DoubleLinkedListEl(E data, DoubleLinkedListEl next, DoubleLinkedListEl prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;

            if (next != null) {
                next.prev = this;
            }
            if (prev != null) {
                prev.next = this;
            }
        }

        public DoubleLinkedListEl(E data) {
            this.data = data;
        }

        public DoubleLinkedListEl getNext() {
            return next;
        }

        public DoubleLinkedListEl getPrev() {
            return prev;
        }

        public E getdata() {
            return data;
        }

        public void setNext(DoubleLinkedListEl next) {
            this.next = next;
        }

        public void setPrev(DoubleLinkedListEl prev) {
            this.prev = prev;
        }

        @Override
        public String toString() {
            return ""+ data;
        }
    }


    private int size;
    private DoubleLinkedListEl head;
    private DoubleLinkedListEl tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public E getFirst() {
        return head.getdata();
    }

    public E getLast() {
        return tail.getdata();
    }

    public void addFirst(E data) {
        head= new DoubleLinkedListEl(data, head, null);
        if (tail == null) tail= head;
        size++;
    }

    public void addLast(E data){
        tail = new DoubleLinkedListEl(data,null,tail);
        if (head == null) head = null;
        size++;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        String s= "[";
        DoubleLinkedListEl t = head;
        while (t!=null){
            s += t.toString()+" ";
            t= t.getNext();
        }
        s += "]";
        return s;
    }

    public void print(){
        System.out.println(toString());
    }

    public void printReverse(){
        System.out.print("[");
        DoubleLinkedListEl t = tail;
        while (t!=null){
            System.out.print(t);
            System.out.print(" ");
            t=t.prev;
        }
        System.out.print("]");
        System.out.println();
    }

    public void removeFirst(){
        if (head==null){
            System.out.println("empty list, can not removeFirst!");
        }else {
            head = head.next;
            if (head==null) tail=null;
            else head.setPrev(null);
            size--;
        }
    }

    public  void removeLast(){
        if (tail == null){
            System.out.println("Empty list, can not remove last");
        }else{
            tail= tail.prev;
            if(tail == null){
                head = null;
            }else{
                tail.setNext(null);
            }
            size--;
        }
    }

    public void reverse(){
        DoubleLinkedListEl t = head;
        while (t!=null){
            DoubleLinkedListEl t1= t.getPrev();
            t.setPrev(t.getNext());

            t.setNext(t1);
            t= t.getPrev();
        }

        t = head;
        head = tail;
        tail = t;
    }





}
