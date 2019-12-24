package Tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.NodeData;
import dataStructure.node_data;
import utils.Point3D;

class NodeDataTest {

	@Test
	void testNodeDataIntPoint3D() {
		Point3D Location =new Point3D(2,1);
		node_data node =new NodeData(1,Location);
	}

	@Test
	void testGetKey() {
		Point3D Location =new Point3D(2,1);
		int key =23;
		node_data node =new NodeData(key,Location);
		   assertEquals(node.getKey(),key);
		
	}

	@Test
	void testGetLocation() {
		Point3D Location =new Point3D(2,1);
		int key =23;
		node_data node =new NodeData(key,Location);
		   assertEquals(node.getLocation(),Location);
	}

	@Test
	void testSetLocation() {
		int key =23;
		Point3D Location =new Point3D(2,1);
		node_data node =new NodeData(key,Location);
		Point3D newLocation =new Point3D(1,2);
		node.setLocation(newLocation);
		   assertEquals(node.getLocation(),newLocation);
	}


}
