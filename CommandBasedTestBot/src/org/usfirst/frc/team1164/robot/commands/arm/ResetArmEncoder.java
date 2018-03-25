package org.usfirst.frc.team1164.robot.commands.arm;

import org.usfirst.frc.team1164.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ResetArmEncoder extends Command {

    public ResetArmEncoder() {}

    protected void initialize() {}

    protected void execute() {
    	Robot.kArm.resetArmEncoder();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
