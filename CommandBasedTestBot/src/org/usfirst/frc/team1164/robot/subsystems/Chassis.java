package org.usfirst.frc.team1164.robot.subsystems;

<<<<<<< HEAD
import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.CustomDriveWithXbox;
import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.commands.ClimbingConfiguration;
=======
import static org.usfirst.frc.team1164.robot.RobotMap.CH_PTOEnabled;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_PTO_forwardPort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_PTO_reversePort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_DPP;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_left_APort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_left_BPort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_left_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_left_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_right_APort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_right_BPort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_right_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_encoder_right_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_highGearEnabled;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_nav_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neut_left_disable;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neut_left_enable;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neut_left_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neut_right_disable;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neut_right_enable;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neut_right_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_neutralizerEnabled;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_trans_forwardPort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_trans_reversePort;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left1_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left1_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left1_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left2_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left2_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left2_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left3_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left3_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_left3_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right1_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right1_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right1_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right2_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right2_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right2_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right3_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right3_name;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_right3_port;
import static org.usfirst.frc.team1164.robot.RobotMap.CH_victor_speedReducer;
>>>>>>> Devon

import org.usfirst.frc.team1164.robot.commands.chassis.driving;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;

import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;
=======
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
>>>>>>> Devon


public class Chassis extends Subsystem {
	// power
	private WPI_VictorSPX rightMotor1, rightMotor2, rightMotor3,
						  leftMotor1,  leftMotor2, 	leftMotor3;
	// driving
	private Encoder leftEncoder, rightEncoder;
	private AHRS Navx;
<<<<<<< HEAD
	private DoubleSolenoid Transmission, PTO;
	private Servo LeftNeutralizer, RightNeutralizer;
	public boolean IsClimbingConfiguration, IsHighGear;
	private Command ClimbingConfiguration = new ClimbingConfiguration();

=======
	// Gear box
	private DoubleSolenoid transmission, PTO;
	private Servo leftNeutralizer, rightNeutralizer;
	public boolean neutralizerEnabled, highGearEnabled, PTOEnabled;
>>>>>>> Devon

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new driving());
	}

	//------------------------------------------//
	
	public Chassis() {
		neutralizerEnabled = CH_neutralizerEnabled;
		highGearEnabled = CH_highGearEnabled;
		PTOEnabled = CH_PTOEnabled;
		
		initializeMotors();
		initializeNavx();
		initializeEncoders();
		initializeGearBox();
		initializeLiveWindow();
	}

	public void initializeMotors() {
		leftMotor1 = new WPI_VictorSPX(CH_victor_left1_port);
		leftMotor1.setInverted(CH_victor_left1_invert);
		leftMotor1.setName(CH_name, CH_victor_left1_name);
		
		leftMotor2 = new WPI_VictorSPX(CH_victor_left2_port);
		leftMotor2.setInverted(CH_victor_left2_invert);
		leftMotor2.setName(CH_name, CH_victor_left2_name);
		
		leftMotor3 = new WPI_VictorSPX(CH_victor_left3_port);
		leftMotor3.setInverted(CH_victor_left3_invert);
		leftMotor3.setName(CH_name, CH_victor_left3_name);
		
		rightMotor1 = new WPI_VictorSPX(CH_victor_right1_port);
		rightMotor1.setInverted(CH_victor_right1_invert);
		rightMotor1.setName(CH_name, CH_victor_right1_name);
		
<<<<<<< HEAD
		//LiveWindow.add("Chassis");
		LiveWindow.add(Left2);
		LiveWindow.add(Left3);
		LiveWindow.add(Right1);
		LiveWindow.add(Right2);
		LiveWindow.add(Right3);
		LiveWindow.add(Navx);
		LiveWindow.add(LeftEncoder);
		LiveWindow.add(RightEncoder);

=======
		rightMotor2 = new WPI_VictorSPX(CH_victor_right2_port);
		rightMotor2.setInverted(CH_victor_right2_invert);
		rightMotor2.setName(CH_name, CH_victor_right2_name);
		
		rightMotor3 = new WPI_VictorSPX(CH_victor_right3_port);
		rightMotor3.setInverted(CH_victor_right3_invert);
		rightMotor3.setName(CH_name, CH_victor_right3_name);
	}
	
	public void initializeNavx() {
>>>>>>> Devon
		try {
			Navx = new AHRS(SPI.Port.kMXP);
			Navx.reset();
			Navx.setName(CH_name, CH_nav_name);
		}
		catch (RuntimeException ex) {
			DriverStation.reportError("could not connect to Navx: " + ex.getMessage(), true);
		}
	}
	
	public void initializeEncoders() {
		leftEncoder = new Encoder(CH_encoder_left_APort, CH_encoder_left_BPort, 
								  CH_encoder_left_invert, Encoder.EncodingType.k2X);
		leftEncoder.setDistancePerPulse(CH_encoder_DPP);
		leftEncoder.setName(CH_name, CH_encoder_left_name);
		leftEncoder.reset();
		
<<<<<<< HEAD
		LeftEncoder = new Encoder(RobotMap.CHE_Left_channelA, RobotMap.CHE_Left_channelB,
				RobotMap.CHE_Left_reversed, Encoder.EncodingType.k2X);
		RightEncoder = new Encoder(RobotMap.CHE_Right_channelA, RobotMap.CHE_Right_channelB, 
				RobotMap.CHE_Right_reversed, Encoder.EncodingType.k2X);
		
		LeftEncoder.setName("Chassis", "LeftEncoder");
		RightEncoder.setName("Chassis", "RightEncoder");
		
		Transmission = new DoubleSolenoid(RobotMap.CHT_Forward_Channel,RobotMap.CHT_Reverse_Channel);
		PTO = new DoubleSolenoid(RobotMap.CHP_Forward_Channel, RobotMap.CHP_Reverse_Channel);
		
		LeftNeutralizer = new Servo(RobotMap.CHN_Left_Channel);
		RightNeutralizer = new Servo(RobotMap.CHN_Right_Channel);
		
		IsClimbingConfiguration = false;
		IsHighGear = false;
		
		//object configuration options
		
			LeftEncoder.reset();
			RightEncoder.reset();
			LeftEncoder.setDistancePerPulse(RobotMap.kDistancePerPulse);
			RightEncoder.setDistancePerPulse(RobotMap.kDistancePerPulse);
		
			// Because of the setup of the transmission, motors 0, 13, and 15 need to be inverted. 
			//These correspond to victors Left1, Right1, and Right2
		
			Left1.setInverted(true);
			Right1.setInverted(true);
			Right2.setInverted(true);
		
			Navx.reset();
			
			Left1.setName("Chassis", "Left1");
			Left2.setName("Chassis", "Left2");
			Left3.setName("Chassis", "Left3");
			Right1.setName("Chassis", "Right1");
			Right2.setName("Chassis", "Right2");
			Right3.setName("Chassis", "Right3");
			Navx.setName("Chassis", "NavX");
			
=======
>>>>>>> Devon
		
		rightEncoder = new Encoder(CH_encoder_right_APort, CH_encoder_right_BPort, 
								   CH_encoder_right_invert, Encoder.EncodingType.k2X);
		rightEncoder.setDistancePerPulse(CH_encoder_DPP);
		rightEncoder.setName(CH_name, CH_encoder_right_name);
		rightEncoder.reset();
	}
	
	public void initializeGearBox() {
		
		transmission = new DoubleSolenoid(CH_trans_forwardPort, CH_trans_reversePort);
		transmission.set(highGearEnabled ? DoubleSolenoid.Value.kForward :
			  							   DoubleSolenoid.Value.kReverse);

		PTO	= new DoubleSolenoid(CH_PTO_forwardPort, CH_PTO_reversePort);
		PTO.set(PTOEnabled ? DoubleSolenoid.Value.kForward :
						  	 DoubleSolenoid.Value.kReverse);

		leftNeutralizer = new Servo(CH_neut_left_port);
		leftNeutralizer.set(neutralizerEnabled ? CH_neut_left_enable : 
												 CH_neut_left_disable);

		rightNeutralizer = new Servo(CH_neut_right_port);
		rightNeutralizer.set(neutralizerEnabled ? CH_neut_left_disable : 
												  CH_neut_right_disable);
	}
	
	public void initializeLiveWindow() {
//		LiveWindow.add("Chassis");
		LiveWindow.add(leftMotor1);
		LiveWindow.add(leftMotor2);
		LiveWindow.add(leftMotor3);
		LiveWindow.add(rightMotor1);
		LiveWindow.add(rightMotor2);
		LiveWindow.add(rightMotor3);
		LiveWindow.add(Navx);
		LiveWindow.add(leftEncoder);
		LiveWindow.add(rightEncoder);
	}
	
	//------------------------------------------//
	
	public void setRightSpeed(double speed) {
		rightMotor1.set(ControlMode.PercentOutput, speed * CH_victor_speedReducer);
		rightMotor2.set(ControlMode.PercentOutput, speed * CH_victor_speedReducer);
		rightMotor3.set(ControlMode.PercentOutput, speed * CH_victor_speedReducer);
	}
	
	public void setLeftSpeed(double speed) {
		leftMotor1.set(ControlMode.PercentOutput, speed*CH_victor_speedReducer);
		leftMotor2.set(ControlMode.PercentOutput, speed*CH_victor_speedReducer);
		leftMotor3.set(ControlMode.PercentOutput, speed*CH_victor_speedReducer);
	}

	//------------------------------------------//
	
	public double getLeftEncoder() {
		return leftEncoder.getDistance();
	}
	
	public double getRightEncoder() {
		return rightEncoder.getDistance();
	}

	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
<<<<<<< HEAD
	public void Brake() {
		Right1.set(ControlMode.PercentOutput, 0);
		Right2.set(ControlMode.PercentOutput, 0);
		Right3.set(ControlMode.PercentOutput, 0);
		Left1.set(ControlMode.PercentOutput, 0);
		Left2.set(ControlMode.PercentOutput, 0);
		Left3.set(ControlMode.PercentOutput, 0);
=======
	//------------------------------------------//
	
	public double getNavxAngle() {
		return Navx.getAngle();
>>>>>>> Devon
	}
	
	public void resetNavx() {
		Navx.reset();
	}

	//------------------------------------------//
	
	public void setGear(boolean inHigh) {
		transmission.set(inHigh ? DoubleSolenoid.Value.kForward :
								  DoubleSolenoid.Value.kReverse);
		highGearEnabled = inHigh;
	}
	
	public boolean getGear() {
		return highGearEnabled;
	}

	//------------------------------------------//
	
	public void setNeutralizer(boolean engaged) {
		leftNeutralizer.set(engaged ? CH_neut_left_enable : 
									  CH_neut_left_disable);
		rightNeutralizer.set(engaged ? CH_neut_right_enable : 
									   CH_neut_right_disable);
		neutralizerEnabled = engaged;
	}
	
	public boolean getNeutralizer() {
		return neutralizerEnabled;
	}
<<<<<<< HEAD
	public void DisengagePTO() {
		PTO.set(DoubleSolenoid.Value.kReverse);
	} 
	public void Climb() {
		if (OI.getControllerButton(3) == true) {
			ClimbingConfiguration.start();
		}
=======

	//------------------------------------------//
	
	public void setPTO(boolean engaged) {
		PTO.set(engaged ? DoubleSolenoid.Value.kForward :
						  DoubleSolenoid.Value.kReverse);
		PTOEnabled = engaged;
>>>>>>> Devon
	}
	
	public boolean getPTO() {
		return PTOEnabled;
	}
	
<<<<<<< HEAD
=======
	//TODO: fix climb command
	
//	public void climb() {
//		if (OI.getControllerButton(3) == true) {
//			ClimbingConfiguration.start();
//		}
//	}
//	
//	public enum Config{
//		Starting, Climbing
//	}
	
>>>>>>> Devon
}