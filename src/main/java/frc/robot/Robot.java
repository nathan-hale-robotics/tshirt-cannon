package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  /*interface for speed of right
   *motor.*/
  private Spark rMotor;
  /*interface for speed of left
   *motor.*/
  private Spark lMotor;
  //TODO how is the x,y,z coordinate plane mapped to the joystick?
  private Joystick driveStick;
  //general timer/stop-watch
  private Timer timer;
  //cannon that fires t-shirts
  private Cannon shirtCannon;

  /**
   * robotInit (robot initialization)
   * is called when robot is turned
   * on.
   */
  @Override
  public void robotInit() {
    //Assigning motors to PWM pins
    lMotor = new Spark(1);
    rMotor = new Spark(2);
    /*assigning driveStick to first
     * joystick plugged in*/
    driveStick = 
    new Joystick(0);
    
    shirtCannon =
     new Cannon(new Spark(0),
     	new DigitalOutput(1));
  }

	/**
	 * teleop is called
	 * periodically (every m_period
	 * seconds) when the robot is
	 * in teleop mode.
	 */
  @Override
  public void teleopPeriodic() {
  	
  }
}
