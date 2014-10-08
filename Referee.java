/**
 * Referee.java
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

import java.util.Timer;
import java.util.TimerTask;

public class Referee {

	private static Referee instance;
	private static Timer time;
	private static Team home;
	private static Team visitor;
	private static String clock;
	private long counter;
	protected static boolean clock_running;
	protected int mins;
	protected int secs;
	protected int stopage;
	
	private Referee() {
		time = new Timer();
		clock_running = false;
		time.scheduleAtFixedRate(new Updater(), 5000, 100);
		time.scheduleAtFixedRate(new GraphicsUpdater(), 0, 50);
		counter = 0;
		secs = 0;
		mins = 0;
		stopage = 1;
		
		home = Team.getHome();
		home.setFormation("4-3-2-1");
		visitor = Team.getVisitor();
		visitor.setFormation("4-3-2-1");
	}
	
	/**
	 * 
	 * @return
	 */
	public static Referee getRef() {
		if(instance == null)
			instance = new Referee();
		return instance;
	}
	
	/**
	 *  Toggles the clock running.
	 */
	public static void toggleTime() {
		if(clock_running)
			clock_running = false;
		else
			clock_running = true;
	}
	
	/**
	 * 
	 */
	private void outOfBounds() {
		GUI.setText("Out of Bounds!");
	}
	
	/**
	 *  This timer task is used to time the updating of all the physics 
	 *  engine items.
	 */
	private class Updater extends TimerTask {

		/**
		 * Updating function that gets called every 100 milliseconds by the 
		 * referee class timer. The long counter acts to allow the clock to
		 * be updated every second. 
		 * 	Every 100 milliseconds:
		 * 		counter is updated.
		 * 		physics update is called.
		 * 		
		 *  Note: This timer was a bit slow to issue the drawing pane to be 
		 *  	  updated, so made the other timer.
		 */
		@Override
		public void run() {			
			counter++;
			
			// update clock if time is running
			if(clock_running && (counter%10 == 0)) {
				GUI.getGUI().setClock(tick());
				if(Driver.debug)
					System.out.println(GUI.getGUI().getClock());
			}
			
			// update physics
			if(!Driver.simple)
				Physics.getPhysics().update();
			else
				Physics.getPhysics().updateSimple();
			
			// Soccer Rule Enforcing ... TODO
			
			// goal check
			
			// out of bounds check
			if(Ball.getBall().getXPos() < 49 || Ball.getBall().getXPos() > (Field.getWidth()*4)+50)
				outOfBounds();
			else if(Ball.getBall().getYPos() < 39 || Ball.getBall().getYPos() > (Field.getLength()*4)+40)
				outOfBounds();
			
			// Player Decisions
			if(counter%10 == 0) {			// update player decision every 10 
				Team.getHome().update();
				Team.getVisitor().update();
			}
		}
		
		/**
		 * Keeps track of the time and creates/returns a 
		 * formated string that displays the time orderly.
		 * 
		 * @return	a new string that contains the time formated.
		 */
		private String tick() {			
			secs++; // tock!
			
			if(secs == 60) {
				secs = 0;
				mins++;
			}
			if(clock == null)			// check if clock has been initialized
				clock = new String();
			
			if( (secs%60) < 10 && mins < 10)
				clock = (mins + "0 : 0" + secs);
			else if ( (secs%60) < 10 )
				clock = (mins + " : 0" + secs);
			else if ( mins < 10 )
				clock = (mins + "0 : " + secs);
			else
				clock = (mins + " : " + secs);
			return clock;	// return formatted clock string
		}
		
	} // end Updater class
	
	// This timer task is used to update the graphics of the field.
	private class GraphicsUpdater extends TimerTask {

		@Override
		public void run() {
			GUI.getFrame().repaint();	// redraw field, ball, etc
		}
		
	}// end GraphicsUpdater class
	
} // end Referee Class
