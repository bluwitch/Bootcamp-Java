package phone;

// @author Martu
public class Galaxy extends Phone implements Ringable {

    public Galaxy(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return "*inserte tonito de los simuladores*";
    }

    @Override
    public String unlock() {
        return "Unlocking via fingerprint";
    }

    @Override
    public void displayInfo() {
        System.out.println("Galaxy " + getVersionNumber() + " - " + getCarrier());
        System.out.println("Battery Percentage: " + getBatteryPercentage() + "%");
    }
}
