public class Main {
    private static final TaskScheduler scheduler = new TaskScheduler();

    public static void main(String[] args) {
        System.out.println("=== Task Scheduler CLI ===");
        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Delete Task");
            System.out.println("4. Exit");
            int choice = Utils.readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addTaskFlow();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    deleteTaskFlow();
                    break;
                case 4:
                    exitScheduler();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void addTaskFlow() {
        String name = Utils.readLine("Enter task name: ");
        long delay = Utils.readInt("Enter delay (in seconds): ");
        boolean repeat = Utils.readYesNo("Repeat? (yes/no): ");
        int id = scheduler.addTask(name, delay, repeat);
        System.out.println("Task scheduled successfully with ID: " + id);
    }

    private static void viewTasks() {
        var tasks = scheduler.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled.");
            return;
        }
        System.out.println("Scheduled Tasks:");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }

    private static void deleteTaskFlow() {
        int id = Utils.readInt("Enter task ID to delete: ");
        if (scheduler.deleteTask(id)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    private static void exitScheduler() {
        System.out.println("Exiting and shutting down scheduler...");
        scheduler.shutdown();
    }
}
