package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Progam {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("===========================");
		System.out.print("Enter the number of products: ");
		int numProd = sc.nextInt();
		
		List<Product> list = new ArrayList<>();
		
		for (int i=1; i <= numProd; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported? (Type number: 1 - c | 2 - u | 3 - i)");
			int choice = sc.nextInt();	
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if (choice == 1) {
				Product prod = new Product(name, price);
				list.add(prod);				
			}
			else if (choice == 2) {
				System.out.println("Manufacture date (DD/MM/YYYY) :");
				Date manufactureDate = sdf.parse(sc.next());
				Product prod = new UsedProduct (name, price, manufactureDate);
				list.add(prod);
			}
			else if (choice == 3){
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				Product prod = new ImportedProduct(name, price, customsFee);
				list.add(prod);
			}
			else {
				System.out.println();
			}
			
		}
		
		System.out.println("===============================");
		System.out.println("====== PRICE TAGS: ============");
		System.out.println("===============================");

		for (Product prod : list) {
			System.out.println(prod.priceTag());
			
		}
		
		sc.close();
	}}
