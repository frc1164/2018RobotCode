package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.CustomDriveWithXbox;
import org.usfirst.frc.team1164.robot.OI;
import org.usfirst.frc.team1164.robot.commands.ClimbingConfiguration;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
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
		 * ENCODER FUNCTIONALITY:
		 * 	In an encoder, two electrical data signals, 90 degrees out of phase with each other, are
		 * used to measure revolution direction, revolution count, and revolution speed depending on 
		 * the amount of data signals available, what format they are available in, and the time in-
		 * between data signals.  These data signals are referred to as "edges", and, depending on 
		 * how many edges there are in a revolution, (there may be 1, 2, or 4), the Quadrature Encoding
		 * value may be 1x, 2x, or 4x.  Today, Quadrature decoding can be cheaply done via Field Programmable
		 * Gate Arrays (FPGA), which are customizable circuits capable of being programmed to run any number of different
		 * possible functions depending on the task provided; in context of the encoder used, it's input is 
		 * the number of edges, or data signals provided by the encoder, so that it may accurately interpret the 
		 * signals depending on their availability.  In an encoder, Cycles Per Revolution (CPR) is defined
		 * by the number of electrical phases per revolution, in which are contained the aforementioned 
		 * data signal types.  
		 * 
		 * While the following information may not be entirely accurate, it may help understand the use of
		 * FPGA Indicies in programming.  Encoder Data may receive signals from three possible channels: 
		 * ---An A Channel that, in it's contrast to the B Channel, may define one direction of motion
		 * ---A B Channel that, in it's contrast to the A Channel, may define another direction of motion
		 * ---An Index Channel that provides a reference point for the quadrature decoder to reset quadrature logging,
		 * a "reset" channel. 
		 * 
		 * Provided are:
		 * FPGA INDEX: May potentially provide the "reset" signal as defined above
		 * Raw Values:  The actual, un-scaled "edge" count of the encoder, the number of data signals read.
		 * Sampling Rate: The rotational rate in distance/second as defined by the setDistancePerPulse() method.
		 * Encoding Scale: The edge count per revolution, as previously defined, this provides the number of data
		 * signals to be "decoded" per electrical phase.
		 * The getStopped() Method: Returns whether or not the encoder has stopped running
		 * Source Type: The available PID provides two reference sources, displacement, and rate, to the 
		 * appropriate application.
		 * 
		 *                ***NOTICE END***
		 *                
		 *                
		 */
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Left FPGA", LeftEncoder.getFPGAIndex());
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Raw Encoding Values", LeftEncoder.getRaw());
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Encoding Rate", LeftEncoder.getRate());
		SmartDashboard.putNumber("LeftEncoder Diagnostics - Left Encoding Scale", LeftEncoder.getEncodingScale());
		SmartDashboard.putBoolean("LeftEncoder Diagnostics- Left Running Status", LeftEncoder.getStopped());
		//SmartDashboard.putString("LeftEncoder Diagnostics - Encoder Direction", encoderDirection());
		SmartDashboard.putString("LeftEncoder Diagnostics - PID Source Type Troubleshoot", pidSourceTypeLeft());
		
		SmartDashboard.putNumber("RightEncoder Diagnostics- Right FPGA", RightEncoder.getFPGAIndex());
		SmartDashboard.putNumber("RightEncoder Diagnostics- Raw Encoding Values", RightEncoder.getRaw());
		SmartDashboard.putNumber("RightEncoder Diagnostics - Encoding Rate", RightEncoder.getRate());
		SmartDashboard.putNumber("RightEncoder Diagnostics - Right Encoding Scale", RightEncoder.getEncodingScale());
		SmartDashboard.putString("Encoder Diagnostics Notice", "If value is false, the encoder is running");
		SmartDashboard.putBoolean("RightEncoder Diagnostics - Right Running Status", RightEncoder.getStopped());
		SmartDashboard.putString("RightEncoder Diagnostics - PID Source Type TroubleShoot", pidSourceTypeRight());
		
		//Transmission & PTO Diagnostics
		
		/*
		 * 			***NOTICE***
		 * 	Under the blacklist return method
		 * what is referenced are the solenoids 
		 * shut down if they are shorted.  Once
		 * the solenoid's channel shorts, the 
		 * PCM will blacklist it and shut it down,
		 * it will then add it to the blacklist,
		 * which can be read from the method provided
		 * 		  ***NOTICE END***
		 */
		SmartDashboard.putString("Transmission Status", transmissionStatus());
		SmartDashboard.putNumber("Transmission BlackList", Transmission.getPCMSolenoidBlackList());
		
		SmartDashboard.putString("PTO Status", ptoStatus());
		SmartDashboard.putNumber("PTO BlackList", PTO.getPCMSolenoidBlackList());
		
		//Neutralizer Diagnostics
		SmartDashboard.putNumber("Raw Left Servo Position", LeftNeutralizer.getPosition());
		SmartDashboard.putString("Raw Left Servo Position", "For Reference, Engage angle for left is 1, Disengage Angle is .25");
		//SmartDashboard.putNumber("Servo Data", LeftNeutralizer.getRawBounds());
		
		
		SmartDashboard.putNumber("Raw Right Servo Position", RightNeutralizer.getPosition());
		SmartDashboard.putString("Raw Right Servo Position", "For Reference, Engage angle for Right is 0, disengage angle is .75");
		//SmartDashboard.put("Servo Data", RightNeutralizer.getRawBounds());
		
		//NavX Diagnostics
		/*
		 * NavX Calibration:
		 * 	
		 */
		SmartDashboard.putString("NavX Diagnostics - Calibration Status", navXCalibrationStatus());
		SmartDashboard.putString("NavX Diagnostics - Disturbance Status", navXMagneticDisturbanceDetection());
		SmartDashboard.putString("NavX Diagnostics - NavX Rotational Sensing Status", navXRotationalStatus());
		SmartDashboard.putString("NavX Diagnostics - NavX Movement Sensing Status", navXMotionStatus());
		SmartDashboard.putString("NavX Diagnostics - NavX Connection", navXConnectionStatus());
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
	
	//START OF DIAGNOSTICS LOGIC CODE

	
	public String pidSourceTypeLeft() {
		if(LeftEncoder.getPIDSourceType() == PIDSourceType.kDisplacement ) {
			return "Displacement";
		}else if(LeftEncoder.getPIDSourceType() == PIDSourceType.kRate) {
			return "Rate";
		}else {
			return "Error";
		}
		
	}
//	public String referenceYawAxis() {
//		
//	}
	/*
	 * 			_________________________________
	 * 			|								|
	 * 			|	NavX Diagnostics Logic		|
	 * 			|_______________________________|
	 */
	public String navXCalibrationStatus() {
		SmartDashboard.putString("***NOTICE***", "Magnetometer Calibration is recommended for precision applications, it is not required");
		if(Navx.isMagnetometerCalibrated() == true) {
			return "NavX Magnetometer is Calibrated";
		}else if(Navx.isMagnetometerCalibrated()== false) {
			return "NavX Magnetometer is not Calibrated, if you do not have the software, please download calibration software at https://www.pdocs.kauailabs.com/navx-mxp/software/tools/magnetometer-calibration/";
			
		}
		else {
			return "Error";
		}
	}
	public String navXRotationalStatus() {
		SmartDashboard.putNumber("Current Yaw Value", Navx.getYaw());
		if(Navx.isRotating() == true) {
			return "Navx is reading Rotation";
		}else if(Navx.isRotating() == false) {
			return "Navx is not reading rotation, possible insufficient gyro calibration";
		}
		else {
			return "Error";
		}
		
	}
	public String navXMagneticDisturbanceDetection() {
		SmartDashboard.putString("***NOTICE***", "Magnetic Disturbances will not be detected until Magnometer on NavX has been calibrated, see code for details");
		if(Navx.isMagneticDisturbance()== true) {
			return "Magnetic Disturbance Detected, NavX values may be affected";
		}else if(Navx.isMagneticDisturbance()== false) {
			return "Magnetic Disturbance Not Detected: Possible that magnometer was not calibrated, otherwise, no anomalies detected";
		}
		else {
			return "Error";
		}
	}
	
	public String navXMotionStatus() {
		SmartDashboard.putNumber("Current X-Axis (Roll) Value", Navx.getRoll());
		SmartDashboard.putNumber("Current Y-Axis (Pitch) Value", Navx.getPitch());
		if(Navx.isMoving() == true) {
			return "Movement is Detected";
		}else if(Navx.isMoving() == false) {
			return "Movement not Detected";
		}
		else {
			return "Error";
		}
	}
	
	public String navXConnectionStatus() {
		if(Navx.isConnected() == true) {
			return "NavX is Connected";
		}else if (Navx.isConnected() == false) {
			return "NavX Is Not Connected";
		}
		else {
			return "Error";
		}
	}
	/*
	 * 
	 * 		___________________________________
	 * 		|							 	  |
	 * 		|   PNEUMATIC DIAGNOSTICS LOGIC	  |
	 * 		|_________________________________|
	 */
	public String transmissionStatus() {
		if(Transmission.getPCMSolenoidVoltageFault()== true) {
			return "Common highside voltage rail is too low - A solenoid is in fault state - most likely shorted chanel";
		}else if(Transmission.getPCMSolenoidVoltageStickyFault() == true) {
			return "Common highside voltage rail is too low - Solenoid StickyFault is set - most likely shorted chanel";
		}
		
	}
	public String ptoStatus() {
		if(PTO.getPCMSolenoidVoltageFault()== true) {
			return "Common highside voltage rail is too low - A solenoid is in fault state - most likely shorted chanel";
		}else if(PTO.getPCMSolenoidVoltageStickyFault() == true) {
			return "Common highside voltage rail is too low - Solenoid StickyFault is set - most likely shorted chanel";
		}
	}
	/*
	 * 		_________________________________
	 * 		|								|
	 * 		|	ENCODER DIAGNOSTICS LOGIC	|
	 * 		|_______________________________|
	 * 
	 */
	
	public String pidSourceTypeRight() {
		if(RightEncoder.getPIDSourceType() == PIDSourceType.kDisplacement ) {
			return "Displacement used as a process control variable";
		}else if(RightEncoder.getPIDSourceType() == PIDSourceType.kRate) {
			return "Rate used as a process control variable";
		}else {
			return "Error";
		}
		
	}
	
//	public String encoderDirection() {
//	if(LeftEncoder.getDirection() == true) {
//		return "ClockWise";
//	}
//	else return "CounterClockWise";
//}
	
	/*
	 * 		______________________________
	 * 		|							 |
	 * 		|	MOTOR DIAGNOSTICS LOGIC  |
	 * 		|____________________________|
	 * 	
	 */
	
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
	
	//END OF DIAGNOSTICS LOGIC
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