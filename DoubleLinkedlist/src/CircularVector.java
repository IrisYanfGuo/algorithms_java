import java.util.Arrays;

/**
 * Created by Yanfang Guo on 2016/11/7.
 * <yanfguo@outlook.com> <yanfguo@vub.ac.be>
 */
public class CircularVector<E> {
    private E data[];
    private int first;
    private int size;
    private int capacity=10;

    public CircularVector() {
        data = (E[]) new Object[capacity];
    }

    public CircularVector(int capacity) {
        size = 0;
        first = 0;
        data = (E[])new Object[capacity];
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity;
            s = s + data[index] + " ";
        }
        s += "]";
        return s;
    }

    public int size() {
        return size;
    }

    public CircularVector addFirst(E o) {
        if (size >= capacity) {
            System.out.println("Can not add, the size exceed the capacity");
        } else {
            size++;
            first = (first + capacity - 1) % capacity;
            data[first] = o;
        }
        return this;

    }

    public CircularVector addLast(E o) {
        if (size >= capacity) {
            System.out.println("Can not add, the size exceed the capacity");
        } else {
            data[(first + size) % capacity] = o;
            size++;
        }

        return this;
    }

    public E getFirst() {
        return data[first];
    }

    public E getLast() {
        return data[first + capacity];
    }

    public int getCapacity() {
        return capacity;
    }

    public CircularVector removeFirst() {
        if (size <= 0) {
            System.out.println("The vector is enpty,No element to remove");
        } else {
            first = (first + capacity + 1) % capacity;
            size--;
        }
        return this;
    }

    public CircularVector removeLast() {
        if (size <= 0) {
            System.out.println("The vector is enpty,No element to remove");
        } else {
            size--;
        }
        return this;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < size; i++) {
            int index = (first + i) % capacity;
            System.out.print(data[index] + " ");
        }
        System.out.println("]");
    }

}
