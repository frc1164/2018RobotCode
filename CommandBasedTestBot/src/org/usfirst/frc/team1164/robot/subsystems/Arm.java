package org.usfirst.frc.team1164.robot.subsystems;

import org.usfirst.frc.team1164.logic.NeoUtil;
import org.usfirst.frc.team1164.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogPotentiometer;


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
   
	public Arm() {
		ArmVictor.setInverted(true);
	}
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	 public boolean GetForwardLimitSwitch() {
		 return ForwardStop.get();
	 }
	 public boolean GetReverseLimitSwitch() {
		 return ReverseStop.get();
	 }

  public void moveArmDown(double speed) {
//		 if (speed < 0.2 && getArmEncoder() > 2.1) {
			 ArmVictor.set(speed);
//		 } else {
//			 ArmVictor.set(0);
//		 }
	 }
	 
	 public void moveArmUp(double speed) {
//		 if (speed < 0.2 && getArmEncoder() < 4.94) {
			 ArmVictor.set(speed);
//		 } else {
//			 ArmVictor.set(0);
//		 }
	 }
	 
	 public void armBreak() {
		 ArmVictor.set(0);
	 }

	 public double getArmPot() {
		 return NeoUtil.VoltsToDegrees(ArmPot.getVoltage());
	 }
	 public double getArmEncoder() {
		 return ArmPot.getVoltage();

	 }
	 public void FoldArm() {
		 FoldingPiston.set(DoubleSolenoid.Value.kForward);
	 }
	 public void UnfoldArm() {
		 FoldingPiston.set(DoubleSolenoid.Value.kReverse);
	 }
	 
	 public enum ArmPositions{
		 Low, Scale, Switch
	 }

    public void initDefaultCommand() {
    	//setDefaultCommand();
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

