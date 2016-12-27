import java.util.*;

/**
 * InterfaceName:ILinkedList
 * Version:1.0
 * Time : 12:54 19.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public interface ILinkedList<E> {

    public void addFirst(E o);
    public LinkedList addLast(E o);
    public  void append(LinkedList a);

    public E get(int i);
    public E getFirst();

    public E popFirst();

    public LinkedList<E> print();

    public int size();

}
