package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.logic.Controls.LT;
import static org.usfirst.frc.team1164.logic.Controls.RT;
import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.Robot.m_oi;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_bot;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_bot_folded;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_top;

import org.usfirst.frc.team1164.logic.Controls;

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
    	//SmartDashboard.putData("Command Name", new Command());
    	
    	/* sudo-code for below: 
    	 * arm speed = 0
    	 * if right trigger is pressed
    	 * 		if arm position is less that the arms top limit
    	 * 			arm speed = +
    	 * else if left trigger is pressed
    	 * 		limit = lowest arm can go based on wether arm is folded
    	 * 		if arm position is higher that lowest limit
    	 * 			arm speed = -
    	 */
    	
    	
    	SmartDashboard.putNumber("arm speed", kArm.getArmSpeed());
    	
    	double speed = 0;
    	if (m_oi.getOperatorAxis(Controls.LS.toInt()) > 0.2) {
    		if (Arm_limit_top > kArm.getArmEncoder()) {
    			speed = kArm.getArmSpeed();
    	    	SmartDashboard.putNumber("arm speed", kArm.getArmSpeed());
    		}
    	} else if (m_oi.getOperatorAxis(Controls.LS.toInt()) < -0.2) { 
    		double limit = (kArm.getArmFolded() ? Arm_limit_bot_folded : 
    											  Arm_limit_bot);
    		if (limit < kArm.getArmEncoder()) {
    			speed = -kArm.getArmSpeed();
    	    	SmartDashboard.putNumber("arm speed", -kArm.getArmSpeed());
    		}
    	} 
    	kArm.setArmVictor(speed);
    	
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
