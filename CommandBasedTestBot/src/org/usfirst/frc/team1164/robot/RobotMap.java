/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	/* For example to map the left and right motors, you could define the
	following variables to use with your drivetrain subsystem.
	public static int leftMotor = 1;
	public static int rightMotor = 2;

	If you are using multiple modules, make sure to define both the port
	number and the module. For example you with a rangefinder:
	public static int rangefinderPort = 1;
	public static int rangefinderModule = 1;
	*/
		
// base robot options
	// Subsystem names
	/** 
	 * These are defined in robot/Robot.java
	 * Chassis = kChassis
	 * Claw = kClaw
	 * Winch = kWinch
	 */
	
	
// controller options
	
	public static final int LTriggerAxis = 2;
	public static final int RTriggerAxis = 3;
	public static final int LAxis = 0;
	public static final int RAxis = 4;
	public static final int driverPort = 0;
	public static final int operatorPort = 1;

	
// chassis options
	// victors
	public static final int CHV_Left_1 = 0;
	public static final int CHV_Left_2 = 1;
	public static final int CHV_Left_3 = 2;
	
	public static final int CHV_Right_1 = 13;
	public static final int CHV_Right_2 = 14;
	public static final int CHV_Right_3 = 15;
	
	public static final double speedReducer = 1;	
	
	// encoders
	public static final int CHE_Left_channelA = 0;
	public static final int CHE_Left_channelB = 1;
	public static final boolean CHE_Left_reversed = true;
	
	public static final int CHE_Right_channelA = 2;
	public static final int CHE_Right_channelB = 3;
	public static final boolean CHE_Right_reversed = false;
	
	public static final double kDistancePerPulse = 0.249364;
	
	//transmission
	public static final int CHT_Forward_Channel = 0;
	public static final int CHT_Reverse_Channel = 1;
	
	//Neutralizer
	public static final int CHN_Left_Channel = 0;
	public static final int CHN_Right_Channel = 1;
	public static final double CHN_Left_DisengageAngle = .8888;
	public static final double CHN_Left_EngageAngle = .35;
	public static final double CHN_Right_DisengageAngle = .5;
	public static final double CHN_Right_EngageAngle = .8888;
	
	//PTO
	public static final int CHP_Forward_Channel = 3;
	public static final int CHP_Reverse_Channel = 2;


// claw options
	public static final int CL_Forward_Channel = 4;
	public static final int CL_Reverse_Channel = 5;
	
// arm options
	public static final int ARM_Victor_Channel = 3;
	public static final int ARM_Encoder_ChannelA = 4;
	public static final int ARM_Encoder_ChannelB = 5;
	public static final boolean ARM_Encoder_IsInverted = false;
	public static final CounterBase.EncodingType ARM_Encoder_EncodingType = CounterBase.EncodingType.k4X; //k is for konstant
	public static final int ARM_Pot_Channel = 0;
	public static final int ARM_Forward_Stop = 6;
	public static final int ARM_Reverse_Stop = 7;
	public static final int ARM_FoldingPiston_ForwardChannel = 6;
	public static final int ARM_FoldingPiston_ReverseChannel = 7;

}
