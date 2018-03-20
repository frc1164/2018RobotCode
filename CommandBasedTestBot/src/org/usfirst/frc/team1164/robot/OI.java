/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import static org.usfirst.frc.team1164.logic.Controls.A;
import static org.usfirst.frc.team1164.logic.Controls.B;
import static org.usfirst.frc.team1164.logic.Controls.BACK;
import static org.usfirst.frc.team1164.logic.Controls.LB;
import static org.usfirst.frc.team1164.logic.Controls.RB;
import static org.usfirst.frc.team1164.logic.Controls.START;
import static org.usfirst.frc.team1164.logic.Controls.X;
import static org.usfirst.frc.team1164.logic.Controls.Y;

import org.usfirst.frc.team1164.robot.commands.InitClimb;
import org.usfirst.frc.team1164.robot.commands.InitDrive;
import org.usfirst.frc.team1164.robot.commands.arm.FoldArm;
import org.usfirst.frc.team1164.robot.commands.arm.UnfoldArm;
import org.usfirst.frc.team1164.robot.commands.arm.changeArmSpeed;
import org.usfirst.frc.team1164.robot.commands.auto.setArmHeight;
import org.usfirst.frc.team1164.robot.commands.chassis.DisengageHighGear;
import org.usfirst.frc.team1164.robot.commands.chassis.EngageHighGear;
import org.usfirst.frc.team1164.robot.commands.claw.CloseClaw;
import org.usfirst.frc.team1164.robot.commands.claw.OpenClaw;
import org.usfirst.frc.team1164.robot.commands.claw.ToggleClaw;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private XboxController driverStick, operatorStick;

	private Button openClaw, closeClaw;
	private Button highGear, lowGear;
	private Button initDriving, initClimbing;
	private Button foldArm, unfoldArm;
	private Button increaseArmSpeed, decreaseArmSpeed;
	
	private Button testButton1, testButton2;

	public OI() {
//		testButton1 = new JoystickButton(driverStick, A.toInt());
//		testButton2 = new JoystickButton(driverStick, B.toInt());
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
		openClaw = new JoystickButton(operatorStick, A.toInt());
		closeClaw = new JoystickButton(operatorStick, B.toInt());
		
		initClimbing = new JoystickButton(operatorStick, BACK.toInt());
		initDriving = new JoystickButton (operatorStick, START.toInt());
		
		foldArm = new JoystickButton(operatorStick, X.toInt());
		unfoldArm = new JoystickButton(operatorStick, Y.toInt());
		
		increaseArmSpeed = new JoystickButton(operatorStick, LB.toInt()); 
		decreaseArmSpeed = new JoystickButton(operatorStick, RB.toInt());
	}
	
	private void initializeDriverControls() {
		highGear = new JoystickButton(driverStick, RB.toInt());
		lowGear = new JoystickButton(driverStick, LB.toInt());
	}
	
	private void initializeButtons() {
		openClaw.whenPressed(new OpenClaw());
		closeClaw.whenPressed(new CloseClaw());
		
		initClimbing.whenPressed(new InitClimb());
		initDriving.whenPressed(new InitDrive());
		
		foldArm.whenPressed(new FoldArm());
		unfoldArm.whenPressed(new UnfoldArm());
		
		increaseArmSpeed.whenPressed(new changeArmSpeed(0.01));
		decreaseArmSpeed.whenPressed(new changeArmSpeed(-0.01));
		
		highGear.whenPressed(new EngageHighGear());
		lowGear.whenPressed(new DisengageHighGear());
		
//		testButton1.whenPressed(new ToggleClaw());
//		testButton2.whenPressed(new setArmHeight(600));
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
