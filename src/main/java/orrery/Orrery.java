package orrery;

/**
 * @author ryanfox
 */
public class Orrery {
    public static void main(String[] args) {
        System.out.println("Welcome to Orrery: a planetary system simulator!");
        PlanetarySystem system = new PlanetarySystem();
        double T = system.getPeriod()/(60*60*24);
        System.out.println(T);
        double var = 2*Math.PI;
        
        for(int i = 0; i <= T; i++) {
        	double x =  1 * Math.cos((i/T)*var);
        	double y = 1 * Math.sin((i/T)*var);
        	System.out.println(i + " " + x + " " + y);
        }
        	
        
    }
}
