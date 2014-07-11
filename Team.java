/**
 * Team.java
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

import java.util.ArrayList;

public class Team {
	
	// class instance variables
	private static Team home;
	private static Team visitor;
	
	// instance variables
	private String name;
	private ArrayList<Player> squad;
	private String formation;
	
	private Team() {								// default constructor
		name = "The Defaults";
		squad = new ArrayList<Player>();
		formation = "default";
		getSquad();
	}
	
	private Team(String n) {						// full-ish constructor
		name = n;
		squad = new ArrayList<Player>();
		formation = "default";
		getSquad();
	}
	
	/**
	 * 
	 * @return
	 */
	public static Team getHome() {
		if(home == null) 
			home = new Team("Hooloovooz");
		return home;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Team getVisitor() {
		if(visitor == null)
			visitor = new Team("Frog Stars");
		return visitor;
	}
	
	/**
	 * 
	 * @param p
	 */
	private void addToSquad(Player p) {
		squad.add(p);
	}
	
	/**
	 * 
	 * @param p
	 */
	private void removeFromSquad(Player p) {
		squad.remove(p);
	}
	
	/**
	 * 
	 * @return
	 */
	public int sizeOfTeam() {
		return squad.size();
	}
	
	/**
	 * 
	 */
	private void getSquad() {
		// team specific stuff
		if(name == "Hooloovooz") {
			
		}
		else {
			
		}
		
		// general team stuff
			
	}

}
