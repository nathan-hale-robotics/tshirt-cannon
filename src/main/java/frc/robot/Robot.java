package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
	/*drive represents a tank
	 *drivetrain. */
  private DifferentialDrive drive;
  /*interface for speed of right
   *motor.*/
  private Spark rMotor =
    new Spark(1);
  /*interface for speed of left
   *motor.*/
  private Spark lMotor =
    new Spark(0);
  //TODO how is the x,y,z coordinate plane mapped to the joystick?
  private Joystick driveStick;

  /**
   * robotInit (robot initialization)
   * is called when robot is turned
   * on.
   */
  @Override
  public void robotInit() {
  	/*TODO I am assuming the spark 
  	 * object lets you interface 
  	 * with a pwm signal that
  	 * indirectly controls the
  	 * motor connected to it.
  	 */
    drive = 
    	new DifferentialDrive(
    		lMotor,
    		rMotor;
    //TODO is port number usb port number?
    driveStick = 
    new Joystick(0);
  }

	/**
	 * teleop is called
	 * periodically (every m_period
	 * seconds) when the robot is
	 * in teleop mode.
	 */
  @Override
  public void teleopPeriodic() {
  	//set drivetrain's speeds
    drive.arcadeDrive(
    	//forward speed
    	driveStick.getX(), 
    	//clockwise rotation speed
    	driveStick.getY());
  }
}
