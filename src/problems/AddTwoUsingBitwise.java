package problems;

public class AddTwoUsingBitwise {

    public static int addTwo(int a, int b) {
        int carry = (a & b) << 1;
        a = a ^ b;

        if (carry == 0) {
            return a;
        }
        return addTwo(a, carry);
    }
    public static void main(String[] args) {
        System.out.println("Jsn!");
        System.out.println(addTwo(5,4));
        System.out.println(addTwo(1,2));
        System.out.println(addTwo(7,8));
        System.out.println(addTwo(90, 120));
    }
}
