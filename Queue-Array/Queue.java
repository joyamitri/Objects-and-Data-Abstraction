/*
_______________________________________________________________________________________________________________________

Program Description: This program's aim is to manage a Queue

_______________________________________________________________________________________________________________________

*/

public class Queue {
    // this is an implementation of queues using arrays.
	
	private int[] data;
	private int first;
	private int last;
	private int size;

	public Queue(int s) {
		// constructor that takes the initial size of the array to be initialized as
		// input and sets size and pointers to 0.
		data = new int[s];
		first = 0;
		last = 0;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void increaseSize() {
		// increases the size of the array when it is full.
		if (first == 0 && last == 0) {
			int s = data.length;
			int[] temp = new int[data.length * 2];
			for (int i = 0; i < data.length; i++) {
				temp[i] = data[i];
			}
			first = 0;
			last = s;
			data = temp;
		} else if (first > 0 && last <= first) {
			int s = data.length;
			int[] temp = new int[s * 2];
			int j = first;
			for (int i = 0; i < data.length; i++) {

				if (j < data.length) {
					temp[i] = data[j];
					j++;
				} else {
					j = 0;
					temp[i] = data[j];
					j++;
				}

			}
			data = temp;
			first = 0;
			last = s;

		}
	}

	public void enqueue(int k) {
		// takes an integer k and enqueues it to the queue
		if (first == last && size == 0) {
			first = 0;
			last = 0;
		}
		if (size == 0) {// or isEmpty()
			data[last] = k;
			if (last == data.length - 1) {
				last = 0;
			} else {
				last++;
			}
			size++;
		} else if (last < data.length && last > first) {
			data[last] = k;
			if (last == data.length - 1) {
				last = 0;
			} else {
				last++;
			}
			size++;
		} else if (first == 0 && last == 0) {
			increaseSize();
			data[last] = k;
			if (last == data.length - 1) {
				last = 0;
			} else {
				last++;
			}
			size++;

		} else if (first > 0 && last <= first) {
			if (last < first) {
				data[last] = k;
				last++;
				size++;
			} else {
				increaseSize();
				data[last] = k;
				last++;
				size++;
			}
		}
	}

	public int dequeue() {
		// dequeues the first present element that was enqueued in the queue
		if (size == 0) {
			return -99;
		} else {
			int temp = data[first];
			data[first] = 0;
			size--;
			if (first == data.length - 1) {
				first = 0;
			} else
				first++;
			return temp;
		}

	}

	public void display() {
		// displays all elements present in the queue if needed.
		// mainly implemented to be able to test my code
		// System.out.println(first + " " + last);
		if (size == 0) {
			System.out.println("empty");
		} else if (first == 0 && last == 0) {
			for (int i = 0; i <= data.length - 1; i++) {
				System.out.println(data[i]);
			}
		} else if (first == 0 && last < data.length) {
			for (int i = 0; i < last; i++) {
				System.out.println(data[i]);
			}
		} else if (first > 0 && last <= first) {
			int j = first;
			for (int i = 0; i < data.length; i++) {
				if (j < data.length) {
					if (j == last && i != 0) {
						break;
					}
					System.out.println(data[j]);
					j++;
				} else {
					j = 0;
					if (j == last && i != 0) {
						break;
					}
					System.out.println(data[j]);
					j++;
				}
			}
		} else if (first > 0 && last < data.length) {
			for (int i = first; i < last; i++) {
				System.out.println(data[i]);
			}
		}
	}

	public static void main(String[] args) {
		// test the code:

		// test 1:
		int a = 1;
		int b = 2;
		int c = 3;
		int d = 4;
		int e = 5;
		int f = 6;
		int g = 7;
		Queue q = new Queue(1);
		System.out.println("-------");
		q.display();
		System.out.println("-------");
		q.enqueue(a);
		q.enqueue(b);
		q.enqueue(c);
		q.dequeue();
		q.dequeue();
		System.out.println("-------");
		q.display();
		System.out.println("-------");
		q.enqueue(d);
		q.enqueue(e);
		q.enqueue(f);
		q.dequeue();
		q.dequeue();
		q.enqueue(g);
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.enqueue(a);
		System.out.println("------");
		q.display();
		System.out.println("------");

	}
}
