import java.util.*;
import java.util.concurrent.*;

public class TaskScheduler {
    private final Map<Integer, Task> tasks = new ConcurrentHashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
    private int taskIdCounter = 0;

    public synchronized int addTask(String name, long delaySeconds, boolean repeat) {
        int id = ++taskIdCounter;
        Task task = new Task(id, name, delaySeconds, repeat);
        tasks.put(id, task);
        scheduleTask(task);
        return id;
    }

    private void scheduleTask(Task task) {
        long delay = task.getDelaySeconds();
        scheduler.schedule(() -> {
            new TaskWorker(task).run();
            if (task.isRepeat()) {
                task.updateNextRun();
                scheduleTask(task);
            } else {
                tasks.remove(task.getId());
            }
        }, delay, TimeUnit.SECONDS);
    }

    public Collection<Task> getAllTasks() {
        return tasks.values();
    }

    public boolean deleteTask(int id) {
        return tasks.remove(id) != null;
    }

    public void shutdown() {
        scheduler.shutdown();
    }
}
