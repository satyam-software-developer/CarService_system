import java.io.*;
import java.util.*;

class items{
	public static void main(String[] args) throws IOException,NullPointerException,FileNotFoundException{
		Scanner scan = new Scanner(System.in);
		System.out.println("");
		System.out.println("\t\t Welcome to Sports Vision \n\t Item Addition and Modification Program");
		System.out.println("");
		int exit = 1;
		while(exit!=0){
			System.out.println("\nChoose from the following options\n1. ADD \n2. MODIFY \n3. View \n4. Delete\n5. Exit\t");
			System.out.println("");
			int ch = scan.nextInt();
			top: 
			if (ch==1){
				System.out.println("");
				System.out.println("Enter Part ID:");
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
						System.out.println("\nAn entry already exists for the given part ID under the name '"+result[1]+"' for price Rs "+result[3]);
						break top;
					}
				}
				System.out.println("\nCar Model Name:");
				String mname = scan.nextLine();
				System.out.println("\nPart Name:");
				String pname = scan.nextLine();
				System.out.println("\nPrice per unit:");
				String price = scan.nextLine(); 
				br1.close();
				PrintWriter pw = new PrintWriter(new FileOutputStream(new File("item-list.txt"),true));
				String b = pid + "|" + mname + "|" + pname + "|" + price + "|";
				System.out.println("");
				pw.println(b);
				pw.flush();
				pw.close();
				System.out.println("");
				System.out.println("------->>  PID: "+pid+"\n------->>  Model Name: "+mname+"\n------->>  Product name: "+pname+"\n------->>  Price: "+price);
				System.out.println("\n\t<____Part Added____>");
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
				System.out.println("Enter Part ID:");
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
						System.out.println(">>>>  PID: "+pid+"\tModel Name: "+mname+"\tProduct name: "+pname+"\tPrice: "+price);
						System.out.println("");
						System.out.println("\nEnter which detail would you like to change\n1: Part Id\n2: Model Name\n3: Product name\n4: Price\n5: All");
						int ch1 = scan.nextInt();
						switch (ch1) {
							case 1:
								System.out.println("Enter new PID:");
								scan.nextLine();
								String pid11 = scan.nextLine();
								System.out.println("\n Modified Part Details: ");
								System.out.println("------->>  PID: "+pid11+"\n------->>  Model Name: "+mname+"\n------->>  Pname: "+pname+"\n------->>  Price: "+price);
								String b1 = pid11+"|"+mname+"|"+pname+"|"+price+"|";
								pw.println(b1);
								break;
							
							case 2:
								System.out.println("\nEnter new Model name:");
								scan.nextLine();
								String mname11 = scan.nextLine();
								System.out.println("\n Modified Part Details: ");
								System.out.println("------->>  PID: "+pid+"\n------->>  Model Name: "+mname11+"\n------->>  Pname: "+pname+"\n------->>  Price: "+price);
								String b2 = pid+"|"+mname11+"|"+pname+"|"+price+"|";
								pw.println(b2);
								break;
							
							case 3:
								System.out.println("\nEnter new Pname:");
								scan.nextLine();
								String pname11 = scan.nextLine();
								System.out.println("\n Modified Part Details: ");
								System.out.println("------->>  PID: "+pid+"\n------->>  Model Name: "+mname+"\n------->>  Pname: "+pname11+"\n------->>  Price: "+price);
								String b3 = pid+"|"+mname+"|"+pname11+"|"+price+"|";
								pw.println(b3);
								break;
							
							case 4:
								System.out.println("\nEnter new Price:");
								scan.nextLine();
								String price11 = scan.nextLine();
								System.out.println("\n Modified Part Details: ");
								System.out.println("------->>  PID: "+pid+"\n------->>  Model Name: "+mname+"\n------->>  Pname: "+pname+"\n------->>  Price: "+price11);
								String b4 = pid1+"|"+mname+"|"+pname+"|"+price11+"|";
								pw.println(b4);
								break;
							
							case 5:
								System.out.println("Enter new PID:");
								scan.nextLine();
								String pid12 = scan.nextLine();			
								System.out.println("\nEnter new Model name:");
								String mname12 = scan.nextLine();
								System.out.println("\nEnter new Pname:");
								String pname12 = scan.nextLine();
								System.out.println("\nEnter new Price:");
								String price12 = scan.nextLine();
								System.out.println("\n Modified Part Details: ");
								System.out.println("------->>  PID: "+pid12+"\n------->>  Model Name: "+mname12+"\n------->>  Pname: "+pname12+"\n------->>  Price: "+price12);
								String b5 = pid12+"|"+mname12+"|"+pname12+"|"+price12+"|";
								pw.println(b5);
								break;
							default:
								System.out.println("\nIncorrect Option!!!");
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
					System.out.println("\nPart Details Modified\n");
				}
				else{
					System.out.println("\nNo Entery Found For The Enterd Part ID\n");
				}
			}
			else if (ch==3){
				String pid = "", mname = "", pname = "", price = "", r;
				File file = new File("item-list.txt");
				BufferedReader br = new BufferedReader(new FileReader(file));
				System.out.println("\t\t>>>>>>>____ITEMS____<<<<<<<");
				System.out.print("+-------+----------------+--------------------------+-----------+\n");
				System.out.printf("|  %-5s| %-15s| %-25s| %-10s|\n","PID", "Model Name", "Part name", "Price");
				System.out.print("|_______|________________|__________________________|___________|\n");
				while((r= br.readLine()) !=null)
				{	
					String[] result = r.split("\\|");
					pid=result[0];
					mname=result[1];
					pname=result[2];
					price=result[3];
					System.out.printf("|  %-5s| %-15s| %-25s| %-10s|\n",pid,mname,pname,price);
					System.out.print("|       |                |                          |           |\n");
				}
				System.out.print("|_______|________________|__________________________|___________|\n");
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
				System.out.println("Enter the Part Number to be deleted:  ");
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
						System.out.println("------->>  PID: "+pid2+"\n------->>  Model Name: "+mname2+"\n------->>  Pname: "+pname2+"\n------->>  Price: "+price2);
						System.out.println("");
						System.out.println("  Deleting the Item....");
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
					System.out.println("\n -_-Item Deleted-_-\n");
				}
				else{
					System.out.println("\n Item with "+num+" item number doesn't exists");
				}
			}

			else if (ch==5){
				System.out.println("\nGood Bye!! See you soon!!\n");
				exit=0;
			}
			else{
				System.out.println("\nTry Again.\n Please enter a valid number.");
			}
		}
		scan.close(); 
	}
}



