package org.usfirst.frc.team1164.robot.subsystems;

import static org.usfirst.frc.team1164.robot.RobotMap.Arm_encoder_APort;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_encoder_BPort;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_encoder_invert;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_isFolded;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_pot_channel;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_victor_inverted;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_victor_name;
import static org.usfirst.frc.team1164.robot.RobotMap.Arm_victor_port;

import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.arm.DriveArm;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Arm extends Subsystem {
	
	private WPI_VictorSPX armVictor;
	private Encoder armEncoder;
	private AnalogInput armPot;
	private DigitalInput topLimitSwitch, botLimitSwitch;
	private DoubleSolenoid foldingPiston;
	private boolean isFolded;
	private double armSpeed;
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveArm());
	}

	//------------------------------------------//
	
	public Arm() {

		isFolded = Arm_isFolded;
		armSpeed = 0.3;
		
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
//		armEncoder.reset();
		
	}

	public void initializePot() {
		armPot = new AnalogInput(Arm_pot_channel);
	}
	
	public void initializeLimitSwitch() {
		topLimitSwitch = new DigitalInput(RobotMap.Arm_limiter_topPort);
		botLimitSwitch = new DigitalInput(RobotMap.Arm_limiter_botPort);
	}
	
	public void initializeFoldingPiston() {
		foldingPiston = new DoubleSolenoid(RobotMap.Arm_fold_forwardPort, RobotMap.Arm_fold_reversePort);
//		foldingPiston.set(isFolded ? DoubleSolenoid.Value.kForward :
//								   	 DoubleSolenoid.Value.kReverse);
	}
	
	public void initialize() {
		foldingPiston.set(isFolded ? DoubleSolenoid.Value.kForward :
	   								 DoubleSolenoid.Value.kReverse);
		
	}
	
	//------------------------------------------//
	
	public void setArmVictor(double speed) {
		SmartDashboard.putNumber("HEYOOO", speed);
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
	
	public boolean getTopSwitch() {
		return topLimitSwitch.get();
	}
	
	public boolean getBotSwitch() {
		return !botLimitSwitch.get();
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

}
	
