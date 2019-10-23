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

  @Override
  public void robotInit() {
    // loads the first joystick attached
    joystick = new Joystick(0);
    // sets the pin 0 to be a Spark (motor)
    compressor = new Spark(0);
    // sets the pin 1 to be a DigitalOutput (toggle output)
    valve = new DigitalOutput(1);
  }

  @Override
  public void teleopPeriodic() {
    // will run the compressor
    // can set the value to 0.5, if want to run at half speed
    if (runningCompressor) {
      compressor.set(1);
    } else {
      compressor.set(0);
    }
    // will toggle the compressor if the user presses a button
    if (joystick.getRawButtonPressed(1)) {
      runningCompressor = !runningCompressor;
    }
    // will open the valve as long as the trigger is pressed
    if (joystick.getRawButton(0)) {
      valve.set(true);
    } else {
      valve.set(false);
    }
  }
}
