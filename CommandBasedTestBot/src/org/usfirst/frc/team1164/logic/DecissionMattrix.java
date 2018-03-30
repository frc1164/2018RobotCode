package org.usfirst.frc.team1164.logic;

import org.usfirst.frc.team1164.robot.commands.auto.advanced.MidSwitch;
import org.usfirst.frc.team1164.robot.commands.auto.advanced.ScoreScale;
import org.usfirst.frc.team1164.robot.commands.auto.advanced.ScoreSwitch;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoDrive;
import org.usfirst.frc.team1164.robot.commands.auto.base.BaseDriveForward;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoTurn;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/** this class takes in all the information from the game
 * and chooses a command to run in the "Autonomous" game
 * stage
 */
public class DecissionMattrix {
	
	private SendableChooser<Integer> positionChooser = new SendableChooser<>();
	private SendableChooser<Integer> preferenceChooser = new SendableChooser<>();
	
	public DecissionMattrix() {
		positionChooser.addDefault("Position 1", 1);
		positionChooser.addObject("Position 2", 2);
		positionChooser.addObject("Position 3", 3);
		positionChooser.addObject("Degraded Mode", 4);
		positionChooser.addObject("TestForward", 5);
		positionChooser.addObject("TestTurn", 6);

		preferenceChooser.addObject("Scale", 1);
		preferenceChooser.addObject("switch", 2);
		preferenceChooser.addObject("forward", 3);
	}
	
	public void SmartDashboard() {
		SmartDashboard.putData("Starting position", positionChooser);
		SmartDashboard.putData("preference", preferenceChooser);
	}
	
	public Command decide() {
		int mode = positionChooser.getSelected();
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		Command returnCommand = null;
		
		if (mode == 1) {
			if(gameData.charAt(0) == 'L') {
				SmartDashboard.putString("AutoCommand", "Score Switch Right");
				returnCommand = new ScoreSwitch(45);
			} 	
			else if (gameData.charAt(1) == 'L') {
				SmartDashboard.putString("AutoCommand", "Score Scale Right");
				returnCommand = new ScoreScale(45);
			} 
			else {
				SmartDashboard.putString("AutoCommand", "AutoRun");
				returnCommand = new AutoDrive(20);
			}
		}
		else if (mode == 2) {
			if(gameData.charAt(0) == 'R') {
				SmartDashboard.putString("AutoCommand", "MidSwitch");
				returnCommand = new MidSwitch();
			}
			else {
				SmartDashboard.putString("AutoCommand", "AutoRun");
				returnCommand = new AutoDrive(20);
			}
		}
		else if (mode == 3) {
			if(gameData.charAt(0) == 'R') {
				SmartDashboard.putString("AutoCommand", "Score Switch Left");
				returnCommand = new ScoreSwitch(-45);
			} 
			else if (gameData.charAt(1) == 'R') {
				SmartDashboard.putString("AutoCommand", "Score Scale Left");
				returnCommand = new ScoreScale (-45);
			} 
			else {
				SmartDashboard.putString("AutoCommand", "AutoRun");
				returnCommand = new AutoDrive(20);
			}
		}
		else if (mode == 4){
			returnCommand = new BaseDriveForward(244, .25);
		}
		else if (mode == 5) {
			returnCommand = new AutoDrive(20);
		}
		else {
			returnCommand = new AutoTurn(90);
		}
		return returnCommand;
	}
}
