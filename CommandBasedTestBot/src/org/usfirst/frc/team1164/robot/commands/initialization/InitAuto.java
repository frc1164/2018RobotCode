package org.usfirst.frc.team1164.robot.commands.initialization;

import static org.usfirst.frc.team1164.robot.Robot.kArm;
import static org.usfirst.frc.team1164.robot.Robot.kChassis;
import static org.usfirst.frc.team1164.robot.Robot.kClaw;

import org.usfirst.frc.team1164.robot.commands.arm.UnfoldWrist;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoSetArmHeight;
import org.usfirst.frc.team1164.robot.commands.calibration.CallibrateArmEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class InitAuto extends CommandGroup {

    public InitAuto() {
//    	requires(kArm);
//    	requires(kChassis);
//    	requires(kClaw);

    	addSequential(new UnfoldWrist());
    	addSequential(new InitDrive());
    	addSequential(new CallibrateArmEncoder());
    	addSequential(new AutoSetArmHeight(1000, false));
    }
}
