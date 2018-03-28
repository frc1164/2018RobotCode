package org.usfirst.frc.team1164.logic.motionProfiler;

import static org.usfirst.frc.team1164.robot.RobotMap.timeFrame;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDController {
	private double prevError;
	private double nextPoint;
	
	private double kP;
	private double kI;
	private double kD;
	
	private double intergral;
	
	//private int deadband;
	private int inDeadband = 0;
	
	public PIDController(double kP, double kI, double kD) {
		this.kP = kP;
		this.kI = kI;
		this.kD = kD;
		
		prevError = 0;
		intergral = 0;
	}
	
	public void setNextPoint(double nextPoint) {
		this.nextPoint = nextPoint;
	}
	
	public double getOutput(double actualPos) {
		double error = nextPoint - actualPos;
		intergral += (error * timeFrame);
		double derivative = (error - prevError) / timeFrame;
		double output = (error * kP) + (intergral * kI) + (derivative * kD);
		prevError = error;
		return output;
	}
	
	public boolean isDone(int deadbandAllowance, double deadband, double error) {
		SmartDashboard.putNumber("thing error", error);
		if (error < deadband && error > -deadband) {
			inDeadband++;
			SmartDashboard.putBoolean("in deadband", false);
		}
		else {
			inDeadband = 0;
			SmartDashboard.putBoolean("in deadband", true);
		}
		if (inDeadband >= deadbandAllowance) {
			return true;
		}
		return false;
	}
}
