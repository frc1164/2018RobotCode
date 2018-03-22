package org.usfirst.frc.team1164.robot.commands;

import org.usfirst.frc.team1164.robot.commands.chassis.DisengageHighGear;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengageNeutralizer;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengagePTO;
import org.usfirst.frc.team1164.robot.commands.chassis.EngageHighGear;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class InitDrive extends CommandGroup {
    public InitDrive() {
        addParallel(new EngageHighGear());
        addParallel(new DisengagePTO());
        addSequential(new DisengageNeutralizer());
//        addSequential(new waitCommand());
        addSequential(new DisengageHighGear());
    }
}