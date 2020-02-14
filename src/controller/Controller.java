package controller;

import com.google.gson.Gson;
import com.sun.source.tree.WhileLoopTree;
import model.data_structures.*;
import model.logic.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;
	
	/* Instancia de la Vista*/
	private View view;
	

	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
	}
		
	public void run() throws IOException {
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato = 0;
		String infraccion = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					view.printMessage("--------- \n Cargar comparendos a estructuras (debe agregar el archivo a cargar en /data) : \n-Queue\n-Stack ");
					view.printMessage("Loading...");
					Gson gson = new Gson();
					String json = "./data/comparendos_dei_2018_BIG.geojson";
					BufferedReader br = new BufferedReader(new FileReader(json));
					Comparendos comparendos = gson.fromJson(br, Comparendos.class);
					Modelo<Features> mdl = new Modelo(comparendos.darListaFeatures());
					br.close();
				    view.printMessage("Datos Cargados y estructuras creadas.");
				    view.printMessage("Numero actual de elementos en ambas estructuras: " + modelo.darTamanio() + "\n---------");
				    view.printMessage("Primer comparendo de Queue:\n"+"\t"+modelo.getPrimeroCola()+ "\n---------");
				    view.printMessage("Primer comparendo de Stack:\n"+"\t"+modelo.getPrimeroPila()+ "\n---------");
					break;
				case 2:
					view.printMessage("--------- \nHallar Cluster de comparendos en Queue: ");
					view.printMessage("Loading...");
					Queue<Features> cluster = (Queue<Features>) modelo.procesarCluster();
					view.printMessage("Numero de comparendos en el cluster : "+ cluster.size());
					view.printMessage("Cluster de comparendos: \n");
					Nodo<Features> actual = new Nodo<Features>((Nodo<Features>) cluster.getPrimerNodo().getSiguiente(),cluster.darPrimero().getFeature());
					while(actual!=null && !cluster.isEmpty()) {
						view.printMessage("\t"+actual.getFeature().toString()+"\n");
						actual = actual.getSiguiente();
					}
				break;
				case 3:
					view.printMessage("--------- \nDar Queue con comparendos procesados del Stack: ");
					view.printMessage("--------- \nDigite el numero de elementos a procesar");
					dato = lector.nextInt();
					view.printMessage("--------- \nDigite la infraccion que quiere consultar en los n elementos del Stack");
					infraccion = lector.next();
					Queue<Features> rta = (Queue<Features>) modelo.procesarStack(dato,infraccion);
					view.printMessage("Numero de comparendos en Queue : "+ rta.size());
					view.printMessage("Queue de comparendos: \n");
					Nodo<Features> actual1 = new Nodo<Features>((Nodo<Features>) rta.getPrimerNodo().getSiguiente(),rta.darPrimero().getFeature());
					while(actual1!=null && !rta.isEmpty()) {
						view.printMessage("\t"+actual1.getFeature().toString()+"\n");
						actual1 = actual1.getSiguiente();
					}
					view.printMessage("---------");
					break;
				default: 
					view.printMessage("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
