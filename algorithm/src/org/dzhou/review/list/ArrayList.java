package org.dzhou.review.list;

public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_CAPACITY = 10;

	Object[] array = null;
	private int size = 0;

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayList(int initialCapacity) {
		array = new Object[initialCapacity];
	}

	@Override
	public void add(T data) {
		ensureCapacity(size + 1);
		array[size + 1] = data;
		size++;
	}

	private void ensureCapacity(int minCapacity) {
		if (minCapacity - array.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity) {
		Object[] newArray = new Object[array.length << 1];
		for (int i = 0; i < array.length; i++)
			newArray[i] = array[i];
		array = newArray;
	}

	@Override
	public void add(int index, T data) {
		rangeCheckForAdd(index);
		// TODO Auto-generated method stub
	}

	private void rangeCheckForAdd(int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException();
	}

	@Override
	public T remove(int index) {
		rangeCheck(index);
		T result = get(index);
		if (index != (size - 1))
			Swap(index, size - 1);
		array[size - 1] = null;
		return result;
	}

	private void rangeCheck(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException();
	}

	private void Swap(int x, int y) {
		Object tmp = array[x];
		array[x] = array[y];
		array[y] = tmp;
	}

	@Override
	public T set(int index, T element) {
		rangeCheck(index);
		array[index] = element;
		return element;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(int index) {
		rangeCheck(index);
		return (T) array[index];
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int getSize() {
		return size;
	}

}
