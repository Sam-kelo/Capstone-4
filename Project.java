package poisedproject;

public class Project {
	
	// Attributes.
	int ProjectNumber;
	String ProjectName;
	String ProjectType;
	String ProjectAddress;
	int ERFNumber;
	String CustomerName;
	String Deadline;
	String Completion;
	String CompletionDate;

	//Constructor.
	public Project(int ProjectNumber, int ERFNumber, String ProjectName, String ProjectType, String ProjectAddress,
			String CustomerName, String Deadline, String Completion, String CompletionDate){

		this.ProjectNumber = ProjectNumber;
		this.ProjectName = ProjectName;
		this.ProjectType = ProjectType;
		this.ProjectAddress = ProjectAddress;
		this.ERFNumber = ERFNumber;
		this.CustomerName = CustomerName;
		this.Deadline = Deadline;
		this.Completion = Completion;
		this.CompletionDate = CompletionDate;
	}
	// Methods
	public String getProjectName() {


		return ProjectName;
	}
	
	public void setProjectName(String ProjectName) {
		
		this.ProjectName = ProjectName;
	}
	

	public String getProjectType(){

		return ProjectType;
	}	
	
	public void setProjectType(String ProjectType) {
		
		this.ProjectType = ProjectType;
	}
	
	public int getERFNumber(){

		return ERFNumber;
	}

	public String getDeadline(){

		return Deadline;
	}
	
	public void setDeadline(String newDeadline) {
		
		this. Deadline = newDeadline;
	}
	
	public void setCompletion(String Completion) {
		
		this.Completion = Completion;
	}
	
	public void setCompletionDate(String CompletionDate) {
		
		this.CompletionDate = CompletionDate;
	}

	public String toString()
	{

		String output = "Project number: " + ProjectNumber;
		output += "\nProject name: " + ProjectName; 
		output += "\nProject address: " + ProjectAddress;
		output += "\nERF number: " + ERFNumber;
		output += "\nProject type: " + ProjectType;
		output += "\nCustomer name: " + CustomerName;
		output += "\nProject deadline: " + Deadline;
		return output;
	}

}

