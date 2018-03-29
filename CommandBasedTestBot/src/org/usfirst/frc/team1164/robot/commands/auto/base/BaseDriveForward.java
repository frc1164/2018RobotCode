package org.usfirst.frc.team1164.robot.commands.auto.base;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BaseDriveForward extends Command {
	private double time;
	private double speed;
	
	public BaseDriveForward(double time, double speed) {
		this.time = time;
		this.speed = speed;
		requires(Robot.kChassis);
		setTimeout(time);
		
	}
	
	public void initialize() {
		Robot.kChassis.setGear(true);
		Robot.kChassis.resetEncoders();
	}
	
	public void execute() {
		Robot.kChassis.setLeftSpeed(speed);
		Robot.kChassis.setRightSpeed(speed);
		
	}

	@Override
	protected boolean isFinished() {
		return isTimedOut();
	}
	
	public void end() {
		
	}
	
	public void interrupted() {
		
	}

}