package org.usfirst.frc.team1164.robot.commands.calibration;

import org.usfirst.frc.team1164.robot.Robot;
import org.usfirst.frc.team1164.robot.commands.arm.UnfoldWrist;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * calibrates the arm for autonomous
 */
public class ArmCallibrateAuto extends CommandGroup {

    public ArmCallibrateAuto() {
    	requires(Robot.kArm);
    	addSequential(new UnfoldWrist());
    	addSequential(new CallibrateArmEncoder());
    }
}
