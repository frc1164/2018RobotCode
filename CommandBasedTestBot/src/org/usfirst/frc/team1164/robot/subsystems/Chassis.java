package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.CustomDriveWithXbox;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;


import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Chassis extends Subsystem {
	private WPI_VictorSPX Right1, Right2, Right3, Left1, Left2, Left3;
	private Encoder LeftEncoder, RightEncoder;
	private AHRS Navx;
	

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new CustomDriveWithXbox());
	}
	
	public Chassis() {
		Left1 = new WPI_VictorSPX(RobotMap.CHV_Left_1);
		Left2 = new WPI_VictorSPX(RobotMap.CHV_Left_2);
		Left3 = new WPI_VictorSPX(RobotMap.CHV_Left_2);
		Right1 = new WPI_VictorSPX(RobotMap.CHV_Right_1);
		Right2 = new WPI_VictorSPX(RobotMap.CHV_Right_2);
		Right3 = new WPI_VictorSPX(RobotMap.CHV_Right_2);
		
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
		
		
		//configuration 
		
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
	
}