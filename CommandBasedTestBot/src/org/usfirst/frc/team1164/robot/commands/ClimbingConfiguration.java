package org.usfirst.frc.team1164.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team1164.robot.subsystems.Chassis;
import org.usfirst.frc.team1164.robot.Robot;

import java.util.concurrent.TimeUnit;
import java.lang.System;

/**
 *
 */
public class ClimbingConfiguration extends Command {

    public ClimbingConfiguration() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//sets high gear to move stem of the solenoid away from neutralizer, as to prevent grinding
		Robot.kChassis.SetHighGear();
		
		//Engages neutralizer and PTO
    		Robot.kChassis.EngageNeutralizer();
    		try {
    		TimeUnit.SECONDS.sleep(1);
    		}
    		catch (InterruptedException ex){
    			System.out.println(ex);
    		}
    		Robot.kChassis.SetLowGear();
    		Robot.kChassis.EngagePTO();
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
