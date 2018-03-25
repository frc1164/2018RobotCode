package org.usfirst.frc.team1164.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class LW {
	
	public static void robot() {
		Robot.decider.SmartDashboard();
	}
	
	public static void disabled() {
		
	}
	
	public static void auto() {
		
	}
	
	public static void teleop() {
		
	}
	
	public static void test() {
		
	}
	
	public static void clear() {
		for (String s : SmartDashboard.getKeys()) {
			SmartDashboard.delete(s);
		}
	}
}
