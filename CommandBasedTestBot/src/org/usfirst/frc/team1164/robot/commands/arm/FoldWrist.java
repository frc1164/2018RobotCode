package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.RobotMap.*;

import edu.wpi.first.wpilibj.command.Command;

public class FoldWrist extends Command {

	/* folds the wrist as long as the arm height is
	 * high enough up (that way the claw doesn't
	 * hit the lower arm)
	 */
	
    public FoldWrist() {
    	requires(kArm);
    }

    protected void initialize() {}

    protected void execute() {
    	if (kArm.getArmEncoder() > Arm_limit_bot_folded) {
    		kArm.setArmFolded(true);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
