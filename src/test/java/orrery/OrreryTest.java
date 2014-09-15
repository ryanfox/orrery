package orrery;

import junit.framework.Assert;
import org.junit.Test;

/**
 * @author ryanfox
 * @author maxspolaor
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
    }
}
