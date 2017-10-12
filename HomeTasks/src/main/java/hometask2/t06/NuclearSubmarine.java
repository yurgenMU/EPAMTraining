package hometask2.t06;

public class NuclearSubmarine {
    enum submarineClass {
        Cruise_missile,
        Ballistic_missile;
    }


    public class NuclearSubmarineReactor {
        private final String reactorType;

        public NuclearSubmarineReactor(String reactorType) {
            this.reactorType = reactorType;
        }
    }
}
