/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import frc.robot.RobotMap;


import frc.robot.Robot;
import edu.wpi.first.wpilibj.GenericHID.Hand;

public class MecanumSystem extends Subsystem {

    @Override
    protected void initDefaultCommand() {

    }

    private double threshold = 0.2;

    public void driveWithMecanum(){

        double rightTriggerValue = Robot.oi.getXbox().getTriggerAxis(Hand.kRight);
        double leftStickXValue = Robot.oi.getXbox().getX(Hand.kLeft);
        //double leftStickYValue = Robot.oi.getXbox().getY(Hand.kLeft);
        double RightStickXValue = Robot.oi.getXbox().getX(Hand.kRight);

        double forward = rightTriggerValue * 0.5;
        double x = leftStickXValue;
        double sideSpeed = 0.5;

        if (Math.abs(rightTriggerValue) > threshold || Math.abs(leftStickXValue) > threshold || Math.abs(RightStickXValue) > threshold ){
            if (Math.abs(rightTriggerValue) > threshold || Math.abs(leftStickXValue) > threshold){
                RobotMap.driveMainRight.set(-(forward-x));
                RobotMap.driveMainLeft.set(forward+x);
                RobotMap.driveFollowRight.set(-(forward-x));
                RobotMap.driveFollowLeft.set(forward+x);
            }if (RightStickXValue > threshold){
                RobotMap.driveMainRight.set(sideSpeed);
                RobotMap.driveMainLeft.set(sideSpeed);
                RobotMap.driveFollowRight.set(-sideSpeed);
                RobotMap.driveFollowLeft.set(-sideSpeed); 
            } if (RightStickXValue < -threshold){
                RobotMap.driveMainRight.set(-sideSpeed);
                RobotMap.driveMainLeft.set(-sideSpeed);
                RobotMap.driveFollowRight.set(sideSpeed);
                RobotMap.driveFollowLeft.set(sideSpeed);
            }
        } else{
            RobotMap.driveMainRight.set(0);
            RobotMap.driveMainLeft.set(0);
            RobotMap.driveFollowRight.set(0);
            RobotMap.driveFollowLeft.set(0);  
        }

        

        System.out.println("StickX " + leftStickXValue + "StickY " + rightTriggerValue);
    }


   





}

