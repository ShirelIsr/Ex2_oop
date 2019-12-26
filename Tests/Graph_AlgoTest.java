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
	
	graph test3() {
		graph g = new DGraph();
		
		Point3D v1 = new Point3D(1,1);
		Point3D v2 = new Point3D(1,4);
		Point3D v3 = new Point3D(2,7);
		Point3D v4 = new Point3D(4,3);
		Point3D v5 = new Point3D(7,6);
		Point3D v6 = new Point3D(10,4);
		node_data n1=new NodeData(1,v1);
		node_data n2=new NodeData(2,v2);
		node_data n3=new NodeData(3,v3);
		node_data n4=new NodeData(4,v4);
		node_data n5=new NodeData(5,v5);
		node_data n6=new NodeData(6,v6);
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		g.addNode(n4);
		g.addNode(n5);
		g.addNode(n6);
		g.connect(n1.getKey(), n2.getKey(), Double.MAX_VALUE);
		g.connect(n2.getKey(), n3.getKey(), Double.MAX_VALUE);
		g.connect(n3.getKey(), n4.getKey(), Double.MAX_VALUE);
		g.connect(n5.getKey(), n4.getKey(), Double.MAX_VALUE);
		g.connect(n3.getKey(), n5.getKey(), Double.MAX_VALUE);
		g.connect(n4.getKey(), n1.getKey(), Double.MAX_VALUE);
		return g;
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
		//graph_algorithms test_graph= new Graph_Algo();
		//test_graph.init(test());
		//System.out.println(test_graph.isConnected());
		//test_graph.init(test2());
		graph_algorithms t2= new Graph_Algo();
		t2.init(test3());
		//Point3D v5 = new Point3D(1,1);
		//Point3D v6 = new Point3D(1,1);
		System.out.println(t2.isConnected());
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
