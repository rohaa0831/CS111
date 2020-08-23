public class HeartTransplant
{

/* ------ Instance variables -------- */

// Person array, each Person is read from the data file
private Person[] listOfPatients;

// SurvivabilityByAge array, each rate is read from data file
private SurvivabilityByAge[] survivabilityByAge;

// SurvivabilityByCause array, each rate is read from data file
private SurvivabilityByCause[] survivabilityByCause;

/* ------ Constructor -------- */
 
/*
* Initializes all instance variables to null.
*/
public HeartTransplant()
 {
this.listOfPatients = null;
this.survivabilityByAge = null;
this.survivabilityByCause = null;
}

/* ------ Methods -------- */

/*
* Inserts Person p into listOfPatients
*
* Returns: 0 if successfully inserts p into array,
* -1 if there is not enough space to insert p into array
*/
public int addPerson(Person p, int arrayIndex){
 if( arrayIndex < 0 || arrayIndex >= listOfPatients.length){
 return -1;
 }
 try{
 listOfPatients[arrayIndex] = p;
 }
 catch(Exception e){
 return -1;
 }
 return 0;
}

/*
* 1) Creates the listOfPatients array with numberOfLines length.
*
* 2) Reads from the command line data file.
* File Format: ID, Ethinicity, Gender, Age, Cause, Urgency, State of health
* Each line refers to one Person.
*
* 3) Inserts each person from file into listOfPatients
* Hint: uses addPerson() method
*
* Returns the number of patients read from file
*/
//public static void main (String[] args){
public int readPersonsFromFile(int numberOfLines){
 listOfPatients = new Person[numberOfLines];
 //return hello;
 int patientCount = 0;
 for(int i=0; i<listOfPatients.length;i++){
 int id = StdIn.readInt();
 int eth= StdIn.readInt();
 int gender = StdIn.readInt();
 int age = StdIn.readInt();
 int cause = StdIn.readInt();
 int urgency =StdIn.readInt();
 int soh = StdIn.readInt();
 Person a = new Person(id,eth,gender,age,cause,urgency,soh);
 addPerson(a,i);
 patientCount++;
 
 }
 return patientCount;

 }


 


/*
* 1) Creates the survivabilityByAge array with numberOfLines length.
*
* 2) Reads from the command line file.
* File Format: Age YearsPostTransplant Rate
* Each line refers to one survivability rate by age.
*
* 3) Inserts each rate from file into the survivabilityByAge array
*
* Returns the number of survivabilities rates read from file
*/
public int readSurvivabilityRateByAgeFromFile (int numberOfLines) {

 // WRITE YOUR CODE HERE
 this.survivabilityByAge= new SurvivabilityByAge[numberOfLines];
 int rates = 0;
 for(int i = 0; i<numberOfLines;i++){
 int a = StdIn.readInt();
 int b = StdIn.readInt();
 double c = StdIn.readDouble();
 SurvivabilityByAge d = new SurvivabilityByAge(a,b,c);
 survivabilityByAge[i] = d;
 rates++;
 }
 return rates; 
}

/*
* 1) Creates the survivabilityByCause array with numberOfLines length.
*
* 2) Reads from the command line file.
* File Format: Cause YearsPostTransplant Rate
* Each line refers to one survivability rate by cause.
*
* 3) Inserts each rate from file into the survivabilityByCause array
*
* Returns the number of survivabilities rates read from file
*/
public int readSurvivabilityRateByCauseFromFile (int numberOfLines) {

 this.survivabilityByCause = new SurvivabilityByCause[15];
 int rates = 0;
 for(int i=0; i<numberOfLines;i++){
 int a = StdIn.readInt();
 int b = StdIn.readInt();
 double c = StdIn.readDouble();
 SurvivabilityByCause d = new SurvivabilityByCause(a,b,c);
 survivabilityByCause[i]= d; 
 rates++;
 }
 return rates; 
}
 
/*
* Returns listOfPatients
*/
public Person[] getListOfPatients(){
 return listOfPatients;
}

/*
* Returns survivabilityByAge
*/
//apply main method and return 
public SurvivabilityByAge[] getSurvivabilityByAge(){
 return survivabilityByAge;
}

/*
* Returns survivabilityByCause
*/
//apply main method and return
public SurvivabilityByCause[] getSurvivabilityByCause(){
 return survivabilityByCause;
}

/*
* Returns a Person array in which with every Person that has
* age above the parameter age from the listOfPatients array.
*
* The return array has to be completely full with no empty
* spots, that is the array size should be equal to the number
* of persons with age above the parameter age.
*
* Return null if there is no Person with age above the
* parameter age.
*/
public Person[] getPatientsWithAgeAbove(int age){
 int count = 0;
 for(int i = 0; i < listOfPatients.length; i++){
 if(listOfPatients[i].getAge()> age)
 count++;
 //else (return null);
 }
 if(count == 0)
 return null;
 int index = 0;
 Person[] patientsWithAgeAbove = new Person[count];
 for(int i = 0; i < listOfPatients.length; i++){
 if(listOfPatients[i].getAge()> age)
 patientsWithAgeAbove[index++] = listOfPatients[i];
 }
 return patientsWithAgeAbove;
}
 
/*
* Returns a Person array with every Person that has the state of health
* equal to the parameter state from the listOfPatients array.
*
* The return array has to be completely full with no empty
* spots, that is the array size should be equal to the number
* of persons with the state of health equal to the parameter state.
*
* Return null if there is no Person with the state of health
* equal to the parameter state.
*/
public Person[] getPatientsByStateOfHealth(int state){
 int count = 0;
 for(int i = 0; i < listOfPatients.length; i++){
 if(listOfPatients[i].getStateOfHealth() == state)
 count++;
 }
 if(count == 0)
 return null;
 int index = 0;
 Person[] patientsByStateOfHealth = new Person[count];
 for(int i = 0; i < listOfPatients.length; i++){
 if(listOfPatients[i].getStateOfHealth() == state)
 patientsByStateOfHealth[index++] = listOfPatients[i];
 }
 return patientsByStateOfHealth;
}

/*
* Returns a Person array with every person that has the heart
* condition cause equal to the parameter cause from the listOfPatients array.
*
* The return array has to be completely full with no empty
* spots, that is the array size should be equal to the number
* of persons with the heart condition cause equal to the parameter cause.
*
* Return null if there is no Person with the heart condition cause
* equal to the parameter cause.
*/
public Person[] getPatientsByHeartConditionCause(int cause){
 int count = 0;
 for(int i = 0; i < listOfPatients.length; i++){
 if(listOfPatients[i].getCause() == cause)
 count++;
 }
 if(count == 0)
 return null;
 int index = 0;
 Person[] patientsByHeartConditionCause = new Person[count];
 for(int i = 0; i < listOfPatients.length; i++){
 if(listOfPatients[i].getCause() == cause)
 patientsByHeartConditionCause[index++] = listOfPatients[i];
 }
 return patientsByHeartConditionCause;
}

/*
* Assume there are numberOfHearts available for transplantation surgery.
* Also assume that the hearts are of the same blood type as the
* persons on the listOfPatients.
* This method finds a set of persons to be the recepients of these
* hearts.
*
* The method returns a Person array from the listOfPatients
* array that have the highest potential for survivability after
* the transplant. The array size is numberOfHearts.
*
* If numberOfHeartsAvailable is greater than listOfPatients
* array size all Persons will receive a transplant.
*
* If numberOfHeartsAvailable is smaller than listOfPatients
* array size find the set of people with the highest
* potential for survivability.
*
* There is no correct solution, you may come up with any set of
* persons from the listOfPatients array.
*/
public Person[] match(int numberOfHearts){
 if(numberOfHearts == 0){
 return null;
 }
 if(numberOfHearts >= listOfPatients.length){
 return listOfPatients;
 }
 Person[] returnList = new Person[numberOfHearts];
 int i = 0;
 for(int j = 0 ; j < survivabilityByCause.length ; j++){
 SurvivabilityByCause c = survivabilityByCause[i];
 int pCount = 0;
 Person[] peeps = getPatientsByHeartConditionCause(c.getCause());
 while(i <= numberOfHearts && pCount < peeps.length){
 returnList[i] = peeps[pCount];
 pCount++;
 i++;
 }
 }
 return returnList;
}

/*
* Client to test the methods you write
*/
public static void main (String[] args){
 HeartTransplant ht = new HeartTransplant();
 // read persons from file
 int numberOfLines = StdIn.readInt();
 int numberOfReadings = ht.readPersonsFromFile(numberOfLines);
 StdOut.println(numberOfReadings + " patients read from file.");
 // read survivability by age from file
 numberOfLines = StdIn.readInt();
 numberOfReadings = ht.readSurvivabilityRateByAgeFromFile(numberOfLines);
 StdOut.println(numberOfReadings + " survivability rates by age lines read from file.");
 // read survivability by heart condition cause from file
 numberOfLines = StdIn.readInt();
 numberOfReadings = ht.readSurvivabilityRateByCauseFromFile(numberOfLines);
 StdOut.println(numberOfReadings + " survivability rates by cause lines read from file.");
 // list all patients
 for (Person p : ht.getListOfPatients()){
 StdOut.println(p);
 }// list survivability by age rates
 for (SurvivabilityByAge rate : ht.getSurvivabilityByAge()){
 StdOut.println(rate);
 }
 // list survivability by cause rates
 for (SurvivabilityByCause rate : ht.getSurvivabilityByCause()){
 StdOut.println(rate);
 }


}
}
public class Recursion { 

02.  /* Assume that n is no less than 0 and no greater than the 
03.    length of the array a */
04.   public static boolean m1(int[] a, int n) { 
05.      if (n <= 0) return true; 
06.      if (!m2(a[n - 1])) return false;  
07.      else return m1(a, n - 1);
08.   }
09.  /* Assume that num is never less than 2 */
10.  public static boolean m2(int num) {
11.      return m3(num, 2);
12.  }
13.  private static boolean m3(int num, int divisor) {
14.     if (num < 2 || (num > 2 && num % divisor == 0))
15.		  return false;
16.     if (divisor <= Math.sqrt(num))
17.         return m3(num, divisor + 1);
18.     return true;
19.  }
20.  public static void main(String[] args) {
21.     int[] array = {6, 2, 5};
22.	   m1(array, 3);
23.  }
24. }
