package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{
	@SuppressWarnings("unused")
	private boolean isOpen;
	//private Solenoid sol0, sol1;
	
	

	public Claw() {
		//sol0 = new Solenoid(RobotMap.CL_canID, RobotMap.CL_sol0ID);
		//sol1 = new Solenoid(RobotMap.CL_canID, RobotMap.CL_sol1ID);
		
		//sol0.set(false);
		//sol1.set(true);
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void Close() {
		isOpen = false;
		//sol0.set(false);
		//sol1.set(true);
	}
	
	public void Open() {
		isOpen = true;
		//sol0.set(true);
		//sol1.set(false);
	}

	public boolean getOpenState() {
		return isOpen;
	}

}
