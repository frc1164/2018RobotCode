package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.Robot.m_oi;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_bot;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_bot_folded;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_limit_top;

import org.usfirst.frc.team1164.logic.XboxControls;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** this class is used so to drive the arm with
 * a joystick currently it has built in safetys 
 * including both the encoder and the limit switches
 */

public class DriveArm extends Command {
	
    public DriveArm() {
       requires(kArm);
    }

    protected void initialize() {}
    
    protected void execute() {
    	/* sudo-code for below: 
    	 * arm speed = 0
    	 * if right trigger is pressed
    	 * 		if arm position is less that the arms top limit
    	 * 			arm speed = +
    	 * else if left trigger is pressed
    	 * 		limit = lowest arm can go based on wether arm is folded
    	 * 		if arm position is higher that lowest limit
    	 * 			arm speed = -
    	 * 
    	 * speed is set to 0.1 if the arm is moving towards and close
    	 * to a limit switch
    	 */
    	
    	
    	SmartDashboard.putNumber("arm speed", kArm.getArmSpeed());
    	
    	double speed = 0;
    	if (m_oi.getOperatorAxis(XboxControls.LS_Y.toInt()) < -0.2) {
    		if (Arm_limit_top > kArm.getArmEncoder() && !kArm.getTopSwitch()) {
    			if (kArm.getArmEncoder() > 1700) {
    				speed = 0.1;
    			} else {
    				speed = kArm.getArmSpeed();
    			}
    	    	SmartDashboard.putNumber("arm speed", kArm.getArmSpeed());
    		}
    	} else if (m_oi.getOperatorAxis(XboxControls.LS_Y.toInt()) > 0.2) { 
    		double limit = (kArm.getArmFolded() ? Arm_limit_bot_folded : 
    											  Arm_limit_bot);
    		if (limit < kArm.getArmEncoder() && !kArm.getBotSwitch()) {
    			if (kArm.getArmEncoder() < 300) {
    				speed = -0.1;
    			} else {
    				speed = -kArm.getArmSpeed();
    			}
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
