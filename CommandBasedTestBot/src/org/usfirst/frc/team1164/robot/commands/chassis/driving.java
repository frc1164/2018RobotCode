package org.usfirst.frc.team1164.robot.commands.chassis;

import static org.usfirst.frc.team1164.logic.XboxControls.LS_X;
import static org.usfirst.frc.team1164.logic.XboxControls.LT;
import static org.usfirst.frc.team1164.logic.XboxControls.RS_X;
import static org.usfirst.frc.team1164.logic.XboxControls.RT;
import static org.usfirst.frc.team1164.robot.Robot.kChassis;
import static org.usfirst.frc.team1164.robot.Robot.m_oi;
import static org.usfirst.frc.team1164.robot.RobotMap.Drive_turnModifier;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * this command is used to drive the robot
 * the triggers are used for backwards and
 * forwards movement while the joysticks
 * are used for turning
 * 
 * RightTrigger = forward movement
 * LeftTrigger = backward movement
 * RightStick xAxis = rotate
 * LeftStick xAxis = turning (only works with
 * 		 forward and backward movement)
 */


public class driving extends Command {

    public driving() {
    	requires(kChassis);
    }

    protected void initialize() {}

    protected void execute() {
    	
    	double forward = m_oi.getControllerAxis(RT.toInt());
    	double backward = m_oi.getControllerAxis(LT.toInt());
    	double rotate = m_oi.getControllerAxis(RS_X.toInt());
    	double turn = m_oi.getControllerAxis(LS_X.toInt());
    	
    	// removes any uncertanity when joystick isnt being moved
    	if (Math.abs(turn) < 0.1) {
    		turn = 0;
    	}
    	
    	double LSpeed = 0;
    	double RSpeed = 0;
    	
    	
    	/* this is a few simple equations to find how fast the wheels
    	 * on each side of the robot should move. basically if the
    	 * robot should be moving forward it sets each sides speed
    	 * to the correct direction then takes off x amount from one
    	 * side of the robot if the robot should be turning
    	 * 
    	 * otherwise if no forward or backwards movement then the robot
    	 * should rotate in place
    	 * 
    	 */
    	
    	if (forward > 0.1 || backward > 0.1) {
        	double speed = forward - backward;
        	LSpeed = speed - (turn < 0 ? (Drive_turnModifier*speed*turn*-1) : 0);
        	RSpeed = speed - (turn > 0 ? (Drive_turnModifier*speed*turn) : 0);
    	} else if (rotate < -0.1 || rotate > 0.1) {
    		LSpeed = rotate;
    		RSpeed = -rotate;
    	}
//    	SmartDashboard.putNumber("Turn", turn);
//    	SmartDashboard.putNumber("LSpeed", LSpeed);
//    	SmartDashboard.putNumber("RSpeed", RSpeed);
    	kChassis.setLeftSpeed(LSpeed);
    	kChassis.setRightSpeed(RSpeed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
