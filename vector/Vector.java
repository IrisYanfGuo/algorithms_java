
/**
 * @author yanfguo yanfguo@vub.ac.be 10 Oct 2016 13:07 Java second exercise
 */
public class Vector {

	/*
	 * this is a class about Vector
	 */
	protected Object data[];
	protected int count = 0;
	protected int capacity;

	public Vector() {
		// TODO Auto-generated constructor stub
	}

	public Vector(int capacity1) {
		data = new Object[capacity1];
		capacity = capacity1;
	}

	public int size() {
		return count;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Object get(int index) {
		return data[index];
	}

	public boolean contains(Object obj) {
		for (int i = 0; i < count; i++) {
			if (data[i] == obj)
				return true;
		}
		return false;
	}

	public void set(int index, Object obj) {
		data[index] = obj;
	}

	public void addFirst(Object item) {
		count++;
		if (isFull())
			extendCapacity();
		for (int i = count; i > 0; i--) {
			data[i] = data[i - 1];
		}
		data[0] = item;

	}

	public void addLast(Object o) {
		data[count] = o;
		count++;
		if (isFull())
			extendCapacity();
	}

	public Object getFirst() {
		return data[0];
	}

	public Object getLast() {
		return data[count - 1];
	}

	public void removeLast() {
		count--;
	}

	public void removeFirst() {
		for (int i = 0; i < count - 1; i++) {
			data[i] = data[i + 1];
		}
		count--;
	}

	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.print(data[i]);
			System.out.print(' ');
			// print 10 elements in one line
			if ((i + 1) % 10 == 0 & i >= 9)
				System.out.println();
		}
		System.out.println();
		System.out.println();
	}

	public void reverse() {
		Object temp;
		for (int i = 0; i < count / 2; i++) {
			temp = data[i];
			data[i] = data[count - 1 - i];
			data[count - 1 - i] = temp;
		}
	}

	// function 7, the double method
	public Vector vectorDouble() {
		Vector v2 = new Vector(count * 2 + 100);// create enough space to store
												// the elements
		for (int i = 0; i < count; i++) {
			v2.addLast(data[i]);
			v2.addLast(data[i]);
		}
		return v2;
	}

	public void copy(Vector v1) {
		for (int i = 0; i < v1.count; i++) {
			data[i] = v1.data[i];
		}
		count = v1.count;

	}

	// 8. interleaves two vectors. and it return to a new vector and the
	// original vector stay the same
	public Vector interleaves(Vector v2) {
		Vector v3 = new Vector(count + v2.count + 100); // always make v3's
														// capacity 100 larger
														// than the sum of v1
														// and v2
		v3.copy(this);
		for (int i = 0; i < v2.count; i++) {
			v3.addLast(v2.data[i]);
		}
		return v3;
	}

	// Add a method “private void extendCapacity()” to the vector class which
	// doubles the capacity of our vector.
	//
	private void extendCapacity() {
		Object[] data2 = new Object[capacity * 2];
		for (int i = 0; i < count; i++) {
			data2[i] = data[i];
		}
		capacity *= 2;
		data = data2;
	}

	public boolean isFull() {
		if (count >= capacity)
			return true;
		else
			return false;
	}
}
