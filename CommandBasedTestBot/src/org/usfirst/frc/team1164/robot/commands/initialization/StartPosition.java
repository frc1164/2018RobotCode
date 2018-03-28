package org.usfirst.frc.team1164.robot.commands.initialization;

import org.usfirst.frc.team1164.robot.commands.arm.FoldWrist;
import org.usfirst.frc.team1164.robot.commands.arm.UnfoldWrist;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoSetArmHeight;
import org.usfirst.frc.team1164.robot.commands.calibration.CallibrateArmEncoder;
import org.usfirst.frc.team1164.robot.commands.claw.CloseClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class StartPosition extends CommandGroup {

    public StartPosition() {
    	addSequential(new InitDrive());
    	addSequential(new UnfoldWrist());
    	addSequential(new CallibrateArmEncoder());
    	addSequential(new AutoSetArmHeight(1000, false));
    	addSequential(new FoldWrist());
    	addSequential(new CloseClaw());
    	
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