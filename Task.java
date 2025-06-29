import java.time.LocalDateTime;

public class Task {
    private final int id;
    private final String name;
    private final long delaySeconds;
    private final boolean repeat;
    private LocalDateTime nextRun;

    public Task(int id, String name, long delaySeconds, boolean repeat) {
        this.id = id;
        this.name = name;
        this.delaySeconds = delaySeconds;
        this.repeat = repeat;
        this.nextRun = LocalDateTime.now().plusSeconds(delaySeconds);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public long getDelaySeconds() { return delaySeconds; }
    public boolean isRepeat() { return repeat; }
    public LocalDateTime getNextRun() { return nextRun; }
    public void updateNextRun() {
        this.nextRun = LocalDateTime.now().plusSeconds(delaySeconds);
    }

    @Override
    public String toString() {
        return String.format("[%d] %s - Delay: %ds - Repeat: %s", id, name, delaySeconds, repeat ? "Yes" : "No");
    }
}
