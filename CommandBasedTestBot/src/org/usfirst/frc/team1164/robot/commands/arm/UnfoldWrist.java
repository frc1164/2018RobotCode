package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.robot.Robot.kArm;

import edu.wpi.first.wpilibj.command.Command;

public class UnfoldWrist extends Command {

    public UnfoldWrist() {
    	requires(kArm);
    }

    protected void initialize() {}

    protected void execute() {
    	kArm.setArmFolded(false);;
    }

    protected boolean isFinished() {
        return true;
    }

    public boolean finished() {
    	return true;
    }
    
    protected void end() {}

    protected void interrupted() {}
}
