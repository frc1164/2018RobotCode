package org.usfirst.frc.team1164.robot.commands.calibration;

import org.usfirst.frc.team1164.robot.Robot;
import org.usfirst.frc.team1164.robot.commands.arm.UnfoldArm;
import org.usfirst.frc.team1164.robot.commands.auto.setArmHeight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CalibrateTeleop extends CommandGroup {

    public CalibrateTeleop() {
    	requires(Robot.kArm);
    	addSequential(new UnfoldArm());
    	addSequential(new CallibrateArmEncoder());
    	addSequential(new setArmHeight(40, true));
    	
        // Add Commands here:
        // e.g. addSequential(new Command1());
    	
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
