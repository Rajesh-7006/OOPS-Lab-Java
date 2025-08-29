import java.util.*;

// Simple Stack using ArrayList
class MyStack {
    private ArrayList<String> stack = new ArrayList<>();

    public void push(String item) {
        stack.add(item);
    }

    public String pop() {
        if (stack.isEmpty()) return "Nothing to undo!";
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

// Employee class
class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) throws Exception {
        if (id <= 0) throw new Exception("Invalid ID!");
        if (name == null || name.trim().isEmpty()) throw new Exception("Name is empty!");
        if (salary < 0) throw new Exception("Salary cannot be negative!");
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " - " + name + " : " + salary;
    }
}

// Payroll System
class PayrollSystem {
    private ArrayList<Employee> employees = new ArrayList<>();
    private MyStack history = new MyStack();

    public void addEmployee(Employee e) {
        employees.add(e);
        history.push("Added " + e);
    }

    public void removeEmployee(int id) {
        for (int i = 0; i < employees.size(); i++) {
            Employee e = employees.get(i);
            if (e.id == id) {
                employees.remove(i);  // ✅ Fix: Safe removal
                history.push("Removed " + e);
                System.out.println("Employee removed.");
                return;
            }
        }
        System.out.println("Employee not found!");
    }

    public void showPayroll() {
        System.out.println("\n--- Payroll ---");
        if (employees.isEmpty()) {
            System.out.println("No employees.");
        } else {
            for (Employee e : employees) {
                System.out.println(e);
            }
        }
    }

    public void undo() {
        if (!history.isEmpty())
            System.out.println("Undo: " + history.pop());
        else
            System.out.println("Nothing to undo!");
    }
}

// Main Program
public class Main1 {
    public static void main(String[] args) {
        PayrollSystem ps = new PayrollSystem();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter number of employees: ");
            int n = sc.nextInt();
            sc.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {
                System.out.println("\nEnter details for Employee " + (i + 1));
                System.out.print("ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name: ");
                String name = sc.nextLine();
                System.out.print("Salary: ");
                double salary = sc.nextDouble();
                sc.nextLine();

                try {
                    Employee e = new Employee(id, name, salary);
                    ps.addEmployee(e);
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        ps.showPayroll();

        System.out.print("\nEnter ID of employee to remove: ");
        int rid = sc.nextInt();
        sc.nextLine(); // clear buffer
        ps.removeEmployee(rid);
        ps.showPayroll();

        ps.undo(); // Just logs action, doesn't reverse it
        ps.showPayroll();

        sc.close();
    }
}