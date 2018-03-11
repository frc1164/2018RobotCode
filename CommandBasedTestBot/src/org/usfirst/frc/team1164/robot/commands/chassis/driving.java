package org.usfirst.frc.team1164.robot.commands.chassis;

import static org.usfirst.frc.team1164.logic.Controls.LS_X;
import static org.usfirst.frc.team1164.logic.Controls.LT;
import static org.usfirst.frc.team1164.logic.Controls.RS_X;
import static org.usfirst.frc.team1164.logic.Controls.RT;
import static org.usfirst.frc.team1164.robot.Robot.kChassis;
import static org.usfirst.frc.team1164.robot.Robot.m_oi;
import static org.usfirst.frc.team1164.robot.RobotMap.Drive_turnModifier;

import edu.wpi.first.wpilibj.command.Command;

public class driving extends Command {

    public driving() {
    	requires(kChassis);
    }

    protected void initialize() {}

    protected void execute() {
    	
    	double forward = m_oi.getControllerAxis(LT.toInt());
    	double backward = m_oi.getControllerAxis(RT.toInt());
    	double rotate = m_oi.getControllerAxis(RS_X.toInt());
    	double turn = m_oi.getControllerAxis(LS_X.toInt());
    	
    	double LSpeed = 0;
    	double RSpeed = 0;
    	
    	if (forward > 0.1|| backward > 0.1) {
        	double speed = forward - backward;
        	LSpeed = speed - (turn < 0 ? (Drive_turnModifier*speed*turn) : 0);
        	RSpeed = speed - (turn > 0 ? (Drive_turnModifier*speed*turn) : 0);
    	} else {
    		LSpeed = rotate;
    		RSpeed = -rotate;
    	}
    	kChassis.setLeftSpeed(LSpeed);
    	kChassis.setRightSpeed(RSpeed);
    	
//		SmartDashboard.putNumber("Left Encoder", Robot.kChassis.GetLeftEncoder());
//		SmartDashboard.putNumber("Right Encoder", Robot.kChassis.GetRightEncoder());
//		SmartDashboard.putBoolean("High Gear", Robot.kChassis.IsHighGear);
		//TODO: fix smartdashboard
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
