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
	private int number;
	private int side;
	private double stamina;
	private double speed;
	private double shot;
	private double pass;
	private double tackle;
	private double header;
	
	
	public Player() {
		number = 0;
		side = 0;
		stamina = 0.0;
		speed = 0.0;
		shot = 0.0;
		pass = 0.0;
		tackle = 0.0;
		header = 0.0;
	}
	
	
	public Player(int num) {		
		number = num;
		side = 0;
		stamina = 0.0;
		speed = 0.0;
		shot = 0.0;
		pass = 0.0;
		tackle = 0.0;
		header = 0.0;
	}
	

	public Player(Player p) {
		
	}

	
	/**
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getSide() {
		return side;
	}
	
	/**
	 * 
	 * @param s
	 */
	public void setSide(int s) {
		side = s;
	}
	
	/**
	 * 
	 * @return
	 */
	public double[] getPosition() {
		return position;
	}
	
	
	/**
	 * 
	 * @param n
	 */
	public void setNumber(int n) {
		this.number = n;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param z
	 */
	public void setPosition(int x, int y, int z) {
		position[0] = x;
		position[1] = y;
		position[2] = z;
	}

	/**
	 * 
	 * @return
	 */
	public double getStamina() {
		return stamina;
	}

	/**
	 * 
	 * @param stamina
	 */
	public void setStamina(double stamina) {
		this.stamina = stamina;
	}

	/**
	 * 
	 * @return
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * 
	 * @param speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * 
	 * @return
	 */
	public double getShot() {
		return shot;
	}

	/**
	 * 
	 * @param shot
	 */
	public void setShot(double shot) {
		this.shot = shot;
	}

	/**
	 * 
	 * @return
	 */
	public double getPass() {
		return pass;
	}

	/**
	 * 
	 * @param pass
	 */
	public void setPass(double pass) {
		this.pass = pass;
	}

	/**
	 * 
	 * @return
	 */
	public double getTackle() {
		return tackle;
	}

	/**
	 * 
	 * @param tackle
	 */
	public void setTackle(double tackle) {
		this.tackle = tackle;
	}

	/**
	 * 
	 * @return
	 */
	public double getHeader() {
		return header;
	}

	/**
	 * 
	 * @param header
	 */
	public void setHeader(double header) {
		this.header = header;
	}

	/**
	 * 
	 */
	public void printStats() {
		System.out.println("Player #" + this.number);
		System.out.println("\tStamina " + this.stamina);
		System.out.println("\tSpeed " + this.speed);
		System.out.println("\tShot " + this.shot);
		System.out.println("\tPass " + this.pass);
		System.out.println("\tTackle " + this.tackle);
		if(!Driver.simple)
			System.out.println("\tHeader " + this.header);
	}
	
	
}
