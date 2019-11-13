package frc.robot;

public class Cannon{

    private final double mass = 1.0;

    private double angle = 45;
    private final double V0 = 1.0; //initail vilocity 

    
    private double g = 9.8; //gravity
    public void calculation(){
        //two equations for projectile and stairs
        // y = V0 * x * Math.sin(angle / 180 * Math.PI) - .5 * g * x * x;
        //y = Math.tan(angle / 180 * Math.PI) * x;
        double distance = V0 * V0 / g * Math.sin(2 * angle / 180 * Math.PI);

    }




}








