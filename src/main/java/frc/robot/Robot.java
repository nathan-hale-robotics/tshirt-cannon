package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
	//Joystick button values
	private static final int
		BUTTON_TRIGGER = 1;
		
	//Default time taken to
	//run compressor.
	private static final double
		PRESSURIZE_TIME = 20;
	

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
  //Is shirtCannon set to 
  //auto arm?
  private boolean autoArm =
  	false;

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
    //assigning driveStick to first
    //joystick plugged in.
    driveStick = 
    new Joystick(0);
    
    shirtCannon =
     new Cannon(new Spark(0),
     	new DigitalOutput(1));
     	
    shirtCannon.disArm();
  }

	/**
	 * teleop is called
	 * periodically (every m_period
	 * seconds) when the robot is
	 * in teleop mode.
	 */
  @Override
  public void teleopPeriodic() {
  	shirtCannon.update();
  	
  	//Disarm cannon and disable
  	//auto arming.
  	if(driveStick.
  		getRawButtonPressed(3)) {
  		shirtCannon.disArm();
  		autoArm = false;
  	}
  	//Toggle auto arming
  	if(driveStick.
  		getRawButtonPressed(2)) {
  		autoArm = !autoArm;
  	}
  	//Fire cannon when armed
  	if(driveStick.
  			getRawButtonPressed(
  			BUTTON_TRIGGER) &&
  			shirtCannon.isArmed()) {
  			shirtCannon.fire();
  	}
  	
  	//if cannon was fired more
  	//than 4 times since armed
  	//fully disarm the cannon.
  	//(prepare cannon for next arm)
  	if(shirtCannon.getNumFired() > 4) {
  		shirtCannon.disArm();
  	}
  	//auto arm cannon whenever
  	//disarmed
  	if(autoArm) {
  		shirtCannon.arm(
				PRESSURIZE_TIME);
  	}
  }
}
