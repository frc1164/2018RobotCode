package org.usfirst.frc.team1164.logic;

import org.usfirst.frc.team1164.robot.commands.auto.advanced.MidSwitch;
import org.usfirst.frc.team1164.robot.commands.auto.advanced.ScoreScale;
import org.usfirst.frc.team1164.robot.commands.auto.advanced.ScoreSwitch;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoDrive;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoTurn;
import org.usfirst.frc.team1164.robot.commands.auto.base.BaseDriveForward;
import org.usfirst.frc.team1164.robot.commands.auto.normalized.*;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DecissionMatrixV2 {
	
	private SendableChooser<Integer> positionChooser = new SendableChooser<>();
	private SendableChooser<Integer> preferenceChooser = new SendableChooser<>();
	
	public DecissionMatrixV2() {
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
		int position = positionChooser.getSelected();
		int preference = preferenceChooser.getSelected();
		String gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		Command returnCommand = null;
		
		if (position == 1) {
			if (preference == 2) {
				if (gameData.charAt(0) == 'L') {
					// score switch left from pos 1
					returnCommand = new ScoreSwitchLeftPos1();
				} else {
					// score switch right from pos 1
					returnCommand = new ScoreSwitchRightPos1();
				}
			} else if (preference == 1) {
				if (gameData.charAt(1) == 'L') {
					// score scale left from pos 1
					returnCommand = new ScoreScaleLeftPos1();
				} else {
					returnCommand = new ScoreScaleRightPos1();
					// score scale right from pos 1
				}
			} else {
				returnCommand = new AutoDrive(10);
				// drive forward 10 feet
			}
		} else if (position == 2) {
			if (preference == 2) {
				if (gameData.charAt(0) == 'L') {
					// score switch left from pos 1
					returnCommand = new ScoreSwitchLeftPos2();
				} else {
					// score switch right from pos 1
					returnCommand = new ScoreSwitchRightPos2();
				}
			} else if (preference == 1) {
				if (gameData.charAt(1) == 'L') {
					// score scale left from pos 1
					returnCommand = new ScoreScaleLeftPos2();
				} else {
					returnCommand = new ScoreScaleRightPos2();
					// score scale right from pos 1
				}
			} else {
				returnCommand = new AutoDrive(10);
				// drive forward 10 feet
			}
		} else {
			if (preference == 2) {
				if (gameData.charAt(0) == 'L') {
					// score switch left from pos 1
					returnCommand = new ScoreSwitchLeftPos3();
				} else {
					// score switch right from pos 1
					returnCommand = new ScoreSwitchRightPos3();
				}
			} else if (preference == 1) {
				if (gameData.charAt(1) == 'L') {
					// score scale left from pos 1
					returnCommand = new ScoreScaleLeftPos3();
				} else {
					returnCommand = new ScoreScaleRightPos3();
					// score scale right from pos 1
				}
			} else {
				returnCommand = new AutoDrive(10);
				// drive forward 10 feet
			}
		}
		
		return returnCommand;
	}
}
