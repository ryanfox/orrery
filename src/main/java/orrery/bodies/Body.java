package orrery.bodies;

import orrery.util.Validators;

/**
 * @author ryanfox
 */
public class Body {
    /**
     * Mass of the body, in kilograms
     */
    private double mass;

    /**
     * Radius of the body, in meters
     */
    private double radius;

    /**
     * Base solar system body constructor.
     * @param mass Mass of the body, in kilograms.  Must be greater than zero.
     * @param radius Radius of the body, in meters.  Must be greater than zero.
     */
    public Body(double mass, double radius) {
        Validators.checkPositive(mass);
        Validators.checkPositive(radius);
        this.mass = mass;
        this.radius = radius;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(int mass) {
        Validators.checkPositive(mass);
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        Validators.checkPositive(radius);
        this.radius = radius;
    }
}
