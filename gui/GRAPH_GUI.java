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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	graph Gui_Graph;

	public GRAPH_GUI(graph g)
	{
		this.Gui_Graph=g;
		initGUI();
	}

	public GRAPH_GUI()
	{
		initGUI();
	}

	private void initGUI() 
	{
		setCanvasSize();
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
		MenuItem AddEdge = new MenuItem("AddEdge");
		AddEdge.addActionListener(this);

		menu.add(save);
		menu.add(load);
		test.add(isconnect);
		test.add(SP);
		test.add(SPD);
		test.add(TSP);
		test.add(AddEdge);
		this.addMouseListener(this);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		Collection<node_data> s =Gui_Graph.getV();

		for (node_data node : s) 
		{
			Point3D p=node.getLocation();
			g.setColor(Color.RED);
			g.fillOval(p.ix(),p.iy(),10,10);
			g.drawString(""+node.getKey(), p.ix()+1, p.iy()+1);
			Collection<edge_data> e =Gui_Graph.getE(node.getKey());
			for(edge_data edge : e)
			{
				if(edge.getTag() ==999)
				{
					g.setColor(Color.GREEN);
					edge.setTag(0);
				}
				else
				{
					g.setColor(Color.BLUE);
				}
				Point3D pE=Gui_Graph.getNode(edge.getDest()).getLocation();
				g.drawLine(p.ix(), p.iy(), pE.ix(), pE.iy());
				double w=Math.floor(edge.getWeight() * 100) / 100;
				g.drawString(""+w,(int)(((p.x()*3+pE.x())/4))+1,(int)((p.y()*3+pE.y())/4)+1);
				g.setColor(Color.YELLOW);
				g.fillOval((int)(((p.x()*3+pE.x())/4)),(int)((p.y()*3+pE.y())/4),10,10);

			}
		}
	}
	public void save() 
	{
		graph_algorithms g = new Graph_Algo();
		g.init(Gui_Graph);
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			try
			{
				g.save(chooser.getSelectedFile()+".txt");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

	}
	public void load() 
	{
		Graph_Algo g = new Graph_Algo();
		JFileChooser chooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION)
		{
			try
			{
				File SelectedFile=chooser.getSelectedFile();
				g.init(SelectedFile.getAbsolutePath());
				Gui_Graph=g.copy();
				repaint();

			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}

	}
	public void isConnect() {
		graph_algorithms g = new Graph_Algo();
		g.init(Gui_Graph);
		boolean ans = g.isConnected();
		if(ans)
		{
			JOptionPane.showMessageDialog(null,"The graph is connected", "isConnected", JOptionPane.QUESTION_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "The graph is not connected", "isConnected", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void addEdge()
	{
		String src=  JOptionPane.showInputDialog("Please input the src");
		String dst=  JOptionPane.showInputDialog("Please input the dest");
		String w=  JOptionPane.showInputDialog("Please input the wahit");
		try {
			Gui_Graph.connect(Integer.parseInt(src), Integer.parseInt(dst), Integer.parseInt(w));
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		repaint();
	}

	public void SP() 
	{
		String src=  JOptionPane.showInputDialog("Please input the src ");
		String dst=  JOptionPane.showInputDialog("Please input the dest");
		graph_algorithms g = new Graph_Algo();
		g.init(Gui_Graph);
		List <node_data> ans=g.shortestPath(Integer.parseInt(src),Integer.parseInt(dst));
		if (ans ==null)
		{
			JOptionPane.showMessageDialog(null,"Err, There is no path between the points :", "shortest path points \"+src+\"-\"+dst", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int s=0;
		for (int d=1;d<ans.size();d++,s++)
		{
			Gui_Graph.getEdge(ans.get(s).getKey(),ans.get(d).getKey()).setTag(999);
		}
		repaint();

	}
	public void SPD() 
	{
		String src=  JOptionPane.showInputDialog("Please input a starting point");
		String dst=  JOptionPane.showInputDialog("Please input a ending point");
		graph_algorithms g = new Graph_Algo();
		g.init(Gui_Graph);
		double ans =g.shortestPathDist(Integer.parseInt(src),Integer.parseInt(dst));
		if(ans !=Double.MAX_VALUE)
		{
			JOptionPane.showMessageDialog(null,"The shortest path dist is:\n "+ans,"shortest path points "+src+"-"+dst, JOptionPane.INFORMATION_MESSAGE);
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"Err, There is no path between the points :", "shortest path points \"+src+\"-\"+dst", JOptionPane.INFORMATION_MESSAGE);	
		}

	}
	public void TSP() 
	{
		List <Integer> targets =new ArrayList<Integer>();
		int repeat;
		String input="";
		do {
			input=JOptionPane.showInputDialog("Please input the points \n ");
			try {
				targets.add(Integer.parseInt(input));
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
			repeat = JOptionPane.showConfirmDialog(null, "Press Yes to repeat, No to quit ", "please confirmm", JOptionPane.YES_NO_OPTION);

		}while(repeat == JOptionPane.YES_OPTION);
		graph_algorithms g = new Graph_Algo();
		g.init(Gui_Graph);
		List <node_data> ans =g.TSP(targets);
		if (ans ==null)
		{
			JOptionPane.showMessageDialog(null,"Err, There is no path between the points :", "shortest path points \"+src+\"-\"+dst", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		int src=0;
		for (int dst=1;dst<ans.size();dst++,src++)
		{
			Gui_Graph.getEdge(ans.get(src).getKey(),ans.get(dst).getKey()).setTag(999);
		}
		repaint();
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
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		switch (str)
		{
		case "save"     :save();
		break;
		case "load"     :load();
		break;
		case "isConnect":isConnect();
		break;
		case "SP"       :SP();
		break;
		case "SPD"      :SPD();
		break;
		case "TSP"      :TSP();
		break;
		case "AddEdge"      :addEdge();
		break;
		}

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

	public void setCanvasSize()
	{
		Collection<node_data> s =Gui_Graph.getV();
		int xi[]=new int[s.size()];
		int yi[]=new int[s.size()];
		int i=0;
		for (node_data node : s) 
		{
			xi[i]=node.getLocation().ix();
			yi[i]=node.getLocation().iy();
			i++;
		}
		Arrays.sort(xi); 
		Arrays.sort(yi); 
		int x=(int) ((Math.abs(xi[0])+Math.abs(xi[s.size()-1])+200));
		int y=(int) ((Math.abs(yi[0])+Math.abs(yi[s.size()-1])+200));
		this.setSize(x, y);

	}

	public static void main(String[] args) {
		graph g=new DGraph();

		for (int i=1;i<11;i++)
		{
			int ix=(int)(Math.random()*800);
			int iy=(int)(Math.random()*800);
			node_data v=new NodeData(i,new Point3D(ix,iy));
			g.addNode(v);
		}
		for (int i=0;i<20;i++)
		{
			int src=(int)(Math.random()*10+1);
			int dst=1;
			do {
				dst=(int)(Math.random()*10+1);
			}while(dst==src);	
			System.out.println(src+"," +dst);
			double w=Math.random()*100;
			g.connect(src, dst, w);

		}


		GRAPH_GUI app = new GRAPH_GUI(g);
		app.setVisible(true);
	}
}