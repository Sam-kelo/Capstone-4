package poisedproject;

public class Person {

	// Attributes.
		String Name;
		int TelephoneNumber;
		String EmailAddress;
		String PhysicalAddress;		
		Person Customer;
		Person Contractor;
		Person Architect;

		// Constructor.
		public Person(String Name, int TelephoneNumber, String EmailAddress, String PhysicalAddress) {

			this.Name= Name;
			this.TelephoneNumber = TelephoneNumber;
			this.EmailAddress= EmailAddress;
			this.PhysicalAddress = PhysicalAddress;

		}

		// Methods.
		public void setTelephoneNumber (int CustomerTelephoneNumber) {
			this.TelephoneNumber = CustomerTelephoneNumber ;
		}
		public void setEmailAddress (String CustomerEmailAddress){
			this.EmailAddress = CustomerEmailAddress;

		}

		// Method.
		public String toString() {
			String output = "Details:";
			output += "\nName: " + Name ;
			output += "\nTelephone Number: " +TelephoneNumber;
			output += "\nEmail Address: " + EmailAddress;
			output += "\nPhysical Address: " + PhysicalAddress;
			return output;
		}
	}
	
