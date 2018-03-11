package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.logic.Controls.LT;
import static org.usfirst.frc.team1164.logic.Controls.RT;
import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.Robot.m_oi;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_bot;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_bot_folded;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_top;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class MoveArm extends Command {
	
    public MoveArm() {
       requires(kArm);
    }

    protected void initialize() {}
    
    protected void execute() {

    	//TODO: create a proper smartdashboard thing
//		SmartDashboard.putNumber("arm pot", Robot.kArm.getArmEncoder());
//    	SmartDashboard.putNumber("lTrigger", OI.getOperatorAxis(2));
//    	SmartDashboard.putNumber("RTrigger", OI.getOperatorAxis(3));
    	
    	/* sudo-code for below: 
    	 * if right trigger is pressed
    	 * 		if arm position is less that the arms top limit
    	 * 			move arm up
    	 * else if left trigger is pressed
    	 * 		limit = lowest arm can go based on wether arm is folded
    	 * 		if arm position is higher that lowest limit
    	 * 			move arm down
    	 * else
    	 * 		stop arm
    	 */
    	
    	SmartDashboard.putNumber("arm speed", kArm.getArmSpeed());
    	
    	
    	if (m_oi.getOperatorAxis(RT.toInt()) > 0.2) {
    		if (Arm_limit_top > kArm.getArmPot()) {
    			kArm.setArmVictor(kArm.getArmSpeed());
    	    	SmartDashboard.putNumber("arm speed", kArm.getArmSpeed());
    		}
    	} else if (m_oi.getOperatorAxis(LT.toInt()) > 0.2) { 
    		double limit = (kArm.getArmFolded() ? Arm_limit_bot_folded : 
    											  Arm_limit_bot);
    		if (limit < kArm.getArmPot()) {
    			kArm.setArmVictor(-kArm.getArmSpeed());
    	    	SmartDashboard.putNumber("arm speed", -kArm.getArmSpeed());
    		}
    	} else {
    		kArm.setArmVictor(0);
        	SmartDashboard.putNumber("arm speed", 0);
    	}
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
