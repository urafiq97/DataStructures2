public class Student implements Cloneable
{
    private String name;
    private double gpa;
    
    public Student( String n, double g )
    {
        name = n;
        gpa = g;
    }
    
    public boolean equals ( Object obj )
    {
        return ( this.name.equals(((Student)obj).name) && this.gpa == ((Student)obj).gpa );
    }
   
    public int hashCode()
    {
        return name.hashCode() + (int)gpa;
    }
    
    public Object clone()
    {
        return new Student(name, gpa);
    }
    
    public String toString()
    {
        return name;
    }
}