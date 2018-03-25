package org.usfirst.frc.team1164.robot.commands.arm;

import org.usfirst.frc.team1164.robot.Robot;
import static org.usfirst.frc.team1164.robot.RobotMap.*;

import edu.wpi.first.wpilibj.command.Command;

public class FoldWrist extends Command {

	/* folds the wrist as long as the arm height is
	 * high enough up (that way the claw doesn't
	 * hit the lower arm)
	 */
	
    public FoldWrist() {
    	requires(Robot.kArm);
    }

    protected void initialize() {}

    protected void execute() {
    	if (Robot.kArm.getArmEncoder() > Arm_limit_bot_folded) {
    		Robot.kArm.setArmFolded(true);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
