package org.usfirst.frc.team1164.robot.commands.claw;

import static org.usfirst.frc.team1164.robot.Robot.kClaw;

import edu.wpi.first.wpilibj.command.Command;

public class OpenClaw extends Command {

    public OpenClaw() {
    	requires(kClaw);
    }

    protected void initialize() {}

    protected void execute() {
    	kClaw.setOpened(true);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
