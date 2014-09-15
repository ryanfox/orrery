package orrery.bodies;

import orrery.util.Validators;

/**
 * @author ryanfox
 * @author maxspolaor
 */
public class Star extends Body {

    /**
     * Star constructor.
     *
     * @param mass Stellar mass, in kilograms.  Must be greater than zero.
     * @param radius Stellar radius, in meters.  Must be greater than zero.
     * @param luminosity Stellar luminosity, in joules/second, AKA watts.  Must be greater than zero.
     */
    public Star(double mass, double radius, double magnitude) {
        super(mass, radius, magnitude);
    }
    
}
