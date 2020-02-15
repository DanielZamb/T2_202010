package model.logic;

import model.data_structures.*;

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
	private Nodo<T> nodoComparendo;
	private String primeroPila;
	private String primeroCola;
	private int tamanio;


	public Modelo(){
	}
	public Modelo(List<T> listaFeatures)
	{
		cargarComparendos(listaFeatures);
	}
	public void cargarComparendos(List<T> listaFeatures){
		try {
			Nodo<Features> primero = new Nodo<Features>(null, (Features) listaFeatures.get(0));
			Nodo<Features> ultimo = new Nodo<Features>(null,(Features)listaFeatures.get(listaFeatures.size()-1));
			listaFeatures.remove(0);
			colaComparendos = new Queue<T>((Nodo<T>) primero);
			pilaComparendos = new Stack<T>((Nodo<T>) primero);
			listaFeatures.forEach(feature -> {
				nodoComparendo = new Nodo<T>(null,(T) feature);
				colaComparendos.enqueue(nodoComparendo);
				pilaComparendos.push(nodoComparendo);
			});
			primeroPila = ""+ultimo.getInfo().toString();
			primeroCola = ""+primero.getInfo().toString();
			tamanio = pilaComparendos.getSize();
		}catch (Exception e){e.printStackTrace();}
	}
	public int darTamanio(){
		return tamanio;
	}
	public Queue<T> procesarCluster(){
		Queue<Queue<T>> cluster = new Queue<Queue<T>>(null);
		Queue<T> temp = null;
		Nodo<Features> nodoRef = (Nodo<Features>) colaComparendos.dequeue();
		temp = new Queue<T>((Nodo<T>)nodoRef);
		while(!colaComparendos.isEmpty()){
			String strRef = nodoRef.getInfo().getProperties().getINFRACCION();
			Nodo<Features> iter = (Nodo<Features>)colaComparendos.dequeue();
			String strIter = iter.getInfo().getProperties().getINFRACCION();
			if (strRef.equals(strIter)){
				temp.enqueue((Nodo<T>) iter);
			}else {
				Nodo<Queue<T>> nodoTemp = new Nodo<Queue<T>>(null, temp);
				cluster.enqueue(nodoTemp);
				nodoRef = iter;
			}
		}
		Nodo<Queue<T>> evaluado = cluster.peekLast();
		Nodo<Queue<T>> rta = null;
		int mayor = 0;
		while(evaluado != null){
			int tamanio = evaluado.getInfo().size();
			if (tamanio> mayor){
				mayor = tamanio;
				rta = evaluado;
				evaluado = evaluado.getSiguiente();
			}
			else
			{
				evaluado = evaluado.getSiguiente();
			}
		}

		assert rta != null;
		return rta.getInfo();
	}
	public Queue<T> procesarStack(int numElementos, String infraccion){
		Queue<T> rta = null;
		int tamanio = 0;
		rta = new Queue<T>(null);
		rta.setTamanio(0);
		Nodo<Features> evaluado = (Nodo<Features>) pilaComparendos.pop();
		while (tamanio<numElementos && !pilaComparendos.isEmpty()){
			if (evaluado.getInfo().getProperties().getINFRACCION().equals(infraccion)){
				rta.enqueue((Nodo<T>) evaluado);
				tamanio = rta.size();
				evaluado = (Nodo<Features>) pilaComparendos.pop();
			}
			else
			{
				evaluado = (Nodo<Features>) pilaComparendos.pop();
			}
		}
		return rta;
	}
	public String getPrimeroCola() {
		return primeroCola;
	}

	public String getPrimeroPila() {
		return primeroPila;
	}

}
