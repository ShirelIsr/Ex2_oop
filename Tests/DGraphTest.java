package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

class DGraphTest {

	@Test
	void testDGraph()
	{

		graph g = new DGraph();

		Point3D p1 = new Point3D(0,0);

		for (int i = 1; i <= 1000000 ; i++) {
			node_data t = new NodeData( i, new Point3D(p1.x()+i , p1.y()+i ,p1.z()+i ));
			g.addNode(t);

		}
		for (int i = 1; i <= 1000000-10 ; i++) {
			g.connect(i, i+1, i*0.5);
			g.connect(i, i+2, i*0.3);
			g.connect(i, i+3, 1);
			g.connect(i, i+4, i*10);
			g.connect(i, i+5, i*3);
			g.connect(i, i+6, i*0.8);
			g.connect(i, i+7, i*0.5);
			g.connect(i, i+8, i*7);
			g.connect(i, i+9, i*3);
			g.connect(i, i+10, i*2.5);
		}

	}
	@Test
	void testGetNode() {

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
	}






	@Test
	void testConnect() {
		graph _graph=new DGraph();
		Point3D Location = new Point3D(1,2);
		node_data node1=new NodeData(1,Location);
		Point3D Location2 = new Point3D(2,2);
		node_data node2=new NodeData(4,Location2);
		_graph.addNode(node1);
		_graph.addNode(node2);
		_graph.connect(node1.getKey(),node2.getKey(),Double.MAX_VALUE);

	}

	@Test
	void testGetV() {
		graph _graph=new DGraph();
		Point3D Location = new Point3D(1,2);
		node_data node1=new NodeData(1,Location);
		Point3D Location2 = new Point3D(2,2);
		node_data node2=new NodeData(4,Location2);
		_graph.addNode(node1);
		_graph.addNode(node2);
		_graph.connect(node1.getKey(),node2.getKey(),Double.MAX_VALUE);
		Collection<node_data> expected =_graph.getV();
		

	}

	@Test
	void testGetE() {
		graph _graph=new DGraph();
		Point3D Location = new Point3D(1,2);
		node_data node1=new NodeData(1,Location);
		Point3D Location2 = new Point3D(2,2);
		node_data node2=new NodeData(4,Location2);
		_graph.addNode(node1);
		_graph.addNode(node2);
		_graph.connect(node1.getKey(),node2.getKey(),Double.MAX_VALUE);
		Collection<edge_data> expected =_graph.getE(node1.getKey());
	}

	@Test
	void testRemoveNode() {
		graph _graph=new DGraph();
		Point3D Location = new Point3D(1,2);
		node_data node1=new NodeData(1,Location);
		Point3D Location2 = new Point3D(2,2);
		node_data node2=new NodeData(4,Location2);
		_graph.addNode(node1);
		_graph.addNode(node2);
		edge_data edge=new EdgeData(node1,node2,2);
		_graph.connect(node1.getKey(),node2.getKey(),Double.MAX_VALUE);
		int edge1=_graph.edgeSize();
		_graph.removeNode(node1.getKey());
		int edge2=_graph.edgeSize();
		System.out.println(edge1==edge2);
		System.out.println(edge1+ " , "+edge2);
		assertEquals(edge1==edge2,false,"Err");
		
		
	}

	@Test
	void testRemoveEdge() {
		graph _graph=new DGraph();
		Point3D Location = new Point3D(1,2);
		node_data node1=new NodeData(1,Location);
		Point3D Location2 = new Point3D(2,2);
		node_data node2=new NodeData(4,Location2);
		_graph.addNode(node1);
		_graph.addNode(node2);
		edge_data edge=new EdgeData(node1,node2,2);
		_graph.connect(node1.getKey(),node2.getKey(),Double.MAX_VALUE);
		int edge1=_graph.edgeSize();
		_graph.removeEdge(node1.getKey(), node2.getKey());
		int edge2=_graph.edgeSize();
		System.out.println(edge1==edge2);
		System.out.println(edge1+ " , "+edge2);
		assertEquals(edge1==edge2,false,"Err");
	}

}
