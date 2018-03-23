package org.usfirst.frc.team1164.robot.commands.auto;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;
import static org.usfirst.frc.team1164.robot.RobotMap.encoderToFt;

import org.usfirst.frc.team1164.logic.motionProfiler.PIDMotion;
import org.usfirst.frc.team1164.logic.motionProfiler.PIDVMotion;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForward extends Command {
	private double distance;
	private PIDMotion controller;
	private PIDMotion turnController;
	
	public DriveForward(double distance) {
		
		Preferences pref = Preferences.getInstance();
		
		SmartDashboard.putString("Enabled?", "1");
		this.distance = distance;
		requires(kChassis);

		SmartDashboard.putString("Enabled?", "2");
		controller = new PIDVMotion(pref.getDouble("StraightMaxA", 0.0), 
								   pref.getDouble("StraightMaxV", 0.0),
								   pref.getDouble("StraightP", 0.0),
								   pref.getDouble("StraightI", 0.0),
								   pref.getDouble("StraightD", 0.0),
								   pref.getDouble("StraightV", 0.0));										
												  
		turnController = new PIDVMotion(pref.getDouble("TurnMaxA", 0.0), 
					pref.getDouble("TurnMaxV", 0.0),
					pref.getDouble("TurnP", 0.0),
					pref.getDouble("TurnI", 0.0),
					pref.getDouble("TurnD", 0.0),
					pref.getDouble("TurnV", 0.0));	
		
		SmartDashboard.putString("Enabled?", "3");
		controller.setEndpoint(distance);
		turnController.setEndpoint(0.0);
		SmartDashboard.putString("Enabled?", "4");
	}
	
	public void initialize() {
		kChassis.resetEncoders();
		kChassis.resetNavx();
	}
	
	public void execute() {
		double srn = 0;
//		srn = 0.001 * (Math.random() - 0.5);
		
		
		double actualPos = kChassis.getAverageEncoder() * encoderToFt;
		
		double straight = controller.getOutput(actualPos);
//		actualPos = 0;
    	double turn = turnController.getOutput(kChassis.getNavxAngle());
//		double turn = 0;
		
		//double LSpeed = speed - (turn < 0 ? (Drive_turnModifier*speed*turn) : 0);
    	//double RSpeed = speed - (turn > 0 ? (Drive_turnModifier*speed*turn) : 0);
		
    	double left = turn + straight;
		double right = -turn + straight;
		if (left > 1) {
			right = right - (left - 1);
			left = 1.0;
		} else if (left < -1) {
			right = right + (left + 1);
			left = -1.0;
		} else if (right > 1) {
			left = left - (right -1);
			right = 1.0;
		} else if (right < -1) {
			left = left + (right + 1);
			right = -1.0;
		}
    	
		kChassis.setLeftSpeed(left);
		kChassis.setRightSpeed(right);
		
		
		SmartDashboard.putNumber("Distance", actualPos+srn);
		SmartDashboard.putNumber("OutputOfStraightController", straight);
		SmartDashboard.putNumber("OutputOfTurnController", turn);
		SmartDashboard.putNumber("AutoLeftSet", left);
		SmartDashboard.putNumber("AutoRightSet", right);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
	
	public void end() {
		
	}
	
	public void interrupted() {
		
	}

}