package trees;

public class Heap {
	private int[] heap_array;
	private int number_of_nodes;
	private int size;
	private static final int ROOT = 1;

	public Heap(int number_of_nodes) {
		this.number_of_nodes = number_of_nodes;
		heap_array = new int[this.number_of_nodes];
		size = 0;
	}

	private int parentNode(int node) {
		if (node == 1)
			return 1;
		return node / 2;
	}

	private int leftChild(int node) {
		return 2 * node;
	}

	private int rightChild(int node) {
		return 2 * node + 1;
	}

	private void swap(int fromIndex, int toIndex) {
		int temp = heap_array[fromIndex];
		heap_array[fromIndex] = heap_array[toIndex];
		heap_array[toIndex] = temp;
		return;
	}

	private int minimumChild(int node) {
		int left = leftChild(node);
		int right = rightChild(node);

		return heap_array[left] < heap_array[right] ? left : right;
	}

	public void insert(int element) {
		int index = size + 1;

		heap_array[size + 1] = element;
		size++;

		int parent;

		while (index > 1) {
			parent = parentNode(index);

			if (heap_array[parent] > element)
				swap(index, parent);

			index = parent;
		}

		return;
	}

	public int minDelete() {

		int value = heap_array[ROOT];

		heap_array[ROOT] = heap_array[size];
		size--;

		int index = ROOT;
		int position;

		while (index <= parentNode(size)) {
			position = minimumChild(index);
			swap(position, index);
			index = position;
		}
		return value;
	}

}
