package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

import dataStructure.DGraph;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
/**
 * This empty class represents the set of graph-theory algorithms
 * which should be implemented as part of Ex2 - Do edit this class.
 * @author 
 *
 */
public class Graph_Algo implements graph_algorithms{

	graph _graph;

	@Override
	public void init(graph g) {
		this._graph=g;
	}

	@Override
	public void init(String file_name) {
		try
		{    
			FileInputStream file = new FileInputStream("file_name.txt"); 
			ObjectInputStream in = new ObjectInputStream(file); 

			this._graph = (graph)in.readObject(); 

			in.close(); 
			file.close(); 

			System.out.println("Object has been deserialized"); 
		} 
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught?"); 
		} 
		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
		} 

	}

	@Override
	public void save(String file_name) {


		try
		{    
			FileOutputStream file = new FileOutputStream(file_name); 
			ObjectOutputStream out = new ObjectOutputStream(file); 

			out.writeObject(this._graph); 
			out.close(); 
			file.close(); 

			System.out.println("Object has been serialized"); 
		}   
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 

	}

	@Override
	public boolean isConnected() 
	{
		Collection<node_data> s = _graph.getV();
		for (node_data node : s) 
		{
			clearNodeData();
			if(_graph.nodeSize()>numOfConected(node))
				return false;	
		}

		return true;
	}

	private void clearNodeData()
	{
		Collection<node_data> s = _graph.getV();
		for (node_data node : s) 
		{
			node.setTag(0);
			node.setWeight(Double.MAX_VALUE);
		}
	}
	private int numOfConected(node_data v)
	{
		if(v.getTag()==1) return 0;
		v.setTag(1);
		Collection<edge_data> e = _graph.getE(v.getKey());
		int count =1;
		for (edge_data edge : e)
		{
			count +=numOfConected(_graph.getNode(edge.getDest()));
		}

		return count;	
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		dijkstra(src);
		return _graph.getNode(dest).getWeight();
	}

	private void dijkstra(int src)
	{
		clearNodeData();
		PriorityQueue<node_data> queue = new PriorityQueue<node_data>();
		_graph.getNode(src).setWeight(0);
		queue.add(_graph.getNode(src));
		while(!queue.isEmpty()){
			node_data u = queue.poll();
			Collection<edge_data> e = _graph.getE(u.getKey());
			for(edge_data edge: e){
				double weightNode=u.getWeight();
				node_data v = _graph.getNode(edge.getDest());
				double weightEdge=edge.getWeight();
				//relax(u,v,weight)
				//double distanceFromU = u.shortestDistance+weight;
				if(_graph.getNode(edge.getDest()).getTag()!=1)
					if(weightEdge+weightNode<_graph.getNode(edge.getDest()).getWeight()) 
					{
						queue.remove(v);
						v.setWeight(weightEdge+weightNode);
						/*remove v from queue for updating 
							the shortestDistance value*/
						v.setInfo(""+u.getKey());
						queue.add(v);
					}
			}
		}
	}



	@Override
	public List<node_data> shortestPath(int src, int dest) {
		dijkstra(src);
		List <node_data> path =new ArrayList <node_data>();
		node_data node = _graph.getNode(dest);
		while( node!=null){
			path.add(node);
			node=_graph.getNode(Integer.parseInt(node.getInfo()));
		}
		//reverse the order such that it will be from source to target
		Collections.reverse(path);
		return path;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {

		List <node_data> path =shortestPath(targets.get(0), targets.get(1));
		int last_path=1;
		for(int i=2;i<targets.size();i++)
		{
			if(!path.contains(_graph.getNode(targets.get(i))))
			{
				List <node_data> path_temp =shortestPath(targets.get(last_path),targets.get(i));
				Iterator <node_data> it=path_temp.iterator();
				while(it.hasNext())
					path.add(it.next());
				last_path=i;
			}
		}

		return path;
	}

	@Override
	public graph copy() {
		graph g = new DGraph();
		Collection <node_data> nodes = _graph.getV();
		for(node_data node : nodes)
		{
			g.addNode(node);
			Collection<edge_data> edges = _graph.getE(node.getKey());
			for(edge_data edge : edges)
			{
				g.connect(edge.getSrc(), edge.getDest(), edge.getWeight());
			}
		}
		return g;
	}

}
