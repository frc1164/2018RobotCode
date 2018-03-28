package org.usfirst.frc.team1164.logic.motionProfiler;

public class PIDVMotion extends PIDMotion {
	
	private double kV;
	
	public PIDVMotion (double maxAcceleration, double maxVelocity, double kP, double kI, double kD, double kV) {
		super(maxAcceleration, maxVelocity, kP, kI, kD);
		this.kV = kV;
	}
	
	public double getOutput(double actualPos) {
		//updates the Motion Profiler with next set point
		MP.update();
		
		//passes the set point to the PID controller
		P.setNextPoint(MP.getPos());
		
		actualCurrentPos = actualPos;
		
		//adds the kV to the PID controller's output
		return P.getOutput(actualPos) + (MP.getVel() * kV);
	}
}
