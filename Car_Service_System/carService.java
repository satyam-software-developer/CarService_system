import java.io.*;
import java.util.*;
import java.sql.Timestamp;

class carService {

	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException{

		int flag=0;
		String r;
		Timestamp ts = new Timestamp(System.currentTimeMillis());
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\n");
		System.out.print("\t<==========================================================================>");
		System.out.println("\n\n\t\t  +++++++______<==WELCOME TO SPORTS VISION==>______+++++++ \t\t");
		//System.out.println("\t\t\t\t\"Give up your Dreams and Die\"\n");
		System.out.println("\t\t\t\t  \"Where Dreams come True!\"\n");
		System.out.println("\t<==========================================================================>");
		System.out.println();
		System.out.println();
		System.out.println("\t\t ________________________");
		System.out.println("\t\t|      YOUR DETAILS      |");
		//System.out.println("\t\t|________________________|");
		System.out.println("\n");
		while(flag!=1){
			System.out.print("\t  Enter Name: ");
			String uname = scan.nextLine();
			System.out.print("\t  Enter Phone Number: ");
			String pass = scan.nextLine();
			System.out.println();
			BufferedReader lbr = new BufferedReader(new FileReader("Login-details.txt"));
			if(uname!="" && pass!="") {
				System.out.println("\t  :)\n");
				System.out.println("\t<==========================================================================>\n");
				// if((r = lbr.readLine()) != null) {
				// 	while((r = lbr.readLine()) != null) {
				// 		String[] lresult = r.split("\\|");
				// 		String un = lresult[0];
				// 		if(uname.equals(un)) {
				// 			flag=1;
				// 		}
				// 		else {
				// 			PrintWriter lpw = new PrintWriter(new FileOutputStream(new File("Login-details.txt"),true));
				// 			String b = uname+"|"+pass+"|"+ts+"|";
				// 			lpw.println(b);
				// 			lpw.flush();
				// 			lpw.close();
				// 			lbr.close();
				// 			flag=1;
				// 		}
				// 	}
				// }
				
				PrintWriter lpw = new PrintWriter(new FileOutputStream(new File("Login-details.txt"),true));
				String b = uname+"|"+pass+"|"+ts+"|";
				lpw.println(b);
				lpw.flush();	
				lpw.close();
				lbr.close();
				flag=1;
				break;
			}
			else
				System.out.println("\tPlease enter Your Name and Phone Number\n");
		}

		try{
			while(flag==1) {
				System.out.println("\n\t____________________________________________________________________________\n");
				System.out.println("\n \t  ____Car Service System____ \n\n\t1: Customer\n\t2: Items\n\t3: Billing\n\t4: Total sales\n\t5: Exit\n");
				System.out.print("\t\tEnter your Choice: ");
				int ch = scan.nextInt();
				System.out.println();

				switch(ch) {
					case 1: addCust();
							break;

					case 2: items();
							break;

					case 3: billing();
							break;

					case 4: System.out.println("\t  Total sales file updated");
							break;

					case 5: System.out.println("\n");
							System.out.println("\t\t\t\t****See you Soon****\n\t\t\t\t Have a great Day:)\n");
							System.out.println("\t<==========================================================================>\n");
							//flag=0;
							System.exit(0);

					default: System.out.println("\tPlease enter a number from the above choices");
				}
			}
		}
		catch (NoSuchElementException e) {
			System.out.println("\n\tThank You :)");
			System.out.println("\n");
			System.out.println("\t\t\t\t****See you Soon****\n\t\t\t\t Have a great Day:)\n");
			System.out.println("\t<==========================================================================>\n");
		}
	}

	public static void addCust() throws IOException,NullPointerException,FileNotFoundException{

		Scanner scan = new Scanner(System.in);
		String r;
		System.out.println("\n\n\t____________________________________________________________________________\n");
		System.out.println("\n\t\t  Welcome to Sports Vision \n\t\t  Customer Programs");
		int exit=0;
		int exit1=0;
		while(exit!=1){
			try{
				System.out.println("\n\t**************************************");
				System.out.println("\tSelect From The Following Choices: \n\n\t1: Add Customer\n\t2: View Customer\n\t3: Modify Customer\n\t4: Delete Customer\n\t5: Exit");
				System.out.println("\t**************************************\n");
				System.out.print("\t\tEnter your Choice: ");
				int choice = scan.nextInt();
				System.out.println();

				if(choice==1){
					while(exit1!=1){
						System.out.println("\tEnter the Customer Details");
						System.out.print("\tEnter Phone Number: ");
						scan.nextLine();
						String phone = scan.nextLine();
						BufferedReader br = new BufferedReader(new FileReader("customer-list.txt"));
						top:
						if(exit==0){
							while((r = br.readLine()) != null)
							{
								String[] result = r.split("\\|");
								String ph1 = result[0];
								if(phone.equals(ph1))
								{
									System.out.println("\n\tAn entry already exists for the given phone number under the name "+result[1]);
									break top;
								}
							}
							br.close();
							System.out.print("\n\tEnter Name: ");
							String name = scan.nextLine();
							System.out.print("\n\tEnter Address: ");
							String address = scan.nextLine(); 
							System.out.print("\n\tEnter Car Model: ");
							String car_model = scan.nextLine(); 
							System.out.print("\n\tEnter Number Of Cars Owned: ");
							String no_car = scan.nextLine(); 
							PrintWriter pw = new PrintWriter(new FileOutputStream(new File("customer-list.txt"),true));
							String b = phone + "|" + name + "|" + address + "|"+ car_model + "|"+ no_car + "|";
							pw.println(b);
							System.out.println("\n\t  ++Customer Added:)++");
							pw.flush();
							pw.close();
						}
						System.out.print("\n\tAdd Another Customer? (Y/N):  ");
						String ch = scan.nextLine();
						if(ch.equals("Y") || ch.equals("y")){
							continue;
						}
						else{
							exit1=1;
						}
					}
				}

				else if(choice==2){
					String ph1 = "", name1 = "", address1 = "", car_model1 = "", no_car1 = "", p;
					File file = new File("customer-list.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					System.out.println("\t\t\t\t\t\t\t\t<<<<________CUSTOMER________>>>>\n");
					System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					System.out.printf("\t|  %-15s| %-20s| %-69s| %-15s| %-5s  |\n","Phone Number", "Name", "Address", "Car Model", "Number of Cars");
					System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					while((p=br.readLine()) !=null)
					{	
						String[] result = p.split("\\|");
						ph1=result[0];
						name1=result[1];
						address1=result[2];
						car_model1=result[3];
						no_car1=result[4];
						System.out.printf("\t|  %-15s| %-20s| %-69s| %-15s| %-14s  |\n",ph1,name1,address1,car_model1,no_car1);
						System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					}
					br.close();
					exit1=0;
				}	

				else if(choice==3){
					String ph1 = "", name1 = "", address1 = "", car_model1 = "", no_car1 = "", w;
					int flag=0;
					File file1 = new File("customer-list.txt");
					BufferedReader br1 = new BufferedReader(new FileReader(file1));
					File temp1 = new File("temp.txt");
					PrintWriter pw1 = new PrintWriter(temp1);
					System.out.println("");
					System.out.print("\tEnter Phone Number: ");
					scan.nextLine();
					String ph2 = scan.nextLine();
					while((w= br1.readLine()) !=null)
					{	
						String[] result = w.split("\\|");
						ph1=result[0];	
						if(ph1.equals(ph2))
						{	
							name1=result[1];
							address1=result[2];
							car_model1=result[3];
							no_car1=result[4];
							System.out.println("");
							System.out.println("\t>>>>  Phone Number: "+ph1+"  \tName: "+name1+"   \tAddress: "+address1+"  \tCar Model: "+car_model1+"\t\tNumber of Cars: "+no_car1);
							System.out.println("");
							System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("\tEnter which detail would you like to change\n\n\t1: Phone Number\n\t2: Customer Name\n\t3: Address\n\t4: Car\n\t5: Total Number of Cars\n\t6: All");
							try{
								System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
								System.out.print("\t\tEnter your Choice: ");
								int ch1 = scan.nextInt();
								switch (ch1) {
								case 1:
									System.out.print("\tEnter new Phone Number: ");
									scan.nextLine();
									String phone = scan.nextLine();
									System.out.println("\n\t Modified Customer Details: ");
									System.out.println("\t------->>  Phone Number: "+phone+"\n\t------->>  Name: "+name1+"\n\t------->>  Address: "+address1+"\n\t------->>  Car Model: "+car_model1+"\n\t------->>  Number of Cars: "+no_car1);
									String b1 = phone + "|" + name1 + "|" + address1 + "|"+ car_model1 + "|"+ no_car1 + "|";
									pw1.println(b1);
									flag=1;
									break;
								
								case 2:
									System.out.print("\n\tEnter Customer Name: ");
									scan.nextLine();
									String nam = scan.nextLine();
									System.out.println("\n\t Modified Customer Details: ");
									System.out.println("\t------->>  Phone Number: "+ph1+"\n\t------->>  Name: "+nam+"\n\t------->>  Address: "+address1+"\n\t------->>  Car Model: "+car_model1+"\n\t------->>  Number of Cars: "+no_car1);
									String b2 = ph1 + "|" + nam + "|" + address1 + "|"+ car_model1 + "|"+ no_car1 + "|";
									pw1.println(b2);
									flag=1;
									break;
								
								case 3:
									System.out.print("\n\tEnter Address: ");
									scan.nextLine();
									String address = scan.nextLine();
									System.out.println("\n\t Modified Customer Details: ");
									System.out.println("\t------->>  Phone Number: "+ph1+"\n\t------->>  Name: "+name1+"\n\t------->>  Address: "+address+"\n\t------->>  Car Model: "+car_model1+"\n\t------->>  Number of Cars: "+no_car1);
									String b3 = ph1 + "|" + name1 + "|" + address + "|"+ car_model1 + "|"+ no_car1 + "|";
									pw1.println(b3);
									flag=1;
									break;
								
								case 4:
									System.out.print("\n\tEnter Car Model: ");
									scan.nextLine();
									String model = scan.nextLine();
									System.out.println("\n\t Modified Customer Details: ");
									System.out.println("\t------->>  Phone Number: "+ph1+"\n\t------->>  Name: "+name1+"\n\t------->>  Address: "+address1+"\n\t------->>  Car Model: "+model+"\n\t------->>  Number of Cars: "+no_car1);
									String b4 = ph1 + "|" + name1 + "|" + address1 + "|"+ model + "|"+ no_car1 + "|";
									pw1.println(b4);
									flag=1;
									break;
								
								case 5:
									System.out.print("\n\tEnter Number of Cars: ");
									scan.nextLine();
									String no_c = scan.nextLine();
									System.out.println("\n\tModified Customer Details: ");
									System.out.println("\n\t Modified Customer Details: ");
									System.out.println("\t------->>  Phone Number: "+ph1+"\n\t------->>  Name: "+name1+"\n\t------->>  Address: "+address1+"\n\t------->>  Car Model: "+car_model1+"\n\t------->>  Number of Cars: "+no_c);
									String b5 = ph1 + "|" + name1 + "|" + address1 + "|"+ car_model1 + "|"+ no_c + "|";
									pw1.println(b5);
									flag=1;
									break;
								
								case 6:
									System.out.print("\tEnter phone number: ");
									scan.nextLine();
									String phone2 = scan.nextLine();
									System.out.print("\n\tEnter customer name: ");
									String nam2 = scan.nextLine();
									System.out.print("\n\tEnter address: ");
									String address2 = scan.nextLine();
									System.out.print("\n\tEnter new car: ");
									String model2 = scan.nextLine();
									System.out.print("\n\tEnter number of cars: ");
									String no_c2 = scan.nextLine();
									System.out.println("\n\t Modified Customer Details: ");
									System.out.println("\t------->>  Phone Number: "+phone2+"\n\t------->>  Name: "+nam2+"\n\t------->>  Address: "+address2+"\n\t------->>  Car Model: "+model2+"\n\t------->>  Number of Cars: "+no_c2);
									String b6 = phone2 + "|" + nam2 + "|" + address2 + "|"+ model2 + "|"+ no_c2 + "|";
									pw1.println(b6);
									flag=1;
									break;
								default:
									System.out.println("\n\tIncorrect Option!!!");
									break;
								}
							}
							catch(InputMismatchException e) {
								System.out.println("\t Please provide a valid Number");
							}
						}
						else{
							pw1.println(w);
						}
					}
					pw1.flush();
					pw1.close();
					br1.close();
					file1.delete();
					temp1.renameTo(file1);
					if(flag != 0){
						System.out.println("\n\tCustomer Details Modified\n");
					}
					else{
						System.out.println("\n\tNo Entery Found For The Enterd Customer Phone Number\n");
					}
				}	
				else if(choice==4){
					String num,w,ph1="", name1 = "", address1 = "", car_model1 = "", no_car1 = "";
					int flag=0;
					File file1 = new File("customer-list.txt");
					BufferedReader br1 = new BufferedReader(new FileReader(file1));
					File temp1 = new File("tempo.txt");
					PrintWriter pw1 = new PrintWriter(temp1);
					System.out.println("");
					System.out.print("\tEnter the Phone Number of Customer to be deleted:  ");
					scan.nextLine();
					num = scan.nextLine();
					while((w= br1.readLine()) !=null)
					{
						String[] result = w.split("\\|");
						ph1=result[0];	
						if(ph1.equals(num)){
							name1=result[1];
							address1=result[2];
							car_model1=result[3];
							no_car1=result[4];
							System.out.println("");
							System.out.println("\t>>>>  Phone Number: "+ph1+"  \tName: "+name1+"\tAddress: "+address1+"\tCar Model: "+car_model1+"\tNumber of Cars: "+no_car1);
							System.out.println("");
							System.out.println("\t  Deleting the Record....");
							flag=1;
							continue;
						}
						else{
							pw1.println(w);
						}
						pw1.flush();
					}
					br1.close();
					pw1.close();
					file1.delete();
					temp1.renameTo(file1);
					if(flag != 0){
						System.out.println("\n\t\t -_-Customer Deleted-_-\n");
					}
					else{
						System.out.println("\n\t Customer with "+num+" phone number doesn't exists");
					}
				}

				else if(choice==5){
					System.out.println("\n\tGood Bye!! See you soon!!\n");
					return;
					//exit=1;
				}
				else{
					System.out.println("\n\t Try Again.\n\t Please enter a valid number.\n\n");
				}
			}
			catch(InputMismatchException e){
				System.out.println("\t Thank you");
				//exit=1;
				return;
			}
		}
		
		scan.close();
		//return 0;
	}


	public static void items() throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("\n\n\t____________________________________________________________________________\n");
		System.out.println("\t\t\t Welcome to Sports Vision \n\t\t Item Addition and Modification Program");
		System.out.println("");
		int exit = 1;
		while(exit!=0){
			try {
				System.out.println("\n\t**************************************");
				System.out.println("\tChoose from the following options\n\t1. ADD \n\t2. MODIFY \n\t3. View \n\t4. Delete\n\t5. Exit\t");
				System.out.println("\t**************************************\n");

				System.out.print("\t\tEnter your Choice: ");
				int ch = scan.nextInt();
				System.out.println("");
				top: 
				if (ch==1){
					System.out.println("");
					System.out.print("\tEnter Part ID: ");
					scan.nextLine();
					String pid = scan.nextLine();
					BufferedReader br1 = new BufferedReader(new FileReader("item-list.txt"));
					String r;
					while((r = br1.readLine()) != null)
					{
						String[] result = r.split("\\|");
						String pidx = result[0];
						if(pid.equals(pidx))
						{
							System.out.println("\n\tAn entry already exists for the given part ID under the name '"+result[1]+"' for price Rs "+result[3]);
							break top;
						}
					}
					System.out.print("\n\tCar Model Name: ");
					String mname = scan.nextLine();
					System.out.print("\n\tPart Name: ");
					String pname = scan.nextLine();
					System.out.print("\n\tPrice per unit: ");
					String price = scan.nextLine(); 
					br1.close();
					PrintWriter pw = new PrintWriter(new FileOutputStream(new File("item-list.txt"),true));
					String b = pid + "|" + mname + "|" + pname + "|" + price + "|";
					System.out.println("");
					pw.println(b);
					pw.flush();
					pw.close();
					System.out.println("");
					System.out.println("\t------->>  PID: "+pid+"\n\t------->>  Model Name: "+mname+"\n\t------->>  Product name: "+pname+"\n\t------->>  Price: "+price);
					System.out.println("\n\t\t<____Part Added____>");
					System.out.println("");
				}
				else if (ch==2){
					String pid = "", mname = "", pname = "", price = "", r;
					int flag = 0;
					File file = new File("item-list.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					File temp = new File("temp.txt");
					PrintWriter pw = new PrintWriter(temp);
					System.out.println("");
					System.out.print("\tEnter Part ID: ");
					scan.nextLine();
					String pid1 = scan.nextLine();
					
					while((r= br.readLine()) !=null)
					{	
						String[] result = r.split("\\|");
						pid=result[0];	
						if(pid.equals(pid1))
						{
							mname=result[1];
							pname=result[2];
							price=result[3];
							System.out.println("");
							System.out.println("\t>>>>  PID: "+pid+"\tModel Name: "+mname+"\tProduct name: "+pname+"\tPrice: "+price);
							System.out.println("");
							System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
							System.out.println("\n\tEnter which detail would you like to change\n\t1: Part Id\n\t2: Model Name\n\t3: Product name\n\t4: Price\n\t5: All");
							System.out.println("\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
							System.out.print("Enter your Choice: ");
							int ch1 = scan.nextInt();
							switch (ch1) {
								case 1:
									System.out.print("\tEnter new PID: ");
									scan.nextLine();
									String pid11 = scan.nextLine();
									System.out.println("\n\t Modified Part Details: ");
									System.out.println("\t------->>  PID: "+pid11+"\n\t------->>  Model Name: "+mname+"\n\t------->>  Pname: "+pname+"\n\t------->>  Price: "+price);
									String b1 = pid11+"|"+mname+"|"+pname+"|"+price+"|";
									pw.println(b1);
									break;
								
								case 2:
									System.out.print("\n\tEnter new Model name:");
									scan.nextLine();
									String mname11 = scan.nextLine();
									System.out.println("\n\t Modified Part Details: ");
									System.out.println("\t------->>  PID: "+pid+"\n\t------->>  Model Name: "+mname11+"\n\t------->>  Pname: "+pname+"\n\t------->>  Price: "+price);
									String b2 = pid+"|"+mname11+"|"+pname+"|"+price+"|";
									pw.println(b2);
									break;
								
								case 3:
									System.out.print("\n\tEnter new Pname: ");
									scan.nextLine();
									String pname11 = scan.nextLine();
									System.out.println("\n\t Modified Part Details: ");
									System.out.println("\t------->>  PID: "+pid+"\n\t------->>  Model Name: "+mname+"\n\t------->>  Pname: "+pname11+"\n\t------->>  Price: "+price);
									String b3 = pid+"|"+mname+"|"+pname11+"|"+price+"|";
									pw.println(b3);
									break;
								
								case 4:
									System.out.print("\n\tEnter new Price: ");
									scan.nextLine();
									String price11 = scan.nextLine();
									System.out.println("\n\t Modified Part Details: ");
									System.out.println("\t------->>  PID: "+pid+"\n\t------->>  Model Name: "+mname+"\n\t------->>  Pname: "+pname+"\n\t------->>  Price: "+price11);
									String b4 = pid1+"|"+mname+"|"+pname+"|"+price11+"|";
									pw.println(b4);
									break;
								
								case 5:
									System.out.print("\tEnter new PID: ");
									scan.nextLine();
									String pid12 = scan.nextLine();			
									System.out.print("\n\tEnter new Model name: ");
									String mname12 = scan.nextLine();
									System.out.print("\n\tEnter new Pname: ");
									String pname12 = scan.nextLine();
									System.out.print("\n\tEnter new Price: ");
									String price12 = scan.nextLine();
									System.out.println("\n\t Modified Part Details: ");
									System.out.println("\t------->>  PID: "+pid12+"\n\t------->>  Model Name: "+mname12+"\n\t------->>  Pname: "+pname12+"\n\t------->>  Price: "+price12);
									String b5 = pid12+"|"+mname12+"|"+pname12+"|"+price12+"|";
									pw.println(b5);
									break;
								default:
									System.out.println("\n\tIncorrect Option!!!");
									break;
							}
							flag=1;
						}
						else
						{
							pw.println(r);
						}
					}
					pw.flush();
					pw.close();
					br.close();	
					
					file.delete();
					temp.renameTo(file);
					if(flag != 0){
						System.out.println("\n\tPart Details Modified\n");
					}
					else{
						System.out.println("\n\tNo Entery Found For The Enterd Part ID\n");
					}
				}
				else if (ch==3){
					String pid = "", mname = "", pname = "", price = "", r;
					File file = new File("item-list.txt");
					BufferedReader br = new BufferedReader(new FileReader(file));
					System.out.println("\t\t\t>>>>>>>____ITEMS____<<<<<<<");
					System.out.print("\t+-------+----------------+--------------------------+-----------+\n");
					System.out.printf("\t|  %-5s| %-15s| %-25s| %-10s|\n","PID", "Model Name", "Part name", "Price");
					System.out.print("\t|_______|________________|__________________________|___________|\n");
					while((r= br.readLine()) !=null)
					{	
						String[] result = r.split("\\|");
						pid=result[0];
						mname=result[1];
						pname=result[2];
						price=result[3];
						System.out.printf("\t|  %-5s| %-15s| %-25s| %-10s|\n",pid,mname,pname,price);
						System.out.print("\t|       |                |                          |           |\n");
					}
					System.out.print("\t|_______|________________|__________________________|___________|\n");
					br.close();
				}

				else if(ch==4){
					String pid2 = "", mname2 = "", pname2 = "", price2 = "", w,num;
					int flag=0;
					File file = new File("item-list.txt");
					BufferedReader br1 = new BufferedReader(new FileReader(file));
					File temp1 = new File("tempo.txt");
					PrintWriter pw1 = new PrintWriter(temp1);
					System.out.println("");
					System.out.print("\tEnter the Part Number to be deleted:  ");
					scan.nextLine();
					num = scan.nextLine();
					while((w= br1.readLine()) !=null)
					{
						String[] result = w.split("\\|");
						pid2=result[0];	
						if(pid2.equals(num)){
							mname2=result[1];
							pname2=result[2];
							price2=result[3];
							System.out.println("");
							System.out.println("\t------->>  PID: "+pid2+"\n\t------->>  Model Name: "+mname2+"\n\t------->>  Pname: "+pname2+"\n\t------->>  Price: "+price2);
							System.out.println("");
							System.out.println("\t  Deleting the Item....");
							flag=1;
							continue;
						}
						else{
							pw1.println(w);
						}
						pw1.flush();
					}
					br1.close();
					pw1.close();
					file.delete();
					temp1.renameTo(file);
					if(flag != 0){
						System.out.println("\n\t -_-Item Deleted-_-\n");
					}
					else{
						System.out.println("\n\t Item with "+num+" item number doesn't exists");
					}
				}

				else if (ch==5){
					System.out.println("\n\tGood Bye!! See you soon!!\n");
					return;
					//exit=0;
				}
				else{
					System.out.println("\n\tTry Again.\n\t Please enter a valid number.");
				}
			}
			catch(InputMismatchException e){
				System.out.println("\t Thank you");
				//exit=1;
				return;
			}		
		}
		scan.close(); 
		return;
	}


	public static void billing() throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		//billing obj = new billing();
		BufferedReader br = new BufferedReader(new FileReader("customer-list.txt"));
		String name = "", ph = "", address = "", car_model = "", no_car = "", r;
		int exit=0;
		System.out.println("\n\n\t____________________________________________________________________________\n");
		System.out.println("\n\t\t\t Welcome to Sports Vision \n\t\t\t Bill Generation Program\n");
		while(exit!=1){
			try{
				System.out.println("\t**************************************");
				System.out.println("\tSelect From The Following Choices: \n\n\t1: Generate A bill\n\t2: Sales \n\t3: Exit");
				System.out.println("\t**************************************\n");
				System.out.print("\t\tEnter your Choice: ");
				int ch = scan.nextInt();
				System.out.println("");
				if(ch==1){
					System.out.print("\n\tEnter the phone number: ");
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
							System.out.println("\t\t\t\t\t\t....________CUSTOMER INFORMATION________....\n");
							System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
							System.out.printf("\t|  %-15s| %-20s| %-69s| %-15s| %-5s  |\n","Phone Number", "Name", "Address", "Car Model", "Number of Cars");
							System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
							System.out.printf("\t|  %-15s| %-20s| %-69s| %-15s| %-14s  |\n",ph,name,address,car_model,no_car);
							System.out.print("\t+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
							//br.close();
							billit(ph,name,address,car_model,no_car);
							//return;
				}			}
					System.out.println("\tRecord not found");
					br.close();
				}
				else if(ch==2)
				{
					String r1;
					int sumTotal=0;
					Random randomObj = new Random();
					
					BufferedReader br1 = new BufferedReader(new FileReader("sales-list.txt"));
					if((r1= br1.readLine()) == null){
						System.out.println("\n\tNo Sales Registered");
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
						System.out.println("\n\tSales file generated: "+billingFile);
					}
					br1.close();
				}
				else if(ch==3)
				{
					System.out.println("\n\tGood Bye!! See you soon!!\n");
					return;
				}
				else{
					System.out.println("\n\tTry Again\n");
				}
			}
			catch(InputMismatchException e){
				System.out.println("\t Thank you");
				return;
			}
		}
	}

	public static void billit(String ph, String name, String address, String car_model, String no_car) throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		//billing obj1 = new billing();
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
				System.out.print("\n\tAdd item to the bill?(y=1/n=anything else): \t");
				int ch = scan.nextInt();
				if(ch==1) {
					System.out.print("\tEnter Part ID: ");
					scan.nextLine();
					String iid = scan.nextLine();
					System.out.print("\tQuantity: ");
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
							System.out.println("\n\t------->>  Name: "+prodname+"\n\t------->>  Price: "+price+"\n\t------->>  Quantity: "+qty+"\n\t------->>  Total: "+total+"\n");
							System.out.println("\t\t_<<Item added to bill>>_\n");
							pw.flush();
						}
					}
				}
				else
					System.out.println("\tTry Again");
			}
			catch(InputMismatchException e){
				System.out.println("\t Continue for billing...."); 
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


	sales(ph, item_count, name, sumTotal, t_id);
	
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


	System.out.print("\t\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.println("\t\t|\t\t\t\t\t\t <<____________<<--CUSTOMER INVOICE-->>____________>>\t\t\t\t\t\t|");
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.println("\t\t|\t\t\t\t\t\t                <<--Sports Vision-->>                 \t\t\t\t\t\t|");
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	System.out.print("\n");
	System.out.print("\t  \t\t<--CUSTOMER INFORMATION-->\n");
	System.out.print("\n");
	System.out.print("\n");
	System.out.print("\t  \t :>  Phone Number: "+ph+ "\n\t  \t :>  Name: "+name+"\n\t  \t :>  Address: "+address+ "\n\t  \t :>  Car Model: "+car_model+ "\n\t  \t :>  Number of Cars: "+no_car+"\n");
	System.out.print("\n");
	System.out.print("\t\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t|\t\t<__Service Details__>\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.printf("\t\t|\t| %-20s| %-8s| %-8s| %10s |\t\t\t\t\t\t\t\t\t\t|\n","Part Name", "Price", "Quantity", "Total");
	System.out.print("\t\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	for(int i=0;i<p.size();i++){
		System.out.printf("\t\t|\t| %-20s| %-8s| %-8s| %10s |\t\t\t\t\t\t\t\t\t\t|\n",pn.get(i),p.get(i),q.get(i),t.get(i));
	}
	System.out.print("\t\t|\t+---------------------+---------+---------+------------+\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t|-----------------------------------------------------------------------------------------------------------------------------------------------|\n");	
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.println("\t\t|\t==>>  Sum Total:  Rs. "+sumTotal);		
	System.out.print("\t\t|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t|\n");
	System.out.print("\t\t+-----------------------------------------------------------------------------------------------------------------------------------------------+\n");	
	System.out.println("");
	System.out.println("\t  Billing Done!");
	System.out.println("");
	System.out.println("");
	System.out.println("\t\t\t\t\t\t\t****____Thank You for choosing Sports Vision!:)____****");

	pw2.flush();
	pw2.close();
	pw.flush();
	pw.close();
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

	public static void sales(String ph,  int item_count, String name, int sumTotal, String t_id) throws IOException,NullPointerException,FileNotFoundException {
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File("sales-list.txt"),true));
		String b = t_id + "|" + ph + "|" + name + "|" + item_count + "|" + sumTotal + "|";
		pw.println(b);
		pw.close();
		return;
	}
}
