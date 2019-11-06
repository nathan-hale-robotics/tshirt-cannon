package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.TimedRobot;




public class Robot extends TimedRobot {
  private Joystick joystick;
  private Spark compressor;
  //these four motors are for the wheels
  Spark frontLeftMotor = new Spark(1);//M1----M2
  Spark rearLeftMotor = new Spark(2);//|   ^  |
  Spark frontRightMotor = new Spark(3);//|   |  |
  Spark rearRightMotor = new Spark(4);//M3----M4
  // motorHeight is for the motor that controls the angle of the cannon
  
  
  // motorHeight is for the motor that controls the angle of the cannon
  Spark motorHeight;
  private boolean runningCompressor = false;
  private DigitalOutput valve;

  @Override
  public void robotInit() {
    // loads the first joystick attached
    joystick = new Joystick(0);
    // sets the pin 0 to be a Spark (motor)
    compressor = new Spark(0);
    
    motorHeight = new Spark(5);
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
  public void operate(){
    double r = Math.hypot(joystick.getX(), joystick.getY());//the speed 
    double robotAngle = Math.atan2(joystick.getY(), joystick.getX() + Math.PI/4); 
    double rightX = joystick.getX();
    double v1 = r * Math.cos(robotAngle) + rightX; //vertical + horizontal movements
    double v2 = r * Math.sin(robotAngle) - rightX;
    double v3 = r * Math.sin(robotAngle) + rightX;
    double v4 = r * Math.cos(robotAngle) - rightX;
    
    frontLeftMotor.set(v1);
    frontRightMotor.set(v2);
    rearLeftMotor.set(v3);
    rearRightMotor.set(v4);

  }
  
  
  

  public void controlAngle() {
	 //uses two different buttons to control
	  //will increase the angle once it is pressed
	  if (joystick.getRawButton(7)) {
		  motorHeight.set(1);
	  }else {
		  motorHeight.set(0);
	  }
	  //decrease
	  if (joystick.getRawButton(8)) {
		  motorHeight.set(-1);
	  }else {
		  motorHeight.set(0);
	  }
  }
  
 
  
  
  
}
