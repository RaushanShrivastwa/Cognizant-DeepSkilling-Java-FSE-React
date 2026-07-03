package com.cognizant.dsa.ex05_task;

// ==========================================================
// 1. TASK DATA MODEL
// ==========================================================
class Task {
    private String taskId;
    private String taskName;
    private String status;

    public Task(String taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public String getTaskId() { return taskId; }

    @Override
    public String toString() {
        return "Task ID: " + taskId + " | Name: " + taskName + " | Status: " + status;
    }
}

// ==========================================================
// 2. SINGLY LINKED LIST CORE IMPLEMENTATION
// ==========================================================
class TaskLinkedList {

    // Internal Node helper structure
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    private Node head = null; // Entry point of the linked list

    // Add Task to the end of the list - O(n)
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next; // Traverse to the final element
            }
            temp.next = newNode;
        }
        System.out.println("[ADDED]: Task queue entry -> " + task.getTaskId());
    }

    // Search Task by ID - O(n)
    public Task searchTask(String taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId().equalsIgnoreCase(taskId)) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null; // Not found
    }

    // Traverse and print list elements - O(n)
    public void traverseTasks() {
        System.out.println("\n--- Current Active Task Pipeline ---");
        if (head == null) {
            System.out.println("Pipeline is empty.");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
        System.out.println("------------------------------------");
    }

    // Delete Task by ID - O(n)
    public void deleteTask(String taskId) {
        if (head == null) {
            System.out.println("[ERROR]: Empty pipeline, cannot delete.");
            return;
        }

        // Case A: The item to delete is the head node itself
        if (head.task.getTaskId().equalsIgnoreCase(taskId)) {
            System.out.println("[DELETED]: Task ID " + head.task.getTaskId() + " removed from head.");
            head = head.next; // Change head pointer to bypass the first node
            return;
        }

        // Case B: The item is deeper inside the list
        Node current = head;
        Node previous = null;

        while (current != null && !current.task.getTaskId().equalsIgnoreCase(taskId)) {
            previous = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("[ERROR]: Deletion failed. Task ID " + taskId + " not found.");
            return;
        }

        // Unlink the node from the chain
        System.out.println("[DELETED]: Task ID " + current.task.getTaskId() + " removed.");
        previous.next = current.next;
    }
}

// ==========================================================
// 3. MAIN TEST APPLICATION
// ==========================================================
public class TaskManager {
    public static void main(String[] args) {
        System.out.println("=== Testing Exercise 5: Task Management System ===");

        TaskLinkedList taskPipeline = new TaskLinkedList();

        // 1. Queue Operations
        taskPipeline.addTask(new Task("T001", "Database Backup Configuration", "Pending"));
        taskPipeline.addTask(new Task("T002", "API Endpoint Security Review", "In Progress"));
        taskPipeline.addTask(new Task("T003", "UI Regression Test Execution", "Completed"));

        // 2. Traversal
        taskPipeline.traverseTasks();

        // 3. Searching
        System.out.println("Searching for Task T002...");
        Task searchResult = taskPipeline.searchTask("T002");
        if (searchResult != null) {
            System.out.println("Match Located -> " + searchResult);
        } else {
            System.out.println("Task missing from tracking dashboard.");
        }

        // 4. Deletion
        System.out.println("\nExecuting deletion protocol...");
        taskPipeline.deleteTask("T002");

        // 5. Verify Structure Post-Deletion
        taskPipeline.traverseTasks();
    }
}