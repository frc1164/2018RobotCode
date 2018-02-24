package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.CustomDriveWithXbox;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Servo;


import com.kauailabs.navx.frc.AHRS;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.ctre.phoenix.motorcontrol.ControlMode;


public class Chassis extends Subsystem {
	private WPI_VictorSPX Right1, Right2, Right3, Left1, Left2, Left3;
	private Encoder LeftEncoder, RightEncoder;
	private AHRS Navx;
	private DoubleSolenoid Transmission, PTO;
	private Servo LeftNeutralizer, RightNeutralizer;
	public boolean IsClimbingConfiguration;
	public boolean IsHighGear;
	

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
		
		
		
		//LiveWindow.add("Chassis");
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
	
	public enum Config{
		Starting, Climbing
	}
	
	/* a function Mixer that accepts the parameters straight and turn (doubles), and left and right
	 * (double objects). This mixer */
	public double Mixer(double straight, double turn, Double left, Double right) {
		left = turn + straight;
		right = -turn + straight;
		if (left > 1) {
			right = right - (left - 1);
			left = 1.0;
		} else if (left < -1) {
			right = right - (left + 1);
			left = -1.0;
		} else if (right > 1) {
			left = left - (right -1);
			right = 1.0;
		} else {
			left = left - (right +1);
			right = -1.0;
		}
	}
}