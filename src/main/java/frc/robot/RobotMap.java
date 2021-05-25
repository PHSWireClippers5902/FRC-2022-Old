package frc.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Ultrasonic;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class RobotMap {

    public static WPI_TalonSRX driveMainRight = new WPI_TalonSRX(1);
    public static WPI_TalonSRX driveMainLeft = new WPI_TalonSRX(2);
    public static WPI_TalonSRX driveFollowRight = new WPI_TalonSRX(3);
    public static WPI_TalonSRX driveFollowLeft = new WPI_TalonSRX(4);

    //public static DifferentialDrive diffDrive = new DifferentialDrive(driveMainLeft, driveMainRight);
    public static SpeedController lightsR;
    public static SpeedController lightsL;
    // Pneumatics
    public static Compressor compressor;
    public static Solenoid frontSolenoid;
    public static Solenoid backSolenoid;
    public static Solenoid topSolenoid;

    public static Ultrasonic ultra;

    // SERVO THING

    public static void init() {
        //diffDrive.setSafetyEnabled(true);
        //diffDrive.setExpiration(0.1);
        //diffDrive.setMaxOutput(1.0);
        //diffDrive.setDeadband(0.2);
        driveMainLeft.configOpenloopRamp(0.5);
        driveMainRight.configOpenloopRamp(0.5);
        driveFollowLeft.configOpenloopRamp(0.5);
        driveFollowRight.configOpenloopRamp(0.5);

        // Lights
        lightsR = new Spark(0);
        lightsL = new Spark(3);

        // Create pneumaticSystem
        compressor = new Compressor(20);
        frontSolenoid = new SolenoidWrapper(20, 1);
        backSolenoid = new SolenoidWrapper(20, 0);
        topSolenoid = new SolenoidWrapper(20, 2);
        frontSolenoid.set(false);
        backSolenoid.set(false);
        topSolenoid.set(false);

    }
}