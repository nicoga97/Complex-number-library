package Main;

public class ComplexNumber {
    private double realPart;
    private double imaginaryPart;

    public ComplexNumber(double realPart, double imaginaryPart) {
        this.imaginaryPart=imaginaryPart;
        this.realPart=realPart;
    }

    public static ComplexNumber complexAdd(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getRealPart()+b.getRealPart(),a.getImaginaryPart()+b.getImaginaryPart());
    }

    public static ComplexNumber complexSubstraction(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(a.getRealPart()-b.getRealPart(),a.getImaginaryPart()-b.getImaginaryPart());
    }

    public static ComplexNumber complexMultiplication(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber((a.getRealPart()*b.getRealPart())-(a.getImaginaryPart()*b.getImaginaryPart()),((a.getRealPart()*b.getImaginaryPart())+(b.getRealPart()*a.getImaginaryPart())));
    }

    public static ComplexNumber complexDivision(ComplexNumber a, ComplexNumber b){
        return new ComplexNumber(((a.getRealPart()*b.getRealPart())+(a.getImaginaryPart()+b.getImaginaryPart()))/(Math.pow(b.getImaginaryPart(),2)+Math.pow(b.getRealPart(),2)),((b.getRealPart()*a.getImaginaryPart())-(a.getRealPart()*b.getImaginaryPart()))/(Math.pow(b.getRealPart(),2)+Math.pow(b.getImaginaryPart(),2)));
    }

    public static ComplexNumber complexConjuate(ComplexNumber a){
        a.setImaginaryPart(a.getImaginaryPart()*(-1));
        return a;
    }

    public static double complexModulus(){
        return 1.0;
    }



    public double getRealPart() {
        return realPart;
    }

    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    public double getImaginaryPart() {
        return imaginaryPart;
    }

    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }

    @Override
    public String toString() {
        return "Main.ComplexNumber[" +
                + realPart +
                "," + imaginaryPart +
                ']';
    }
}
