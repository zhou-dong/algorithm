package org.dzhou.review.list;

public interface List<T> {

	public void add(T data);

	public void add(int index, T data);

	public T remove(int index);

	public T set(int index, T element);

	public T get(int index);

	public boolean isEmpty();

	public int getSize();

}
