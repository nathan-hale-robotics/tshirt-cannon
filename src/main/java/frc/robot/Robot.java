package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  private DifferentialDrive drive;
  private Joystick driveStick;

  @Override
  public void robotInit() {
    drive = new DifferentialDrive(new Spark(0), new Spark(1));
    driveStick = new Joystick(0);
  }

  @Override
  public void teleopPeriodic() {
    drive.arcadeDrive(driveStick.getX(), driveStick.getY());
  }
}
