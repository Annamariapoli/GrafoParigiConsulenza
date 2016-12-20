package application;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import bean.Fermata;
import db.Dao;

public class Model {
	
	private Dao dao = new Dao();
	
	private SimpleWeightedGraph<Integer, DefaultWeightedEdge> grafo ;
	
	public List<Fermata> getFer(){
		List<Fermata> fer = new LinkedList<Fermata>();
		fer = dao.getAllFermate();
		return fer;
	}
	
	public List<Integer> getStaz (){
		List<Integer> staz = new LinkedList<Integer>();
		staz= dao.getAllStazioni();
		return staz;
	}
	
	public void buildGraph(){
		grafo = new SimpleWeightedGraph <Integer, DefaultWeightedEdge> (DefaultWeightenedEdge.class);
		for(Integer s : getStaz()){
			grafo.addVertex(s);               //1 nodo = 1 stazione
		}
	}

}
