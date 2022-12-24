public class App {
    public static void main(String[] args) throws Exception {

        ComplexNumber z = new ComplexNumber(1, -1);
        
        System.out.println(z);

        ComplexNumber w = new ComplexNumber();

        w = z.pow(3);

        System.out.println(w);

        

        
    }
}
