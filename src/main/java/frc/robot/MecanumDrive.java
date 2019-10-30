package frc.robot;

import edu.wpi.first.wpilibj.Spark;

public class MecanumDrive {

  private Spark frontLeft;
  private Spark frontRight;
  private Spark backLeft;
  private Spark backRight;

  public MecanumDrive(int frontLeft, int frontRight, int backLeft, int backRight) {
    this.frontLeft = new Spark(frontLeft);
    this.frontRight = new Spark(frontRight);
    this.backLeft = new Spark(backLeft);
    this.backRight = new Spark(backRight);
  }

  public void move(double speed, double strafe, double turn) {
    frontLeft.set(speed - strafe - turn);
    frontRight.set(speed + strafe + turn);
    backLeft.set(speed + strafe - turn);
    backRight.set(speed - strafe + turn);
  }
}
