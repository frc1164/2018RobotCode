package org.usfirst.frc.team1164.robot.commands.calibration;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * moves the arm down till it hits the limit switch
 * then simply resets the encoder to give us a good
 * idea of the arm height
 */
public class CallibrateArmEncoder extends Command {

	private boolean isDone;
	
	
    public CallibrateArmEncoder() {
    	requires(Robot.kArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	isDone = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
		if (Robot.kArm.getBotSwitch()) {
			isDone = true;
			Robot.kArm.resetArmEncoder();
		} else {
			Robot.kArm.setArmVictor(-0.18);
		}
//    	if (!Robot.kArm.getBotSwitch()) {
//        	SmartDashboard.putString("find bottom", "started movement");
//        	Robot.kArm.setArmSpeed(-0.1);
//    	} else {
//        	SmartDashboard.putString("find bottom", "finished movement");
//    		Robot.kArm.resetArmEncoder();
//    		isDone = true;
//    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	SmartDashboard.putString("find bottom", "Finished");
        return isDone;
    }

    public boolean finished() {
    	return isDone;
    }
    
    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
