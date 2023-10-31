import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markAsDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return (isDone ? "[X] " : "[ ] ") + description;
    }
}

public class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added: " + description);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks in the list.");
        } else {
            System.out.println("Tasks in the list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public void markTaskAsDone(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Task task = tasks.get(taskIndex - 1);
            task.markAsDone();
            System.out.println("Task marked as done: " + task.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int taskIndex) {
        if (taskIndex >= 1 && taskIndex <= tasks.size()) {
            Task task = tasks.remove(taskIndex - 1);
            System.out.println("Task deleted: " + task.getDescription());
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nTodo List Menu:");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task as Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the task description: ");
                        String description = scanner.nextLine();
                        todoList.addTask(description);
                        break;
                    case 2:
                        todoList.listTasks();
                        break;
                    case 3:
                        System.out.print("Enter the task number to mark as done: ");
                        if (scanner.hasNextInt()) {
                            int taskIndex = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            todoList.markTaskAsDone(taskIndex);
                        } else {
                            System.out.println("Invalid input. Please enter a valid task number.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the task number to delete: ");
                        if (scanner.hasNextInt()) {
                            int taskIndex = scanner.nextInt();
                            scanner.nextLine(); // Consume the newline character
                            todoList.deleteTask(taskIndex);
                        } else {
                            System.out.println("Invalid input. Please enter a valid task number.");
                        }
                        break;
                    case 5:
                        System.out.println("Goodbye!");
                        scanner.close();
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid choice.");
                scanner.nextLine(); // Consume the invalid input
            }
        }
    }
}
