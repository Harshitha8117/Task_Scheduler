public class TaskWorker implements Runnable {
    private final Task task;

    public TaskWorker(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("[TaskWorker] Executing Task: %s at %s%n", task.getName(), java.time.LocalTime.now());
        // Simulate task execution logic here (e.g., print, call APIs, etc.)
    }
}
