/**
 * Player.java
 * 
 * 	This file is part of FootyBees.
 *
 *  FootyBees is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  FootyBees is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with FootyBees.  If not, see <http://www.gnu.org/licenses/>.
 *  
 *  Copyright 2014 Devin Rusnak
 *  @author Devin Rusank
 *
 */
package footybees;

public class Player extends PhysicalObject {

	// class instance variables
	private String name;
	private int number;
	private double[] position;
	
	public Player() {
		
	}
	
	public Player(String n, int num, double x, double y, double z) {
		
	}

	public Player(Player p) {
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumber() {
		return number;
	}
	
	public double[] getPosition() {
		return position;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public void setNumber(int n) {
		number = n;
	}
	
	public void setPosition(int x, int y, int z) {
		position[0] = x;
		position[1] = y;
		position[2] = z;
	}

	
}
