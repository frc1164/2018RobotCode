package org.usfirst.frc.team1164.robot.subsystems;

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

import org.usfirst.frc.team1164.robot.commands.chassis.driving;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Chassis extends Subsystem {
	// power
	private WPI_VictorSPX rightMotor1, rightMotor2, rightMotor3, leftMotor1,  leftMotor2, 	leftMotor3;
	// driving
	private Encoder leftEncoder, rightEncoder;
	private AHRS Navx;
	// Gear box
	private DoubleSolenoid transmission, PTO;
	private Servo leftNeutralizer, rightNeutralizer;
	public boolean neutralizerEnabled, highGearEnabled, PTOEnabled;

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
		
		rightMotor2 = new WPI_VictorSPX(CH_victor_right2_port);
		rightMotor2.setInverted(CH_victor_right2_invert);
		rightMotor2.setName(CH_name, CH_victor_right2_name);
		
		rightMotor3 = new WPI_VictorSPX(CH_victor_right3_port);
		rightMotor3.setInverted(CH_victor_right3_invert);
		rightMotor3.setName(CH_name, CH_victor_right3_name);
	}
	
	public void initializeNavx() {
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
		
		
		rightEncoder = new Encoder(CH_encoder_right_APort, CH_encoder_right_BPort, 
								   CH_encoder_right_invert, Encoder.EncodingType.k2X);
		rightEncoder.setDistancePerPulse(CH_encoder_DPP);
		rightEncoder.setName(CH_name, CH_encoder_right_name);
		rightEncoder.reset();
	}
	
	public void initializeGearBox() {
		
		transmission = new DoubleSolenoid(CH_trans_forwardPort, CH_trans_reversePort);
//		transmission.set(highGearEnabled ? DoubleSolenoid.Value.kForward :
//			  							   DoubleSolenoid.Value.kReverse);

		PTO	= new DoubleSolenoid(CH_PTO_forwardPort, CH_PTO_reversePort);
//		PTO.set(PTOEnabled ? DoubleSolenoid.Value.kForward :
//						  	 DoubleSolenoid.Value.kReverse);

		leftNeutralizer = new Servo(CH_neut_left_port);
//		leftNeutralizer.set(neutralizerEnabled ? CH_neut_left_enable : 
//												 CH_neut_left_disable);

		rightNeutralizer = new Servo(CH_neut_right_port);
//		rightNeutralizer.set(neutralizerEnabled ? CH_neut_left_disable : 
//												  CH_neut_right_disable);
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
	
	public void smartDashboard() {

//		 _____________________
//		|					  |
//		|  SmartDashBoard UI  |
//		|_____________________|
		
		SmartDashboard.putData("Chassis", leftEncoder);
		SmartDashboard.putData("Chassis", rightEncoder);
		SmartDashboard.putData("Chassis", Navx);
		SmartDashboard.putData("Chassis", transmission);
		SmartDashboard.putData("Chassis", PTO);
		SmartDashboard.putData("Chassis", leftNeutralizer);
		SmartDashboard.putData("Chassis", rightNeutralizer);
		SmartDashboard.putBoolean("Chassis", neutralizerEnabled);
		SmartDashboard.putBoolean("Chassis", highGearEnabled);
		SmartDashboard.putBoolean("Chassis", PTOEnabled);
		
		//SmartDashboard Motor Hardware Diagnostics
		
		/*
		 * Motor Diagnostics
		 * Below, what is provided for each motor, in order, is, Bus Voltage,
		 * MotorOutputVoltage, OutputCurrent, Temperature, and BaseID,
		 * for Troubleshooting and Diagnostic purposes, the following are
		 * defined:
		 * 
		 * ***Bus Voltage: Battery Voltage- tells you whether you have raw
		 * power available to complete the motor's task
		 * 
		 * ***Motor Output Voltage- What is being put out from the speed 
		 * controllers to the motors-Tells you the voltage each motor receives
		 * 
		 * ***Output Current: What is the actual motor current being drawn from
		 * the speed controllers, battery.
		 * 
		 * ***Temperature: Currently, the current acceptable temperature range is
		 * the ambient temperature + 2 degrees. Currently, research must be conducted
		 * to determine the measurement system used
		 * 
		 * ***BaseID: CAN Bus ID: Can be referenced with the RoboRIO Webdashboard
		 * at 
		 * 172.22.11.2 for USB Connection
		 * 10.11.64.2  current static IP for event
		 * RoboRIO-1164-frc.local for ping, browser
		 * 
		 * Diagnostic Chain Follows Order: Battery --> Speed Controller --> Motor
		 */
		
		
		//Left1 Hardware Diagnostics
		SmartDashboard.putNumber("Left1 HD- BusVoltage", leftMotor1.getBusVoltage());
		SmartDashboard.putNumber("Left1 HD-MotorOutputVoltage", leftMotor1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left1 HD-OutputCurrent", leftMotor1.getOutputCurrent());
		SmartDashboard.putNumber("Left1 HD-Temperature", leftMotor1.getTemperature());
		SmartDashboard.putNumber("Left1 HD- BaseID", leftMotor1.getBaseID());
		
		
		//Left2 Hardware Diagnostics
		SmartDashboard.putNumber("Left2 HD - BusVoltage", leftMotor2.getBusVoltage());
		SmartDashboard.putNumber("Left2 HD- MotorOutputVoltage", leftMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left2 HD - OutputCurrent", leftMotor2.getOutputCurrent());
		SmartDashboard.putNumber("Left2 HD - Temperature", leftMotor2.getTemperature());
		SmartDashboard.putNumber("Left2 HD - BaseID", leftMotor2.getBaseID());
		
		//Left3 Hardware Diagnostics
		SmartDashboard.putNumber("Left3 HD - BusVoltage", leftMotor3.getBusVoltage());
		SmartDashboard.putNumber("Left3 HD- MotorOutputVoltage", leftMotor3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left3 HD - OutputCurrent", leftMotor3.getOutputCurrent());
		SmartDashboard.putNumber("Left3 HD - Temperature", leftMotor3.getTemperature());
		SmartDashboard.putNumber("Left3 HD - BaseID", leftMotor3.getBaseID());
		
		//Right1 Hardware Diagnostics
		SmartDashboard.putNumber("Right1 HD - BusVoltage", rightMotor1.getBusVoltage());
		SmartDashboard.putNumber("Right1 HD- MotorOutputVoltage", rightMotor1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right1 HD - OutputCurrent", rightMotor1.getOutputCurrent());
		SmartDashboard.putNumber("Right1 HD - Temperature", rightMotor1.getTemperature());
		SmartDashboard.putNumber("Right1 HD - BaseID", rightMotor1.getBaseID());
		
		//Right2 Hardware Diagnostics
		SmartDashboard.putNumber("Right2 HD - BusVoltage", rightMotor2.getBusVoltage());
		SmartDashboard.putNumber("Right2 HD- MotorOutputVoltage", rightMotor2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right2 HD - OutputCurrent", rightMotor2.getOutputCurrent());
		SmartDashboard.putNumber("Right2 HD - Temperature", rightMotor2.getTemperature());
		SmartDashboard.putNumber("Right2 HD - BaseID", rightMotor2.getBaseID());
		
		//Right3 Hardware Diagnostics
		SmartDashboard.putNumber("Right3 HD - BusVoltage", rightMotor3.getBusVoltage());
		SmartDashboard.putNumber("Right3 HD- MotorOutputVoltage", rightMotor3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right3 HD - OutputCurrent", rightMotor3.getOutputCurrent());
		SmartDashboard.putNumber("Right3 HD - Temperature", rightMotor3.getTemperature());
		SmartDashboard.putNumber("Right3 HD - BaseID", rightMotor3.getBaseID());
		
		// For all questions and concerns regarding the diagnostics system, 
		//please refer to the CTRE documentation at
		//http://www.ctr-electronics.com/downloads/api/java/html/index.html
		
		
		//SmartDashboard Encoder Diagnostics
		/*
		 *                  ***NOTICE***
		 * 
		 * Due to the nature of the program documentation,
		 * Hardware Diagnostics is unavailable from the
		 * software application.  This is left to implicit
		 * troubleshooting from the methods providing encoder
		 * nature, available from the Encoder class, whose 
		 * documentation is available on the wpi java documentation
		 * website under "Encoder"
		 * 
		 *                ***NOTICE END***
		 *                
		 *                
		 */
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Left FPGA", leftEncoder.getFPGAIndex());
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Left Encoding Scale", leftEncoder.getEncodingScale());
		SmartDashboard.putBoolean("LeftEncoder Diagnostics- Encoder Running Status", leftEncoder.getStopped());
		SmartDashboard.putBoolean("LeftEncoder Diagnostics - Encoder Direction", leftEncoder.getDirection());
		SmartDashboard.putString("LeftEncoder Diagnostics", "Hello");
		//githubstuff
		
		
		
		
//		___________________
//		|				  |
//		|  LiveWindow UI  |
//		|_________________|
		
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

	public double getAverageEncoder() {
		return (getLeftEncoder() + getRightEncoder())/2;
	}
	
	public void resetEncoders() {
		leftEncoder.reset();
		rightEncoder.reset();
	}
	
	//------------------------------------------//
	
	public double getNavxAngle() {
		return Navx.getAngle();
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

		SmartDashboard.putNumber("Left neut", (engaged ? CH_neut_left_enable : CH_neut_left_disable));
		SmartDashboard.putNumber("right neut", (engaged ? CH_neut_right_enable : CH_neut_right_disable));
		neutralizerEnabled = engaged;
	}
	
	public boolean getNeutralizer() {
		return neutralizerEnabled;
	}

	//------------------------------------------//
	
	public void setPTO(boolean engaged) {
		PTO.set(engaged ? DoubleSolenoid.Value.kForward :
						  DoubleSolenoid.Value.kReverse);
		PTOEnabled = engaged;
	}
	
	public boolean getPTO() {
		return PTOEnabled;
	}
}