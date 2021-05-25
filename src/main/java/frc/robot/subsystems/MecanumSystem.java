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

        if (Math.abs(rightTriggerValue) > threshold || Math.abs(leftStickXValue) > threshold ){
            /*
            RobotMap.driveMainRight.set((rightTriggerValue-leftStickXValue)/2);
            RobotMap.driveMainLeft.set((rightTriggerValue-leftStickXValue)/2);
            RobotMap.driveFollowRight.set((rightTriggerValue-leftStickXValue)/2);
            RobotMap.driveMainLeft.set((rightTriggerValue-leftStickXValue)/2);
            */
            double forward = rightTriggerValue * 0.5;
            RobotMap.frontRightWheel.set(-forward);
            RobotMap.backRightWheel.set(-forward);
            RobotMap.frontLeftWheel.set(forward);
            RobotMap.backLeftWheel.set(forward);
        } else{
            RobotMap.frontRightWheel.set(0);
            RobotMap.frontLeftWheel.set(0);
            RobotMap.backRightWheel.set(0);
            RobotMap.backLeftWheel.set(0);  
        }

            /*
        if (Math.abs(RightStickXValue) > threshold){
            RobotMap.driveMainRight.set(RightStickXValue/2);
            RobotMap.driveMainLeft.set(RightStickXValue/2);
            RobotMap.driveFollowRight.set(RightStickXValue/2);
            RobotMap.driveMainLeft.set(leftStickXValue/2);
        }
        */

        System.out.println("StickX " + leftStickXValue + "StickY " + rightTriggerValue);
    }


   





}

