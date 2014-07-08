/**
 * Physics.java
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

public class Physics {

	// class instance 
	public static Physics instance;
	
	// class constants
	private static final double AIR_DENSITY = 1.0;
	private static final double CONSTANT_k = 1.0;
	private static final double CONSTANT_D = 0.0026;
	private static final double DRAG_COEFFICIENT = 0.25;
	private static final double ROLLING_COEFFICIENT = 0.02;
	private static final double GRAVITY = 9.8;
	private static final double TIME = 0.25;
	
	// constructor - empty
	private Physics() {	}
	
	Ball ball = Ball.getBall();
	/**
	 * Class instance access method.
	 * @return instance of class Physics
	 */
	public static Physics getPhysics() {
		if(instance == null)
			instance = new Physics();
		return instance;
	}
	
	public double getX() {
		return 0.0;
	}
	
	public double getY() {
		return 0.0;
	}
	
	public double getZ() {
		return 0.0;
	}
	
	// kick the ball
	//   updates the vector velocities of the ball
	public void kick(double force, double angleXY, double angleXZ) {
		double x, y, z;
		// compute z_vector
		z = Field.getBall().getZ() + (force * Math.sin(angleXZ));		// v[0z] = v[0]sin(a[0])
		Field.getBall().setZ(z);
		
		// compute y_vector
		y = Field.getBall().getY() + (force * Math.sin(angleXY));		// v[0y] = v[0]sin(a[0])
		Field.getBall().setY(y);
		
		// compute x_vector
		x = Field.getBall().getX() + (force * Math.cos(angleXY));		// v[0x] = v[0]cos(a[0]) 
		Field.getBall().setX(x);
	}
	
	
	/**
	 * Force(drag) = -1/2 * C * rho * A * v^2
	 * @param area - surface area of object
	 * @param velocity - speed of object
	 * @return the positive value of the force due to drag, in Newtons.
	 */
	public double airDrag(double area, double velocity) {
		return ( 0.5*DRAG_COEFFICIENT*AIR_DENSITY*area*velocity*velocity );
	}
	
	/**
	 * Rolling Friction = Mu[r] * n
	 * @param newtons - Force of the rolling object.
	 * @return newtons - New force of object after applying friction.
	 */
	public double rollingFriction(double newtons) {
		return (ROLLING_COEFFICIENT * newtons);
	}
	
	/**
	 * Terminal Speed = sqrt( m g / D )
	 * @param mass - Mass of object falling
	 * @return Top speed for the object trough the fluid(air).
	 */
	public double terminalSpeed(double mass) {
		return Math.sqrt( (mass * GRAVITY) / CONSTANT_D);
	}
	
	/**
	 *  t = 0.25s
	 */
	public void update() {
		double accel = 0.0;
		double velocity = 0.0;
		double outside_forces = 0.0;
		
		// Ball...
		//	...apply forces, then calculate distance moved.
		
		accel = ball.getX() / ball.getMass();				// X vector computation
		outside_forces = airDrag( (ball.getSize()/2)*(ball.getSize()/2)*4*Math.PI, accel*TIME );
		if(ball.getZPos() <= 1.0) 					// on ground apply rolling friction too
			outside_forces += rollingFriction(ball.getX());
		
		if(outside_forces >= ball.getX())	{		// total damping check
			ball.setX(0.0);		// ball won't move, set force to 0
		System.out.println("Ball X: 0");}
		else {					// ball will move
			ball.setX(ball.getX() - outside_forces);// update force
			accel = ball.getX() / ball.getMass();	// get velocity
			velocity = accel * TIME;
			if( Math.abs(velocity) > terminalSpeed(ball.getMass()) ) {	// terminal check
				velocity = terminalSpeed(ball.getMass());
				if(velocity < 0 )
					velocity *= -1.0;
			}
			ball.setXPos( ball.getXPos() + velocity );		// update x position
			System.out.println("Ball X: " + ball.getXPos());
		}
				
		accel = ball.getY() / ball.getMass();				// Y vector computation
		outside_forces = airDrag( (ball.getSize()/2)*(ball.getSize()/2)*4*Math.PI, accel*TIME );
		if(ball.getZPos() <= 1.0) 					// on ground apply rolling friction too
			outside_forces += rollingFriction(ball.getY());
		
		if(outside_forces >= ball.getY())	{		// total damping check
			ball.setY(0.0);		// ball won't move, set force to 0
			System.out.println("Ball Y: 0");}
		else {					// ball will move
			ball.setY(ball.getY() - outside_forces);// update force
			accel = ball.getY() / ball.getMass();	// get velocity
			velocity = accel * TIME;
			if( Math.abs(velocity) > terminalSpeed(ball.getMass()) ) {	// terminal check
				velocity = terminalSpeed(ball.getMass());
				if(velocity < 0 )
					velocity *= -1.0;
			}
			ball.setYPos( ball.getYPos() + velocity );		// update y position
			System.out.println("Ball Y: " + ball.getYPos());
		}
	}
}
