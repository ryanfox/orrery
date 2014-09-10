package orrery;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author ryanfox
 */
public class OrreryTest {

    /**
     * Make sure main runs successfully
     */
    @Test
    public void testMain() {
        Orrery.main(new String[]{});
    }

    /**
     * Make sure system can perform a timestep correctly
     */
    @Test
    public void testStep() {
        PlanetarySystem sys = new PlanetarySystem();
        sys.step();

        // Earth should have moved 0.9 degrees in a day, with some wiggle room for floating-point errors
        Assert.assertEquals(sys.getPlanet().getPosition(sys.getTime()), 0.972, 1e-15);
    }
}
