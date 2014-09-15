package orrery;

import orrery.bodies.Planet;
import orrery.bodies.Star;

/**
 * Defines a planetary system.  The "plane of reference" is equal to the stellar equator (i.e., the ecliptic).
 * @author ryanfox
 * @author maxspolaor
 */
public class PlanetarySystem {
	private final double G = 6.673e-11;
    private Star star;
    private Planet planet;
    private double time;

    /**
     * Create a 1-planet system.  Right now corresponds to the sun and earth.
     */
    public PlanetarySystem() {
        star = new Star(1.9e30, 6.9e8, -26.74);
        planet = new Planet(5.9e24, 6.4e6, 0, 0, 1.5e11);
        time = 0;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public Planet getPlanet() {
        return planet;
    }

    public double getTime() {
        return time;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    /**
     * Evolve the system forward 1 day.
     */
    public void step() {
        time += 60 * 60 * 24;
    }
    
    
    /**
     * 
     * Calculate orbital period of the 1-planet system.
     * 
     */
    public double getPeriod() {
    	
    	double mu = G*(star.getMass() + planet.getMass());    	
    	return 2*Math.PI*Math.sqrt(Math.pow(planet.getSemimajorAxis(), 3)/mu);     	    	
    }
    
    
}
