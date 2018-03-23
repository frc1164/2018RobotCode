package org.usfirst.frc.team1164.robot.commands.auto;

import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class MidSwitch extends CommandGroup {

    public MidSwitch() {
    	addSequential (new DriveForward(8));
    	addSequential (new OpenClaw());
    }
}
