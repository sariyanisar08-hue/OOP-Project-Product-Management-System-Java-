package p1;
import java.io.*;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);

	        while (true) {
	        	System.out.println("--------product managment-----");
	            
	            System.out.println("1. Add Product");
	            System.out.println("2. Display Products");
	            System.out.println("3. Search Product by Name");
	            System.out.println("4. Exit");
	            System.out.print("Enter your choice: ");
	            int mainChoice = sc.nextInt();
	            

	            if (mainChoice == 1) {
	            	System.out.println(" \n");
	                System.out.println(" Add Product ");
	                System.out.println("1 for  Save to File");
	                System.out.println("2 for  Save to Database");
	                System.out.print("Enter your 2nd  choice: ");
	                int choice = sc.nextInt();
	                

	                Product p = new Product();

	                if (choice == 1) {
	                    p.inputForFile(); 
	                    try (FileWriter fw = new FileWriter("Product.txt", true)) {
	                        fw.write(p.toString() + "\n");
	                        System.out.println("Product saved to file.");
	                    } catch (IOException e) {
	                        System.out.println("File error: " + e.getMessage());
	                    }

	                } else if (choice == 2) {
	                    p.inputForDatabase(); 
	                    try {
	                        DBManager db = new DBManager();
	                        String query = "INSERT INTO Product (productname, productQuantity, price, brand) VALUES (" +
	                                "'" + p.name + "', " + p.quantity + ", " + p.price + ", '" + p.brand + "')";
	                        db.insertUpdateDelete(query);
	                        System.out.println("Product saved to Database.");
	                    } catch (Exception e) {
	                        System.out.println("Database error: " + e.getMessage());
	                    }
	                }

	            } else if (mainChoice == 2) {
	            	System.out.println(" \n");
	                System.out.println(" Display Products");
	                System.out.println(" \n");
	                System.out.println("1. From File");
	                System.out.println("2. From Database");
	                System.out.print("Enter your choice: ");
	                int choice = sc.nextInt();

	                if (choice == 1) {
	                    try (Scanner fileScanner = new Scanner(new File("Product.txt"))) {
	                        System.out.println(" Products from File ");
	                        while (fileScanner.hasNextLine()) {
	                            System.out.println(fileScanner.nextLine());
	                        }
	                    } catch (IOException e) {
	                        System.out.println("File error: " + e.getMessage());
	                    }
	                } else if (choice == 2) {
	                    try {
	                        DBManager db = new DBManager();
	                        String query = "SELECT * FROM Product";
	                        db.select(query);
	                    } catch (Exception e) {
	                        System.out.println("Database error: " + e.getMessage());
	                    }
	                }

	            } else if (mainChoice == 3) {
	                System.out.println(" Search by Product Name");
	                System.out.println("1 for File");
	                System.out.println("2. for Database");
	                System.out.print("Enter your choice: ");
	                int choice = sc.nextInt();

	                System.out.print("Enter Product Name to Search: ");
	                String searchName = sc.nextLine().toLowerCase();

	                if (choice == 1) {
	                    try (Scanner fileScanner = new Scanner(new File("Product.txt"))) {
	                        boolean found = false;
	                        while (fileScanner.hasNextLine()) {
	                            String line = fileScanner.nextLine();
	                            if (line.toLowerCase().contains(searchName)) {
	                                System.out.println("Found: " + line);
	                                found = true;
	                            }
	                        }
	                        if (!found)
	                        System.out.println("Product not found in file.");
	                    } catch (IOException e) {
	                        System.out.println("File error: " + e.getMessage());
	                    }

	                } else if (choice == 2) {
	                    try {
	                        DBManager db = new DBManager();
	                        String query = "SELECT * FROM Product WHERE LOWER(productname) LIKE '%" + searchName + "%'";
	                        db.select(query);
	                    } catch (Exception e) {
	                        System.out.println("Database error: " + e.getMessage());
	                    }
	                }

	            } else if (mainChoice == 4) {
	                System.out.println("Exit program");
	                break;
	            } else {
	                System.out.println("Invalid main menu choice.");
	            }
	        }
	    }
	}
