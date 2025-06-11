import java.util.ArrayList;
import java.util.List;

public class ContainerShip {
    private String name;
    private double maxSpeedKnots;
    private int maxContainers;
    private double maxWeightInKg;
    private List<Container> containers;

    public ContainerShip(String name, double maxSpeedKnots, int maxContainers, double maxWeightInKg) {
        this.name = name;
        this.maxSpeedKnots = maxSpeedKnots;
        this.maxContainers = maxContainers;
        this.maxWeightInKg = maxWeightInKg;
        this.containers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public double getMaxSpeedKnots() {
        return maxSpeedKnots;
    }
    public int getMaxContainers() {
        return maxContainers;
    }
    public double getMaxWeightInKg() {
        return maxWeightInKg;
    }
    public List<Container> getContainers() {
        return containers;
    }
    public void setName(String name) {
         this.name = name;
    }
    public void setMaxSpeedKnots(double maxSpeedKnots) {
        this.maxSpeedKnots = maxSpeedKnots;
    }
    public void setMaxContainers(int maxContainers) {
        this.maxContainers = maxContainers;
    }
    public void setMaxWeightInKg(double maxWeightInKg) {
        this.maxWeightInKg = maxWeightInKg;
    }

    public boolean addContainer(Container container) {
        if(containers.size() >= maxContainers) {
            System.out.println("The container is over the max number of containers");
            return false;
        }
        double currentTotalWeight = 0;
        for(Container c : containers) {
            currentTotalWeight += c.massInKg;
        }
        if((currentTotalWeight + container.massInKg) > maxWeightInKg) {
            System.out.println("The container is over the max weight");
            return false;
        }
        containers.add(container);
        System.out.println("The container is added to the list");
        return true;
    }

    public boolean removeContainer(String serialNumber) {
        for(Container c : containers) {
            if(serialNumber.equals(c.getSerialNumber())) {
                containers.remove(c);
                System.out.println("The container is removed from the list");
                return true;
            }
        }
        System.out.println("The container is not in the list");
        return false;
    }

    public boolean transferContainer(String serialNumber, ContainerShip destinationShip) {
        for(Container c : containers) {
            if(serialNumber.equals(c.getSerialNumber())) {
                if(destinationShip.addContainer(c)) {
                    System.out.println("The container is added to the other ships list");
                    return true;
                }
                else {
                    System.out.println("The container cannot be added to the other ships list");
                    return false;
                }
            }
        }
        System.out.println("The container is not in the list");
        return false;
    }

    public void shipInfo(){
        System.out.println("Ship Information");
        System.out.println("Name: " + name);
        System.out.println("Max Speed Knots: " + maxSpeedKnots);
        System.out.println("Max Containers: " + maxContainers);
        System.out.println("Max Weight in Kg: " + maxWeightInKg);
        System.out.print("Containers: ");
        for (Container c : containers) {
            System.out.print(c.getSerialNumber() + "  ");
        }
        System.out.println();
        double currentTotalWeight = 0;
        for(Container c : containers) {
            currentTotalWeight += c.massInKg;
        }
        System.out.println("Current Total Weight: " + currentTotalWeight);
        System.out.println("COntainer Information:");
        System.out.println();
        for(Container c : containers) {
            System.out.println(c.printContainerInfo());
        }
        System.out.println("end of information on ship:" + name);
    }


}
