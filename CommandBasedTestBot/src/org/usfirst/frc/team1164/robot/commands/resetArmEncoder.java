package org.usfirst.frc.team1164.robot.commands;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class resetArmEncoder extends Command {

    public resetArmEncoder() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	SmartDashboard.putString("Arm encoder reset", "false");
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("Arm encoder reset", "0");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putString("Arm encoder reset", "1");
    	Robot.kArm.resetArmEncoder();
    	SmartDashboard.putString("Arm encoder reset", "2");
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
