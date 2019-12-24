package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Set;

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
			System.out.println("IOException is caught"); 
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
			initConnected();
			if(_graph.nodeSize()>numOfConected(node))
				return false;	
		}

		return true;
	}

	private void initConnected()
	{
		Collection<node_data> s = _graph.getV();
		for (node_data node : s) 
		{
			node.setTag(0);
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

		return 0;
	}
	private void dijkstra(int src)
	{
		_graph.getNode(src).setWeight(0);	
		Collection<node_data> s = _graph.getV();
		for (node_data node : s) 
		{
			double weightNode=node.getWeight();
			node.setTag(1);
			Collection<edge_data> e = _graph.getE(node.getKey());
			for (edge_data edge : e)
			{
				double weightEdge=edge.getWeight();
				if(_graph.getNode(edge.getDest()).getTag()!=1)
					if(weightEdge+weightNode<_graph.getNode(edge.getDest()).getWeight())
						_graph.getNode(edge.getDest()).setWeight(weightEdge+weightNode);
				
			}

		}
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		_graph.getNode(src).setWeight(0);
		

		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public graph copy() {
		return null;
	}

}
