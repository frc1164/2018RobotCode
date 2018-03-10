package org.usfirst.frc.team1164.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.Robot;


/**
 *
 */
public class MoveArm extends Command {
	
	
    public MoveArm() {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.kArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("In init move arm initialized", " ");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double LStickValue;
    	LStickValue = OI.getControllerAxis(RobotMap.LAxis);
    	if (LStickValue > 0.05) {
    		Robot.kArm.moveArm(OI.armSpeed);
    	} else if (LStickValue < -0.05) {
    		Robot.kArm.moveArm(-OI.armSpeed);
    	}
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
