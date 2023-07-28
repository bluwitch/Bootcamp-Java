package phone;

// @author Martu
public class IPhone extends Phone implements Ringable {

    public IPhone(String versionNumber, int batteryPercentage, String carrier, String ringTone) {
        super(versionNumber, batteryPercentage, carrier, ringTone);
    }

    @Override
    public String ring() {
        return """
              . . . MR WORLDWIDE This for everybody going through tough times
               Believe me, been there, done that DALE """;
    }

    @Override
    public String unlock() {
        return "Unlocking via Face ID";
    }

    @Override
    public void displayInfo() {
        System.out.println("IPhone " + getVersionNumber() + " - " + getCarrier());
        System.out.println("Battery Percentage: " + getBatteryPercentage() + "%");
    }
}
