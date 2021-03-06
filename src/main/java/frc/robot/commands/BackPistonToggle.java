package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

//This code toggles on and off the two back pistons with a toggleWhenPressed button in OI

public class BackPistonToggle extends Command {

  public BackPistonToggle() {
    requires(Robot.pneumaticSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.pneumaticSystem.offBackPistons();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.pneumaticSystem.onBackPistons();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.pneumaticSystem.offBackPistons();
  }


  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
