/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriverInput extends Command {
  public DriverInput() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.drivetrain);
    requires(Robot.limelight);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.limelight.SetVisionProcessingMode(1, 1);

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double forward;
    double twist;

    forward = Robot.drivetrain.CalculateControllerValue(.3, Robot.m_oi.driver, true, "Y");
    twist = Robot.drivetrain.CalculateControllerValue(.3, Robot.m_oi.driver, false, "Z");

    Robot.drivetrain.inputdrive(forward, twist);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
