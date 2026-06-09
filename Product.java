package p1;
import java.util.Scanner;
public class Product {
	 int id;
	    String name;
	    int quantity;
	    double price;
	    String brand;

	    
	    public void inputForFile() {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Product ID: ");
	        id = sc.nextInt();
	        sc.nextLine(); // consume newline

	        System.out.print("Enter Product Name: ");
	        name = sc.nextLine();

	        System.out.print("Enter Quantity: ");
	        quantity = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Price: ");
	        price = sc.nextDouble();
	        sc.nextLine();

	        System.out.print("Enter Brand: ");
	        brand = sc.nextLine();
	    }

	    
	    public void inputForDatabase() {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter Product Name: ");
	        name = sc.nextLine();

	        System.out.print("Enter Quantity: ");
	        quantity = sc.nextInt();
	        sc.nextLine();

	        System.out.print("Enter Price: ");
	        price = sc.nextDouble();
	        sc.nextLine();

	        System.out.print("Enter Brand: ");
	        brand = sc.nextLine();
	    }

	    public String toString() {
	        return id + "," + name + "," + quantity + "," + price + "," + brand;
	    }
	}
