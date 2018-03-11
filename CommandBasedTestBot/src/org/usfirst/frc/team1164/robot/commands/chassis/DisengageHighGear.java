package org.usfirst.frc.team1164.robot.commands.chassis;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DisengageHighGear extends Command {

    public DisengageHighGear() {}

    protected void initialize() {}

    protected void execute() {
    	kChassis.setGear(false);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
