package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

class Graph_AlgoTest {
	graph test()
	{
	graph _graph=new DGraph();
	int j=2;
	for (int i=0;i<10;i++,j++)
	{
		Point3D Location = new Point3D(i,j);
		node_data node=new NodeData(i,Location);
		_graph.addNode(node);
	}
	Collection<node_data> s = _graph.getV();
	for (node_data node1 : s) 
	{
		for (node_data node2 : s)
		{
			if(node1.getKey()!=node2.getKey())
				_graph.connect(node1.getKey(), node2.getKey(), Double.MAX_VALUE);
		}
	}
	return _graph;
	}
	graph test2()
	{
		graph _graph=new DGraph();
		int j=2;
		for (int i=0;i<10;i++,j++)
		{
			Point3D Location = new Point3D(i,j);
			node_data node=new NodeData(i,Location);
			_graph.addNode(node);
		}
		j=1;
		for (int i=0;i<9;i++,j++)
		{
			_graph.connect(i, j, Double.MAX_VALUE);
		}
		return _graph;
		
		
	}
	

	

	@Test
	void testInitString() {
		graph_algorithms test_graph= new Graph_Algo();
		test_graph.init("test");
	}

	@Test
	void testSave() {
		graph_algorithms test_graph= new Graph_Algo();
		graph _graph=test();
		test_graph.init(_graph);	
		test_graph.save("test");
		
		
	}

	@Test
	void testIsConnected() {
		graph_algorithms test_graph= new Graph_Algo();
		test_graph.init(test());
		System.out.println(test_graph.isConnected());
		test_graph.init(test2());
		System.out.println(test_graph.isConnected());
	}

	@Test
	void testShortestPathDist() {
		fail("Not yet implemented");
	}

	@Test
	void testShortestPath() {
		fail("Not yet implemented");
	}

	@Test
	void testTSP() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

}
