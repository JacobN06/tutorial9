public abstract class Container {
    protected double massInKg;
    protected double heightInCm;
    protected double weightOfContainerInKg;
    protected double weightOfCargoInKg;
    protected double depthOfContainerInCm;
    protected String serialNumber;
    protected double maximumPayloadInKg;
    protected boolean isLoaded;

    public Container( double massInKg,double heightInCm, double weightOfContainerInKg, double weightOfCargoInKg, double depthOfContainerInCm, String serialNumber, double maximumPayloadInKg, boolean isLoaded) {
        this.massInKg = massInKg;
        this.heightInCm = heightInCm;
        this.weightOfContainerInKg = weightOfContainerInKg;
        this.weightOfCargoInKg = weightOfCargoInKg;
        this.depthOfContainerInCm = depthOfContainerInCm;
        this.serialNumber = serialNumber;
        this.maximumPayloadInKg = maximumPayloadInKg;
        this.isLoaded = isLoaded;
    }

    public void loadContainer(double weightOfCargoInKg, double maximumPayloadInKg) {
        if(this.weightOfCargoInKg > this.maximumPayloadInKg) {
            System.out.println("Weight of Cargo in kg is greater than maximum payload in kg");
            System.out.println("Maximum payload in kg: " + this.maximumPayloadInKg);
            System.out.println("Weight of Cargo in kg: " + this.weightOfCargoInKg);
        }
        else {
        this.massInKg = this.weightOfCargoInKg + this.weightOfCargoInKg;
        System.out.println("Cargo Loaded");
        this.isLoaded = true;
        System.out.println("New Mass: " + massInKg);

        }
    }


}
