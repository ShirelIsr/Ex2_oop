package dataStructure;
import java.awt.Color;
import utils.Point3D;

public class NodeData implements node_data{ 
	
	int key;
	Point3D location;
	double weight;
	int tag = 0;
	String info;
	
	public NodeData(int key,Point3D Location)
	{
		this.key=key;
		this.location=Location;
		this.weight=Double.MAX_VALUE;
		tag=0;

	}
	
	public NodeData(int key,Point3D Location,double weight,int tag)
	{
		this.key=key;
		this.location=Location;
		this.weight= weight;
		this.tag = tag;
	}
	
	public NodeData(node_data node)
	{
		this(node.getKey(),node.getLocation(),node.getWeight(),node.getTag());
		this.info = node.getInfo();

	}


	@Override
	public int getKey() {
		return this.key;
	}

	@Override
	public Point3D getLocation() {

		return this.location;
	}

	@Override
	public void setLocation(Point3D p) {
		this.location=p;
	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight=w;

	}

	@Override
	public String getInfo() {
		return this.info;
	}

	@Override
	public void setInfo(String s) {
		this.info = s;
	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag=t;

	}
}
