package org.usfirst.frc.team1164.robot.commands.initialization;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class InitClimb extends Command {

    public InitClimb() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kChassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.kChassis.setGear(true);
    	Robot.kChassis.setNeutralizer(true);
    	try {
    		TimeUnit.SECONDS.sleep(1);
    	} catch (InterruptedException ex) {
    		System.out.println(ex);
    	}
    	Robot.kChassis.setGear(false);
    	Robot.kChassis.setPTO(true);
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
