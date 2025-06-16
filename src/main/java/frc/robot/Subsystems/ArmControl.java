// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;


import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmControl extends SubsystemBase {
  /** Creates a new ArmControl. */

  TalonSRX armControl = new TalonSRX(14);

  public ArmControl() {
    TalonSRXConfiguration armControlConfiguration = new TalonSRXConfiguration();
  
    armControlConfiguration.slot0.kP = Constants.Arm.kP;
    armControlConfiguration.slot0.kI = Constants.Arm.kI;
    armControlConfiguration.slot0.kD = Constants.Arm.kD;

    armControl.getAllConfigs(armControlConfiguration);
    armControl.setSelectedSensorPosition(0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Arm Position", armControl.getSelectedSensorPosition());
    // This method will be called once per scheduler run
  }

  public void movePercentOut(double power){
    armControl.set(TalonSRXControlMode.PercentOutput, power);
  }

  public void movePosition(double position) {
    armControl.set(TalonSRXControlMode.Position, position);
  }
}
