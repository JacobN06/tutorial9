public class LiquidContainer extends Container implements IHazardNotifier {
    private boolean isHazardous = false;

    public LiquidContainer(double massInKg,double heightInCm, double weightOfContainerInKg, double weightOfCargoInKg, double depthOfContainerInCm, String serialNumber, double maximumPayloadInKg,boolean isLoaded,boolean isHazardous) {
        super(massInKg,heightInCm,weightOfContainerInKg,weightOfCargoInKg,depthOfContainerInCm,"L",maximumPayloadInKg,isLoaded);
        this.isHazardous = isHazardous;
    }

    public void setAsHazardous(){
        this.isHazardous = true;
    }
    public boolean isHazardous(){
        return this.isHazardous;
    }

    @Override
    public void notifyHazard(String serialNumber, String message) {
        System.out.println("Hazard notification");
        System.out.println(serialNumber);
        System.out.println(message);
        System.out.println();
    }

    @Override
    public void loadContainer(double weightOfCargoInKg, double maximumPayloadInKg) {
        if(this.weightOfCargoInKg > this.maximumPayloadInKg) {
            notifyHazard(this.serialNumber,"Weight of Cargo in kg is greater than maximum payload in kg");
            System.out.println("Maximum payload in kg: " + this.maximumPayloadInKg);
            System.out.println("Weight of Cargo in kg: " + this.weightOfCargoInKg);
            System.out.println("Could Not Load");
            System.out.println();
        }
        if(this.isHazardous == true){
            if(weightOfCargoInKg > (this.maximumPayloadInKg / 2)) {
                System.out.println("Weight of Cargo in kg is greater than maximum payload in kg for hazardous materials");
                System.out.println("Maximum payload in kg for hazardous materials: " + (this.maximumPayloadInKg / 2));
                System.out.println("Weight of Cargo in kg: " + this.weightOfCargoInKg);
                System.out.println("Could Not Load");
                System.out.println();
            }
            else{this.massInKg = this.weightOfCargoInKg + this.weightOfCargoInKg;
                System.out.println("Cargo Loaded");
                this.isLoaded = true;
                System.out.println("New Mass: " + massInKg);}
            System.out.println();
        }
        else {
            if(weightOfCargoInKg > (this.maximumPayloadInKg - (this.maximumPayloadInKg / 10))){
                notifyHazard(this.serialNumber,"WARNING: Weight of Cargo in kg is greater than 90% maximum payload in kg");
                System.out.println("90% of Maximum payload in kg: " + (this.maximumPayloadInKg - (this.maximumPayloadInKg / 10)));
                System.out.println("Weight of Cargo in kg: " + this.weightOfCargoInKg);
                System.out.println("Could Not Load");
                System.out.println();
            }
            this.massInKg = this.weightOfCargoInKg + this.weightOfCargoInKg;
            System.out.println("Cargo Loaded");
            this.isLoaded = true;
            System.out.println("New Mass: " + massInKg);
            System.out.println();

        }

    }
    public void emptyContainer(){
        this.weightOfCargoInKg = 0;
        this.massInKg = this.weightOfContainerInKg;
        this.isLoaded = false;
        System.out.println("Container Emptied");
    }
    @Override
    public String printContainerInfo() {
        System.out.println("Liquid Container Info");
        System.out.println("Serial Number: " + this.serialNumber);
        System.out.println("Is Hazardous: " + this.isHazardous);
        System.out.println("Mass: " + this.massInKg);
        System.out.println("Cargo Weight: " + this.weightOfCargoInKg);
        System.out.println("Is Loaded: " + this.isLoaded);
        System.out.println();
        return "end of info";
    }

}
