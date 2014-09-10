package orrery.bodies;

import orrery.util.Validators;

/**
 * @author ryanfox
 */
public class Star extends Body {
    /**
     * Stellar luminosity, in joules/second, AKA watts
     */
    private double luminosity;

    /**
     * Star constructor.
     *
     * @param mass Stellar mass, in kilograms.  Must be greater than zero.
     * @param radius Stellar radius, in meters.  Must be greater than zero.
     * @param luminosity Stellar luminosity, in joules/second, AKA watts.  Must be greater than zero.
     */
    public Star(double mass, double radius, double luminosity) {
        super(mass, radius);
        Validators.checkPositive(luminosity);
        this.luminosity = luminosity;
    }

    public double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(int luminosity) {
        Validators.checkPositive(luminosity);
        this.luminosity = luminosity;
    }
}
