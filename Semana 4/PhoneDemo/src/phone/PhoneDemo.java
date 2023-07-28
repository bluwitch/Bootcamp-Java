package phone;

public class PhoneDemo {

    public static void main(String[] args) {
        Galaxy A13 = new Galaxy("A13", 100, "Verizon", "ringtone");
        IPhone iphone = new IPhone("X", 100, "AT&T", "ringtone");

        iphone.displayInfo();
        System.out.println(iphone.ring());
        System.out.println(iphone.unlock());
                
        A13.displayInfo();
        System.out.println(A13.ring());
        System.out.println(A13.unlock());
    }

}
