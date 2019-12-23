package dataStructure;

public class EdgeData implements edge_data{
	
	node_data src;
	node_data dest;
	double weight;
	int tag;
	String info;
	
	public EdgeData(node_data src,node_data dest)
	{
		this.src=src;
		this.dest=dest;
		this.weight=Double.MAX_VALUE;
		tag=0;
	}
	public EdgeData(node_data src,node_data dest,double weight)
	{
		this.src=src;
		this.dest=dest;
		this.weight=weight;
		tag=0;
	}

	@Override
	public int getSrc() {
		return this.src.getKey();
	}

	@Override
	public int getDest() {
		return this.dest.getKey();
	}

	@Override
	public double getWeight() {
		return this.weight;
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
		this.tag = t;
	}

}
