/**
 * Decision.java
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

public class Decision {

	private static Decision instance;
	// other class variables???
	
	private Decision() {
		
	}
	
	/**
	 * 
	 * @return
	 */
	public static Decision getDecision() {
		if(instance == null)
			instance = new Decision();
		return instance;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public static Player think(Player p) {
		
		// clock not running, get into position
		if(!Referee.clock_running) 
			 return getIntoPosition(p);
		
		else {
			// Heuristic 1  TODO
			
		}
		
		return p;
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	private static Player getIntoPosition(Player p) {
		if(Driver.debug)
			System.out.println("getting into position");	
		
		
		if(p.getNumber() == 11) {		// goalie, get in box
			if(p.getXPos() > Field.getCenter().getX()) {
				p.setX(10);
			}
			
			return p;
		}
			
		if(p.getSide() == 1) {

		}
	
		return p;
	}
	
}
