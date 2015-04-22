// CIS 1C Assignment #2 
// Instructor Solution Featuring clone()

// client -----------------------------------------------------
import cs_1c.*;
import java.util.*;

//------------------------------------------------------
public class Foothill
{
   final static int MAT_SIZE = 100000;//
   // -------  main --------------
   public static void main(String[] args) throws Exception
   {
      // 100000 x 100000 filled with 0
      int k; //
      SparseMat<Double> mat  //
         = new SparseMat<Double>(MAT_SIZE, MAT_SIZE, 0.); //
     
      // test mutators
      for (k = 0; k < 10; k++)
      {
         mat.set(k, k, (k+1)*1.);
         mat.set(4, k, k*10.);
         mat.set(k, 4, -k*10.);
      }
      mat.showSubsquare(0, 12);
      System.out.println();
      System.out.println("mat.get = " + mat.get(5, 5));
      
    //  SparseMat<Double> mat2 = (SparseMat<Double>)mat.clone();
      
      for (k = 0; k < 10; k++)
      {
         mat.set(k, k, 1.);
         mat.set(4, k, 10.);
         mat.set(k, 4, -10.);
      }
      
      mat.showSubsquare(0, 12);
      System.out.println();
     // mat2.showSubsquare(0, 12);
   }
}