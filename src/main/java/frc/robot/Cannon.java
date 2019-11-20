package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;

public class Cannon {

  private final Joystick joystick;
  private Timer chargeDelay = new Timer();
  private int offset = 20;
  private boolean autoArm = false;
  private Spark airCompressor = new Spark(4);
  private DigitalInput pressureSwitch = new DigitalInput(0);

  public Cannon(Joystick joystick) {
    chargeDelay.start();
    this.joystick = joystick;
  }

  public void update() {
    if (joystick.getRawButton(3)) {
      autoArm = !autoArm;
    }
    if (pressureSwitch.get()) {
      chargeDelay.reset();
      offset = 0;
    }
    airCompressor.set(chargeDelay.get() + offset > 20 ? 1 : 0);
  }
}
