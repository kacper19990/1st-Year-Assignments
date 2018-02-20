public class Rational {
    int numerator;
    int denominator;

    public Rational(int numerator, int denominator){
        this.numerator = numerator;
        if(denominator == 0){
            System.out.println("Cannot divide by 0");
        }
        else
            this.denominator = denominator;
    }

    public Rational(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
    }

    int[] totsFraction = new int[2];

    public void add(int num2, int dem2){
        int addNum;
        if(denominator == dem2){
            addNum = numerator + num2;
            totsFraction[0] = addNum;
            totsFraction[1] = denominator;
        }
        else{
            int temp = denominator * dem2;
            int topLeft = numerator * dem2;
            int topRight = num2 * denominator;
            addNum = topLeft + topRight;
            totsFraction[0] = addNum;
            totsFraction[1] = temp;
        }
    }

    public void subtract(int num2, int dem2){
        int subNum;
        if(denominator == dem2){
            subNum = numerator - num2;
            totsFraction[0] = subNum;
            totsFraction[1] = denominator;
        }
        else{
            int temp = denominator * dem2;
            int topLeft = numerator * dem2;
            int topRight = num2 * denominator;
            subNum = topLeft - topRight;
            totsFraction[0] = subNum;
            totsFraction[1] = temp;
        }
    }

    public void multiply(int num2, int dem2){
        int topNum;
        int botNum;
        topNum = numerator * num2;
        botNum = denominator * dem2;
        totsFraction[0] = topNum;
        totsFraction[1] = botNum;
    }

    public void divide(int num2, int dem2){
        int topNum;
        int botNum;
        int temp;
        temp = num2;
        num2 = dem2;
        dem2 = temp;
        topNum = numerator * num2;
        botNum = denominator * dem2;
        totsFraction[0] = topNum;
        totsFraction[1] = botNum;
    }

    public boolean equals(int num2, int dem2){
        int temp;
        temp = numerator * dem2;
        num2 *= denominator;
        return (temp == num2);
    }

    public boolean isLessThan(int num2, int dem2){
        int temp;
        temp = numerator * dem2;
        num2 *= denominator;
        return (temp < num2);
    }

    public void simplify(){
        int gcd = GCD(numerator,denominator);
        int top = numerator / gcd;
        int bot = denominator / gcd;
        totsFraction[0] = top;
        totsFraction[1] = bot;
    }

    public int GCD(int n1, int n2){
        n1 = ( n1 > 0) ? n1 : -n1;
        n2 = ( n2 > 0) ? n2 : -n2;

        while(n1 != n2)
        {
            if(n1 > n2)
                n1 -= n2;
            else
                n2 -= n1;
        }
        return n1;
    }

    public void toStrings(){
        System.out.println("The fraction is " + totsFraction[0] + "/" + totsFraction[1]);
    }

}
