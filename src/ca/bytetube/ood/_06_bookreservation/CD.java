package ca.bytetube.ood._06_bookreservation;

public class CD extends Resource{
    private String arist;
    private int duration;

    public CD(String id, String name, int quantity, String arist, int duration) {
        super(id, name, quantity);
        this.arist = arist;
        this.duration = duration;
    }

    public String getArist() {
        return arist;
    }

    public void setArist(String arist) {
        this.arist = arist;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
