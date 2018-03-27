package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.robot.Robot.kArm;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class UnfoldWrist extends Command {

    public UnfoldWrist() {
    	requires(kArm);
    }

    protected void initialize() {
       	SmartDashboard.putString("unfold wrist", "Initialized");
    }

    protected void execute() {
    	kArm.setArmFolded(false);
       	SmartDashboard.putString("unfold wrist", "executed");
    }

    protected boolean isFinished() {
    	SmartDashboard.putString("unfold wrist", "Finished");
        return true;
    }
    
    protected void end() {}

    protected void interrupted() {}
}
