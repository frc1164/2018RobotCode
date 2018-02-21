package org.usfirst.frc.team1164.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team1164.robot.*;
/**
 *
 */
public class CustomDriveWithXbox extends Command {


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
    	double LStickValue;
    	double RStickValue;
    	double LTriggerValue;
    	double RTriggerValue;
    	
    	double LeftMotorValue;
    	double RightMotorValue;
    	
    	LStickValue = OI.getControllerAxis(RobotMap.LAxis);
    	RStickValue = OI.getControllerAxis(RobotMap.RAxis);
    	LTriggerValue = OI.getControllerAxis(RobotMap.LTriggerAxis);
    	RTriggerValue = OI.getControllerAxis(RobotMap.RTriggerAxis);

		//Drive forward and backward
    	RightMotorValue = RTriggerValue - LTriggerValue;
    	LeftMotorValue = RTriggerValue - LTriggerValue;

		//Turning slowly (Assuming LAxis is the slow turning axis)
    	RightMotorValue = (1 - RStickValue) * RightMotorValue;
    	LeftMotorValue = (1 + RStickValue) * RightMotorValue;

		//Turning quickly (Assuming RAxis is the fast turning axis)
		RightMotorValue = RightMotorValue - (0.5 * LStickValue);
		LeftMotorValue = LeftMotorValue + (0.5 * LStickValue);
		
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
