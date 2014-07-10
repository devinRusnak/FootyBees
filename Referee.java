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
	private long counter;
	protected static boolean clock_running;
	protected int mins;
	protected int secs;
	protected int stopage;
	
	private Referee() {
		time = new Timer();
		clock_running = true;
		time.scheduleAtFixedRate(new Updater(), 5000, 250);
		time.scheduleAtFixedRate(new GraphicsUpdater(), 0, 50);
		counter = 0;
		secs = 0;
		mins = 0;
		stopage = 1;
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
	 *  This timer task is used to time the updating of all the physics 
	 *  engine items.
	 */
	private class Updater extends TimerTask {

		/**
		 * Updating function that gets called every 250 milliseconds by the 
		 * referee class timer. The long counter acts to allow the clock to
		 * be updated every second. 
		 * 	Every 250 milliseconds:
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
			if(clock_running && (counter % 4 == 0)) {
				GUI.getGUI().setClock(tick());
				if(Driver.debug)
					System.out.println(counter);
			}
			
			// update physics
			Physics.getPhysics().update();
			
			
			// Soccer Rule Enforcing ... TODO
			
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
			if( (secs%60) < 10 && mins < 10)
				return new String(mins + "0 : 0" + secs);
			else if ( (secs%60) < 10 )
				return new String(mins + " : 0" + secs);
			else if ( mins < 10 )
				return new String(mins + "0 : " + secs);
			else
				return new String(mins + " : " + secs);
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
