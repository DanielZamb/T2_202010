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
			primeroCola = primero.getFeature().toString();
			primeroPila = ultimo.getFeature().toString();
			listaFeatures.remove(0);
			colaComparendos = new Queue<T>((Nodo<T>) primero);
			pilaComparendos = new Stack<T>((Nodo<T>) ultimo);
			listaFeatures.forEach(feature -> {
				nodoComparendo = new Nodo<T>(null,(T) feature);
				colaComparendos.enqueue(nodoComparendo);
				pilaComparendos.push(nodoComparendo);
			});
		}catch (Exception e){e.printStackTrace();}
	}
	public int darTamanio(){
		return colaComparendos.size();
	}
	public Queue<T> procesarCluster(){
		Queue<T> cluster = null;
		Nodo<Features> referencia = (Nodo<Features>) colaComparendos.dequeue();
		String infracRef = referencia.getFeature().getProperties().getDES_INFRAC();
		cluster.enqueue((Nodo<T>) referencia);
		while (referencia!= null && !colaComparendos.isEmpty()){
			Nodo<Features> evaluado = (Nodo<Features>) colaComparendos.dequeue();
			String comp = evaluado.getFeature().getProperties().getDES_INFRAC();
			if(infracRef.equals(comp)){
				colaComparendos.enqueue((Nodo<T>) evaluado);
			}else{
				referencia = evaluado;
			}
		}
		return cluster;
	}
	public Queue<T> procesarStack(int numElementos, String infraccion){
		Queue<T> rta = null;
		int contador = 0;
		Nodo<Features> evaluado = (Nodo<Features>) pilaComparendos.pop();
		while (contador<=numElementos && !pilaComparendos.isEmpty()){
			if (evaluado.getFeature().getProperties().getINFRACCION().equals(infraccion)){
				rta.enqueue((Nodo<T>) evaluado);
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
