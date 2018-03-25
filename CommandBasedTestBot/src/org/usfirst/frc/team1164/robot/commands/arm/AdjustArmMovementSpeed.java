package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.RobotMap.*;

import edu.wpi.first.wpilibj.command.Command;


/**
 * basically what the name says, this command will
 * set the speed at which the arm moves, this way
 * however is controlling can have some varation
 * to something they feel comfortable with
 * it can also be used for easier adjustments if
 * the controller does so desire
 */

public class AdjustArmMovementSpeed extends Command {
	
	private double speed;
	
    public AdjustArmMovementSpeed(double speedIncriment) {
    	this.speed = speedIncriment; 
    }

    protected void initialize() {}

    protected void execute() {
    	
    	/*
    	 * sudo code:
    	 * if the speed to change by is greater than 0
    	 * 		if the current speed is less than maxSpeed
    	 * 			raise speed by speed to change by
    	 * else if the speed to change by is less than 0
    	 * 		if the current speed is greater than minSpeed
    	 * 			lower speed by speed to change by
    	 */
    	
    	if (speed > 0) {
    		if (kArm.getArmSpeed() <= Arm_limit_top_speed) {
    			kArm.setArmSpeed(kArm.getArmSpeed() + speed);
    		}
    	} else if (speed < 0) {
    		if (kArm.getArmSpeed() >= Arm_limit_bot_speed) {
    			kArm.setArmSpeed(kArm.getArmSpeed() - speed);
    		}
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
