package frc.robot;

import edu.wpi.first.wpilibj.Spark;

/**
 * A class used to interface with a mecanum
 * wheel drivetrain.
 */
public class MecanumDrive {
  //Drive base motor interfaces
  private final Spark frontLeft;
  private final Spark frontRight;
  private final Spark backLeft;
  private final Spark backRight;

  /**
   * Initialize motor interfaces
   */
  public MecanumDrive(int frontLeft,
                      int frontRight, int backLeft, int backRight) {
    this.frontLeft = new Spark(frontLeft);
    this.frontRight = new Spark(frontRight);
    this.backLeft = new Spark(backLeft);
    this.backRight = new Spark(backRight);
  }

  /**
   * Adjust rotation velocity and directional
   * velocity. Expected input range: -1 to 1.
   *
   * @param forward forward velocity
   * @param strafe  rightward velocity
   * @param turn    clockwise rotation velocity
   */
  public void speed(double forward, double strafe,
                    double turn) {


    //This ensures the absolute value sum of all
    //velocities is 1 or under.
    double forwardR = forward / (1 +
      Math.abs(strafe) + Math.abs(turn));
    double strafeR = strafe / (1 +
      Math.abs(forward) + Math.abs(turn));
    double turnR = turn / (1 +
      Math.abs(strafe) + Math.abs(forward));

    frontLeft.set(-(forwardR + strafeR + turnR));
    frontRight.set(forwardR - strafeR - turnR);
    backLeft.set(-(forwardR - strafeR + turnR));
    backRight.set(forwardR + strafeR - turnR);
  }
}
