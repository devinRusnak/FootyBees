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

import java.util.Random;
import java.util.HashMap;

public class Team {
	
	// class instance variables
	private static Team home = null;
	private static Team visitor = null;
	
	// instance variables
	private String name;
	private HashMap<Integer, Player> squad;
	private String formation;
	
	private Team() {								// default constructor
		name = "default";
		formation = "4-4-2";
		squad = new HashMap<Integer,Player>(11);
		setSquad(1);
	}
	
	private Team(String n, int seed) {						// full-ish constructor
		name = n;
		squad = new HashMap<Integer,Player>(11);
		if(!Driver.simple)
			setSquad(seed);
		else
			setSquadSimple(seed);
	}
	
	/**
	 * 
	 * @return
	 */
	public static Team getHome() {
		if(home == null) 
			home = new Team("Hooloovooz", 1);
		return home;
	}
	
	/**
	 * 
	 * @return
	 */
	public static Team getVisitor() {
		if(visitor == null)
			visitor = new Team("Frog Stars", 1);
		return visitor;
	}
	
	/**
	 * 
	 * @param f
	 */
	public void setFormation(String f) {
		formation = f;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFormation() {
		return formation;
	}
	
	/**
	 * 
	 * @param seed
	 */
	private void setSquad(int seed) {
		Random rand = new Random();					// initialize random number generator
		if(seed != 0)
			rand.setSeed(seed);

	}
	
	/**
	 * 
	 * @param seed
	 */
	private void setSquadSimple(int seed) {
		Random rand = new Random();					// initialize random number generator
		if(seed != 0)
			rand.setSeed(seed);
		
		Player temp_player;
		
		for(int i=0; i<10; i++) {					// random regular players
			temp_player = new Player(i+1);
			temp_player.setStamina(rand.nextDouble() * 5.0 +5);				
			temp_player.setShot(rand.nextDouble() * 5.0 + 5);
			temp_player.setPass(rand.nextDouble() * 5.0 + 5);
			temp_player.setSpeed(rand.nextDouble() * 5.0 + 5);
			temp_player.setTackle(rand.nextDouble() * 5.0 + 5);
			if(this.name == "Frog Stars")
				temp_player.setSide(1);
			squad.put(i, temp_player);
			squad.get(i).printStats();
		}
		
		temp_player = new Player(11);				// fixed goalie stats
		temp_player.setStamina(7.0);
		temp_player.setShot(9.0);
		temp_player.setPass(10.0);
		temp_player.setSpeed(7.0);
		temp_player.setTackle(10.0);
		if(this.name == "Frog Stars")
			temp_player.setSide(1);
		squad.put(10, temp_player);
		squad.get(10).printStats();
		
	}
	
	/**
	 * 
	 * @return
	 */
	public HashMap<Integer, Player> getSquad() {
		return this.squad;
	}

	/**
	 * 
	 */
	public void update() {
		for(int i=0; i<11; i++) {
			if(Driver.debug)
				//System.out.println("updating player " + i+1);
			squad.put(i, Decision.think(squad.get(i)) );
		}
		
	}
}
