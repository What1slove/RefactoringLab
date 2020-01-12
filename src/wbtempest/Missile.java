package wbtempest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A missile.  If being fired down into the level, it represents a player missile;
 * if fired up (at the player), it represents an enemy missile.
 * 
 * @author ugliest
 *
 */
public class Missile {
	private static int BASE_SPEED = 8;
	static int HEIGHT = 8;
	private static int HEIGHT_H = HEIGHT/2;
	private int colnum;
	private int zpos;
	private boolean visible = true;
	private int speed;
	
	public Missile(int colnum, int zpos, boolean down){
		this.colnum = colnum;
		this.zpos = zpos;
    	if (down)
    		speed = BASE_SPEED;
    	else
    		speed = -BASE_SPEED/2;
	}
	
	public int getZPos(){
		return zpos;
	}
	
	public int getColumn(){
		return colnum;
	}
	
	public void move(int maxz){
		zpos+=speed;
		if ((zpos > maxz) || (zpos < 0))
			visible = false;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	/**
	 * return the points that make up the onscreen missile.
	 * 
	 * @param lev
	 * @return
	 */
	public GameObjectCoordsMap getCoords(Level lev){
		GameObjectCoordsMap coordsMap = new GameObjectCoordsMap(5);
		ArrayList<Coord> coords = coordsMap.coords;
		Column c = lev.getColumns().get(colnum);
		int[] p1 = c.getFrontPoint1();
		int[] p2 = c.getFrontPoint2();
		coords.get(0).setXYZ(p1[0]+(p2[0] - p1[0])*2/5,p1[1]+(p2[1] - p1[1])*2/5,zpos-HEIGHT_H);
		coords.get(1).setXYZ(p1[0]+(p2[0] - p1[0])/2,p1[1]+(p2[1] - p1[1])/2,zpos-HEIGHT);
		coords.get(2).setXYZ(p1[0]+(p2[0] - p1[0])*3/5,p1[1]+(p2[1] - p1[1])*3/5,zpos-HEIGHT_H);
		coords.get(3).setXYZ(p1[0]+(p2[0] - p1[0])/2,p1[1]+(p2[1] - p1[1])/2,zpos);
		coords.get(4).setXYZ(coords.get(0));
		coordsMap.coords=coords;
		return coordsMap;
	}

	/**
	 * coordinates for the second layer to be drawn; idea is to allow board to draw in 
	 * a different color.
	 * @param lev
	 * @return
	 */
	public GameObjectCoordsMap getLayerCoords(Level lev){
		GameObjectCoordsMap coordsMap = new GameObjectCoordsMap(5);
		ArrayList<Coord> coords = coordsMap.coords;
		Column c = lev.getColumns().get(colnum);
		int[] p1 = c.getFrontPoint1();
		int[] p2 = c.getFrontPoint2();
		coords.get(0).setXYZ(p1[0]+(p2[0] - p1[0])*9/20,p1[1]+(p2[1] - p1[1])*9/20,zpos-HEIGHT_H);
		coords.get(1).setXYZ(p1[0]+(p2[0] - p1[0])/2,p1[1]+(p2[1] - p1[1])/2,zpos-HEIGHT*3/5);
		coords.get(2).setXYZ(p1[0]+(p2[0] - p1[0])*11/20,p1[1]+(p2[1] - p1[1])*11/20,zpos-HEIGHT_H);
		coords.get(3).setXYZ(p1[0]+(p2[0] - p1[0])/2,p1[1]+(p2[1] - p1[1])/2,zpos-HEIGHT*2/5);
		coords.get(4).setXYZ(coords.get(0));
		coordsMap.coords=coords;
		return coordsMap;
	}

	public void setVisible(boolean b) {
		this.visible = b;
	}
}
