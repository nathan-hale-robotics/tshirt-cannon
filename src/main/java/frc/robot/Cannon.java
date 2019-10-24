package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Spark;

/*A Cannon consists of any valves,
 * pressurized chambers, and 
 * compressors.*/
public class Cannon {
	/*Used as a stop watch to
   * keep track of compressor
   * on duration (compressor time)*/
  private Timer compTime;
	//general timer/stop-watch
  //private Timer timer;
  private Spark compressor;
  //is compressor running?
  private boolean runningCompressor = 
  	false;
  /*valve controlling whether
   * pressurized chamber is open
   * to cannon barrel.*/
  private DigitalOutput valve;
  
  /**assign Cannon to pins*/
	public Cannon(
		//pwm pin for compressor
		Spark compressor,
		//TODO what kind of pin is valve assigned?
		DigitalOutput valve) {
		this.compressor = 
			compressor;
		this.valve = valve;
		//set timer to 0
		this.compTime.reset();
	}

}
