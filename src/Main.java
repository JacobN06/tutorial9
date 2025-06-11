public class Main {
    public static void main(String[] args) {
        LiquidContainer liquidContainer = new LiquidContainer(1000,250,500,400,100,"L",1000,false,false);
        GasContainer gasContainer = new GasContainer(800,240,300,200,80,800,false);
        RefrigeratedContainer refrigeratedContainer = new RefrigeratedContainer(1200,260,600,0,120,"R",1200,false,null,-20);

        System.out.println("Loading liquid container");
        liquidContainer.loadContainer(400,1000);
        liquidContainer.printContainerInfo();

        System.out.println("Loading gas container");
        gasContainer.loadContainer(200,800);
        gasContainer.printContainerInfo();

        System.out.println("Loading refrigerated container");
        refrigeratedContainer.loadRefrigertedContainer("Ice cream",500);
        refrigeratedContainer.printContainerInfo();

        ContainerShip ship = new ContainerShip("Titanic",30,20,20000);

        ship.addContainer(liquidContainer);
        ship.addContainer(gasContainer);
        ship.addContainer(refrigeratedContainer);

        System.out.println("ship info");
        ship.shipInfo();

        System.out.println("emptying gas container");
        gasContainer.emptyContainer();
        gasContainer.printContainerInfo();

        System.out.println("Checking info after emptying gas container");
        ship.shipInfo();
    }
}