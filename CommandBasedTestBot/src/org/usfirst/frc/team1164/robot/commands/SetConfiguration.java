package org.usfirst.frc.team1164.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1164.robot.*;
import org.usfirst.frc.team1164.robot.subsystems.Chassis;

/**
 *
 */
public class SetConfiguration extends Command {
	
	private Chassis.Config configuration;

    public SetConfiguration(Chassis.Config config) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kChassis);
    
    	this.configuration = config;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	//sets high gear to move stem of the solenoid away from neutralizer, as to prevent grinding
		Robot.kChassis.SetHighGear();
		
		//Engages or Disengages neutralizer and PTO
    	if (configuration == Chassis.Config.Starting) {
    		Robot.kChassis.DisengageNeutralizer();
    		Robot.kChassis.DisengagePTO();
    		Robot.kChassis.IsClimbingConfiguration = false;
    		
    		}
    	else {
    		Robot.kChassis.EngageNeutralizer();
    		Robot.kChassis.EngagePTO();
    		Robot.kChassis.IsClimbingConfiguration = true;
    	}
    	
    	//sets low gear to finish configuring in neutral
		Robot.kChassis.SetLowGear();
    	
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
