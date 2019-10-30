package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  private Joystick joystick;
  private Spark compressor;
  private boolean runningCompressor = false;
  private DigitalOutput valve;
  private MecanumDrive driveBase;

  @Override
  public void robotInit() {
    joystick = new Joystick(0);
    compressor = new Spark(0);
    valve = new DigitalOutput(1);
    
    driveBase = new MecanumDrive(1, 2, 3, 4);
  }

  @Override
  public void teleopPeriodic() {
    //Cannon code
    if (runningCompressor) {
      compressor.set(1);
    } else {
      compressor.set(0);
    }
    if (joystick.getRawButtonPressed(1)) {
      runningCompressor = !runningCompressor;
    }
    if (joystick.getRawButton(0)) {
      valve.set(true);
    } else {
      valve.set(false);
    }
    
    //Drive-base code
    driveBase.speed(joystick.getY(), 
      joystick.getX(), joystick.getZ());
  }
}
