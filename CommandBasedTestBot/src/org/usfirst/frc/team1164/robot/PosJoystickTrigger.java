package org.usfirst.frc.team1164.robot;

import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;

public class PosJoystickTrigger extends Trigger {
	double triggerLimit;
	int joystickChannel;
	Joystick stick;
	XboxController controller;
	
	public PosJoystickTrigger(Joystick myJoystick, int myJoystickChannel, double myTriggerLimit){
		triggerLimit = myTriggerLimit;
		joystickChannel = myJoystickChannel;
		stick = myJoystick;
		
	}// of WPI Joystick constructor
	
	public PosJoystickTrigger(XboxController myController, int myJoystickChannel, double myTriggerLimit) {
		triggerLimit = myTriggerLimit;
		joystickChannel = myJoystickChannel;
		controller = myController;
		
	}// of Xbox Controller constructor
	
	public boolean get() {
		if(stick.getRawAxis(joystickChannel) >= triggerLimit) return true;
		
		return false;
	}// of method get
	
}// of class JoystickTrigger
