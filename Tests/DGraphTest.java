package Tests;

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
			return _graph;
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
		edge_data edge=new EdgeData(node1,node2,2);
		_graph.connect(node1.getKey(),node2.getKey(),Double.MAX_VALUE);

	}

	@Test
	void testGetV() {
		fail("Not yet implemented");
	}

	@Test
	void testGetE() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveNode() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveEdge() {
		fail("Not yet implemented");
	}

}
