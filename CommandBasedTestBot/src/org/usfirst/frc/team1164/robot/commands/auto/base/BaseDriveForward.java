package org.usfirst.frc.team1164.robot.commands.auto.base;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class BaseDriveForward extends Command {
	private double distance;
	private double speed;
	
	public BaseDriveForward(double distance, double speed) {
		this.distance = distance;
		this.speed = speed;
		requires(Robot.kChassis);
		
	}
	
	public void initialize() {
		Robot.kChassis.resetEncoders();
	}
	
	public void execute() {
		Robot.kChassis.setLeftSpeed(speed);
		Robot.kChassis.setRightSpeed(speed);
		
		
		SmartDashboard.putNumber("Distance", distance);
		SmartDashboard.putNumber("speed", speed);
		SmartDashboard.putNumber("LeftEncoder", Robot.kChassis.getLeftEncoder());
		SmartDashboard.putNumber("RightEncoder", Robot.kChassis.getLeftEncoder());
	}

	@Override
	protected boolean isFinished() {
		double leftEncoder = Robot.kChassis.getLeftEncoder();
		double rightEncoder = Robot.kChassis.getRightEncoder();
		
		boolean checkLeft = leftEncoder >= distance || leftEncoder < 0;
		boolean checkRight = rightEncoder >= distance || leftEncoder < 0;
		
		return (checkLeft || checkRight);
	}
	
	public void end() {
		
	}
	
	public void interrupted() {
		
	}

}