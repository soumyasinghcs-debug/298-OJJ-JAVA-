import java.util.Scanner;

class WrongAge extends Exception{
    WrongAge(String message){
        super(message);
    }
}

class father{
    int fatherAge;
    father(int age) throws WrongAge{
        if (age<0){
            throw new WrongAge("Fathers age cant be negative");
        }
        fatherAge= age;

    }
    void display(){
        System.out.println("Fathers age: " + fatherAge);
    }
}
class son extends father{
    int sonAge;


    son(int fatherAge, int sonAge) throws WrongAge {
        super(fatherAge);

        if(sonAge < 0 ){
            throw new WrongAge("Sons age cant be negative");
        }
        if (sonAge > fatherAge){
            throw new WrongAge("Sons age cant be greater than fathers age");
        }
        this.sonAge = sonAge;

    }
    void display(){
        System.out.println("Sons age: " + sonAge);
    }

} 
public class LAB7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter Fathers Age: ");
            int fatherAge= sc.nextInt();
            System.out.print("Enter sons Age: ");
            int sonAge= sc.nextInt();

            father f = new father (fatherAge);
            son s = new son (fatherAge, sonAge);


            f.display();
            s.display();
    } catch(WrongAge e){
        System.out.println("Exception: " + e.getMessage());
    }
}
}
