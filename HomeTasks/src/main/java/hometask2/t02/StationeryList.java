package hometask2.t02;

import java.util.Arrays;

public class StationeryList<T> {
    private final int initialCapacity = 10;
    private int size = 0;
    private Object[] elements;

    public StationeryList() {
        elements = new Object[initialCapacity];
    }


    public void add(T item) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = item;
    }


    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        return (T) elements[index];
    }

    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }

        T removedElement = (T) elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;

        return removedElement;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(elements[i] + " ");
        }
        String ans = sb.toString();
        System.out.println(ans);
        return ans;
    }

    private void ensureCapacity() {
        int newCapacity = elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public int getSize() {
        return size;
    }

//    public T[] getElements() {
//        return elements;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StationeryList<?> that = (StationeryList<?>) o;

        if (initialCapacity != that.initialCapacity) return false;
        if (size != that.size) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(elements, that.elements);
    }

    @Override
    public int hashCode() {
        int result = initialCapacity;
        result = 31 * result + size;
        result = 31 * result + Arrays.hashCode(elements);
        return result;
    }
}