public class GasContainer extends Container implements IHazardNotifier {
    public GasContainer(double massInKg, double heightInCm, double weightOfContainerInKg, double weightOfCargoInKg, double depthOfContainerInCm, double maximumPayloadInKg,boolean isLoaded){
        super(massInKg,heightInCm,weightOfContainerInKg,weightOfCargoInKg,depthOfContainerInCm,"G",maximumPayloadInKg,isLoaded);

    }
    @Override
    public void notifyHazard(String serialNumber, String message) {
        System.out.println("Hazard Notification");
        System.out.println("Container Serial Number: " + serialNumber);
        System.out.println("Message: " + message);
    }
    @Override
    public void loadContainer(double weightOfCargoInKg, double maximumPayloadInKg) {
        if (weightOfCargoInKg > maximumPayloadInKg) {
            notifyHazard(this.serialNumber, "Cargo weight exceeds the maximum allowed payload!");
            System.out.println("Could not load cargo.");
        } else {
            this.weightOfCargoInKg = weightOfCargoInKg;
            this.massInKg = this.weightOfCargoInKg + this.weightOfContainerInKg;
            this.isLoaded = true;
            System.out.println("Cargo Loaded Successfully");
            System.out.println("New Mass: " + massInKg);
        }
    }
    public void emptyContainer() {
        double leftover = this.weightOfCargoInKg * 0.05;
        this.weightOfCargoInKg = leftover;
        this.massInKg = this.weightOfContainerInKg + this.weightOfCargoInKg;
        this.isLoaded = false;
        System.out.println("Container Emptied (5% of cargo left inside)");
        System.out.println("Remaining cargo weight: " + this.weightOfCargoInKg);
    }
    @Override
    public String printContainerInfo() {
        System.out.println("Gas Container Info");
        System.out.println("Container Serial Number: " + this.serialNumber);
        System.out.println("Container Mass: " + this.massInKg);
        System.out.println("Container Weight: " + this.weightOfContainerInKg);
        System.out.println("Cargo Weight: " + this.weightOfCargoInKg);
        System.out.println("is Loaded: " + this.isLoaded);
        System.out.println();
        return "end of info";
    }

}
