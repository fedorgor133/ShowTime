package resources.dao;

public class Trio<T, V, K> {

    T element1;
    V element2;
    K element3;

    public Trio(T element1, V element2, K element3) {
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
    }

    public T getElement1() {
        return element1;
    }

    public V getElement2() {
        return element2;
    }

    public K getElement3() {
        return element3;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((element1 == null) ? 0 : element1.hashCode());
        result = prime * result + ((element2 == null) ? 0 : element2.hashCode());
        result = prime * result + ((element3 == null) ? 0 : element3.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        Trio other = (Trio) obj;

        if (element1 == null)
            return other.element1 == null;
        else if (!element1.equals(other.element1))
            return false;

        if (element2 == null)
            return other.element2 == null;
        else if (!element2.equals(other.element2))
            return false;

        if (element3 == null)
            return other.element3 == null;
        else if (!element3.equals(other.element3))
            return false;

        return true;
    }
}
