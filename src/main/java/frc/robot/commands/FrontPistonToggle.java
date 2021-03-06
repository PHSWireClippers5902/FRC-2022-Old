package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

//This code toggles on and off the two front pistons with a toggleWhenPressed button in OI
public class FrontPistonToggle extends Command {
  public FrontPistonToggle() {
    requires(Robot.pneumaticSystem);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    //Robot.pneumaticSystem.offFrontPistons();
    Robot.pneumaticSystem.toggleFrontPistons();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    //RobotMap.frontSolenoid.set(true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  /*
  @Override
  protected void cancel(){
    Robot.pneumaticSystem.
  }
*/

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
