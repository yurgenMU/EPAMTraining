package hometask2.t05;

public abstract class Discipline<T extends Number> {
//    MATHEMATICS(5.0), PHYSICS(5), CHEMISTRY(5.0);

    private final T highestScore;

    public Number getHighestScore() {
        return highestScore;
    }


    Discipline(T highestScore) {
        this.highestScore = highestScore;
    }


}
