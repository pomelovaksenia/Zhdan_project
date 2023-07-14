package system_pac.model;

public class Counter {
    private static long counter;

    public static synchronized Long next(){
        return counter++;
    }
}
