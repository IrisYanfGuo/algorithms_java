package datastru;


/**
 * InterfaceName:ILinkedList
 * Version:1.0
 * Time : 12:54 19.Nov 2016
 *
 * @author Yanfang Guo <yanfguo@outlook.com <yanfguo@vub.ac.be>
 */
public interface ILinkedList<E> {

    void addFirst(E o);
    LinkedList addLast(E o);
    void append(LinkedList<E> a);

    E get(int i);
    E getFirst();

    E popFirst();

    LinkedList<E> print();

    int size();

}
