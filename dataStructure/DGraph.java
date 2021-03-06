package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class DGraph implements graph ,Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	HashMap <node_data, HashMap<Integer, edge_data>> edge =new HashMap <node_data, HashMap<Integer, edge_data>> ();
	HashMap <Integer,node_data> _graph=new HashMap<Integer,node_data>();
	private int countMc=0;
	private int countE=0;

	public DGraph()
	{
		edge =new HashMap <node_data, HashMap<Integer, edge_data>> ();
		_graph=new HashMap<Integer,node_data>();
		countMc=0;
		countE=0;

	}

	@Override
	public node_data getNode(int key) {
		return  _graph.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		if( src == dest) return null;
		if((_graph.get(src)==null) || (_graph.get(dest)==null)) return null;
		node_data key=_graph.get(src);
		if(edge.get(key) != null) return edge.get(key).get(dest);
		return null;
	}

	@Override
	public void addNode(node_data n) {
		_graph.put(n.getKey(), n);
		countMc++;
		edge.put(n,new HashMap<Integer, edge_data>());
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(src == dest) throw new RuntimeException("ERR, src/dest doe'snt exiest ");
		if(w<0)
			throw new RuntimeException("ERR, weight could not be negative ");
		node_data srcN=_graph.get(src);
		node_data destN=_graph.get(dest);
		if((srcN ==null) || (destN ==null) ) throw new RuntimeException("ERR, src/dest doe'snt exiest ");
		edge_data e=new EdgeData(srcN,destN,w);
		if(!edge.get(srcN).containsKey(dest))
			countE++;
		edge.get(srcN).put(dest, e);
		countMc++;
	}

	@Override
	public Collection<node_data> getV() {
		return _graph.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		node_data key=_graph.get(node_id);
		return edge.get(key).values();
	}

	@Override
	public node_data removeNode(int key) {
		node_data keyN=_graph.get(key);
		if (keyN==null) return null;
		countE-=edge.get(keyN).size();
		edge.get(keyN).clear();
		countMc++;
		return null;
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		node_data srcN=_graph.get(src);
		node_data destN=_graph.get(dest);
		if((srcN ==null) || (destN ==null) ) return null;
		edge_data ans=edge.get(srcN).remove(dest);
		if(ans !=null)
		{
			countMc++;
			countE--;
		}
		return ans;
	}

	@Override
	public int nodeSize() {
		if(_graph.isEmpty()) return 0;
		return _graph.size();
	}

	@Override
	public int edgeSize() {
		return this.countE;
	}

	@Override
	public int getMC() {
		return this.countMc;
	}
}
