package system_pac.model;

public class counter {
    private static long counter;

    public static synchronized Long next(){
        return counter++;
    }
}
