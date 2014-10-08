/**
 * PhysicalObject.java
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

public class PhysicalObject {

	protected double x_vector;		// newtons
	protected double y_vector;		// newtons
	protected double z_vector;		// newtons
	protected double[] position;		// meters
	protected double mass;			// kilo-grams
	
	public PhysicalObject() {
		x_vector = 0.0;
		y_vector = 0.0;
		z_vector = 0.0;
		position = new double[3];
		mass = 68.0;
	}
	
	public PhysicalObject(double x, double y, double z, double m) {
		x_vector = x;
		y_vector = y;
		z_vector = z;
		position = new double[3];
		mass = m;
	}
	
	public PhysicalObject(PhysicalObject p) {
		x_vector = p.getX();
		y_vector = p.getY();
		z_vector = p.getZ();
		position = new double[3];		
		mass = p.getMass();
	}
	
	public double getX() {
		return x_vector;
	}
	
	public double getY() {
		return y_vector;
	}
	
	public double getZ() {
		return z_vector;
	}
	
	public double getXPos(){
		return position[0];
	}
	
	public double getYPos(){
		return position[1];
	}
	
	public double getZPos(){
		return position[2];
	}
	
	public double getMass() {
		return mass;
	}
	
	public void setX(double x) {
		x_vector = x;
	}
	
	public void setY(double y) {
		y_vector = y;
	}
	
	public void setZ(double z) {
		z_vector = z;
	}
	
	public void setXPos(double x) {
		position[0] = x;
	}
	
	public void setYPos(double y) {
		position[1] = y;
	}
	
	public void setZPos(double z) {
		position[2] = z;
	}
	
	public void setMass(double m) {
		mass = m;
	}
	
}
