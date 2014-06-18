/**
 * Physics.java
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

public class Physics {

	// constants
	private static final double GRAVITY = -9.8;
	private static final double AIR_RESISTANCE = -0.25;
	private static final double ROLLING_RESISTANCE = -1.0;
	
	// class instance 
	public static Physics instance;
	
	private Physics() {	}
	
	/**
	 * 
	 * @return
	 */
	public static Physics getPhysics() {
		if(instance == null)
			instance = new Physics();
		return instance;
	}
	
	public double getX() {
		return 0.0;
	}
	
	public double getY() {
		return 0.0;
	}
	
	public double getZ() {
		return 0.0;
	}
	
	/**
	 * 
	 */
	public void update() {
		
	}
}
