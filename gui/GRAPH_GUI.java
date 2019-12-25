package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

	public final class GRAPH_GUI  extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener
	{
		graph _graph;
		
		public GRAPH_GUI(graph g)
		{
			this._graph=g;
			initGUI();
		}
		
		public GRAPH_GUI()
		{
			initGUI();
		}
		
		private void initGUI() 
		{
			this.setSize(1000, 1000);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MenuBar menuBar = new MenuBar();
			Menu menu = new Menu("Menu");
			Menu test = new Menu("Test");
			menuBar.add(menu);
			menuBar.add(test);
			this.setMenuBar(menuBar);
			
			MenuItem save = new MenuItem("save");
			save.addActionListener(this);
			MenuItem load = new MenuItem("load");
			load.addActionListener(this);
			MenuItem isconnect = new MenuItem("isConnect");
			isconnect.addActionListener(this);
			MenuItem SP = new MenuItem("SP");
			SP.addActionListener(this);
			MenuItem SPD = new MenuItem("SPD");
			SPD.addActionListener(this);
			MenuItem TSP = new MenuItem("TSP");
			TSP.addActionListener(this);
			
			menu.add(save);
			menu.add(load);
			test.add(isconnect);
			test.add(SP);
			test.add(SPD);
			test.add(TSP);
			this.addMouseListener(this);
		}

		public void paint(Graphics g)
		{
			super.paint(g);
			
			Collection<node_data> s =_graph.getV();
			for (node_data node : s) 
			{
				Point3D p=node.getLocation();
				g.setColor(Color.RED);
				g.fillOval(p.ix(),p.iy(),10,10);
				g.drawString(""+node.getKey(), p.ix()+1, p.iy()+1);
				Collection<edge_data> e =_graph.getE(node.getKey());
				for(edge_data edge : e)
				{
					g.setColor(Color.BLUE);
					Point3D pE=_graph.getNode(edge.getDest()).getLocation();
					
					g.drawLine(p.ix(), p.iy(), pE.ix(), pE.iy());
				}
					
					
					
				
			}
		}
		public static void save() 
		{
			
			}
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
//			switch (str)
//			{
//			case "save":save();
//			case "load" :load();
//			case "isConnect":isConnect();
//			case "SP" : SP();
//			case "SPD" :SPD();
//			case "TSP" :TSP();
//			}
			
		}
		
		public static void main(String[] args) {
			graph g=new DGraph();
			int j=2;
			for (int i=100;i<1000;i=i+50,j=j+50)
			{
				Point3D Location = new Point3D(i,j);
				node_data node=new NodeData(i,Location);
				g.addNode(node);
			}
			Collection<node_data> s = g.getV();
			for (node_data node1 : s) 
			{
				for (node_data node2 : s) 
				{
					if(node1.getKey()!=node2.getKey())
						g.connect(node1.getKey(), node2.getKey(), Double.MAX_VALUE);
				}
			}
			GRAPH_GUI app = new GRAPH_GUI(g);
			app.setVisible(true);
	
			
			
		}

}
