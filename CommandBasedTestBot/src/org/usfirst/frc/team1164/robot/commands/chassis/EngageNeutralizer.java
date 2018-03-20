package org.usfirst.frc.team1164.robot.commands.chassis;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;

import edu.wpi.first.wpilibj.command.Command;



public class EngageNeutralizer extends Command {

    public EngageNeutralizer() {}

    protected void initialize() {}

    protected void execute() {
    	if (!kChassis.getGear()) {
    		kChassis.setNeutralizer(true);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
