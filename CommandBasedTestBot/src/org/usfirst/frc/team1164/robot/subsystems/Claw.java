package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{
	
	public boolean isOpen;
	private DoubleSolenoid Claw;
	

	public Claw() {
		Claw = new DoubleSolenoid(RobotMap.CL_Forward_Channel, RobotMap.CL_Reverse_Channel);
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	
	public void Close() {
		isOpen = false;
		Claw.set(DoubleSolenoid.Value.kForward);
	}
	
	public void Open() {
		isOpen = true;
		Claw.set(DoubleSolenoid.Value.kReverse);
	}

	public boolean getOpenState() {
		return isOpen;
	}

}
