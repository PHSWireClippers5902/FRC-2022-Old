package frc.robot.commands; 

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//This code turns front and back pistons off 

public class goEvenFaster extends Command {

  // Called just before this Command runs the first time
  @Override
  protected void initialize() 
  {
    Robot.testSystem.gofaster(0.5);
  }

  public boolean isFinished()
  {
    return false;
}


  protected void end(){

  }

  
}