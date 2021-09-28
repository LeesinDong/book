package no34;

/**
 * @author Leesin Dong
 * @since Created in 2021/9/28 9:51 下午
 */
public enum Planet {

    MERCURY(3.302e+23, 2.439e6);

    private final double mass;
    private final double radius;
    private final double sufaceGravity;
    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        this.sufaceGravity = G * mass / (radius * radius);
    }

    public double sufaceWeight(double mass) {
        return mass * sufaceGravity;
    }

    public double getMass() {
        return mass;
    }

    public double getRadius() {
        return radius;
    }

    private Planet isMass(double mass) {
        for (Planet value : Planet.values()) {
            if (value.mass == (mass)) {
                return value;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "mass=" + mass +
                ", radius=" + radius +
                ", sufaceGravity=" + sufaceGravity +
                '}';
    }
}
