public class MyTestingClass {
    private String firstName;
    private String lastName;
     private int age;
    public MyTestingClass(String firstName,String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    public String toString(){
        return "name: "+ firstName + " " + lastName + "   age: " + age;
    }
    public int getAge() {
        return age;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public int hashCode() {
        int result = 7;
        for (int i = 0; i < firstName.length(); i++) {
            result = 31 * result + firstName.charAt(i);
        }
        for (int i = 0; i < lastName.length(); i++) {
            result = 31 * result + lastName.charAt(i);
        }
        result = 31 * result + age;
        return result;
    }
}
