/**
 * Ball.java
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

public class Ball extends PhysicalObject {
	
	private static double elasticity;
	private static double[] position;
	private static Ball instance;
	
	private Ball() {
		elasticity = 1.0;			// k_constant
		position = new double[3];
		position[0] = 0.0;			// xPos
		position[1] = 0.0;			// yPos
		position[2] = 0.0;			// zPos
	}
	
	/**
	 * 
	 * @return
	 */
	public static Ball getBall() {
		if(instance == null)
			instance = new Ball();
		return instance;
	}
	
	public double getK() {
		return elasticity;
	}
	
	public void setK(double k) {
		elasticity = k;
	}
}
