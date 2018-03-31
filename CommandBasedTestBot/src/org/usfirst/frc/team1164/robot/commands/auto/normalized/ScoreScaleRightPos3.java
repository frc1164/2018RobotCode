package org.usfirst.frc.team1164.robot.commands.auto.normalized;

import org.usfirst.frc.team1164.robot.commands.auto.base.AutoDrive;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoSetArmHeight;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoTurn;
import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreScaleRightPos3 extends CommandGroup {

    public ScoreScaleRightPos3() {
    	// move forward
    	addParallel(new AutoSetArmHeight(2300, false));
    	addSequential(new AutoDrive(28));
    	// turn left
    	addSequential(new AutoTurn(-90));
    	// open claw
    	addSequential(new AutoDrive(1));
    	addSequential(new OpenClaw());
    	
    	
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
