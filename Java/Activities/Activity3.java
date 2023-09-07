package Activities;

import java.io.IOException;

public class Activity3 {
    public static void main(String[] args) throws IOException {

    double EarthSec=31557600;
    double MercurySec=0.2408467;
    double VenusSec=0.61519726;
    double MarsSec=1.8808158;
    double JupiterSec=11.862615;
    double SaturnSec=29.447498;
    double NetpuneSec=64.79132;
    double UranusSec=84.016846;

    double sec=System.in.read();

    System.out.println("Age on Planet Mercury: "+sec/EarthSec/MercurySec);
    System.out.println("Age on Planet Venus: "+sec/EarthSec/VenusSec);
    System.out.println("Age on Planet Mars: "+sec/EarthSec/MarsSec);
    System.out.println("Age on Planet Jupiter: "+sec/EarthSec/JupiterSec);
    System.out.println("Age on Planet Saturn: "+sec/EarthSec/SaturnSec);
    System.out.println("Age on Planet Neptune: "+sec/EarthSec/NetpuneSec);
    System.out.println("Age on Planet Uranus: "+sec/EarthSec/UranusSec);

    }
}
