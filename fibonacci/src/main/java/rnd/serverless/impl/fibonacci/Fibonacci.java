package rnd.serverless.impl.fibonacci;

import com.google.auto.service.AutoService;
import rnd.serverless.api.Calculate;

import java.math.BigInteger;
@AutoService(Calculate.class)
public class Fibonacci implements Calculate {
    private final int n;

    public Fibonacci() {
        this.n = 100;
    }

    @Override
    public String calculate() {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return String.format("FIBONACCI: %s", a);
    }
}
