
import java.awt.*;
import java.util.ArrayList;
        import java.util.List;

public class Resheto_Eratosfena {
    private static long startTime = System.currentTimeMillis();
    static class ParaChisel {
        Integer num;
        Integer lastCrossed;

        ParaChisel(Integer num, Integer lastCrossed) {
            this.num = num;
            this.lastCrossed = lastCrossed;
        }
    }

    private List<ParaChisel> primes;

    private Resheto_Eratosfena() {
        primes = new ArrayList<>();
        primes.add(new ParaChisel(2, 2));
        primes.add(new ParaChisel(3, 3));
    }

    private void fillNPrimes(int n) {
        while (primes.size()<n) {
            addNextPrime();
        }
    }

    private void addNextPrime() {
        int candidate = primes.get(primes.size()-1).num + 2;
        for (int i = 1; i < primes.size(); i++) {
            ParaChisel p = primes.get(i);
            while (p.lastCrossed < candidate) {
                p.lastCrossed += p.num;
            }
            if (p.lastCrossed == candidate) {
                //restart
                candidate+=2;
                i=-1;
            }
        }
        System.out.println(candidate);
        primes.add(new ParaChisel(candidate, candidate));
    }



    public static void main(String[] args) {
        Resheto_Eratosfena test = new Resheto_Eratosfena();
        test.fillNPrimes(1000);
        long timeSpent = System.currentTimeMillis() - startTime;
        System.out.println("программа выполнялась " + timeSpent + " миллисекунд");
    }
}