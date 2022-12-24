
public class ComplexNumber {

    private double x;
    private double y;
    private double r;
    private double phi;

    public ComplexNumber(){
        x = 0;
        y = 0;
    };

    public ComplexNumber(double real){
        x = real;
        y = 0;
    }

    public ComplexNumber(double real, double imaginary){
        x = real;
        y = imaginary;
    }

    public void setX(double real){
        x = real;
    }

    public void setY(double imaginary){
        y = imaginary;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getRadius(){
        return r;
    }

    public double getArgument(){
        return phi;
    }

    public ComplexNumber addition(ComplexNumber w){
        return new ComplexNumber(x + w.x, y + w.y);
    }

    public ComplexNumber subtraction(ComplexNumber w){
        return new ComplexNumber(x - w.x, y - w.y);
    }

    public ComplexNumber multiplication(ComplexNumber w){
        return new ComplexNumber(x*w.x - y*w.y, x*w.y + y*w.x);
    }

    public ComplexNumber conjugation(){
        return new ComplexNumber(x, -y);
    }

    public double length(){
        return x*x + y*y;
    }

    public double absolute(){
        r = Math.sqrt(x*x + y*y);
        return r;
    }

    public ComplexNumber coefMultiplication(double a){
        return new ComplexNumber(a*x, a*y);
    }

    public ComplexNumber division(ComplexNumber w){
        if(x == 0 && y == 0) throw new ArithmeticException("Division by zero");
        return multiplication(w.conjugation()).coefMultiplication(1 / w.length());
    }

    public double argument(){
        phi = Math.atan2(y, x);
        return phi;
    }

    public ComplexNumber pow(int n){
        this.argument();
        this.absolute();
        
        double tmpRad = Math.pow(r, n);

        return new ComplexNumber(tmpRad * Math.cos(n*phi), tmpRad * Math.sin(n*phi));
    }

    public ComplexNumber Ln(){
        return new ComplexNumber(Math.log(absolute()), argument());
    }



    @Override
    public String toString() {
        String ans = "";
        if(x != 0) ans += String.format("%.2f", x);
        
        if(y < 0) {
            if(y == -1) ans += " - i";
            else ans += " - " + String.format("%.2f", Math.abs(y)) + "i";
        }
        else if(y > 0) {
            if(y == 1) ans += " + i";
            else ans += " + " + String.format("%.2f", y) + "i";
        }
        else return x+"";

        if(x == 0) return ans.substring(3, ans.length());
        return ans;
    }
}
