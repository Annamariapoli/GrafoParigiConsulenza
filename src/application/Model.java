package application;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.GraphPath;
import org.jgrapht.Graphs;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;

import bean.Fermata;
import db.Dao;

public class Model {
	
	private Dao dao = new Dao();
	
	private SimpleWeightedGraph<Fermata, DefaultWeightedEdge> grafo ;
	
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
		grafo = new SimpleWeightedGraph <Fermata, DefaultWeightedEdge>(DefaultWeightenedEdge.class);
//		for(Integer s : getStaz()){
//			grafo.addVertex(s);               //1 nodo = 1 stazione
//		}
		for(Fermata f : getFer()){
			grafo.addVertex(f);
		}
		//aggiungo archi tra stazioni piu vicine
	}
	
	public List<Fermata > getCamminoMinimo(Fermata f1, Fermata f2){   //manca il tempo
		List<Fermata> fermateIntermedie = new LinkedList<Fermata>();
		if(f1 ==null || f2 == null){
			return null;
		}
		DijkstraShortestPath<Fermata, DefaultWeightedEdge>	di = new DijkstraShortestPath<Fermata, DefaultWeightedEdge>(grafo,f1, f2);
		GraphPath<Fermata, DefaultWeightedEdge> path = di.getPath();
		if(path==null){
			return null;
		}
		else {
			fermateIntermedie = Graphs.getPathVertexList(path);
			return fermateIntermedie;
		}
	}
	
	public long getTempoDelCammino(Fermata f1, Fermata f2){
		List<Fermata> fermate = getCamminoMinimo(f1, f2);
		int contaFermate = fermate.size();
		long time = contaFermate * 30 ;
		return time;
	}
	
	

}
