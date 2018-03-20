package org.usfirst.frc.team1164.robot.commands.chassis;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;

import edu.wpi.first.wpilibj.command.Command;



public class DisengageNeutralizer extends Command {

    public DisengageNeutralizer() {}

    protected void initialize() {}

    protected void execute() {
    	if (!kChassis.getGear()) {
    		kChassis.setNeutralizer(false);
    	}
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
