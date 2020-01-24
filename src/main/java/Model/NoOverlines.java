package Model;

public class NoOverlines extends Closing {

    @Override
    public boolean checkCount(int count) {
        return count == 5;
    }
}
