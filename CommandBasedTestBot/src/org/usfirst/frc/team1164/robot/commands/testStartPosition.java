package org.usfirst.frc.team1164.robot.commands;

import java.util.concurrent.TimeUnit;

import org.usfirst.frc.team1164.robot.commands.arm.FoldArm;
import org.usfirst.frc.team1164.robot.commands.auto.setArmHeight;
import org.usfirst.frc.team1164.robot.commands.claw.CloseClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class testStartPosition extends CommandGroup {

    public testStartPosition() {
    	addSequential(new setArmHeight(150));
    	addSequential(new FoldArm());
    	try {
    		TimeUnit.SECONDS.sleep(4);
    	}
    	catch (InterruptedException ex){
    		System.out.println(ex);
    	}
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
