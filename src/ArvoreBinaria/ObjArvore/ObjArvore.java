package ArvoreBinaria.ObjArvore;

public abstract class ObjArvore<T> implements Comparable<T> {

    public abstract boolean equals(Object o);
    public abstract int hashCod();
    public abstract int compareTo(T outro);
    public abstract String toString();

}
