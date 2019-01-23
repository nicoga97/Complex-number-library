package Main;

public class MathComplex {

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

}
