package org.usfirst.frc.team1164.robot.commands.auto.normalized;

import org.usfirst.frc.team1164.robot.commands.auto.base.AutoDrive;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoSetArmHeight;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoTurn;
import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ScoreScaleLeftPos2 extends CommandGroup {

    public ScoreScaleLeftPos2() {
    	
    	// move forward
    	addSequential(new AutoDrive(0));
    	// turn left
    	addSequential(new AutoTurn(0));
    	// move forward
    	addSequential(new AutoDrive(0));
    	// turn right
    	addSequential(new AutoTurn(0));
    	// move forward
    	addParallel(new AutoSetArmHeight(2300, false));
    	addSequential(new AutoDrive(0));
    	// turn right
    	addSequential(new AutoTurn(0));
    	addSequential(new AutoDrive(0));
    	// open claw
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
