package model.logic;

import model.data_structures.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo<T> {
	/**
	 * Atributos del modelo del mundo
	 */
	private Queue<T> colaComparendos;
	private Stack<T> pilaComparendos;
	private ListaEncadenada<T> listaComparendos;
	private Nodo<T> nodoComparendo;


	public Modelo(){
	}
	public Modelo(List<T> listaFeatures)
	{
		cargarComparendos(listaFeatures);
	}
	public void cargarComparendos(List<T> listaFeatures){
		try {
			Nodo<Features> primero = new Nodo<Features>(null, (Features) listaFeatures.get(0));
			listaFeatures.remove(0);
			colaComparendos = new Queue<T>((Nodo<T>) primero);
			listaFeatures.forEach(feature -> {
				nodoComparendo = new Nodo<T>(null,(T) feature);
				colaComparendos.enqueue(nodoComparendo);
				System.out.println("tamaño de la queue: "+colaComparendos.size());
				pilaComparendos.push(nodoComparendo);
				System.out.println("tamaño del stack: "+pilaComparendos.getSize());
			});
		}catch (Exception e){e.printStackTrace();}
	}
}
