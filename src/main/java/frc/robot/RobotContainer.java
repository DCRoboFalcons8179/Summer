// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Comands.ArmMove;
import frc.robot.Subsystems.ArmControl;

public class RobotContainer {
  public RobotContainer() {
    configureBindings();
  }


  private final ArmMove armMove = new ArmMove();
  private final ArmControl armControl = new ArmControl();

  private final XboxController m_driveControler = new XboxController(0);

  private final JoystickButton aButton = new JoystickButton(m_driveControler, XboxController.Button.kA.value);

  private void configureBindings() {
aButton.whileTrue(new ArmMove(() -> 0.5, armControl));
        aButton.whileFalse(new ArmMove(() -> 0, armControl));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
  private void buttonComands() {
    
          }

}
