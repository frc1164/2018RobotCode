package org.usfirst.frc.team1164.robot.commands.claw;

import org.usfirst.frc.team1164.logic.Controls;
import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleClaw extends Command {
	
    public ToggleClaw() {
//    	requires(kClaw);
    }

    protected void initialize() {}

    protected void execute() {
//    	kClaw.setOpened(!kClaw.isOpen());
    	if (Robot.m_oi.getOperatorAxis(Controls.RT.toInt()) > 0.5) {
    		Robot.kClaw.setOpened(true);
    	} else if (Robot.m_oi.getOperatorAxis(Controls.RT.toInt()) > 0.5) {
    		Robot.kClaw.setOpened(false);
    	}
    	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
