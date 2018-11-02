package org.usfirst.frc.team1164.robot.commands;

import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ToggleClaw extends Command {
    public ToggleClaw() {
    	requires(Robot.kClaw);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(OI.getOperatorAxis(3) >= 0.5) {
    		Robot.kClaw.Open();
    	} else if (OI.getOperatorAxis(2) >= 0.5) {
    		Robot.kClaw.Close();
    	}
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