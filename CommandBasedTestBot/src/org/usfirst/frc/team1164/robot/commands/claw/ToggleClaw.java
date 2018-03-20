package org.usfirst.frc.team1164.robot.commands.claw;

import static org.usfirst.frc.team1164.robot.Robot.kClaw;

import edu.wpi.first.wpilibj.command.Command;

public class ToggleClaw extends Command {
	
    public ToggleClaw() {
//    	requires(kClaw);
    }

    protected void initialize() {}

    protected void execute() {
    	kClaw.setOpened(!kClaw.isOpen());
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
