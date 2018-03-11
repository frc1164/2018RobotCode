/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

<<<<<<< HEAD
import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;


=======
>>>>>>> origin/Devon
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public final class RobotMap {
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

	//---------------------------------------------------//
	//													 //
	// 					Starting Options				 //
	//													 //
	//---------------------------------------------------//
	public static final boolean CH_neutralizerEnabled = false;
	public static final boolean CH_highGearEnabled = false;
	public static final boolean CH_PTOEnabled = false;
	
	public static final boolean Cl_isOpen = false;
	
	public static final boolean Arm_isFolded = false;
	

	//---------------------------------------------------//
	//													 //
	// 					chassis options					 //
	//													 //
	//---------------------------------------------------//
	
	public static final double 	Drive_turnModifier		= 0.5;
	
	public static final String 	CH_name 				= "Chassis";
	public static final String	CH_nav_name				= "Navx";
	
	//---------------------= Motors =--------------------//

	public static final double 	CH_victor_speedReducer	= 1;
	
	public static final int 	CH_victor_left1_port 	= 0;
	public static final boolean CH_victor_left1_invert 	= true;
	public static final String 	CH_victor_left1_name 	= "Left Motor 1";
	
	public static final int 	CH_victor_left2_port 	= 1;
	public static final boolean CH_victor_left2_invert 	= false;
	public static final String 	CH_victor_left2_name 	= "Left Motor 2";
	
	public static final int 	CH_victor_left3_port 	= 2;
	public static final boolean CH_victor_left3_invert 	= false;
	public static final String 	CH_victor_left3_name 	= "Left Motor 3";

	public static final int 	CH_victor_right1_port 	= 13;
	public static final boolean CH_victor_right1_invert	= true;
	public static final String 	CH_victor_right1_name 	= "Right Motor 1";
	
	public static final int 	CH_victor_right2_port 	= 14;
	public static final boolean CH_victor_right2_invert = true;
	public static final String 	CH_victor_right2_name 	= "Right Motor 2";
	
	public static final int 	CH_victor_right3_port 	= 15;
	public static final boolean CH_victor_right3_invert = false;
	public static final String 	CH_victor_right3_name 	= "Right Motor 3";
	
	//-------------------= Encoders =--------------------//

<<<<<<< HEAD
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

=======
	public static final double 	CH_encoder_DPP			= 0.249364;
	
	public static final int 	CH_encoder_left_APort	= 0;
	public static final int 	CH_encoder_left_BPort	= 1;
	public static final boolean CH_encoder_left_invert 	= false;
	public static final String	CH_encoder_left_name	= "Left Drive Encoder";

	public static final int 	CH_encoder_right_APort	= 2;
	public static final int 	CH_encoder_right_BPort	= 3;
	public static final boolean CH_encoder_right_invert = true;
	public static final String	CH_encoder_right_name	= "Left Drive Encoder";
	
	//-------------------- Gear Box ---------------------//
								// transmission
	public static final int 	CH_trans_forwardPort 	= 0;
	public static final int 	CH_trans_reversePort 	= 1;
	
	public static final int 	CH_PTO_forwardPort 		= 3;
	public static final int 	CH_PTO_reversePort 		= 2;
	
	public static final int 	CH_neut_left_port		= 1;
	public static final double 	CH_neut_left_enable		= 1;
	public static final double 	CH_neut_left_disable	= .25;
	
	public static final int 	CH_neut_right_port		= 0;
	public static final double 	CH_neut_right_enable	= 0;
	public static final double 	CH_neut_right_disable	= .75;

	//---------------------------------------------------//
	//													 //
	// 					Claw options					 //
	//													 //
	//---------------------------------------------------//
	
	public static final int 	Cl_forwardPort			= 5;
	public static final int 	CL_reversePort			= 4;

	//---------------------------------------------------//
	//													 //
	// 					Arm options					 	 //
	//													 //
	//---------------------------------------------------//
	
	public static final String	Arm_name				= "Arm";
	
	public static final int 	Arm_victor_port 		= 3;
	public static final boolean Arm_victor_inverted 	= false;
	public static final String	Arm_victor_name			= "Arm motor";
	
	public static final int 	Arm_encoder_APort		= 4;
	public static final int 	Arm_encoder_BPort		= 5;
	public static final boolean Arm_encoder_invert 		= false;
	public static final String 	Arm_encoder_name		= "Arm Encoder";
	
	public static final int 	Arm_pot_channel 		= 3;
	public static final int 	Arm_limiter_forwardPort = 6;
	public static final int 	Arm_limiter_reversePort = 7;
	public static final int 	Arm_fold_forwardPort 	= 6;
	public static final int 	Arm_fold_reversePort 	= 7;

	public static final double 	Arm_limit_top			= 4.55;
	public static final double	Arm_limit_bot			= 2.1;
	public static final double	Arm_limit_bot_folded	= 3.99;
	public static final double 	Arm_limit_top_speed		= 0.40;
	public static final double 	Arm_limit_bot_speed		= 0.1;
	
>>>>>>> origin/Devon
}
