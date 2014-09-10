orrery
======

Orrery is a planetary system simulator.  With it, you can specify stellar and planetary parameters and watch your system evolve over time.  

Users can add a star to their system, and specify its parameters - mass, radius, luminosity, et cetera.  Once their star is in place, they begin to add planets.  Planets and orbits are also customizable, from mass to orbital ellipticity.  After a system is set up, users can view reports on their system.  Light curve plots and a map of the system are available to the user.  The application can be used to validate a theoretical expolanetary model or compare measured light curves with different models to compare fit.

Pull requests and tickets are welcome!


Stars
-----
Stars in Orrery are represented by only a few parameters:
* Stellar mass
* Stellar radius
* Stellar luminosity

This is not a perfect representation of all stars, but it is a close enough approximation for our purposes.

Potential future goals - multiple star systems, modeling limb darkening.


Planets
-------
Planets in Orrery are represented by the following parameters:
* Planetary mass
* Planetary radius
* Orbital radius
* Orbital period
* Orbital inclination
* Periapsis angle (how far from reference plane the farthest point on the orbit is)
* Orbital eccentricity
* Ascending node angle (where the orbit "crosses" the reference plane)
* Mean anomaly (how far the planet is along its orbit at time t = 0)

Currently Orrery only supports one planet, so many of these are moot.  This list also does not include every factor that may affect the system, but the goal is a reasonable simulation, not perfect physical replication.

Potential future goals - moons around planets, simulate planet/star and planet/planet gravitational interaction


Reporting
---------
Orrery assumes the system is a very large distance away from the observer.  A plot of the observed light curve and map of the current state of the system is shown in the main window.

Potential future goals - export light curve to a file, live reports for each planet



Changelog
---------
_v0.0.1_
* Added initial features





_v0.1 goals_
* Simulate a 1-star, 1-planet system
* Draw a map of the system, i.e. a picture of the planet going around the star
* Draw a plot of the light curve, i.e. the flux observed by a very distant telescope
* Approximations we’re okay with:
* Star only has stellar radius - no mass, luminosity yet (or don't account for them in our calculations, anyway)
* Planet only has planetary radius and orbital period
* Orbit is on zero inclination
* Orbit is perfectly circular
* No partial eclipses - planet is either 0% or 100% occulting the star
