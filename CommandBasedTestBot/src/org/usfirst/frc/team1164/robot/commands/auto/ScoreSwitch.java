package org.usfirst.frc.team1164.robot.commands.auto;
import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 *
 */
public class ScoreSwitch extends CommandGroup {

	public static final boolean RIGHT = true;
	public static final boolean LEFT = false;
	
    public ScoreSwitch(boolean side) {
		addSequential(new DriveForward(12));
		SmartDashboard.putString("Completed Drive Forward", "Sucess!");
    	if (side == RIGHT) {
    		addSequential(new AutoTurn(45.0));
    	}
    	else {
    		addSequential(new AutoTurn(-45.0));
    	}
		SmartDashboard.putString("Completed AutoTurn", "Sucess!");
		addSequential(new OpenClaw());
		SmartDashboard.putString("Completed OpenClaw", "Sucess!");

    }
}
