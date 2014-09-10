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
 */
public class Planet extends Body {

    /**
     * Distance from the star in meters
     */
    private double orbitalRadius;

    /**
     * Orbital period in seconds
     */
    private double period;

    /**
     * Inclination of the orbital path with respect to the stellar equator, in degrees
     */
    private double inclination;

    /**
     * Rotation of the periapsis with respect to the reference plane, in degrees.
     *   0 degrees - periapsis in the reference plane
     *  90 degrees - periapsis is at highest point, north of the star
     * 180 degrees - periapsis is in the reference plane
     * 270 degrees - periapsis is at lowest point, south of the star
     */
    private double periapsisAngle;

    /**
     * Eccentricity of the planet's orbit.  0 is perfectly circular.  Values greater than or equal to 1 correspond
     * to escape orbits, and have no meaning in this simulation.
     */
    private double eccentricity;

    /**
     * Determines the rotation of the ascending node (where the orbit "crosses" the stellar equator) with respect to
     * the reference plane, in degrees.
     *   0 degrees - ascending node is directly between the star and observer
     *  90 degrees - ascending node is directly to the right of the star
     * 180 degrees - ascending node is directly behind the star
     * 270 degrees - ascending node is directly to the left of the star
     */
    private double ascendingNodeAngle;

    /**
     * The distance around its orbit the planet has at time t = 0, in degrees.
     *   0 degrees - the planet is at the ascending node
     *  90 degrees - the planet is at its highest point in the orbit, from the perspective of the observer
     * 180 degrees - the planet is at the descending node
     * 270 degrees - the planet is at its lowest point in the orbit
     */
    private double meanAnomaly;

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
    public Planet(double mass, double radius, double orbitalRadius, double period, double inclination,
                  double periapsisAngle, double eccentricity, double ascendingNodeAngle, double meanAnomaly) {
        super(mass, radius);
        Validators.checkPositive(orbitalRadius);
        Validators.checkPositive(period);
        Validators.checkRangeInclusive(inclination, -360, 360);
        Validators.checkNonnegative(periapsisAngle);
        Validators.checkNonnegative(eccentricity);
        Validators.checkRangeInclusive(ascendingNodeAngle, -360, 360);
        Validators.checkRangeInclusive(meanAnomaly, -360, 360);
        this.orbitalRadius = orbitalRadius;
        this.period = period;
        this.inclination = inclination;
        this.periapsisAngle = periapsisAngle;
        this.eccentricity = eccentricity;
        this.ascendingNodeAngle = ascendingNodeAngle;
        this.meanAnomaly = meanAnomaly;
    }

    public double getOrbitalRadius() {
        return orbitalRadius;
    }

    public void setOrbitalRadius(double orbitalRadius) {
        Validators.checkPositive(orbitalRadius);
        this.orbitalRadius = orbitalRadius;
    }

    public double getPeriod() {
        return period;
    }

    public void setPeriod(double period) {
        Validators.checkPositive(period);
        this.period = period;
    }

    public double getInclination() {
        return inclination;
    }

    public void setInclination(double inclination) {
        Validators.checkRangeInclusive(inclination, -360, 360);
        this.inclination = inclination;
    }

    public double getPeriapsisAngle() {
        return periapsisAngle;
    }

    public void setPeriapsisAngle(double periapsisAngle) {
        Validators.checkNonnegative(periapsisAngle);
        this.periapsisAngle = periapsisAngle;
    }

    public double getEccentricity() {
        return eccentricity;
    }

    public void setEccentricity(double eccentricity) {
        Validators.checkNonnegative(eccentricity);
        this.eccentricity = eccentricity;
    }

    public double getAscendingNodeAngle() {
        return ascendingNodeAngle;
    }

    public void setAscendingNodeAngle(double ascendingNodeAngle) {
        Validators.checkRangeInclusive(ascendingNodeAngle, -360, 360);
        this.ascendingNodeAngle = ascendingNodeAngle;
    }

    public double getMeanAnomaly() {
        return meanAnomaly;
    }

    public void setMeanAnomaly(double meanAnomaly) {
        Validators.checkRangeInclusive(meanAnomaly, -360, 360);
        this.meanAnomaly = meanAnomaly;
    }

    /**
     * Get the position of the planet at time t, given in seconds.  Naively assumes orbit is circular and planet
     * has constant velocity around the star.
     *
     * @param time The time at which to find the planet
     * @return The angular position of the planet, in the range [0, 360).  0 degrees is equivalent to directly between
     * the observer and star.
     */
    public double getPosition(double time) {
        double orbitFraction = (time % getPeriod()) / getPeriod();
        double position = orbitFraction * 360 + getMeanAnomaly();
        return position % 360;
    }
}
