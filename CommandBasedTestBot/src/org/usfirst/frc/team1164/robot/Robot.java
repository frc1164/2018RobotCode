/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team1164.robot;

import org.usfirst.frc.team1164.logic.DecissionMattrix;
import org.usfirst.frc.team1164.robot.commands.initialization.InitAuto;
import org.usfirst.frc.team1164.robot.commands.initialization.InitTeleop;
import org.usfirst.frc.team1164.robot.commands.initialization.InitTest;
import org.usfirst.frc.team1164.robot.subsystems.Arm;
import org.usfirst.frc.team1164.robot.subsystems.Chassis;
import org.usfirst.frc.team1164.robot.subsystems.Claw;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.hal.PDPJNI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	// physical robot systems
	public static final Chassis kChassis = new Chassis();
	public static final Claw kClaw = new Claw();
	public static final Arm kArm = new Arm();
	private static Compressor robotCompressor;
	
	// logic stuff
	public static OI m_oi;
	public static PDPJNI PDP = new PDPJNI();
	public static DecissionMattrix decider;
	
	
	//-------------------------------------------
	
	@Override
	public void robotInit() {
		m_oi = new OI();
		decider = new DecissionMattrix();
		CameraServer AxisCamera = CameraServer.getInstance();
		AxisCamera.addAxisCamera("10.11.64.13");
	}

	public void robotPeriodic() {
		LW.robot();
		SmartDashboard.putNumber("Arm encoder", kArm.getArmEncoder());
	}

	//-------------------------------------------
	
	@Override
	public void disabledInit() {}

	@Override
	public void disabledPeriodic() {
		LW.disabled();
		Scheduler.getInstance().run();
	}

	//-------------------------------------------

	private Command autoCommand;
	
	@Override
	public void autonomousInit() {
		autoCommand = new InitAuto();
		bootup(autoCommand);
	}
	
	@Override
	public void autonomousPeriodic() {
		LW.auto();
		Scheduler.getInstance().run();
	}

	//-------------------------------------------
	
	@Override
	public void teleopInit() {
		if (autoCommand != null) {
			autoCommand.cancel();
		}
		bootup(new InitTeleop());
	}

	@Override
	public void teleopPeriodic() {
		LW.teleop();
		Scheduler.getInstance().run();
	}
	
	//-------------------------------------------
	
	
	public void testInit() {}
	
	@Override
	public void testPeriodic() {
		LW.test();
		Scheduler.getInstance().run();
	}

	//-------------------------------------------
	
	public void bootup(Command c) {
		c.start();
	}
}
