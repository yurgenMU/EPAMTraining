package hometask2.t05;

public enum Discipline {
    MATHEMATICS(5.0), PHYSICS(5), CHEMISTRY(5.0);

    private final Number highestScore;

    public Number getHighestScore() {
        return highestScore;
    }


    Discipline(Number highestScore) {
        this.highestScore = highestScore;
    }


}
