package org.usfirst.frc.team1164.robot.commands.calibration;

import org.usfirst.frc.team1164.robot.Robot;
import org.usfirst.frc.team1164.robot.commands.arm.FoldWrist;
import org.usfirst.frc.team1164.robot.commands.arm.UnfoldWrist;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoSetArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * calibrates the arm for test mode
 */

public class ArmCallibrateTest extends CommandGroup {

    public ArmCallibrateTest() {
    	requires(Robot.kArm);
    	addSequential(new UnfoldWrist());
    	addSequential(new CallibrateArmEncoder());
    	addSequential(new AutoSetArmHeight(1000, false));
    	addSequential(new FoldWrist());
    }
}
