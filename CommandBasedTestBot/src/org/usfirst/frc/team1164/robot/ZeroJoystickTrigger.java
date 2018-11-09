package org.usfirst.frc.team1164.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.XboxController;

public class ZeroJoystickTrigger extends Trigger{
	double triggerLimit;
	int joystickChannel;
	XboxController stick;
	
	public ZeroJoystickTrigger(XboxController myStick, int myChannel, double myLimit) {
		triggerLimit = myLimit;
		joystickChannel = myChannel;
		stick = myStick;
	}// of constructor
	
	public boolean get() {
		if(stick.getRawAxis(joystickChannel) <= triggerLimit && stick.getRawAxis(joystickChannel) >= -triggerLimit)
				return true;
		return false;
	}// of get

}// of ZeroJoystickTrigger

