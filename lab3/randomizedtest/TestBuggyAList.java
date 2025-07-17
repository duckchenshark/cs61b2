package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
import static org.junit.Assert.*;
import org.junit.Test;

public class TestBuggyAList {
  // YOUR TESTS HERE
 @Test
    public void randomizedTest(){
     AListNoResizing<Integer> correct = new AListNoResizing<>();
     BuggyAList<Integer> broken = new BuggyAList<>();

     int N = 5000;
     for (int i = 0; i < N; i += 1) {
         int operationNumber = StdRandom.uniform(0, 2);
         if (operationNumber == 0) {
             // addLast
             int randVal = StdRandom.uniform(0, 100);
             correct.addLast(randVal);
             broken.addLast(randVal);
             System.out.println("addLast(" + randVal + ")");
         } else if (operationNumber == 1) {
             if(correct.size()==0||broken.size()==0){
             continue;}
             correct.removeLast();
             broken.removeLast();
         }
         else if(operationNumber==2){
             if(correct.size()==0||broken.size()==0){
                 continue;
             }
             correct.getLast();
             broken.getLast();
         }

     }
 }
}
