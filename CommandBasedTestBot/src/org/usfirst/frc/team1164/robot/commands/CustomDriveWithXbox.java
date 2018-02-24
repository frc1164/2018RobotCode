package org.usfirst.frc.team1164.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1164.robot.*;
/**
 *
 */
public class CustomDriveWithXbox extends Command {
	
	private double LStickValue;
	private double RStickValue;
	private double LTriggerValue;
	private double RTriggerValue;
	
	private double LeftMotorValue;
	private double RightMotorValue;


    public CustomDriveWithXbox() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kChassis);
    	
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	this.LStickValue = OI.getControllerAxis(RobotMap.LAxis);
    	this.RStickValue = OI.getControllerAxis(RobotMap.RAxis);
    	this.LTriggerValue = OI.getControllerAxis(RobotMap.LTriggerAxis);
    	this.RTriggerValue = OI.getControllerAxis(RobotMap.RTriggerAxis);

		//Drive forward and backward
    	RightMotorValue = this.RTriggerValue - this.LTriggerValue;
    	LeftMotorValue = this.RTriggerValue - this.LTriggerValue;

		//Turning slowly (Assuming LAxis is the slow turning axis)
    	RightMotorValue = (1 - this.RStickValue) * RightMotorValue;
    	LeftMotorValue = (1 + this.RStickValue) * RightMotorValue;

		//Turning quickly (Assuming RAxis is the fast turning axis)
		RightMotorValue = RightMotorValue - (0.5 * this.LStickValue);
		LeftMotorValue = LeftMotorValue + (0.5 * this.LStickValue);
		
		Robot.kChassis.setRightMotorSpeed(RightMotorValue);
		Robot.kChassis.setLeftMotorSpeed(LeftMotorValue);
    	
		SmartDashboard.putNumber("Left Encoder", Robot.kChassis.GetLeftEncoder());
		SmartDashboard.putNumber("Right Encoder", Robot.kChassis.GetRightEncoder());

    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
