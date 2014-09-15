package orrery;

/**
 * @author ryanfox
 */
public class Orrery {
    public static void main(String[] args) {
        System.out.println("Welcome to Orrery: a planetary system simulator!");
        PlanetarySystem system = new PlanetarySystem();
        double period = system.getPeriod()/(60*60*24);
        System.out.println(period);
        
        for(int i = 0; i <= period; i++) {
        	double x =  1 * Math.cos((i / period) * 2 * Math.PI);
        	double y = 1 * Math.sin((i / period) * 2 * Math.PI);
        	System.out.println(i + " " + x + " " + y);
        }
        	
        
    }
}
