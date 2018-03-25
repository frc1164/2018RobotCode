package org.usfirst.frc.team1164.robot.commands.claw;

import static org.usfirst.frc.team1164.logic.XboxControls.LT;
import static org.usfirst.frc.team1164.logic.XboxControls.RT;
import static org.usfirst.frc.team1164.robot.Robot.m_oi;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * this opens/closes the claw with the operators triggers
 */

public class DriveClaw extends Command {
	
    public DriveClaw() {
    	requires(Robot.kClaw);
    }

    protected void initialize() {}

    protected void execute() {
//    	kClaw.setOpened(!kClaw.isOpen());
    	Command c = null;
    	
    	if (m_oi.getOperatorAxis(RT.toInt()) > 0.5) {
    		c = new OpenClaw();
    	} else if (m_oi.getOperatorAxis(LT.toInt()) > 0.5) {
    		c = new CloseClaw();
    	}
    	
    	if (c != null) {
    		c.start();
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
