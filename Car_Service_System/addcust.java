import java.io.*;
import java.util.*;

class addcust{
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		String r;
		System.out.println("\n\t\t  Welcome to Sports Vision \n\t\tCustomer Programs");
		int exit=0;
		int exit1=0;
		while(exit!=1){
			try{
				System.out.println("\nSelect From The Following Choices: \n1: Add Customer\n2: View Customer\n3: Modify Customer\n4: Delete Customer\n5: Exit\n");
				int choice = scan.nextInt();

				if(choice==1){
					while(exit1!=1){
						System.out.println("Enter the Customer Details");
						System.out.println("Enter Phone Number:");
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
									System.out.println("An entry already exists for the given phone number under the name "+result[1]);
									break top;
								}
							}
							br.close();
							System.out.println("\nEnter Name:");
							String name = scan.nextLine();
							System.out.println("\nEnter Address:");
							String address = scan.nextLine(); 
							System.out.println("\nEnter Car Model:");
							String car_model = scan.nextLine(); 
							System.out.println("\nEnter Number Of Cars Owned:");
							String no_car = scan.nextLine(); 
							PrintWriter pw = new PrintWriter(new FileOutputStream(new File("customer-list.txt"),true));
							String b = phone + "|" + name + "|" + address + "|"+ car_model + "|"+ no_car + "|";
							pw.println(b);
							pw.flush();
							pw.close();
						}
						System.out.println("\nAdd Another Customer? (Y/N) ");
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
					System.out.println("\t\t\t\t\t\t\t<<<<________CUSTOMER________>>>>\n");
					System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					System.out.printf("|  %-15s| %-20s| %-69s| %-15s| %-5s  |\n","Phone Number", "Name", "Address", "Car Model", "Number of Cars");
					System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
					while((p=br.readLine()) !=null)
					{	
						String[] result = p.split("\\|");
						ph1=result[0];
						name1=result[1];
						address1=result[2];
						car_model1=result[3];
						no_car1=result[4];
						System.out.printf("|  %-15s| %-20s| %-69s| %-15s| %-14s  |\n",ph1,name1,address1,car_model1,no_car1);
						System.out.print("+-----------------+---------------------+----------------------------------------------------------------------+----------------+-----------------+\n");
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
					System.out.println("Enter Phone Number:");
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
							System.out.println(">>>>  Phone Number: "+ph1+"  \tName: "+name1+"\tAddress: "+address1+"\tCar Model: "+car_model1+"\tNumber of Cars: "+no_car1);
							System.out.println("");
							System.out.println("Enter which detail would you like to change\n1: Phone Number\n2: Customer Name\n3: Address\n4: Car\n5: Total Number of Cars\n6: All");
							int ch1 = scan.nextInt();
							switch (ch1) {
								case 1:
								System.out.println("Enter new Phone Number:");
								scan.nextLine();
								String phone = scan.nextLine();
								System.out.println("\n Modified Customer Details: ");
								System.out.println("------->>  Phone Number: "+phone+"\n------->>  Name: "+name1+"\n------->>  Address: "+address1+"\n------->>  Car Model: "+car_model1+"\n------->>  Number of Cars: "+no_car1);
								String b1 = phone + "|" + name1 + "|" + address1 + "|"+ car_model1 + "|"+ no_car1 + "|";
								pw1.println(b1);
								break;
							
							case 2:
								System.out.println("\nEnter Customer Name:");
								scan.nextLine();
								String nam = scan.nextLine();
								System.out.println("\n Modified Customer Details: ");
								System.out.println("------->>  Phone Number: "+ph1+"\n------->>  Name: "+nam+"\n------->>  Address: "+address1+"\n------->>  Car Model: "+car_model1+"\n------->>  Number of Cars: "+no_car1);
								String b2 = ph1 + "|" + nam + "|" + address1 + "|"+ car_model1 + "|"+ no_car1 + "|";
								pw1.println(b2);
								break;
							
							case 3:
								System.out.println("\nEnter Address:");
								scan.nextLine();
								String address = scan.nextLine();
								System.out.println("\n Modified Customer Details: ");
								System.out.println("------->>  Phone Number: "+ph1+"\n------->>  Name: "+name1+"\n------->>  Address: "+address+"\n------->>  Car Model: "+car_model1+"\n------->>  Number of Cars: "+no_car1);
								String b3 = ph1 + "|" + name1 + "|" + address + "|"+ car_model1 + "|"+ no_car1 + "|";
								pw1.println(b3);
								break;
							
							case 4:
								System.out.println("\nEnter Car Model:");
								scan.nextLine();
								String model = scan.nextLine();
								System.out.println("\n Modified Customer Details: ");
								System.out.println("------->>  Phone Number: "+ph1+"\n------->>  Name: "+name1+"\n------->>  Address: "+address1+"\n------->>  Car Model: "+model+"\n------->>  Number of Cars: "+no_car1);
								String b4 = ph1 + "|" + name1 + "|" + address1 + "|"+ model + "|"+ no_car1 + "|";
								pw1.println(b4);
								break;
							
							case 5:
								System.out.println("\nEnter Number of Cars:");
								scan.nextLine();
								String no_c = scan.nextLine();
								System.out.println("\nModified Customer Details: ");
								System.out.println("\n Modified Customer Details: ");
								System.out.println("------->>  Phone Number: "+ph1+"\n------->>  Name: "+name1+"\n------->>  Address: "+address1+"\n------->>  Car Model: "+car_model1+"\n------->>  Number of Cars: "+no_c);
								String b5 = ph1 + "|" + name1 + "|" + address1 + "|"+ car_model1 + "|"+ no_c + "|";
								pw1.println(b5);
								break;
							
							case 6:
								System.out.println("Enter phone number:");
								scan.nextLine();
								String phone2 = scan.nextLine();
								System.out.println("\nEnter customer name:");
								String nam2 = scan.nextLine();
								System.out.println("\nEnter address:");
								String address2 = scan.nextLine();
								System.out.println("\nEnter new car:");
								String model2 = scan.nextLine();
								System.out.println("\nEnter number of cars:");
								String no_c2 = scan.nextLine();
								System.out.println("\n Modified Customer Details: ");
								System.out.println("------->>  Phone Number: "+phone2+"\n------->>  Name: "+nam2+"\n------->>  Address: "+address2+"\n------->>  Car Model: "+model2+"\n------->>  Number of Cars: "+no_c2);
								String b6 = phone2 + "|" + nam2 + "|" + address2 + "|"+ model2 + "|"+ no_c2 + "|";
								pw1.println(b6);
								break;
							default:
								System.out.println("\nIncorrect Option!!!");
								break;
							}
							flag=1;
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
						System.out.println("\nCustomer Details Modified\n");
					}
					else{
						System.out.println("\nNo Entery Found For The Enterd Customer Phone Number\n");
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
					System.out.println("Enter the Phone Number of Customer to be deleted:  ");
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
							System.out.println(">>>>  Phone Number: "+ph1+"  \tName: "+name1+"\tAddress: "+address1+"\tCar Model: "+car_model1+"\tNumber of Cars: "+no_car1);
							System.out.println("");
							System.out.println("  Deleting the Record....");
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
						System.out.println("\n -_-Customer Deleted-_-\n");
					}
					else{
						System.out.println("\n Customer with "+num+" phone number doesn't exists");
					}
				}

				else if(choice==5){
					System.out.println("\nGood Bye!! See you soon!!\n");
					exit=1;
				}
				else{
					System.out.println("\n Try Again.\n Please enter a valid number.");
				}
			}
			catch(InputMismatchException e){
				System.out.println(" Thank you");
				exit=1;
			}
		}
		
		scan.close();
	}
}