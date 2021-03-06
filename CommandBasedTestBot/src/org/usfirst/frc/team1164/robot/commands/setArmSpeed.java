package org.usfirst.frc.team1164.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1164.robot.OI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class setArmSpeed extends Command {

	private double speed;
	
    public setArmSpeed(double speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.speed = speed; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	OI.armSpeed += speed;
    	if (OI.armSpeed >= 1 || OI.armSpeed <= 0) {
    		OI.armSpeed = 0;
    	}
    	SmartDashboard.putNumber("armSpeed", OI.armSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
