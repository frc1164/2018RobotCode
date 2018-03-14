package org.usfirst.frc.team1164.robot.commands.auto;

import static org.usfirst.frc.team1164.robot.Robot.kArm;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class setArmHeight extends Command {

	private double height;
	private boolean isDone;
	
    public setArmHeight(double height) {
    	requires(kArm);
    	this.height = height;
    }

    protected void initialize() {
    	isDone = false;
    }

    protected void execute() {
    	double distanceToGo = kArm.getArmPot() - height;
    	
    	if (distanceToGo < -0.05) {
    		kArm.setArmVictor(0.1);
    	} else if (distanceToGo > 0.05) {
    		kArm.setArmVictor(-0.1);
    	} else {
    		isDone = true;
    	}
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {}

    protected void interrupted() {}
}
