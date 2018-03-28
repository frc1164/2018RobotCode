package org.usfirst.frc.team1164.logic.motionProfiler;

public class PIDMotion {
	
	protected MotionProfiler MP;
	protected PIDController P;
	protected double actualCurrentPos;
	
	public PIDMotion(double maxAcceleration, double maxVelocity, double kP, double kI, double kD) {
		
		MP = new MotionProfiler(maxAcceleration, maxVelocity);
		
		P = new PIDController(kP, kI, kD);
		P.setNextPoint(0);
	}
	
	public double getOutput(double actualPos) {
		MP.update();
		P.setNextPoint(MP.getPos());
		actualCurrentPos = actualPos;
		return P.getOutput(actualPos);
	}
	
	public void setEndpoint(double goal) {
		MP.setEndpoint(goal);
	}
	
	
	public boolean isDone(int deadbandAllowance, double deadband) {
		return P.isDone(deadbandAllowance, deadband, MP.getEndPoint() - actualCurrentPos);
	}
	
	public int getAccelLength() { 
		return MP.getAccelLength(); 
	}
}
