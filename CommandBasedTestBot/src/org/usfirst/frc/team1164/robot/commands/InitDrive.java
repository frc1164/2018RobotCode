package org.usfirst.frc.team1164.robot.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team1164.robot.Robot;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengageHighGear;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengageNeutralizer;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengagePTO;
import org.usfirst.frc.team1164.robot.commands.chassis.EngageHighGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InitDrive extends CommandGroup {
    public InitDrive() {
    	requires(Robot.kChassis);
    	
    	addSequential(new EngageHighGear());
    	addSequential(new DisengagePTO());
        addSequential(new DisengageNeutralizer());
//		addSequential(new waitCommand());
//    	try {
//    		TimeUnit.SECONDS.sleep(1);
//    	}
//    	catch (InterruptedException ex){
//    		System.out.println(ex);
//    	}
//		addSequential(new DisengageHighGear());
    }
}
