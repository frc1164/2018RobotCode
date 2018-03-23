package org.usfirst.frc.team1164.robot.commands.auto;
import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;
/**
 *
 */
public class ScoreScale extends CommandGroup {
	public static final boolean RIGHT = true;
	public static final boolean LEFT = false;
	
    public ScoreScale(boolean side) {
    	addSequential(new DriveForward(25));
    	if (side == RIGHT) {
	    	addSequential(new AutoTurn(45.0, .25));
    	}
    	else
    	{
    		addSequential(new AutoTurn(-45.0, .25));
    	}
    	addSequential(new OpenClaw());
    }
}