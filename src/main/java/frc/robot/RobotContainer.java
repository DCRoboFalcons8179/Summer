// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Comands.ArmMove;
import frc.robot.Comands.SpeedDown;
import frc.robot.Comands.SpeedUp;
import frc.robot.Subsystems.ArmControl;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }

  private final ArmControl armControl = new ArmControl();
  
  private final CommandXboxController xboxController = new CommandXboxController(Constants.controllerPort);

  private void configureBindings() {
    buttonComands();
  }

  public void periodic() {
    SmartDashboard.putNumber("Speed", Constants.Arm.speed);
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

  private void buttonComands() {
    xboxController.a().whileTrue(new ArmMove(() -> 0.5, armControl));
    xboxController.a().whileFalse(new ArmMove(() -> 0, armControl));
    
    xboxController.b().whileTrue(new ArmMove(() -> -0.5, armControl));
    xboxController.b().whileFalse(new ArmMove(() -> 0, armControl));

    xboxController.povUp().onTrue(new SpeedUp(0.05));
    xboxController.povDown().onTrue(new SpeedDown(-0.05));
  }

}
