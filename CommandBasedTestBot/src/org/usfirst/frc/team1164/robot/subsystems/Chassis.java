package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.CustomDriveWithXbox;
import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.commands.ClimbingConfiguration;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Command;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.hal.PDPJNI;

import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Chassis extends Subsystem {
	private WPI_VictorSPX Right1, Right2, Right3, Left1, Left2, Left3;
	private Encoder LeftEncoder, RightEncoder;
	private AHRS Navx;
	private DoubleSolenoid Transmission, PTO;
	private Servo LeftNeutralizer, RightNeutralizer;
	public boolean IsClimbingConfiguration, IsHighGear;
	private Command ClimbingConfiguration = new ClimbingConfiguration();


	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CustomDriveWithXbox());
	}
	
	public Chassis() {
		
		//Object definitions
		Left1 = new WPI_VictorSPX(RobotMap.CHV_Left_1);
		Left2 = new WPI_VictorSPX(RobotMap.CHV_Left_2);
		Left3 = new WPI_VictorSPX(RobotMap.CHV_Left_3);
		Right1 = new WPI_VictorSPX(RobotMap.CHV_Right_1);
		Right2 = new WPI_VictorSPX(RobotMap.CHV_Right_2);
		Right3 = new WPI_VictorSPX(RobotMap.CHV_Right_3);
//		_______________________
//		|					  |
//		|  SmartDashBoard UI  |
//		|_____________________|
		
		SmartDashboard.putData("Chassis", LeftEncoder);
		SmartDashboard.putData("Chassis", RightEncoder);
		SmartDashboard.putData("Chassis", Navx);
		SmartDashboard.putData("Chassis", Transmission);
		SmartDashboard.putData("Chassis", PTO);
		SmartDashboard.putData("Chassis", LeftNeutralizer);
		SmartDashboard.putData("Chassis", RightNeutralizer);
		SmartDashboard.putBoolean("Chassis", IsClimbingConfiguration);
		SmartDashboard.putBoolean("Chassis", IsHighGear);
		SmartDashboard.putData("Chassis", ClimbingConfiguration);
		
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
		SmartDashboard.putNumber("Left1 HD- BusVoltage", Left1.getBusVoltage());
		SmartDashboard.putNumber("Left1 HD-MotorOutputVoltage", Left1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left1 HD-OutputCurrent", Left1.getOutputCurrent());
		SmartDashboard.putNumber("Left1 HD-Temperature", Left1.getTemperature());
		SmartDashboard.putNumber("Left1 HD- BaseID", Left1.getBaseID());
		
		
		//Left2 Hardware Diagnostics
		SmartDashboard.putNumber("Left2 HD - BusVoltage", Left2.getBusVoltage());
		SmartDashboard.putNumber("Left2 HD- MotorOutputVoltage", Left2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left2 HD - OutputCurrent", Left2.getOutputCurrent());
		SmartDashboard.putNumber("Left2 HD - Temperature", Left2.getTemperature());
		SmartDashboard.putNumber("Left2 HD - BaseID", Left2.getBaseID());
		
		//Left3 Hardware Diagnostics
		SmartDashboard.putNumber("Left3 HD - BusVoltage", Left3.getBusVoltage());
		SmartDashboard.putNumber("Left3 HD- MotorOutputVoltage", Left3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Left3 HD - OutputCurrent", Left3.getOutputCurrent());
		SmartDashboard.putNumber("Left3 HD - Temperature", Left3.getTemperature());
		SmartDashboard.putNumber("Left3 HD - BaseID", Left3.getBaseID());
		
		//Right1 Hardware Diagnostics
		SmartDashboard.putNumber("Right1 HD - BusVoltage", Right1.getBusVoltage());
		SmartDashboard.putNumber("Right1 HD- MotorOutputVoltage", Right1.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right1 HD - OutputCurrent", Right1.getOutputCurrent());
		SmartDashboard.putNumber("Right1 HD - Temperature", Right1.getTemperature());
		SmartDashboard.putNumber("Right1 HD - BaseID", Right1.getBaseID());
		
		//Right2 Hardware Diagnostics
		SmartDashboard.putNumber("Right2 HD - BusVoltage", Right2.getBusVoltage());
		SmartDashboard.putNumber("Right2 HD- MotorOutputVoltage", Right2.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right2 HD - OutputCurrent", Right2.getOutputCurrent());
		SmartDashboard.putNumber("Right2 HD - Temperature", Right2.getTemperature());
		SmartDashboard.putNumber("Right2 HD - BaseID", Right2.getBaseID());
		
		//Right3 Hardware Diagnostics
		SmartDashboard.putNumber("Right3 HD - BusVoltage", Right3.getBusVoltage());
		SmartDashboard.putNumber("Right3 HD- MotorOutputVoltage", Right3.getMotorOutputVoltage());
		SmartDashboard.putNumber("Right3 HD - OutputCurrent", Right3.getOutputCurrent());
		SmartDashboard.putNumber("Right3 HD - Temperature", Right3.getTemperature());
		SmartDashboard.putNumber("Right3 HD - BaseID", Right3.getBaseID());
		
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
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Left FPGA", LeftEncoder.getFPGAIndex());
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Left Encoding Scale", LeftEncoder.getEncodingScale());
		SmartDashboard.putBoolean("LeftEncoder Diagnostics- Encoder Running Status", LeftEncoder.getStopped());
		SmartDashboard.putString("LeftEncoder Diagnostics - Encoder Direction", encoderDirection());
		SmartDashboard.putString("LeftEncoder Diagnostics", "Hello");
		//githubstuff
		
		
		
		
//		___________________
//		|				  |
//		|  LiveWindow UI  |
//		|_________________|
		
		LiveWindow.add(Left1);
		LiveWindow.add(Left2);
		LiveWindow.add(Left3);
		LiveWindow.add(Right1);
		LiveWindow.add(Right2);
		LiveWindow.add(Right3);
		LiveWindow.add(Navx);
		LiveWindow.add(LeftEncoder);
		LiveWindow.add(RightEncoder);
		
		
		


		try {
			Navx = new AHRS(SPI.Port.kMXP);
		}
		catch (RuntimeException ex){
			DriverStation.reportError("could not connect to Navx: " + ex.getMessage(), true);
			
		}
		
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
			
		
	}
	
	public String encoderDirection() {
		if(LeftEncoder.getDirection() == true) {
			return "ClockWise";
		}
		else return "CounterClockWise";
	}
	
	public void setLeftMotorSpeed(double speed) {
		Left1.set(ControlMode.PercentOutput, speed*RobotMap.speedReducer);
		Left2.set(ControlMode.PercentOutput, speed*RobotMap.speedReducer);
		Left3.set(ControlMode.PercentOutput, speed*RobotMap.speedReducer);

	}
	
	public void setRightMotorSpeed(double speed) {
		Right1.set(ControlMode.PercentOutput, speed*RobotMap.speedReducer);
		Right2.set(ControlMode.PercentOutput, speed*RobotMap.speedReducer);
		Right3.set(ControlMode.PercentOutput, speed*RobotMap.speedReducer);
	}
	
	
	public void ResetEncoders() {
		LeftEncoder.reset();
		RightEncoder.reset();
	}
	
	public double GetLeftEncoder() {
		return LeftEncoder.getDistance();
	}
	
	public double GetRightEncoder() {
		return RightEncoder.getDistance();
	}
	public double GetNavxAngle() {
		return Navx.getAngle();
	}
	public void ResetNavx() {
		Navx.reset();
	}
	
	public void Brake() {
		Right1.set(ControlMode.PercentOutput, 0);
		Right2.set(ControlMode.PercentOutput, 0);
		Right3.set(ControlMode.PercentOutput, 0);
		Left1.set(ControlMode.PercentOutput, 0);
		Left2.set(ControlMode.PercentOutput, 0);
		Left3.set(ControlMode.PercentOutput, 0);
	}
	
	public void SetHighGear() {
		Transmission.set(DoubleSolenoid.Value.kForward);
		IsHighGear = true;
	}
	
	public void SetLowGear() {
		Transmission.set(DoubleSolenoid.Value.kReverse);
		IsHighGear = false;
	}
	
	public void EngageNeutralizer() {
		LeftNeutralizer.set(RobotMap.CHN_Left_EngageAngle);
		RightNeutralizer.set(RobotMap.CHN_Right_EngageAngle);
	}
	public void DisengageNeutralizer() {
		LeftNeutralizer.set(RobotMap.CHN_Left_DisengageAngle);
		RightNeutralizer.set(RobotMap.CHN_Right_DisengageAngle);
	}
	
	public void EngagePTO() {
		PTO.set(DoubleSolenoid.Value.kForward);
	}
	public void DisengagePTO() {
		PTO.set(DoubleSolenoid.Value.kReverse);
	} 
	public void Climb() {
		if (OI.getControllerButton(3) == true) {
			ClimbingConfiguration.start();
		}
	}
	
	public enum Config{
		Starting, Climbing
	}
	
}