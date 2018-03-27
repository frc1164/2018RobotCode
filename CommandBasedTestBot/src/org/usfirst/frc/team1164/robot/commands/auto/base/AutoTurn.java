package org.usfirst.frc.team1164.robot.commands.auto.base;

import org.usfirst.frc.team1164.logic.motionProfiler.PIDMotion;
import org.usfirst.frc.team1164.logic.motionProfiler.PIDVMotion;
import static org.usfirst.frc.team1164.robot.Robot.kChassis;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class AutoTurn extends Command {
	
	private double TurnAngle;
	private double Speed;
	private PIDMotion turnController;

    public AutoTurn(double TurnAngle, double Speed) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(kChassis);
    	
    	Preferences pref = Preferences.getInstance();
    	
    	this.TurnAngle = TurnAngle;
    	this.Speed = Speed;
    	
    	DriverStation.reportError("construct AutoTurn", true);
    	
    	turnController = new PIDVMotion(pref.getDouble("TurnMaxA", 0.0), 
				   						pref.getDouble("TurnMaxV", 0.0),
				   						pref.getDouble("TurnP", 0.0),
				   						pref.getDouble("TurnI", 0.0),
				   						pref.getDouble("TurnD", 0.0),
				   						pref.getDouble("TurnV", 0.0));	
    	
    }
    
    public AutoTurn(double TurnAngle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(kChassis);
    	
    	Preferences pref = Preferences.getInstance();
    	
    	this.TurnAngle = TurnAngle;
    	//this.Speed = Speed;
    	
    	DriverStation.reportError("construct AutoTurn", true);
    	
    	turnController = new PIDVMotion(pref.getDouble("TurnMaxA", 0.0), 
				   						pref.getDouble("TurnMaxV", 0.0),
				   						pref.getDouble("TurnP", 0.0),
				   						pref.getDouble("TurnI", 0.0),
				   						pref.getDouble("TurnD", 0.0),
				   						pref.getDouble("TurnV", 0.0));	
    	
    	turnController.setEndpoint(TurnAngle);
    	
    	SmartDashboard.putNumber("turnAccelBlockLength", turnController.getAccelLength());
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	kChassis.resetNavx();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// small random number to update smart dashboard.
    	double srn = 0.001 * (Math.random() - 0.5);
		
		double actualTurn = kChassis.getNavxAngle();
		
		double speed = turnController.getOutput(actualTurn);
		
		kChassis.setLeftSpeed(speed);
		kChassis.setRightSpeed(-speed);
		
		SmartDashboard.putNumber("Distance", actualTurn+srn);
		SmartDashboard.putNumber("turnControllerOutput", speed);
		SmartDashboard.putNumber("LeftEncoder", kChassis.getLeftEncoder());
		SmartDashboard.putNumber("RightEncoder", kChassis.getRightEncoder());
		SmartDashboard.putNumber("turnActual", actualTurn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return turnController.isDone(10, 5.0);
//    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
