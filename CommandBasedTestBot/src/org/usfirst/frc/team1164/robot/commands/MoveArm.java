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
	
	int direction;
    public MoveArm(int mydirection) {
        // Use requires() here to declare subsystem dependencies
       requires(Robot.kArm);
       direction = mydirection;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	SmartDashboard.putString("In init move arm initialized", " ");
    	System.out.println("init move arm command");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		SmartDashboard.putNumber("arm pot", Robot.kArm.getArmEncoder());
    	SmartDashboard.putNumber("LTrigger", OI.getOperatorAxis(2));
    	SmartDashboard.putNumber("RTrigger", OI.getOperatorAxis(3));
    	
    	if (direction == 1) {
    		Robot.kArm.moveArmUp(OI.armSpeed);
    		System.out.println("Move Arm up");
    	}
    	else if (direction == -1) {
    		Robot.kArm.moveArmDown(-OI.armSpeed);
    		System.out.println("Move Arm down");

    	}
    	else{
    		Robot.kArm.armBreak();
    		System.out.println("Brake arm");

    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.kArm.GetForwardLimitSwitch() || !Robot.kArm.GetReverseLimitSwitch()) ;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.kArm.armBreak();
    	System.out.println("MoveArm exited");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
