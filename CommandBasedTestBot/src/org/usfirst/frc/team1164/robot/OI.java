/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import org.usfirst.frc.team1164.robot.commands.ClimbingConfiguration;
import org.usfirst.frc.team1164.robot.commands.CloseClaw;
import org.usfirst.frc.team1164.robot.commands.FoldArm;
import org.usfirst.frc.team1164.robot.commands.OpenClaw;
import org.usfirst.frc.team1164.robot.commands.SetTransmissionHighGear;
import org.usfirst.frc.team1164.robot.commands.SetTransmissionLowGear;

import org.usfirst.frc.team1164.robot.commands.StartingConfiguration;
import org.usfirst.frc.team1164.robot.commands.UnfoldArm;
import org.usfirst.frc.team1164.robot.commands.setArmSpeed;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private static XboxController driverStick = new XboxController(RobotMap.driverPort);
	private static XboxController operatorStick = new XboxController(RobotMap.operatorPort);
	
	private Button buttonOpenClaw = new JoystickButton(operatorStick, 1); //a
	private Button buttonCloseClaw = new JoystickButton(operatorStick, 2); //b
	
	private Button buttonHighGear = new JoystickButton(driverStick, 6); // lbutton
	private Button buttonLowGear = new JoystickButton(driverStick, 5); //rbutton
	private Button buttonPTO_Init = new JoystickButton(operatorStick, 7); //back
	private Button buttonChassis_Init = new JoystickButton (operatorStick, 8); //start


	private Button foldArm = new JoystickButton(operatorStick, 3);
	private Button unfoldArm = new JoystickButton(operatorStick, 4);
	
	private Button increaseArmSpeed = new JoystickButton(operatorStick, 6); // lbutton
	private Button decreaseArmSpeed = new JoystickButton(operatorStick, 5); // rbutton
	
	public static double armSpeed = 0.15;
	
	public OI() {
		buttonOpenClaw.whenPressed(new OpenClaw());
		buttonCloseClaw.whenPressed(new CloseClaw());
		buttonHighGear.whenPressed(new SetTransmissionHighGear());
		buttonLowGear.whenPressed(new SetTransmissionLowGear());
    
		buttonPTO_Init.whenPressed(new ClimbingConfiguration());
		buttonChassis_Init.whenPressed(new StartingConfiguration());
		increaseArmSpeed.whenPressed(new setArmSpeed(0.01));
		decreaseArmSpeed.whenPressed(new setArmSpeed(-0.01));
		foldArm.whenPressed(new FoldArm());
		unfoldArm.whenPressed(new UnfoldArm());
	}
	
	public static double getControllerAxis(int AxisChannel) {
		return driverStick.getRawAxis(AxisChannel);
	}
	public static boolean getControllerButton(int ButtonChannel) {
		return driverStick.getRawButton(ButtonChannel);
	}

	public static double getOperatorAxis(int AxisChannel) {
		return operatorStick.getRawAxis(AxisChannel);
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
