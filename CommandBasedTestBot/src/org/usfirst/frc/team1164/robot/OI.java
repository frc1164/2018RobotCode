/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import static org.usfirst.frc.team1164.logic.XboxControls.A;
import static org.usfirst.frc.team1164.logic.XboxControls.B;
import static org.usfirst.frc.team1164.logic.XboxControls.X;
import static org.usfirst.frc.team1164.logic.XboxControls.Y;
import static org.usfirst.frc.team1164.logic.XboxControls.BACK;
import static org.usfirst.frc.team1164.logic.XboxControls.LB;
import static org.usfirst.frc.team1164.logic.XboxControls.RB;
import static org.usfirst.frc.team1164.logic.XboxControls.START;

import org.usfirst.frc.team1164.robot.commands.arm.FoldWrist;
import org.usfirst.frc.team1164.robot.commands.arm.UnfoldWrist;
import org.usfirst.frc.team1164.robot.commands.auto.base.AutoSetArmHeight;
import org.usfirst.frc.team1164.robot.commands.arm.AdjustArmMovementSpeed;
import org.usfirst.frc.team1164.robot.commands.calibration.ArmCallibrateTest;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengageHighGear;
import org.usfirst.frc.team1164.robot.commands.chassis.EngageHighGear;
import org.usfirst.frc.team1164.robot.commands.initialization.InitClimb;
import org.usfirst.frc.team1164.robot.commands.initialization.InitDrive;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private XboxController driverStick, operatorStick;

	private Button highGear, lowGear;
	private Button initDriving, initClimbing;
	private Button foldArm, unfoldArm;
	private Button increaseArmSpeed, decreaseArmSpeed;
	private Button lowScale, highScale, _switch, ground;
	
	public OI() {
		initializeControllers();
		initializeOperatorControls();
		initializeDriverControls();
		initializeButtons();
	}

	private void initializeControllers() {
		driverStick = new XboxController(0);
		operatorStick = new XboxController(1);
	}
	
	private void initializeOperatorControls() {		
		initClimbing = new JoystickButton(operatorStick, BACK.toInt());
		initDriving = new JoystickButton (operatorStick, START.toInt());
		
		foldArm = new JoystickButton(operatorStick, LB.toInt());
		unfoldArm = new JoystickButton(operatorStick, RB.toInt());
		
//		increaseArmSpeed = new JoystickButton(operatorStick, A.toInt()); 
//		decreaseArmSpeed = new JoystickButton(operatorStick, B.toInt());
		
		lowScale = new JoystickButton(operatorStick, Y.toInt());
		highScale = new JoystickButton(operatorStick, X.toInt());
		_switch = new JoystickButton(operatorStick, B.toInt());
		ground = new JoystickButton(operatorStick, A.toInt());
	}
	
	private void initializeDriverControls() {
		highGear = new JoystickButton(driverStick, RB.toInt());
		lowGear = new JoystickButton(driverStick, LB.toInt());
	}
	
	private void initializeButtons() {
		initClimbing.whenPressed(new InitClimb());
		initDriving.whenPressed(new InitDrive());
		
		foldArm.whenPressed(new FoldWrist());
		unfoldArm.whenPressed(new UnfoldWrist());
		
//		increaseArmSpeed.whenPressed(new AdjustArmMovementSpeed(0.01));
//		decreaseArmSpeed.whenPressed(new AdjustArmMovementSpeed(-0.01));
		
		highGear.whenPressed(new EngageHighGear());
		lowGear.whenPressed(new DisengageHighGear());
		
		lowScale.whenPressed(new AutoSetArmHeight(122, true));
		highScale.whenPressed(new AutoSetArmHeight(183, true));
		_switch.whenPressed(new AutoSetArmHeight(61, true));
		ground.whenPressed(new AutoSetArmHeight(24, true));
	}
	
	
	public double getControllerAxis(int AxisChannel) {
		return driverStick.getRawAxis(AxisChannel);
	}

	public double getOperatorAxis(int AxisChannel) {
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
