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
import java.util.LinkedList;

import javax.swing.JFrame;

import utils.Point3D;

	public final class GRAPH_GUI  extends JFrame implements ActionListener, MouseListener, MouseMotionListener, KeyListener
	{
		LinkedList<Point3D> points = new LinkedList<Point3D>();
		
		public GRAPH_GUI()
		{
			initGUI();
		}
		
		private void initGUI() 
		{
			this.setSize(800, 600);
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
			
			Point3D prev = null;
		
			for (Point3D p : points) 
			{
				g.setColor(Color.BLUE);
				g.fillOval((int)p.x(), (int)p.y(), 10, 10);
				
				if(prev != null)
				{
					g.setColor(Color.RED);
					g.drawLine((int)p.x(), (int)p.y(), 
							(int)prev.x(), (int)prev.y());
					
					g.drawString("5", (int)((p.x()+prev.x())/2),(int)((p.y()+prev.y())/2));
				}
				prev = p;
			}
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
			// TODO Auto-generated method stub
			
		}
		
		public static void main(String[] args) {
			GRAPH_GUI app = new GRAPH_GUI();
			app.setVisible(true);
			
		}

}
