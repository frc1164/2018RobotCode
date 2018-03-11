package org.usfirst.frc.team1164.robot.commands.arm;

import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.RobotMap.*;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class changeArmSpeed extends Command {

	private double speed;
	
    public changeArmSpeed(double speedIncriment) {
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
