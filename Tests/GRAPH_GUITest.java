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
	graph test1()
	{

		graph g = new DGraph();

		Point3D p1 = new Point3D(0,0);

		for (int i = 1; i <= 1000000 ; i++) {
			node_data t = new NodeData( i, new Point3D(p1.x()+i+1 , p1.y()+i*10 ,p1.z()+i ));
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
		return g;
	}
	graph test2()
	{

		graph g = new DGraph();

		Point3D p1 = new Point3D(0,0);

		for (int i = 1; i <= 100 ; i++) {
			node_data t = new NodeData( i, new Point3D(p1.x()+i*10 , p1.y()+i*1 ,p1.z()+i ));
			g.addNode(t);

		}

		for (int i = 1; i <= 100-10 ; i++) {
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
		return g;
		
	}

	@Test
	void testGRAPH_GUIGraph() {
		graph g=test1();
		GRAPH_GUI app = new GRAPH_GUI(g);
		app.setVisible(true);
	}

	@Test
	void testGRAPH_GUI() {
		graph g=test2();
		GRAPH_GUI app = new GRAPH_GUI();
		app.initGUI(g);
		app.setVisible(true);
	}

	@Test
	void testPaintGraphics() {
		graph g=test2();
		GRAPH_GUI app = new GRAPH_GUI(g);
		app.setVisible(true);
	}



}
