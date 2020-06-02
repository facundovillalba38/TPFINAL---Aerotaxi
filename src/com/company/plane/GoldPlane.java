<<<<<<< HEAD:src/com/company/plane/GoldPlane.java
package com.company.plane;
=======
package com.company.Plane;
>>>>>>> 45e7a8e75faae606199933519b7965af82e3411c:src/com/company/Plane/GoldPlane.java

public class GoldPlane extends Plane {
    private Boolean catering;
    private Boolean wifi;

    public GoldPlane(double fuelCapacity, double costKm, double maxSpeed, String engineType, int passengers, Boolean wifi) {
        super(fuelCapacity, costKm, maxSpeed, engineType, passengers);
        this.catering = true;
        this.wifi = wifi;
    }
}