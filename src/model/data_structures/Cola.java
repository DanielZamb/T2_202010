package model.data_structures;

public class Queue extends ListaEncadenada{

    private Nodo first;
    private Nodo last;
    private int tamanio;


    public Queue()
    {
        first= null;
        last=null;
        tamanio=0;
    }

    public void enqueue(Nodo nodo) {
        if (first==null)
        {
            first= nodo;
            last= nodo;
            tamanio++;
        }

        else
            nodo.setSiguiente(last);
        last= nodo;

        tamanio++;
    }

    public Nodo dequeue ()
    {
        Nodo respuesta = first;
        Nodo actual = last;


        while (actual != first)
        {
            if (actual.getSiguiente().equals(first))
            {
                actual.setSiguiente(null);
                actual= first;

            }
            else
                actual = actual.getSiguiente();
        }

        tamanio --;

        return respuesta;
    }

    public boolean isEmpty()
    {
        boolean respuesta = false;
        if(tamanio==0)
        {
            respuesta = true;
        }
        return respuesta;

    }

    public int size()
    {
        return tamanio;
    }

    public Nodo darPrimero()
    {
        return first;
    }

    public Nodo darUltimo()
    {
        return last;
    }


}
