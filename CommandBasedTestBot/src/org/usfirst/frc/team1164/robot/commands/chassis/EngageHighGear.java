package org.usfirst.frc.team1164.robot.commands.chassis;

import edu.wpi.first.wpilibj.command.Command;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;

public class EngageHighGear extends Command {

    public EngageHighGear() {}

    protected void initialize() {}

    protected void execute() {
    	kChassis.setGear(true);	
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
