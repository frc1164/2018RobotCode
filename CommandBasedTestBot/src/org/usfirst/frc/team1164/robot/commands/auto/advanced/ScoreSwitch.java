package org.usfirst.frc.team1164.robot.commands.auto.advanced;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoDrive;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoTurn;
import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class ScoreSwitch extends CommandGroup {

	public static final boolean RIGHT = true;
	public static final boolean LEFT = false;
	
    public ScoreSwitch(boolean side) {
    	if (side == RIGHT) {
    		addSequential(new AutoDrive(12));
    		addSequential(new AutoTurn(45.0));
    		addSequential(new OpenClaw());
    	}
    	else {
    		addSequential(new AutoDrive(12));
    		addSequential(new AutoTurn(-45.0));
    		addSequential(new OpenClaw());
    	}
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
