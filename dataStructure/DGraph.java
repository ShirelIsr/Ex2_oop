package dataStructure;

import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph{

	HashMap <node_data, HashMap<Integer, edge_data>> edge =new HashMap <node_data, HashMap<Integer, edge_data>> ();
	HashMap <Integer,node_data> _graph=new HashMap<Integer,node_data>();


	@Override
	public node_data getNode(int key) {
		return  _graph.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		edge_data edge = new  EdgeData(_graph.get(src),_graph.get(dest));
		return edge;
	}

	@Override
	public void addNode(node_data n) {
		_graph.put(n.getKey(), n);
	}

	@Override
	public void connect(int src, int dest, double w) {
		edge_data edge = new  EdgeData(_graph.get(src),_graph.get(dest),w);

	}

	@Override
	public Collection<node_data> getV() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public node_data removeNode(int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
