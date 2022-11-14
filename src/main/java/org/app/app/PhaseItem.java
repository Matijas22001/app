package org.app.app;

public class PhaseItem {
    private static int id_actual = 0;
    private int id;
    private double bar_value;
    private int hz_value;
    private int hit_value;

    public PhaseItem(double bar_value, int hz_value, int hit_value) {
        id = ++id_actual;
        this.bar_value = bar_value;
        this.hz_value = hz_value;
        this.hit_value = hit_value;
    }

    public double getBar_value() {
        return bar_value;
    }

    public void setBar_value(double bar_value) {
        this.bar_value = bar_value;
    }

    public int getHz_value() {
        return hz_value;
    }

    public void setHz_value(int hz_value) {
        this.hz_value = hz_value;
    }

    public int getHit_value() {
        return hit_value;
    }

    public void setHit_value(int hit_value) {
        this.hit_value = hit_value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
