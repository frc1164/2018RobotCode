package org.usfirst.frc.team1164.robot.commands;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.Robot;
/**
 *
 */
public class ArmDebug extends Command {
	private Instant start, end;
	
    public ArmDebug() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.kArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	start = Instant.now();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	try {
    	NeoUtil.record(Robot.kArm.getArmEncoder(), Robot.kArm.getArmPot(), "C:\\Users\\evela1164\\Desktop\\Output.xlsx");
    	}
    	catch (IOException e) {
    		e.getLocalizedMessage();
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	end = Instant.now();
    	Duration duration = Duration.between(start, end);
    	return duration.toMillis() >= 20000;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
