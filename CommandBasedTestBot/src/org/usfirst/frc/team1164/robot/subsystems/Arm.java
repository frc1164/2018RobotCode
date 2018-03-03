package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {
	
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
	 public void RaiseArm() {
		 ArmVictor.set(.1);
	 }
	 public void LowerArm() {
		 ArmVictor.set(-.1);
	 }
	 public void StopArm() {
		 ArmVictor.set(0);
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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

