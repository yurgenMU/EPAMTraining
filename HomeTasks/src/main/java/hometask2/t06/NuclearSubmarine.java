package hometask2.t06;

import hometask2.t07.Weapon;

@Weapon
public class NuclearSubmarine {
    enum SubmarineClass {
        Cruise_missile,
        Ballistic_missile
    }

    private final NuclearSubmarineReactor reactor;
    private final SubmarineClass submarineClass;

    public NuclearSubmarine(NuclearSubmarineReactor reactor, SubmarineClass submarineClass) {
        this.reactor = reactor;
        this.submarineClass = submarineClass;
    }

    public void swim() {
        if (reactor != null)
            System.out.println("Submarine went on a trek");
    }

    public static class NuclearSubmarineReactor {
        private final String reactorType;

        public NuclearSubmarineReactor(String reactorType) {
            this.reactorType = reactorType;
        }
    }
}
