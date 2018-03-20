package org.usfirst.frc.team1164.robot.subsystems;

import static org.usfirst.frc.team1164.robot.RobotMap.*;

import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.commands.arm.MoveArm;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
	
	private WPI_VictorSPX armVictor;
	private Encoder armEncoder;
	private AnalogInput armPot;
	private DigitalInput forwardLimitSwitch, reverseLimitSwitch;
	private DoubleSolenoid foldingPiston;
	private boolean isFolded;
	private double armSpeed;
	
	public void initDefaultCommand() {
		setDefaultCommand(new MoveArm());
	}

	//------------------------------------------//
	
	public Arm() {

		isFolded = Arm_isFolded;
		armSpeed = 0.15;
		
		initializeMotor();
		initializeEncoder();
		initializePot();
		initializeLimitSwitch();
		initializeFoldingPiston();
	}
	
	public void initializeMotor() {
		armVictor = new WPI_VictorSPX(Arm_victor_port);
		armVictor.setInverted(Arm_victor_inverted);
		armVictor.setName(Arm_victor_name);
	}
	
	public void initializeEncoder() {
		armEncoder = new Encoder(Arm_encoder_APort, Arm_encoder_BPort, 
				 				 Arm_encoder_invert, EncodingType.k2X);
		armEncoder.setName("Temp");
		armEncoder.reset();
		
	}

	public void initializePot() {
		armPot = new AnalogInput(Arm_pot_channel);
	}
	
	public void initializeLimitSwitch() {
//		forwardLimitSwitch = new DigitalInput(Arm_limiter_forwardPort);
//		reverseLimitSwitch = new DigitalInput(Arm_limiter_reversePort);
	}
	
	public void initializeFoldingPiston() {
		foldingPiston = new DoubleSolenoid(Arm_fold_forwardPort, Arm_fold_reversePort);
//		foldingPiston.set(isFolded ? DoubleSolenoid.Value.kForward :
//								   	 DoubleSolenoid.Value.kReverse);
	}
	
	public void initialize() {
		foldingPiston.set(isFolded ? DoubleSolenoid.Value.kForward :
	   								 DoubleSolenoid.Value.kReverse);
		
	}
	
	//------------------------------------------//
	
	public void setArmVictor(double speed) {
		armVictor.set(speed);
	}

	//------------------------------------------//
	
	public double getArmEncoder() {
		return armEncoder.getDistance();
	}
	
	public void resetArmEncoder() {
		armEncoder.reset();
	}

	public double getArmPot() {
		return armPot.getVoltage();
	}
	
	public double getArmAngle() {
		return NeoUtil.VoltsToDegrees(getArmPot());
	}

	//------------------------------------------//
	
	public boolean getForwardLimiter() {
		return forwardLimitSwitch.get();
	}
	
	public boolean getReverseLimiter() {
		return reverseLimitSwitch.get();
	}

	//------------------------------------------//
	
	public void setArmFolded(boolean folded) {
		foldingPiston.set(folded ? DoubleSolenoid.Value.kForward :
								   DoubleSolenoid.Value.kReverse);
		isFolded = folded;
	}
	
	public boolean getArmFolded() {
		return isFolded;
	}

	//------------------------------------------//
	
	public void setArmSpeed(double speed) {
		this.armSpeed = speed;
	}
	
	public double getArmSpeed() {
		return armSpeed;
	}
//	public void moveArmDown(double speed) {
//		if (speed < 0.4 && getArmEncoder() > 2.1) {
//			armVictor.set(speed);
//		} else {
//			armVictor.set(0);
//		}
//	}
//	
//	public void moveArmUp(double speed) {
//		if (speed < 0.4 && getArmEncoder() < 4.94) {
//			armVictor.set(speed);
//		} else {
//			armVictor.set(0);
//		}
//	}

//	public void armBreak() {
//		armVictor.set(0);
//	}
	    
}
	
