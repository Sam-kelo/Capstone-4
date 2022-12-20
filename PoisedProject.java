package poisedproject;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.FileWriter;

public class PoisedProject {

	public static void main(String[]args) throws ParseException, IOException{
		// Declaring array that will contain different class data.
		ArrayList<Project>ProjectsArray = new ArrayList<Project>();
	
		// File that is to be read and converted to an array.
		String file = "Projects.txt";
		String line = "";

		// Using a buffered reader to read the file contents.
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				String[] element= line.split(",");

				String CustomerName = element[9];
				int CustomerTelephoneNumber = Integer.parseInt(element[10]);
				String CustomerEmailAddress = element[11];
				String CustomerPhysicalAddress = element[12];			
				Person Customer = new Person( CustomerName, CustomerTelephoneNumber, CustomerEmailAddress,CustomerPhysicalAddress);
	
				String ArchitectName = element[17];
				int ArchitectTelephoneNumber = Integer.parseInt(element[18]);
				String ArchitectEmailAddress = element[19];
				String ArchitectPhysicalAddress = element[20];			
				Person Architect =new Person( ArchitectName, ArchitectTelephoneNumber, ArchitectEmailAddress,ArchitectPhysicalAddress);
				
				String ContractorName = element[13];
				int ContractorTelephoneNumber = Integer.parseInt(element[14]);
				String ContractorEmailAddress = element[15];
				String ContractorPhysicalAddress = element[16];			
				Person Contractor= new Person( ContractorName, ContractorTelephoneNumber, ContractorEmailAddress,ContractorPhysicalAddress);

				int ProjectNumber = Integer.parseInt(element[0]);
				int ERFNumber = Integer.parseInt(element[1]);
				String ProjectName = element[2];
				String ProjectType = element[3];
				String ProjectAddress= element[4];
				String ProjCustomerName = element[5];
				String Deadline= element[6];
				String Completion= element[7];
				String CompletionDate = element[8];
				ProjectsArray.add(new Project(ProjectNumber, ERFNumber, ProjectName, ProjectType, ProjectAddress,ProjCustomerName
						,Deadline, Completion, CompletionDate, Customer, Architect, Contractor));
				
			}
		}catch(FileNotFoundException e) {
			System.out.println("File not found");
		}			

		// File that is to be read and converted to an array.
		
		int choice = 0;
		String answer;

		// Scanner object for user choice.
		Scanner sc = new Scanner(System.in);
		try{
				
		// Main menu
		do {
		
			System.out.println("Menu: ");
			System.out.println("1. View current projects: ");
			System.out.println("2. Capture project details: ");
			System.out.println("3. Change a projects due date: ");
			System.out.println("4. Update contractor details: ");
			System.out.println("5. View complete and incomplete projects: ");
			System.out.println("6. Finalise a project: ");
			System.out.println("7. Generate Invoice: ");

			System.out.println("Enter choice here: ");
			choice = sc.nextInt();
		
			// Switch case for user selection.
			switch(choice) {	
			
			case 1:
				
				// Printing out project content.
				System.out.println(ProjectsArray);
				System.out.println();	
			
				break;
			// Capturing project details.
			case 2:
				
				try {
					System.out.println("Enter project number: ");
					Scanner proj_num = new Scanner(System.in);
					int ProjectNumber = proj_num.nextInt();				

					System.out.println("Enter project name: ");
					Scanner projName = new Scanner(System.in);
					String ProjectName = projName.nextLine();	

					System.out.println("Enter project address: ");
					Scanner projAddress = new Scanner(System.in);
					String ProjectAddress = projAddress.nextLine();	

					try {
						System.out.println("Enter the ERF number.9 numbers maximum: ");
						Scanner ERF_num = new Scanner(System.in);
						int ERFNumber = ERF_num.nextInt();			

						System.out.println("Enter project type: ");
						Scanner projType = new Scanner(System.in);
						String ProjectType = projType.nextLine();

						System.out.println("Enter customer name: ");
						Scanner projCustomerName = new Scanner(System.in);
						String ProjCustomerName = projCustomerName.nextLine();	

						try {

							/* Should the user enter an incorrect date format, the user will
							 * be asked to re-enter a correct date after inputting the due date.
							 */				
							System.out.println("Enter current date (dd-MM-yyyy):");
							Scanner current_date = new Scanner(System.in);
							String date1 = current_date.nextLine();

							System.out.println("Enter deadline for the project (dd-MM-yyyy): ");
							Scanner deadline = new Scanner(System.in);
							String Deadline = deadline.nextLine();

							SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
							java.util.Date firstDate = df.parse(date1);
							java.util.Date secondDate = df.parse(Deadline);						
							System.out.println("Project captured. ");
							System.out.println();

							// Capturing customer details
							System.out.println("Enter customer name: ");
							Scanner projCustomer = new Scanner(System.in);
							String CustomerName = projCustomer.nextLine();	
							try {
								System.out.println("Enter customer telephone number.(10 digits maximum starting with 0.eg-0112685824): ");
								Scanner projCustomerTelephone = new Scanner(System.in);
								int CustomerTelephoneNumber = projCustomerTelephone.nextInt();	

								System.out.println("Enter customer email address: ");
								Scanner projCustomerEmail = new Scanner(System.in);
								String CustomerEmailAddress = projCustomerEmail.nextLine();	

								System.out.println("Enter customer physical address: ");
								Scanner projCustomeraddress = new Scanner(System.in);
								String CustomerPhysicalAddress = projCustomeraddress.nextLine();	

								Person Customer = new Person(CustomerName, CustomerTelephoneNumber, CustomerEmailAddress, CustomerPhysicalAddress);								
								System.out.println("Customer details have been captured: ");
								System.out.println();

								// Capturing architect details.
								System.out.println("Enter architect name: ");
								Scanner projArchitect = new Scanner(System.in);
								String architectName = projArchitect.nextLine();	

								System.out.println("Enter architect telephone number.(10 digits maximum starting with 0.eg-0112685824): ");
								Scanner projArchitectTelephone = new Scanner(System.in);
								int architectTelephoneNumber = projArchitectTelephone.nextInt();	

								System.out.println("Enter architect email address: ");
								Scanner projArchitectEmail = new Scanner(System.in);
								String architectEmailAddress = projArchitectEmail.nextLine();	

								System.out.println("Enter architect physical address: ");
								Scanner projArchitectaddress = new Scanner(System.in);
								String architectPhysicalAddress = projArchitectaddress.nextLine();	

								Person Architect = new Person(architectName, architectTelephoneNumber, architectEmailAddress,  architectPhysicalAddress);			
								System.out.println("Architect details have been captured: ");
								System.out.println();

								// Capturing contractor details.
								System.out.println("Enter contractor name: ");
								Scanner projContractor = new Scanner(System.in);
								String contractorName = projContractor.nextLine();	

								System.out.println("Enter contractor telephone number.(10 digits maximum starting with 0.eg-0112685824): ");
								Scanner projContractorTelephone = new Scanner(System.in);
								int contractorTelephoneNumber = projContractorTelephone.nextInt();	

								System.out.println("Enter contractor email address: ");
								Scanner projContractorEmail = new Scanner(System.in);
								String contractorEmailAddress = projContractorEmail.nextLine();	

								System.out.println("Enter contractor physical address: ");
								Scanner projContractoraddress = new Scanner(System.in);
								String contractorPhysicalAddress = projContractoraddress.nextLine();	

								Person Contractor = new Person(contractorName, contractorTelephoneNumber, contractorEmailAddress, contractorPhysicalAddress);
								System.out.println("Contractor details have been captured: ");
								System.out.println();				

								if (firstDate.after(secondDate))
								{
									System.out.println("Project is overdue.");

								}
								/*
								 *  If the user does not enter a project name, then the project name
								 *  will include the project type and the customer name. Else it will
								 *  print in the normal class structure.
								 */
								if(ProjectName.equals("")) {

									Project projectObj1 = new Project(ProjectNumber, ERFNumber,ProjectName+"/"+ProjectType+" "+ProjCustomerName, ProjectType,ProjectAddress,
											ProjCustomerName,Deadline,"No", " ",Customer,Architect,Contractor);
									ProjectsArray.add(projectObj1);
									System.out.println(projectObj1);
								}

								else {

									Project projectObj = new Project(ProjectNumber, ERFNumber, ProjectName, ProjectType, ProjectAddress,ProjCustomerName
											,Deadline, "No", " ", Customer, Architect, Contractor);
									ProjectsArray.add(projectObj);
									System.out.println(projectObj);	

								}

								try {

									// Writing new project to the file.
									File toFile = new File("Projects.txt");
									PrintWriter tf = new PrintWriter(toFile);

									for(int i = 0; i<ProjectsArray.size(); i++) {	

										tf.println(ProjectsArray.get(i).ProjectNumber+","+ProjectsArray.get(i).ERFNumber+","+ProjectsArray.get(i).ProjectName+","	
												+ProjectsArray.get(i).ProjectAddress+","+ProjectsArray.get(i).ProjectType+	
												","+ProjectsArray.get(i).ProjCustomerName+","+ProjectsArray.get(i).Deadline+","+ProjectsArray.get(i).Completion+","+
												ProjectsArray.get(i).CompletionDate+","+ProjectsArray.get(i).Customer.Name+","+ProjectsArray.get(i).Customer.TelephoneNumber+
												","+ProjectsArray.get(i).Customer.EmailAddress+","+ProjectsArray.get(i).Customer.PhysicalAddress+","+ProjectsArray.get(i).Architect.Name+
												","+ProjectsArray.get(i).Architect.TelephoneNumber+","+ProjectsArray.get(i).Architect.EmailAddress+","+ProjectsArray.get(i).Architect.PhysicalAddress+
												","+ProjectsArray.get(i).Contractor.Name+","+ProjectsArray.get(i).Contractor.TelephoneNumber+","+ProjectsArray.get(i).Contractor.EmailAddress+","+ProjectsArray.get(i).Contractor.PhysicalAddress);

										tf.flush();
									}	

									System.out.println();
									System.out.println("Written to file.");	

									// Exception handling.
								}catch(Exception e) {
									System.out.println("Unable to write to file");
								}

							}catch(InputMismatchException e) {
								System.out.println("Incorrect input. Please enter a valid telephone number");
							}
						}catch(ParseException e) {
							System.out.println("Please enter a valid date.");
						}
					}catch(InputMismatchException e) {
						System.out.println("Incorrect input. Please enter a number");						
					}
				}catch(InputMismatchException e) {

					System.out.println("Incorrect input. Please enter a project number");

				}	
				
				break;

			case 3:
				
				try {
					int selector1 = 0;		

					try {
						// Getting an index of a project selected by the user.
						System.out.println("Please Enter the index of the project to be updated: ");
						Scanner input = new Scanner(System.in);
						selector1 = input.nextInt();
						input.nextLine();
						selector1 = selector1 - 1;
						try {	
							System.out.println("Enter new due date: (dd-MM-yyyy)");
							Scanner newdeadline = new Scanner(System.in);
							String newDeadline = newdeadline.nextLine();

							SimpleDateFormat t= new SimpleDateFormat("dd-MM-yyyy");
							java.util.Date newduedate = t.parse(newDeadline);

							// Setting the new deadline in the projects array.	
							ProjectsArray.get(selector1).setDeadline(newDeadline);
							System.out.println(ProjectsArray.get(selector1).toString());

							System.out.print("Due date changed.");

							File fileEdit = new File("Projects.txt");
							PrintWriter fe = new PrintWriter(fileEdit);

							// Writing new due date to the file.
							try {
								for(selector1 = 0; selector1<ProjectsArray.size(); selector1++) {	
									fe.println(ProjectsArray.get(selector1).ProjectNumber+","+ProjectsArray.get(selector1).ERFNumber+","+ProjectsArray.get(selector1).ProjectName+","	
											+ProjectsArray.get(selector1).ProjectAddress+","+ProjectsArray.get(selector1).ProjectType+	
											","+ProjectsArray.get(selector1).ProjCustomerName+","+ProjectsArray.get(selector1).Deadline+","+ProjectsArray.get(selector1).Completion+","+
											ProjectsArray.get(selector1).CompletionDate+","+ProjectsArray.get(selector1).Customer.Name+","+ProjectsArray.get(selector1).Customer.TelephoneNumber+
											","+ProjectsArray.get(selector1).Customer.EmailAddress+","+ProjectsArray.get(selector1).Customer.PhysicalAddress+","+ProjectsArray.get(selector1).Architect.Name+
											","+ProjectsArray.get(selector1).Architect.TelephoneNumber+","+ProjectsArray.get(selector1).Architect.EmailAddress+","+ProjectsArray.get(selector1).Architect.PhysicalAddress+
											","+ProjectsArray.get(selector1).Contractor.Name+","+ProjectsArray.get(selector1).Contractor.TelephoneNumber+","+ProjectsArray.get(selector1).Contractor.EmailAddress+","+ProjectsArray.get(selector1).Contractor.PhysicalAddress);

								}

								fe.close();

								// Exception handling.
							}catch(Exception e) {
								System.out.println("Unable to write to file");
							}
						}catch(ParseException e) {
							System.out.println("Please enter a valid date.");

						}
					}catch(InputMismatchException e) {
						System.out.println("Incorrect input. Please enter a valid index.");
					}


				}catch(IndexOutOfBoundsException e) {
					System.out.println("Please enter a valid index.");

				}

				break;
							
			case 4: 
				
				try {

					int selector2 = 0;

					try {

						// Getting an index of a project selected by the user.
						System.out.println("Please Enter the index of the project to be updated: ");
						Scanner input = new Scanner(System.in);
						selector2 = input.nextInt();
						input.nextLine();
						selector2 = selector2 - 1;

						// Attaining contractor details and adding them to the contractor array.
						try {

							System.out.println("Enter contractors telephone number.(10 digits maximum starting with 0.eg-0112685824): ");
							Scanner contractorTel = new Scanner(System.in);
							int newContractorTelephoneNumber = contractorTel.nextInt();
							ProjectsArray.get(selector2).Contractor.setTelephoneNumber(newContractorTelephoneNumber);

							System.out.println("Enter the email address of the contractor: ");
							Scanner contractorEmail = new Scanner(System.in);
							String newContractorEmailAddress = contractorEmail.nextLine();
							ProjectsArray.get(selector2).Contractor.setEmailAddress(newContractorEmailAddress);
							System.out.println("Details have been edited.");
							
							File contractorEdit = new File("Projects.txt");
							PrintWriter ce = new PrintWriter(contractorEdit);
							
							// Writing new contractor details to the file.
							try {

								for(selector2 = 0; selector2<ProjectsArray.size(); selector2++) {	
									ce.println(ProjectsArray.get(selector2).ProjectNumber+","+ProjectsArray.get(selector2).ERFNumber+","+ProjectsArray.get(selector2).ProjectName+","	
											+ProjectsArray.get(selector2).ProjectAddress+","+ProjectsArray.get(selector2).ProjectType+	
											","+ProjectsArray.get(selector2).ProjCustomerName+","+ProjectsArray.get(selector2).Deadline+","+ProjectsArray.get(selector2).Completion+","+
											ProjectsArray.get(selector2).CompletionDate+","+ProjectsArray.get(selector2).Customer.Name+","+ProjectsArray.get(selector2).Customer.TelephoneNumber+
											","+ProjectsArray.get(selector2).Customer.EmailAddress+","+ProjectsArray.get(selector2).Customer.PhysicalAddress+","+ProjectsArray.get(selector2).Architect.Name+
											","+ProjectsArray.get(selector2).Architect.TelephoneNumber+","+ProjectsArray.get(selector2).Architect.EmailAddress+","+ProjectsArray.get(selector2).Architect.PhysicalAddress+
											","+ProjectsArray.get(selector2).Contractor.Name+","+ProjectsArray.get(selector2).Contractor.TelephoneNumber+","+ProjectsArray.get(selector2).Contractor.EmailAddress+","+ProjectsArray.get(selector2).Contractor.PhysicalAddress);

								}

								ce.close();

								// Exception handling.
							}catch(Exception e) {
								System.out.println("Unable to write to file");
							}
						}catch(InputMismatchException e) {
							System.out.println("Incorrect input. Please enter a telephone number");
						}
					}catch(InputMismatchException e) {
						System.out.println("Incorrect input. Please enter a valid index.");
					}
				}catch(IndexOutOfBoundsException e) {
					System.out.println("Please enter a valid index.");

				}

				break;

			case 5:

				int i;
				int j;

				System.out.println("Completed projects:");
				// Iterating through the project array to get all the completed projects.
				for(i = 0; i<ProjectsArray.size(); i++) {
					if(ProjectsArray.get(i).Completion.equals("Yes")) {
						System.out.println(ProjectsArray.get(i));
					}
				}
				System.out.println();
				System.out.println("Incomplete projects:");
				// Iterating through the project array to get all the incomplete projects.
				for(j = 0; j<ProjectsArray.size(); j++) {
					if(ProjectsArray.get(j).Completion.equals("No")){
						System.out.println(ProjectsArray.get(j));
					}
				}	

				break;	

			case 6:
					
				int selector3 = 0;		

				try{
					// Getting user input to select index.
					System.out.println("Enter the index project to be updated and finalised: ");
					Scanner iinput = new Scanner(System.in);
					selector3 = iinput.nextInt();
					selector3 = selector3 - 1;

					/*
					 * The user may leave each section blank to continue to keep current attributes or they
					 * may add new details.
					 */
					System.out.println("Edit the project or leave each section blank to keep pre existing details.");
					System.out.println();
					System.out.println("Change project name: ");
					Scanner projName = new Scanner(System.in);
					String ProjectName = projName.nextLine();	
					ProjectsArray.get(selector3).setProjectName(ProjectName);

					System.out.println("Change project address: ");
					Scanner projAddress = new Scanner(System.in);
					String ProjectAddress = projAddress.nextLine();	
					ProjectsArray.get(selector3).setProjectAddress(ProjectAddress);

					System.out.println("Change project type: ");
					Scanner projType = new Scanner(System.in);
					String ProjectType = projType.nextLine();
					ProjectsArray.get(selector3).setProjectType(ProjectType);

					// Setting the completion element to yes.
					ProjectsArray.get(selector3).setCompletion("Yes");

					//Setting completion date to current date and parsing it into a string.
					Date CompletionDate = new Date();
					SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
					String strDate = df.format(CompletionDate);

					ProjectsArray.get(selector3).setCompletionDate(strDate);

					try {
						// Writing updated project to a file.
						File file1 = new File("ProjectSummary.txt");
						PrintWriter pr = new PrintWriter(file1);

						for( selector3 = 0; selector3<ProjectsArray.size(); selector3++) {	

							pr.println("Project Number:"+ProjectsArray.get(selector3).ProjectNumber+"\nERF Number:"+ProjectsArray.get(selector3).ERFNumber+"\nProject Name:"+ ProjectsArray.get(selector3).ProjectName		
									+"\nProject Address"+ProjectsArray.get(selector3).ProjectAddress+"\nProject Type:"+ProjectsArray.get(selector3).ProjectType+	
									"\nCustomer Name:"+ProjectsArray.get(selector3).ProjCustomerName+"\nDeadline:"+ProjectsArray.get(selector3).Deadline+"\nCompleted:"+ProjectsArray.get(selector3).Completion+
									"\nDate of completion:"+(ProjectsArray.get(selector3).CompletionDate+"\n"));

							pr.flush();

						}	

						System.out.println("Written to file.");	

						// Exception handling.
					}catch(Exception e) {
						System.out.println("Unable to write to file");
					}

				}catch(InputMismatchException e) {
					System.out.println("Incorrect input. Please enter a valid index.");
				}
				catch(IndexOutOfBoundsException e) {
					System.out.println("The index does not exist. Please enter a valid index.");

				}

				break;	

			case 7:
				
				/*	Creating an invoice which contains current
				 *  fee paid and any amount outstanding.
				 */	
				System.out.println("Enter the name of the project: ");
				Scanner projectname = new Scanner(System.in);
				String ProjectName = projectname.nextLine();


				System.out.println("Enter the name of the customer: ");
				Scanner customername = new Scanner(System.in);
				String InvCustomerName = customername.nextLine();

				try {

					System.out.println("Enter the customer's telephone number.(10 digits maximum starting with 0.eg-0112685824): ");
					Scanner customertel = new Scanner(System.in);
					int CustomerTel= customertel.nextInt();

					System.out.println("Enter the building type: ");
					Scanner buildtype = new Scanner(System.in);
					String BuildingType = buildtype.nextLine();
					try {	

						System.out.println("Enter the total fee to be paid:");
						Scanner totalfee = new Scanner(System.in);
						double TotalFee = totalfee.nextDouble();

						System.out.println("Enter the total fee paid:");
						Scanner totalfeePaid = new Scanner(System.in);
						double FeePaid = totalfeePaid.nextDouble();

						Date todaysDate = new Date();

						// Determining the amount outstanding.
						double AmountOutstanding = TotalFee - FeePaid;

						// If the amount outstanding is 0 then there will be no invoice.
						if(AmountOutstanding == 0) {
							System.out.println("No invoice required");
						}
						// If there is an outstanding amount then an invoice will be generated.
						else {

							System.out.println("Invoice generated. ");
							System.out.println();

							File invoiceFile = new File("Invoice.txt");
							PrintWriter pw = new PrintWriter(invoiceFile);	

							pw.println("Invoice"+"\nProject Name: "+ProjectName+"\nCustomer name:"+InvCustomerName + "\nCustomer telephone number: "+CustomerTel +"\nBuilding type: "+BuildingType+"\nTotal fee: "+
									TotalFee+"\nFee paid: "+FeePaid+"\nAmount Outstanding: "+AmountOutstanding+"\nDate:"+todaysDate);
							pw.close();
						}

						// Exception handling.
					}catch(InputMismatchException e) {
						System.out.println("Incorrect input. Please enter a valid amount.");				
					}
				}catch(InputMismatchException e) {
					System.out.println("Incorrect input. Please enter a valid telephone number.");				
				}

				break;

			default:

				System.out.println("Please enter a valid choice.");			
			}

			// Giving the user an option to continue.	
			System.out.println();
			System.out.println("Would you like to return to the menu? Click \"y\" for yes or \"n\".");	
			answer = sc.next();	

			if(answer.equals ("y")) {
				continue;

			}

			else if (answer.equals("n")) {
				System.out.println("Thank you for using Poised Mananger.");
			}

			else {
				System.out.println("Please enter a valid option.");
			}

		}while(answer.equals("y"));

		}catch(InputMismatchException e) {
			System.out.println("Incorrect input. Please enter a valid choice.");
		}

		sc.close();

	}
}
