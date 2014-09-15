package orrery.bodies;

import orrery.util.Validators;

/**
 * @author ryanfox
 * @author maxspolaor
 */
public abstract class Body {
	/**
	 * Physical properties of a general gravitational body:
	 * i.e., star, planet, moon, asteroid.
	 * 
	 * @param mass Mass of the body, in kilograms. Must be greater than zero.
	 * @param radius Equatorial radius of the body, in meters. Must be greater than zero.
	 * @param magnitude Apparent magnitute of the body. It can be negative or positive. 
	 * 
	 */
	private double mass;
	private double radius;
	private double magnitude;
	

    /**
     * Base solar system body constructor.
     * @param mass Mass of the body, in kilograms.  Must be greater than zero.
     * @param radius Radius of the body, in meters.  Must be greater than zero.
     * @param magnitude Apparent magnitute of the body. It can be negative or positive.
     */
    public Body(double mass, double radius, double magnitude) {
        Validators.checkPositive(mass);
        Validators.checkPositive(radius);
        this.mass = mass;
        this.radius = radius;
        this.magnitude = magnitude;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        Validators.checkPositive(mass);
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        Validators.checkPositive(radius);
        this.radius = radius;
    }
    
    public double getMagnitude(double magnitude) {
    	return magnitude;
    }
    
    public void setMagnitude() {
    	this.magnitude= magnitude;
    }
}
