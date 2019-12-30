package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.graph;
import dataStructure.node_data;
import gui.GRAPH_GUI;
import utils.Point3D;

class GRAPH_GUITest {

	@Test
	void testGRAPH_GUIGraph() {


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

		graph_algorithms test = new Graph_Algo();
		test.init(g);
	}

	@Test
	void testGRAPH_GUI() {
		fail("Not yet implemented");
	}

	@Test
	void testPaintGraphics() {
		fail("Not yet implemented");
	}

	@Test
	void testSave() {
		fail("Not yet implemented");
	}

	@Test
	void testLoad() {
		fail("Not yet implemented");
	}

	@Test
	void testIsConnect() {
		fail("Not yet implemented");
	}

	@Test
	void testSP() {
		fail("Not yet implemented");
	}

	@Test
	void testSPD() {
		fail("Not yet implemented");
	}

	@Test
	void testTSP() {
		fail("Not yet implemented");
	}

}
