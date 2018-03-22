package org.usfirst.frc.team1164.logic;

import org.usfirst.frc.team1164.robot.commands.auto.AutoTurn;
import org.usfirst.frc.team1164.robot.commands.auto.MidSwitch;
import org.usfirst.frc.team1164.robot.commands.auto.ScoreScale;
import org.usfirst.frc.team1164.robot.commands.auto.ScoreSwitch;
import org.usfirst.frc.team1164.robot.commands.auto.DriveForward;

import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class autoDecissionMattrix {
	public static Command decide(int mode, String gameData) {
		Command autoCommand = null;
		//mode is our starting position from left to right
		if (mode == 1) {
			if(gameData.charAt(0) == 'L') {
				SmartDashboard.putString("AutoCommand", "Score Switch Right");
				autoCommand = new ScoreSwitch(ScoreSwitch.LEFT);
			} 	
			else if (gameData.charAt(1) == 'L') {
				SmartDashboard.putString("AutoCommand", "Score Scale Right");
				autoCommand = new ScoreScale(ScoreScale.LEFT);
			} 
			else {
				SmartDashboard.putString("AutoCommand", "AutoRun");
				autoCommand = new DriveForward(8);
			}
		}
		else if (mode == 2) {
			if(gameData.charAt(0) == 'R') {
				SmartDashboard.putString("AutoCommand", "MidSwitch");
				autoCommand = new MidSwitch();
			}
			else {
				SmartDashboard.putString("AutoCommand", "AutoRun");
				autoCommand = new DriveForward(8);
			}
		}
		else if (mode == 3) {
			if(gameData.charAt(0) == 'R') {
				SmartDashboard.putString("AutoCommand", "Score Switch Left");
				autoCommand = new ScoreSwitch(ScoreSwitch.RIGHT);
			} 
			else if (gameData.charAt(1) == 'R') {
				SmartDashboard.putString("AutoCommand", "Score Scale Left");
				autoCommand = new ScoreScale (ScoreScale.RIGHT);
			} 
			else {
				SmartDashboard.putString("AutoCommand", "AutoRun");
				autoCommand = new DriveForward(8);
			}
		}
		else {
			autoCommand = new AutoTurn(Preferences.getInstance().getDouble("DegreesToTurn", 0.0));
		}
		return autoCommand;
	}
}
