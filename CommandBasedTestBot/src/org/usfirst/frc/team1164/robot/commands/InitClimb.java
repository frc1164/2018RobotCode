package org.usfirst.frc.team1164.robot.commands;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengageHighGear;
import org.usfirst.frc.team1164.robot.commands.chassis.EngageHighGear;
import org.usfirst.frc.team1164.robot.commands.chassis.EngageNeutralizer;
import org.usfirst.frc.team1164.robot.commands.chassis.EngagePTO;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InitClimb extends CommandGroup {
    public InitClimb() {
    	requires(kChassis);
    	
    	addSequential(new EngageHighGear());
    	addSequential(new EngageNeutralizer());
    	addSequential(new waitCommand());
    	addParallel(new DisengageHighGear());
    	addSequential(new EngagePTO());
    }
}
