package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Spark;

//TODO at what point is the cannon considered disarmed? at what point is the airTank considered full?
/*A Cannon consists of any valves,
 * pressurized chambers, and 
 * compressors.*/
public class Cannon {
	//Default valve open duration
	//when cannon is fired.
	private static final double
		DEFAULT_FIRE = 0.5;

	//how long air tank's
	//compressor ran in total
	//since tankTime reset.
	//TODO not fully implemented
	private double tankTime =
		0.0;

	//Used to pressurize
	//cannon's air tank.
  private Spark compressor;
  //How long the compressor is
  //set to run for since its
  //timer has been reset.
  //(compressor Time)
  private double compTime = 
  	0.0;
  //Used as a stop watch to
  //keep track of compressor
  //on duration.
  //(compressor timer)
  private Timer compTimer;
  
  //valve controlling whether
  //pressurized chamber is open
  //to cannon barrel.
  private DigitalOutput valve;
  //How long the valve is
  //set to be open for since 
  //its timer has been reset.
  private double valveTime = 
  	0.0;
  //Used as a stop watch to
  //keep track of valve
  //open duration.
  private Timer valveTimer;
  
  //Is cannon ready to fire?
  private boolean isArmed =
		false;
	//Does air tank contain
	//pressure?
	private boolean hasPressure =
		false;
	//Is compressor finished
	//pressurizing the air tank?
	private boolean isFinished =
		false;
	//number of times cannon
	//was fired since it was
	//considered armed
	private int numFired =
		0;
  
  /**assign Cannon to pins*/
	public Cannon(
		//pwm pin for compressor
		Spark compressor,
		//TODO what kind of pin is valve assigned?
		DigitalOutput valve) {
		this.compressor = 
			compressor;
		this.valve = valve;
		
		this.compTimer.reset();
		this.valveTimer.reset();
	}
	/**
	 *Updates state of cannon
	 *components based on time
	 *they've ran.
	 */
	public void update() {
		//update compressor state
		if(compTime >
			compTimer.get())
			compressor.set(1);
		else
			compressor.set(0);
		
		//update valve state
		//TODO is false closed and true open?
		if(valveTime >
			valveTimer.get())
			valve.set(true);
		else
			valve.set(false);
			
		//update isFinished state
		if(compTimer.get() >
			compTime &&
			!isFinished)
			isFinished = true;
		
		//update isArmed state
		if(isFinished &&
			hasPressure &&
			!isArmed) {
			isArmed = true;
			numFired = 0;
		}
	}
	
	/**
	 * turns on air tank's
	 * compressor for a set 
	 * amount of time.
	 */
	public void arm(
		//Time compressor will run
		double compTime) {
		this.compTime =
			compTime;
		compTimer.reset();
		hasPressure = true;
		isFinished = false;
	}
	
	/**
	 * sets cannon to a
	 * disArmed state
	 */
	public void disArm() {
		fire(2.0);
		isArmed = false;
		hasPressure = false;
	}
	
	/**
	 * open air tank to cannon
	 * barrel for given amount
	 * of time.
	 * (fire the cannon)
	 */
	public void fire(
		//Time valve is opened for
		double valveTime) {
		this.valveTime =
			valveTime;
		valveTimer.reset();
		++numFired;
	}
	
	public void fire() {
		this.fire(DEFAULT_FIRE);
	}
	
	/**
	 * Is cannon ready to fire?
	 */
	public boolean isArmed() {
		return isArmed;
	}
	
	/**
	 * Is compressor finished
	 * running?
	 */
	public boolean isFinished() {
		return isFinished;
	}
	
	/**
	 * Does air tank potentially
	 * contain air pressure?
	 */
	public boolean hasPressure() {
		return hasPressure;
	}
}
