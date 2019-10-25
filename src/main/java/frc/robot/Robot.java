package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;

public class Robot extends TimedRobot {
  private Joystick joystick;
  private Spark compressor;
  private boolean runningCompressor = false;
  private DigitalOutput valve;
  private Timer timer;

  @Override
  public void robotInit() {
    joystick = new Joystick(0);
    compressor = new Spark(0);
    valve = new DigitalOutput(1);
    timer = new Timer();
  }

  @Override
  public void teleopPeriodic() {
    if (runningCompressor) {
      compressor.set(1);
    } else {
      compressor.set(0);
    }
    if (joystick.getRawButtonPressed(1)) {
      runningCompressor = !runningCompressor;
    }
    if (joystick.getRawButtonPressed(0)) {
      timer.reset();
      timer.start();
    }
    valve.set(timer.get() < 0.5);
  }
}
