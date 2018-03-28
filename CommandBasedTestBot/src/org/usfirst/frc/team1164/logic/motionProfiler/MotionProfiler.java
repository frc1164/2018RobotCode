package org.usfirst.frc.team1164.logic.motionProfiler;

import static org.usfirst.frc.team1164.robot.RobotMap.timeFrame;

import edu.wpi.first.wpilibj.filters.LinearDigitalFilter;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MotionProfiler {

	private PosCounter counter;
	private LinearDigitalFilter filter;
	private double curPos;
	private double curVel;
	private double endpoint;
	private double aMax;
	private double vMax;
	
	public MotionProfiler(double aMax, double vMax) {
		
//		 sets the current position of the robot and endpoint
		curPos = 0;
		endpoint = 0;
		this.aMax = aMax;
		this.vMax = vMax;
//		SmartDashboard.putString("start", String.format("%f and %f", aMax, vMax));
//		creates the acceleration block
		
		int ffGainLength = (int) (vMax / (aMax * timeFrame));
		
//		int ffGainLength = (int) (1 / (aMax * timeFrame));
//		SmartDashboard.putString("start2", String.format("%d", ffGainLength));
		double[] ffGain = new double[ffGainLength];
		for (int i = 0; i < ffGainLength; i++) {
			ffGain[i] = vMax / ffGainLength;
		}
		
//		creates the position block
		counter = new PosCounter(ffGainLength);
		
//		creates the filter "convolution"
		double[] fbGain = {};
//		SmartDashboard.putString("ffGains",String.format("%f %f", ffGain[0], ffGain[500]));
		filter = new LinearDigitalFilter(counter, ffGain, fbGain);
		filter.reset();
	}
	
	public void update() {
//		does the next convolution step
		double srn = 0.001 * (Math.random() - 0.5);
		
		curVel = filter.pidGet();
		curPos += (curVel * timeFrame);
		SmartDashboard.putString("bad",String.format("%f %f", curVel, curPos));
		SmartDashboard.putNumber("setPoint", curPos + srn);
	}
	
	public void setEndpoint(double endpoint) {
//		sets the final goal
		this.endpoint = endpoint;
		counter.setEndPoint((int) (endpoint / (vMax * timeFrame)));
	}
	
	public double getEndPoint() {
		return endpoint;
	}
	
	public double getVel() {
//		return most recent velocity
		return curVel;
	}
	
	public double getPos() {
//		returns most recent position
		return curPos;  
	}
	
	// get the length of acceleration block
	public int getAccelLength() {
		return counter.getGap();
	}
	
}
