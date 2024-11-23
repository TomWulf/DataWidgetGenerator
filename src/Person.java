public class Person
{
    private String IDNum;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;
    static private int IDSeed =  1;

    // This is not required for the student assignment
    // Just shows how to use a Static Class Variable to control the sequence of the IDnums
    public static void setIDSeed(int IDSeed) {
        Person.IDSeed = IDSeed;
    }

    public static int getIDSeed() {
        return IDSeed;
    }

    public Person(String IDNum, String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = IDNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public Person(String firstName, String lastName, String title, int YOB)
    {
        this.IDNum = this.genIDNum();
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }


    public String getIDNum() {
        return IDNum;
    }

    private String genIDNum() {
        // Code update suggested by the IDE!  use a stringbuilder here
        StringBuilder newID = new StringBuilder("" + IDSeed);
        while(newID.length() < 8)
        {
            newID.insert(0, "0");
        }

        IDSeed++;

        return newID.toString();
    }

    public void setIDNum(String IDNum) {
        this.IDNum = IDNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Person{" +
                "IDNum='" + IDNum + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", YOB=" + YOB +
                '}';
    }

    public String toCSVDataString()
    {
        return IDNum + ", " + firstName  + ", " + lastName  + ", " + title + ", " + YOB;
    }


}
