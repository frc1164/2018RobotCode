package org.usfirst.frc.team1164.robot.commands;

import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.Robot;
import org.usfirst.frc.team1164.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetArmPosition extends Command {
	
	private double TargetPosition;
	private boolean isAboveTarget;

    public SetArmPosition(double Position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArm);
    	TargetPosition = Position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (Robot.kArm.getArmPot() < TargetPosition) {
    		isAboveTarget = false;
    	}
    	else {
    		isAboveTarget = true;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	if (isAboveTarget) {
    			Robot.kArm.moveArmDown(OI.armSpeed);
    	}
    	else {
    			Robot.kArm.moveArmUp(OI.armSpeed);
    	}
    }
    	

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	//Creates arm position tolerance of .05
    	if (Math.abs(TargetPosition - Robot.kArm.getArmPot()) <= .05) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
