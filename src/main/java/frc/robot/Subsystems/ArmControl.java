// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
import com.ctre.phoenix6.configs.Slot0Configs;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmControl extends SubsystemBase {
  /** Creates a new ArmControl. */

  TalonSRX ArmControl = new TalonSRX(14);

  public ArmControl() {
    TalonSRXConfiguration ArmControlConfiguration = new TalonSRXConfiguration();
  
    ArmControlConfiguration.slot0.kP = 1;
    ArmControlConfiguration.slot0.kI = 0;
    ArmControlConfiguration.slot0.kD = 0;

    ArmControl.getAllConfigs(ArmControlConfiguration);
    
    ArmControl.setNeutralMode(NeutralMode.Brake);

    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Move(double power){
    
  }
}
