public class Problem4 {
    public static void main(String[] args) {
        try {
            method();
            System.out.println("After the method call");
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundsException in method()");
        } catch (Exception ex) {
            System.out.println("Exception in main");
        }
    }

    static void method() throws Exception {
        try {
            String s = "abc";
            System.out.println(s.charAt(3));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("IndexOutOfBoundsException in method()");
        }
    }
}
