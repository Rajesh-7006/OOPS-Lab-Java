import java.util.Scanner;

public class MaxFinder {
    public static <T extends Comparable<T>> T findMaximum(T[] arr) {
        T max = arr[0]; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Number of CGPA? ");
        int n1 = sc.nextInt();
        Float[] cgpa = new Float[n1];
        System.out.println("Enter CGPA for students:");
        for (int i = 0; i < n1; i++) {
            cgpa[i] = sc.nextFloat();
        }
        System.out.println("Highest CGPA is: " + findMaximum(cgpa));
        System.out.println("How many students for Total marks? ");
        int n2 = sc.nextInt();
        Integer[] total = new Integer[n2];
        System.out.println("Enter Total marks of students:");
        for (int i = 0; i < n2; i++) {
            total[i] = sc.nextInt();
        }
        System.out.println("Highest Total marks is: " + findMaximum(total));
        sc.nextLine();
        System.out.print("\nHow many students for Names? ");
        int n3 = sc.nextInt();
        sc.nextLine();
        String[] names = new String[n3];
        System.out.println("Enter Names of students:");
        for (int i = 0; i < n3; i++) {
            names[i] = sc.nextLine();
        }
        System.out.println("Name last in alphabetical order: " + findMaximum(names));

        sc.close();
    }
}
