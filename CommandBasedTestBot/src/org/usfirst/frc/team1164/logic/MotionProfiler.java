package org.usfirst.frc.team1164.logic;
import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc.team1164.logic.PosCounter;

public class MotionProfiler implements PIDOutput {
	private double velocityMax;
	private double accelerationMax;
	private static final double time = 0.002;
	public static final PosCounter kPosCounter = new PosCounter(gap);
	
	public MotionProfiler () {
		kPosCounter.PIDGet();
	}


	@Override
	public void pidWrite(double output) {
		// TODO Auto-generated method stub
		
	}
}