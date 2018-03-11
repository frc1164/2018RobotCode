package org.usfirst.frc.team1164.robot.commands.chassis;

import static org.usfirst.frc.team1164.robot.Robot.kChassis;

import edu.wpi.first.wpilibj.command.Command;

public class EngagePTO extends Command {

    public EngagePTO() {}

    protected void initialize() {}

    protected void execute() {
    	kChassis.setPTO(true);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
