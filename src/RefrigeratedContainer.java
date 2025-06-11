public class RefrigeratedContainer extends Container {
    private String productType;
    private double containerTemperature;

    private static final java.util.Map<String, Double> productTemperatureRequirements = new java.util.HashMap<>();
    static {
        productTemperatureRequirements.put("Bananas", 13.3);
        productTemperatureRequirements.put("Chocolate", 18.0);
        productTemperatureRequirements.put("Fish", 2.0);
        productTemperatureRequirements.put("Meat", -15.0);
        productTemperatureRequirements.put("Ice cream", -18.0);
        productTemperatureRequirements.put("Frozen pizza", -30.0);
        productTemperatureRequirements.put("Cheese", 7.2);
        productTemperatureRequirements.put("Sausages", 5.0);
        productTemperatureRequirements.put("Butter", 20.5);
        productTemperatureRequirements.put("Eggs", 19.0);
    }

    public RefrigeratedContainer(double massInKg,double heightInCm,double weightOfContainerInKg,double weightOfCargoInKg,double depthOfContainerInCm,String serialNumber,double maximumPayloadInKg,boolean isLoaded,String productType,double containerTemperature){
        super(massInKg, heightInCm, weightOfContainerInKg, weightOfCargoInKg, depthOfContainerInCm, "R", maximumPayloadInKg, isLoaded);
        this.productType = productType;
        this.containerTemperature = containerTemperature;
    }

    public boolean loadRefrigertedContainer(String productType, double productWeight) {
        Double requiredTemperature = productTemperatureRequirements.get(productType);
        if (this.isLoaded) {
            System.out.println("Container already loaded with: " + this.productType);
            return false;
        }
        else if (requiredTemperature == null) {
            System.out.println("Unknown product: " + productType);
            return false;
        }

        else if (this.containerTemperature > requiredTemperature) {
            System.out.println("Container temperature is too high for " + productType);
            System.out.println("Required: " + requiredTemperature + "°C, but container is at: " + this.containerTemperature + "°C");
            return false;
        }

        else if (productWeight > this.maximumPayloadInKg) {
            System.out.println("Weight of product exceeds maximum payload!");
            return false;
        }

        this.productType = productType;
        this.weightOfCargoInKg = productWeight;
        this.massInKg = this.weightOfContainerInKg + productWeight;
        this.isLoaded = true;

        System.out.println("Product " + productType + " loaded successfully");
        return true;
    }

    public void emptyContainer() {
        this.productType = null;
        this.weightOfCargoInKg = 0;
        this.massInKg = this.weightOfContainerInKg;
        this.isLoaded = false;
        System.out.println("Container emptied.");
    }
    @Override
    public String printContainerInfo() {
        System.out.println("Refrigerated Container Info");
        System.out.println("Serial Number: " + this.serialNumber);
        System.out.println("Product Type: " + (productType != null ? productType : "Empty"));
        System.out.println("Container Temperature: " + this.containerTemperature + "°C");
        System.out.println("Cargo Weight: " + this.weightOfCargoInKg + "kg");
        System.out.println();
        return "end of info";
    }
}
