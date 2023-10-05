public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {
    private T[] list;
    private int numberOfElements;

    public ArrayFrontBackCappedList(int capacity) {
        list = (T[]) new Object[capacity];
        numberOfElements=0;
        //Object[] objs = {2, 4, 6, 8, 9, null, null, null, null, null};
        //this.list = (T[]) objs;
        //this.numberOfElements = 5;
    }

    public String toString() {
        String arrayString = "";
        for (int i = 0; i < numberOfElements; i++) {
            if (i > 0) {
                arrayString += ", ";
            }

            arrayString += list[i];
        }
        return "size=" + numberOfElements + "; capacity=" + list.length + ";\t[" + arrayString + "]";
    }

    @Override
    public boolean addFront(T newEntry) {
        if (isFull()) return false;
        for (int i = numberOfElements - 1; i >= 0; i--) {
            list[i + 1] = list[i];
        }
        list[0] = newEntry;
        numberOfElements++;
        return true;
    }

    @Override
    public boolean addBack(T newEntry) {
        if (isFull()) return false;
        if (isEmpty()) {
            list[0] = newEntry;
            numberOfElements++;
            return true;
        }

        list[numberOfElements] = newEntry;
        numberOfElements++;
        return true;

    }

    @Override
    public T removeFront() {
        if (isEmpty()) {
            return null;
        }
        T returnT = list[0];
        if (numberOfElements == 1) {
            list[0] = null;
        } else {
            for (int i = 0; i < numberOfElements - 1; i++) {
                list[i] = list[i + 1];
            }
            list[numberOfElements - 1] = null;
        }
        numberOfElements--;
        return returnT;

    }

    @Override
    public T removeBack() {
        if (isEmpty()) return null;
        T returnT = list[numberOfElements - 1];
        list[numberOfElements - 1] = null;
        numberOfElements--;
        return returnT;

    }

    @Override
    public void clear() {
        for (int i = 0; i < numberOfElements; i++) {
            list[i] = null;
        }
        numberOfElements = 0;

    }

    @Override
    public T getEntry(int givenPosition) {
        if (givenPosition < 0 || givenPosition > numberOfElements) {
            return null;
        }
        return list[givenPosition];
    }

    @Override
    public int indexOf(T anEntry) {
        int i = 0;
        while (i < numberOfElements) {
            if (list[i].equals(anEntry)) return i;
            i++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T anEntry) {
        int returnVal = -1;
        int i = 0;
        while (i < numberOfElements) {
            if (list[i].equals(anEntry)) returnVal = i;
            i++;
        }
        return returnVal;
    }

    @Override
    public boolean contains(T anEntry) {
        int i = 0;
        while (i < numberOfElements) {
            if (list[i].equals(anEntry)) return true;
            i++;
        }
        return false;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public boolean isEmpty() {
        return numberOfElements == 0;

    }

    @Override
    public boolean isFull() {
        return numberOfElements == list.length;
    }
}
