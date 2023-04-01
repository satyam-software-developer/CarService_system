import java.io.*;
import java.util.*;

class billing{
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		billing obj = new billing();
		BufferedReader br = new BufferedReader(new FileReader("customer-list.txt"));
		String name = "", ph = "", address = "", car_model = "", no_car = "", r;
		int exit=0;
		System.out.println("\n\t\t Welcome to Sports Vision \n\t\t Bill Generation Program");
		while(exit!=1){
			System.out.println("\nSelect From The Following Choices: \n1: Generate A bill\n2: Sales \n3: Exit\n");
			int ch = scan.nextInt();
			if(ch==1){
				System.out.println("\nEnter the phone number:");
				scan.nextLine();
				String ph1 = scan.nextLine();
				while((r= br.readLine()) !=null)
				{
					String[] result = r.split("\\|");
					ph=result[0];
					if(ph.equals(ph1))
					{
						name=result[1];
						address= result[2];
						car_model=result[3];
						no_car=result[4];
						System.out.println("\t\t\t\t\t....________CUSTOMER INFORMATION________....\n");
						System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
						System.out.printf("|  %-15s| %-20s| %-69s| %-15s| %-5s  |\n","Phone Number", "Name", "Address", "Car Model", "Number of Cars");
						System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
						System.out.printf("|  %-15s| %-20s| %-69s| %-15s| %-14s  |\n",ph,name,address,car_model,no_car);
						System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
						br.close();
						obj.billit(ph,name,address,car_model,no_car);
						return;
			}			}
				System.out.println("Record not found");
				br.close();
			}
			else if(ch==2)
			{
				String r1;
				int sumTotal=0;
				Random randomObj = new Random();
				
				BufferedReader br1 = new BufferedReader(new FileReader("sales-list.txt"));
				if((r1= br1.readLine()) == null){
					System.out.println("\nNo Sales Registered");
				}
				else{
					int random = randomObj.nextInt(1000);
					String billingFile = "Sales_@"+java.time.LocalDate.now()+"_"+random+".txt";
					PrintWriter pw = new PrintWriter(new FileOutputStream(new File(billingFile),true));
					pw.print("#Sports Vision#\n");
					pw.print("\n\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
					pw.println("\n\t\t\t\t\t\t\t ******  Sports Vision  Sales  ******\n");
					pw.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
					pw.println();
					pw.println("\t  ---->>Sales Information<<----");
					pw.println();
					pw.println();
					pw.printf("\t\t| %-20s| %-12s | %-20s| %-15s | %10s|\n","Bill_Id", "Phone Number", "Customer Name", "Quatity Sold","Sale");
					pw.println("\t\t|----------------------------------------------------------------------------------------|");
					
					while((r1= br1.readLine()) !=null)
					{
						String[] result = r1.split("\\|");
						String b_id=result[0];
						String phn1=result[1];
						String cust= result[2];
						String qty = result[3];
						String prices = result[4];
						int sale = Integer.parseInt(prices);
						sumTotal = sumTotal+sale;
						pw.printf("\t\t| %-20s| %-12s | %-20s| %-15s | %10s|\n",b_id,phn1,cust,qty,sale);
						pw.flush();
					}
					pw.println("\n");
					pw.println("\t  :=> Total Sales: Rs."+sumTotal);
					pw.close();
					System.out.println("\nSales file generated: "+billingFile);
				}
				br1.close();
			}
			else if(ch==3)
			{
				System.out.println("\nGood Bye!! See you soon!!\n");
				return;
			}
			else{
				System.out.println("\nTry Again\n");
			}
		}
	}
	public void billit(String ph, String name, String address, String car_model, String no_car) throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		billing obj1 = new billing();
		String r, prodname="",priceS;
		int price=0,sumTotal=0,total=0,qty=0,item_count=0;
		List<String> pn = new ArrayList<String>();
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> q = new ArrayList<Integer>();
		List<Integer> t = new ArrayList<Integer>();

		Random randomObj = new Random();
		int randomNum = randomObj.nextInt(900000);
		randomNum += 100000;
		String t_id = ph+"_"+randomNum;
		String billingFile = name+"_"+randomNum+".txt";
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(billingFile),true));
		pw.println("****__Sports Vision__****");
		pw.println();
		pw.println();
		boolean flag=true;
		while(flag){
			try{
				System.out.println("Add item to the bill?(y=1/n=anything else):\t");
				int ch = scan.nextInt();
				if(ch==1) {
					System.out.println("Enter Part ID:");
					scan.nextLine();
					String iid = scan.nextLine();
					System.out.println("Quantity:");
					qty = scan.nextInt();
					item_count=item_count+qty;
					BufferedReader br = new BufferedReader(new FileReader("item-list.txt"));
					while((r= br.readLine()) !=null) {
						String[] result = r.split("\\|");
						String iid1=result[0];
						if(iid.equals(iid1)) {
							prodname=result[2];
							priceS= result[3];
							price = Integer.parseInt(priceS);
							total = price*qty;
							sumTotal += total;

							pn.add(prodname);
							p.add(price);
							q.add(qty);
							t.add(total);
							System.out.println("\n------->>  Name: "+prodname+"\n------->>  Price: "+price+"\n------->>  Quantity: "+qty+"\n------->>  Total: "+total+"\n");
							System.out.println("\t_<<Item added to bill>>_\n");
							pw.flush();
						}
					}
				}
				else
					System.out.println("Try Again");
			}
			catch(InputMismatchException e){
				System.out.println(" Continue for billing...."); 
				flag=false;
				break;
			}
		}
	System.out.println("\n");
	pw.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.println("\t|\t\t\t\t\t\t <<____________<<--CUSTOMER INVOICE-->>____________>>\t\t\t\t\t\t|");
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.println("\t|\t\t\t\t\t\t                <<--Sports Vision-->>                 \t\t\t\t\t\t|");
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	pw.print("\n");
	pw.print("  \t\t<--CUSTOMER INFORMATION-->\n");
	pw.print("\n");
	pw.print("\n");
	pw.print("  \t :>  Phone Number: "+ph+ "\n  \t :>  Name: "+name+"\n  \t :>  Address: "+address+ "\n  \t :>  Car Model: "+car_model+ "\n  \t :>  Number of Cars: "+no_car+"\n");
	pw.print("\n");
	pw.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t|\t\t<__Service Details__>\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	pw.printf("\t|\t| %-20s| %-8s| %-8s| %10s |\t\t\t\t\t\t\t\t\t\t|\n","Part Name", "Price", "Quantity", "Total");
	pw.print("\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	for(int i=0;i<p.size();i++){
		pw.printf("\t|\t| %-20s| %-8s| %-8s| %10s |\t\t\t\t\t\t\t\t\t\t|\n",pn.get(i),p.get(i),q.get(i),t.get(i));
	}
	pw.print("\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t|-----------------------------------------------------------------------------------------------------------------------------------------------|\n");	
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.println("\t|\t==>>  Sum Total:  Rs. "+sumTotal);		
	pw.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	pw.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");	
	pw.println("");
	pw.println("");
	pw.println("\t\t\t\t\t\t****____Thank You for choosing Sports Vision!:)____****");

	System.out.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.println("\t|\t\t\t\t\t\t <<____________<<--CUSTOMER INVOICE-->>____________>>\t\t\t\t\t\t|");
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.println("\t|\t\t\t\t\t\t                <<--Sports Vision-->>                 \t\t\t\t\t\t|");
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	System.out.print("\n");
	System.out.print("  \t\t<--CUSTOMER INFORMATION-->\n");
	System.out.print("\n");
	System.out.print("\n");
	System.out.print("  \t :>  Phone Number: "+ph+ "\n  \t :>  Name: "+name+"\n  \t :>  Address: "+address+ "\n  \t :>  Car Model: "+car_model+ "\n  \t :>  Number of Cars: "+no_car+"\n");
	System.out.print("\n");
	System.out.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t|\t\t<__Service Details__>\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.printf("\t|\t| %-20s| %-8s| %-8s| %10s |\t\t\t\t\t\t\t\t\t\t|\n","Part Name", "Price", "Quantity", "Total");
	System.out.print("\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	for(int i=0;i<p.size();i++){
		System.out.printf("\t|\t| %-20s| %-8s| %-8s| %10s |\t\t\t\t\t\t\t\t\t\t|\n",pn.get(i),p.get(i),q.get(i),t.get(i));
	}
	System.out.print("\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t|-----------------------------------------------------------------------------------------------------------------------------------------------|\n");	
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.println("\t|\t==>>  Sum Total:  Rs. "+sumTotal);		
	System.out.print("\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");	
	System.out.println("");
	System.out.println("  Billing Done!");
	System.out.println("");
	System.out.println("");
	System.out.println("\t\t\t\t\t\t****____Thank You for choosing Sports Vision!:)____****");
	pw.flush();
	pw.close();
	obj1.sales(ph, item_count, name, sumTotal, t_id);
	
	PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("Total-sales.txt"),true));
	BufferedReader br1 = new BufferedReader(new FileReader("Total-sales.txt"));	
	if((r = br1.readLine()) ==null) {
		pw2.println("##_Sports Vision_##\n");
		pw2.println("\t<------------------------------------------------------------------------------------>\n");
		pw2.println("\t\t\t\t\t||__Overall Sales__||\n");
	}
	pw2.println("\t<------------------------------------------------------------------------------------>\n");
	pw2.print("  \t :>  Phone Number: "+ph+ "\t:>  Name: "+name+"\t:>  Car Model: "+car_model+ "\n");
	pw2.printf("\n\t\t| %-20s| %-8s| %-8s|\n","Part Name", "Price", "Quantity");
	pw2.println("\t\t+---------------------+---------+---------+");
	for(int i=0;i<p.size();i++){
		pw2.printf("\t\t| %-20s| %-8s| %-8s|\n",pn.get(i),p.get(i),q.get(i));
	}
	pw2.println("\n\t Total sale = Rs. "+sumTotal);
	int sum = sumTotal;
	pw2.println("\t<------------------------------------------------------------------------------------>");
	pw2.flush();
	pw2.close();


	//obj1.totalSales(String ph, String name, String car_model,int sumTotal, ArrayList pn,ArrayList p,ArrayList q);
	// class sale{
	// 	void totalSales() {
	// 		System.out.println("\t<------------------------------------------------------------------------------------>\n");
	// 		System.out.println("\t\t\t\t\t||__Overall Sales__||\n");
	// 		System.out.println("\t<------------------------------------------------------------------------------------>\n");
	// 		System.out.print("  \t :>  Phone Number: "+ph+ "\t:>  Name: "+name+"\t:>  Car Model: "+car_model+ "\n");
	// 		System.out.printf("\n\t\t| %-20s| %-8s| %-8s|\n","Part Name", "Price", "Quantity");
	// 		System.out.println("\t\t+---------------------+---------+---------+");
	// 		for(int i=0;i<p.size();i++){
	// 			System.out.printf("\t\t| %-20s| %-8s| %-8s|\n",pn.get(i),p.get(i),q.get(i));
	// 		}
	// 		System.out.println("\n\t Total sale = Rs. "+sum);
	// 		System.out.println("\t<------------------------------------------------------------------------------------>");

	// 	}
	// } 

	scan.close(); 
	return;
	}

	// public static void totalSales(String ph, String name, String car_model,int sumTotal, ArrayList pn,ArrayList p,ArrayList q) throws IOException,NullPointerException,FileNotFoundException{

	// 	System.out.println("\t<------------------------------------------------------------------------------------>\n");
	// 	System.out.println("\t\t\t\t\t||__Overall Sales__||\n");
	// 	System.out.println("\t<------------------------------------------------------------------------------------>\n");
	// 	System.out.print("  \t :>  Phone Number: "+ph+ "\t:>  Name: "+name+"\t:>  Car Model: "+car_model+ "\n");
	// 	System.out.printf("\n\t\t| %-20s| %-8s| %-8s|\n","Part Name", "Price", "Quantity");
	// 	System.out.println("\t\t+---------------------+---------+---------+");
	// 	for(int i=0;i<p.size();i++){
	// 		System.out.printf("\t\t| %-20s| %-8s| %-8s|\n",pn.get(i),p.get(i),q.get(i));
	// 	}
	// 	System.out.println("\n\t Total sale = Rs. "+sumTotal);
	// 	System.out.println("\t<------------------------------------------------------------------------------------>");
	// }

	public void sales(String ph,  int item_count, String name, int sumTotal, String t_id) throws IOException,NullPointerException,FileNotFoundException{
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("sales-list.txt"),true));
		String b = t_id + "|" + ph + "|" + name + "|" + item_count + "|" + sumTotal + "|";
		pw.println(b);
		pw.close();
	}
}
