package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

public class Test2 extends Subsystem{
    public void initDefaultCommand(){

    }

    public void gofaster(double speed){
        RobotMap.testMotor.set(speed);
    }
}