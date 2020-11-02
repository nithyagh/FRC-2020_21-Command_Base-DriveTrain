/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class DriveForwardTimed extends CommandBase {
  /**
   * Creates a new DriveForwardTimed.
   */

  private final DriveTrain m_driveTrain;
  private boolean isFinished = false;
  private Timer m_timer;

  public DriveForwardTimed(DriveTrain dt) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_driveTrain = dt;
    addRequirements(m_driveTrain);
    m_timer = new Timer();

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_timer.reset();

    isFinished = false;
    m_timer.start();
    m_driveTrain.arcadeDrive(Constants.Autonomous.driveForwardSpeed, Constants.Autonomous.driveForwardTurn);
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if ( m_timer.get() < Constants.Autonomous.driveForwardTime){
      m_driveTrain.arcadeDrive(Constants.Autonomous.driveForwardSpeed, Constants.Autonomous.driveForwardTurn);
    }

    else{
      //m_driveTrain.stop();
      isFinished = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_driveTrain.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }
}
