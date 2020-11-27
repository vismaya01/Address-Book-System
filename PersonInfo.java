class PersonInfo {
        public String firstName;
        public String lastName;
        public String address;
        public String city;
        public String state;
        public String zip;
        public String phoneNumber;
        public String email;

        //Standard setters
        public void setFirstName (String firstName) {
                this.firstName = firstName;
        }
        public void setLastName (String lastName) {
                this.lastName = lastName;
        }

        public void setAddress (String address){
                this.address = address;
        }
        public void setCity (String city) {
                this.city = city;
        }
        public void setState (String state) {
                this.state = state;
        }
        public void setZip (String zip) {
                this.zip = zip;
        }
        public void setPhoneNumber (String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }
        public void setEmail (String email) {
        	this.email = email;
        }

        //Standard getters
        public String getFirstName() {
                return this.firstName;
        }
         public String getLastName() {
                return this.lastName;
        }
        public String getAddress() {
                return this.address;
        }
         public String getCity() {
                return this.city;
        }
         public String getState() {
                return this.state;
        }
         public String getZip() {
                return this.zip;
        }
        public String getPhoneNumber() {
                return this.phoneNumber;
        }
        public String getEmail() {
        		return this.email;
	}

        //parameterized constructor
        public PersonInfo (String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email) {
                setFirstName(firstName);
                setLastName(lastName);
                setAddress(address);
                setCity(city);
                setState(state);
                setZip(zip);
                setPhoneNumber(phoneNumber);
                setEmail(email);
      }

		//method for displaying person record
        public String toString() {
                return "Name : " + this.firstName + " " + this.lastName +
                                "\nAddress : " + this.address +
                                "\nCity : " + this.city + " , " +"State : " + this.state + " , " +"ZIP : " + this.zip +
                                "\nPhone Number : " + this.phoneNumber + " \nEmail : " + this.email;
        }
}
