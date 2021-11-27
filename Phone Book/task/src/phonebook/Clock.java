package phonebook;

public class Clock {

    private long start = 0;
    private long stop = 0;

    public void setStart() {
        start = System.currentTimeMillis();
    }

    public void setStop() {
        stop = System.currentTimeMillis();
    }

    public long getDuration() {
        return stop - start;
    }

    public void printTime() {
        long duration = getDuration();
        var min = (duration / 1000) / 60;
        var sec = (int) (duration / 1000) % 60;
        var ms = duration % 1000;
        System.out.printf("%d min. %d sec. %d ms.", min, sec, ms);

    }
    public void printTime(long duration) {
        var min = (duration / 1000) / 60;
        var sec = (int) (duration / 1000) % 60;
        var ms = duration % 1000;
        System.out.printf("%d min. %d sec. %d ms.", min, sec, ms);
    }
}
