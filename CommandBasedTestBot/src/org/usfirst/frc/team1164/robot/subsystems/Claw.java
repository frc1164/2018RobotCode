package org.usfirst.frc.team1164.robot.subsystems;

import static org.usfirst.frc.team1164.robot.RobotMap.*;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Claw extends Subsystem{
	
	private boolean isOpen;
	private DoubleSolenoid claw;
	

	public Claw() {

		isOpen = Cl_isOpen;
		claw = new DoubleSolenoid(Cl_forwardPort, CL_reversePort);
		claw.set(Cl_isOpen ? DoubleSolenoid.Value.kReverse :
 			  				 DoubleSolenoid.Value.kForward);
	}

	@Override
	protected void initDefaultCommand() {}
	
	public void setOpened(boolean opened) {
		claw.set(opened ? DoubleSolenoid.Value.kReverse :
			   			  DoubleSolenoid.Value.kForward);
		isOpen = opened;
	}

	public boolean isOpen() {
		return isOpen;
	}

}
