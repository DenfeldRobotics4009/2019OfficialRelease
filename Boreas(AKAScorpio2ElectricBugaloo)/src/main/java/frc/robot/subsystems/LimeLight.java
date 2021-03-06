/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.Lime;
 
/**
 * @author Nikolai (AdmiralTyhard)
 */
public class LimeLight extends Subsystem {
  public NetworkTable camera, ubs;
  public NetworkTableEntry tx;
  public NetworkTableEntry cameraMode;
  public NetworkTableEntry ledMode; 

  public LimeLight() {
    camera = NetworkTableInstance.getDefault().getTable("limelight");
    tx = camera.getEntry("tx");
    cameraMode = camera.getEntry("cameraMode");
    ledMode = camera.getEntry("ledMode");  
    

  }
  
  public void SetVisionProcessingMode(int color, int light) {
    cameraMode.setDouble(color);
    ledMode.setDouble(light);

  }

  @Override
  public void initDefaultCommand() {
    //setDefaultCommand(new Lime());
    // setDefaultCommand(new MySpecialCommand());
  }
}
