package resources.dao;

public class Quartet<T, V, K, Z> {

    T element1;
    V element2;
    K element3;
    Z element4;

    public Quartet(T element1, V element2, K element3, Z element4) {
        this.element1 = element1;
        this.element2 = element2;
        this.element3 = element3;
        this.element4 = element4;
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

    public Z getElement4() {
        return element4;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((element1 == null) ? 0 : element1.hashCode());
        result = prime * result + ((element2 == null) ? 0 : element2.hashCode());
        result = prime * result + ((element3 == null) ? 0 : element3.hashCode());
        result = prime * result + ((element4 == null) ? 0 : element4.hashCode());
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

        Quartet other = (Quartet) obj;

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

        if (element4 == null)
            return other.element4 == null;
        else if (!element4.equals(other.element4))
            return false;

        return true;
    }
}
