package org.usfirst.frc.team1164.robot.subsystems;

<<<<<<< HEAD
import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.RobotMap;
import org.usfirst.frc.team1164.robot.commands.MoveArm;
=======
import static org.usfirst.frc.team1164.robot.RobotMap.*;

import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.commands.arm.MoveArm;
>>>>>>> origin/Devon

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
<<<<<<< HEAD
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
=======
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
>>>>>>> origin/Devon

public class Arm extends Subsystem {
	
<<<<<<< HEAD
	private WPI_VictorSPX ArmVictor = new WPI_VictorSPX(RobotMap.ARM_Victor_Channel);
	private Encoder ArmEncoder = new Encoder(RobotMap.ARM_Encoder_ChannelA, RobotMap.ARM_Encoder_ChannelB, 
			RobotMap.ARM_Encoder_IsInverted, RobotMap.ARM_Encoder_EncodingType);
	private AnalogInput ArmPot = new AnalogInput(RobotMap.ARM_Pot_Channel);
	private DigitalInput ForwardStop = new DigitalInput(RobotMap.ARM_Forward_Stop);
	private DigitalInput ReverseStop = new DigitalInput(RobotMap.ARM_Reverse_Stop);
	private DoubleSolenoid FoldingPiston = new DoubleSolenoid(RobotMap.ARM_FoldingPiston_ForwardChannel, RobotMap.ARM_FoldingPiston_ReverseChannel);
   
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 public boolean GetForwardLimitSwitch() {
		 return ForwardStop.get();
	 }
	 public boolean GetReverseLimitSwitch() {
		 return ReverseStop.get();
	 }
	 public void moveArm(double speed) {
		 SmartDashboard.putString("moveArm called from Arm Subsystem", " ");
		 if (speed < 0.2 || getArmPot() < 4.8 || getArmPot() > 2.1) {
			 ArmVictor.set(speed);
		 }
	 }
	 public double getArmPot() {
		 return NeoUtil.VoltsToDegrees(ArmPot.getVoltage());
	 }
	 public double getArmEncoder() {
		 return ArmEncoder.get();
	 }
	 public void FoldArm() {
		 FoldingPiston.set(DoubleSolenoid.Value.kForward);
	 }
	 public void UnfoldArm() {
		 FoldingPiston.set(DoubleSolenoid.Value.kReverse);
	 }

    public void initDefaultCommand() {
    	//setDefaultCommand(new MoveArm());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
=======
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
				 				 Arm_encoder_invert, EncodingType.k4X);
		armEncoder.setName(Arm_encoder_name);
		armEncoder.reset();
		
	}

	public void initializePot() {
		armPot = new AnalogInput(Arm_pot_channel);
	}
	
	public void initializeLimitSwitch() {
		forwardLimitSwitch = new DigitalInput(Arm_limiter_forwardPort);
		reverseLimitSwitch = new DigitalInput(Arm_limiter_reversePort);
	}
	
	public void initializeFoldingPiston() {
		foldingPiston = new DoubleSolenoid(Arm_fold_forwardPort, Arm_fold_reversePort);
		foldingPiston.set(isFolded ? DoubleSolenoid.Value.kForward :
								   	 DoubleSolenoid.Value.kReverse);
	}
	
	//------------------------------------------//
	
	public void setArmVictor(double speed) {
		armVictor.set(speed);
	}

	//------------------------------------------//
	
	public double getArmEncoder() {
		return armEncoder.get();
	}
>>>>>>> origin/Devon

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
	
