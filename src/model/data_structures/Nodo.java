package model.data_structures;

public class Nodo<T> {
    private T siguiente;
    private T info;

    public Nodo(T siguiente, T features){
        this.siguiente = siguiente;
        this.info = features;
    }

    public T getSiguiente() {
        return siguiente;
    }

    public T getFeature() {
        return info;
    }


    public void setSiguiente(T siguiente) {
        this.siguiente = siguiente;
    }

    public void setInfo(T feature) {
        this.info = feature;
    }
}
