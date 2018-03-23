package org.usfirst.frc.team1164.robot.commands.auto;

import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.RobotMap.auto_armHeight_tolerance;

import org.usfirst.frc.team1164.logic.NeoUtil;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class setArmHeight extends Command {
	
	private double angleToGoTo;
	private boolean isDone;
	
    public setArmHeight(float height_cm) {
    	requires(kArm);
    	this.angleToGoTo = NeoUtil.getAngle(height_cm);
    }

    protected void initialize() {
    	isDone = false;
    }

    protected void execute() {
    	double distanceToGo = kArm.getArmEncoder() - angleToGoTo;

		SmartDashboard.putNumber("distance to go", distanceToGo);
    	if (distanceToGo < -auto_armHeight_tolerance) {
    		SmartDashboard.putNumber("Move direction", 0.1);
    		kArm.setArmVictor(0.1);
    	} else if (distanceToGo > auto_armHeight_tolerance) {
    		SmartDashboard.putNumber("Move direction", -0.1);
    		kArm.setArmVictor(-0.1);
    	} else {
    		SmartDashboard.putNumber("Move direction", 0);
    		isDone = true;
    	}
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {}

    protected void interrupted() {}
}
