package chapter_2;

// generate a simple progression. By default 0, 1, 2...
import java.util.Scanner;
public class Progression {
    //instance variable
    protected long current;

    //construct a progression starting at zero
    public Progression() {
        this(0);
    }

    //construct a progression with given start value
    public Progression(long start) {
        this.current = start;
    }

    //return the next value of the progression
    public long nexValue()
    {
        long temp = this.current;
        advance();
        return temp;
    }

    //advance the current value to the next value of the progression
    protected void advance(){
        current = current + 1;
    }

    //print the next n values of the progression separated by spaces
    public void printProgression(int n){
        System.out.print(nexValue());
        for (int i = 1; i < n; i++) {
            System.out.print(" " + nexValue());
        }
        System.out.println();
    }


}
