/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveTrain extends SubsystemBase {
  /**
   * Creates a new DriveTrain.
   */

  private final SpeedController m_leftMotor = new SpeedControllerGroup
    (new PWMTalonSRX(Constants.DriveConstants.leftFrontMotorPort) , new PWMTalonSRX(Constants.DriveConstants.leftBackMotorPort) );

  private final SpeedController m_rightMotor = new SpeedControllerGroup
    (new PWMTalonSRX(Constants.DriveConstants.rightFrontMotorPort) , new PWMTalonSRX(Constants.DriveConstants.rightBackMotorPort) ); 
    
  private final DifferentialDrive m_drive = new DifferentialDrive(m_leftMotor, m_rightMotor);


  public DriveTrain() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive( double speed, double rotation){
    m_drive.arcadeDrive(speed, rotation);
  }

  public void tankDrive( double leftSpeed, double rightSpeed){
    m_drive.tankDrive(leftSpeed, rightSpeed);
  }

  public void stop(){
    m_drive.stopMotor();
  }
}
