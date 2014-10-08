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

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")	// ?
public class DrawingPanel extends JPanel {

	
	public void paintComponent(Graphics g) {
		Player tempHome, tempAway;
		int width = (int)(Field.getWidth()*4);
		int length = (int)(Field.getLength()*4);
		int ball_size = (int)(Ball.getBall().getSize()*20);
		
		// background
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 375, 500);
		g.setColor(Color.black);
		
		// outer box
		g.drawRect(50, 40, width, length);
		g.setColor(Color.green);
		g.fillRect(52, 42, width-3, length-3);
		
		// half line
		g.setColor(Color.black);
		g.drawLine(50, 40+(length/2), 50+width, 40+(length/2));
		
		// half circle
		g.drawOval((50 + (width/2) - 37), (40 + (length/2) - 37), 74, 74);
		
		// goalie boxes
		g.drawLine((50 + 55 + 44), 65, (50 + 55 + 44 + 73), 65);
		g.drawLine((50 + 55 + 44), 40, (50 + 55 + 44), 64);
		g.drawLine((50 + 55 + 44 + 73), 40, (50 + 55 + 44 + 73), 64);
		
		g.drawLine((50 + 55 + 44), 436, (50 + 55 + 44 + 73), 436 );
		g.drawLine((50 + 55 + 44), 436, (50 + 55 + 44), 460);
		g.drawLine((50 + 55 + 44 + 73), 436, (50 + 55 + 44 + 73), 460);
		
		// penalty boxes
		g.drawLine((50 + 55), 106, (50 + 55 + 161), 106);
		g.drawLine((50 + 55), 40, (50 + 55), 106);
		g.drawLine((50 + 55 + 161), 40, (50 + 55 + 161), 106);
		
		g.drawLine((50 + 55), 394, (50 + 55 + 161), 394);
		g.drawLine((50 + 55), 394, (50 + 55), 460);
		g.drawLine((50 + 55 + 161), 394, (50 + 55 + 161), 460);
		
		// ball
		g.drawOval((int)Ball.getBall().getXPos()-(ball_size/2), (int)Ball.getBall().getYPos()-(ball_size/2), 
				ball_size, ball_size);
		g.setColor(Color.orange);
		g.fillOval((int)Ball.getBall().getXPos()-(ball_size/2), (int)Ball.getBall().getYPos()-(ball_size/2), 
				ball_size, ball_size);
		g.setColor(Color.yellow);
		g.drawOval( ((int)Ball.getBall().getXPos()) - (ball_size * (int)(Ball.getBall().getZPos() * 1.5)), 
				((int)Ball.getBall().getYPos()) - (ball_size * (int)(Ball.getBall().getZPos() * 1.5)), 
				ball_size*(int)(Ball.getBall().getZPos() * 3), 
				ball_size*(int)(Ball.getBall().getZPos() * 3) ); 	// draw circle proportional to the height of the ball


		// players TODO
		for(int i=0; i < 11; i++) {
			tempHome = Team.getHome().getSquad().get(i);
			tempAway = Team.getVisitor().getSquad().get(i);
			
			g.drawRect((int)tempHome.getXPos()*4, (int)tempHome.getYPos()*4, 8, 8);
			g.fillRect((int)tempHome.getXPos()*4-1, (int)tempHome.getYPos()*4-1, 7, 7);
			
			g.drawRect((int)tempAway.getXPos()*4, (int)tempAway.getYPos()*4, 8, 8);
			g.fillRect((int)tempAway.getXPos()*4-1, (int)tempAway.getYPos()*4-1, 7, 7);
		}
	}

}
