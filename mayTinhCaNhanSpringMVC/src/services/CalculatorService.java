package services;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

public class CalculatorService {
    public double sum(double numberA, double numberB) {
        return numberA + numberB;
    }

    public double sub(double numberA, double numberB) {
        return numberA - numberB;
    }

    public double mul(double numberA, double numberB) {
        return numberA * numberB;
    }

    public double div(double numberA, double numberB) {
        return numberA / numberB;
    }

    public double showResult(String choice, double a, double b) {
        double result = 0;
        if (choice.equals ( "sum" )) {
            result = sum ( a, b );
        } else if (choice.equals ( "sub" )) {
            result = sub ( a, b );
        } else if (choice.equals ( "mul" )) {
            result = mul ( a, b );
        } else result = div ( a, b );
        return result;
    }

}
