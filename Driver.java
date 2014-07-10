/**
 * Driver.java
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

public class Driver {
	public static boolean debug = true;
	
	// MAIN!!!
	public static void main(String[] args) {
		
		// print out header info to standard output
		System.out.println("Soccer Simulator for AI Testing:");
		System.out.println("Footy-Bees");
		System.out.println("Author: Devin Rusnak  June 2014");
		System.out.println("initializing...");
		
		// game variable declaration and initialization
		Physics laws = Physics.getPhysics();
		Decision mind = Decision.getDecision();
		Field pitch = Field.getPitch();
		GUI view = GUI.getGUI();
		Referee ref = Referee.getRef();
		System.out.println("..ready");

		// Physics Equation Testing
		System.out.println(laws.terminalSpeed(Ball.getBall().getMass()));
		System.out.println(laws.rollingFriction(300.0));
		System.out.println(laws.airDrag( (Ball.getBall().getSize()/2)*2*Math.PI, 2.0) ); 

	}

}
