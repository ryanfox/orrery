package orrery.bodies;

import orrery.util.Validators;

/**
 * Planet representation.  For orbital parameters, the reference plane is determined by the stellar equator.
 * See https://en.wikipedia.org/wiki/Orbital_elements for a nice picture describing the various angles.
 *
 * Note: some of the variables here may become obsolete after more features are added.  For example, period can be
 * calculated after we have stellar and planetary masses, and orbital radius.
 *
 * @author ryanfox
 * @author maxspolaor
 */
public class Planet extends Body {
	/**
	 * Physical properties thatdefine the size and shape of the trajectory of a planet around a star.
	 * 
	 * @param eccentricity Orbital eccentricity of the planet's orbit. A value of 0 is a circular orbit, 
	 * values between 0 and 1 form an elliptical orbit, 1 is a parabolic escape orbit, and greater 
	 * than 1 is a hyperbola.
	 * @param semimajorAxis Semimjaor axis of the planet's orbit, in meters. Must be greater than zero.
	 * 
	 */
	private double eccentricity;
	private double semimajorAxis;

	
    /**
     * Planet constructor.
     *
     * @param mass Planetary mass, in kilograms.  Must be positive.
     * @param radius Planetary radius, in meters.  Must be positive.
     * @param orbitalRadius Average radius of the planet's orbit, in meters.  Must be positive.
     * @param period Period of the planet's orbit, in seconds.  Must be positive.
     * @param inclination Inclination of the orbit, in degrees.  Must be between -360 and 360 inclusive.
     * @param periapsisAngle Rotation of the periapsis, in degrees, Must be between -360 and 360 inclusive.
     * @param eccentricity Eccentricity of the orbit.  Unitless.  Must be nonnegative, but > 1 is unbound.
     * @param ascendingNodeAngle Ascending node angle.  Must be between -360 and 360 inclusive.
     * @param meanAnomaly Orbit progress at t = 0.  Must be between -360 and 360 inclusive.
     */
    public Planet(double mass, double radius, double magnitude, double eccentricity, double semimajorAxis) {
        super(mass, radius, magnitude);
        Validators.checkRangeInclusive(eccentricity, 0, 1);
        Validators.checkPositive(semimajorAxis);
        this.eccentricity= eccentricity;
        this.semimajorAxis = semimajorAxis;
    }
    
    public double getEccentricity() {
    	return eccentricity; 	
    }
    
    public void setEccentricity(double eccentricity) {
    	Validators.checkRangeInclusive(eccentricity, 0, 1);
    	this.eccentricity = eccentricity;   	
    }
    
    public double getSemimajorAxis() {
    	return semimajorAxis; 	
    }
    
    public void setSemimajorAxis(double semimajorAxis) {
    	Validators.checkPositive(semimajorAxis);
    	this.semimajorAxis = semimajorAxis;   	
    }
   
}
