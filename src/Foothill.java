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
//      for (k = 0; k < 10; k++)
//      {   
//         mat.set(k, 3,  3.);
//        System.out.println("THIS  + "  +mat.get (k,k));
//         mat.set(k+2, 8,  56.);
//         System.out.println("THE OTHER" + mat.get (5,4));
//         mat.set(k+3, 31, -k*100.);
//         System.out.println(mat.get (k,5));
//         mat.set(k + 4, 45, 78.);
//         System.out.println("THAT" + mat.get (k+1,k+1));
//      }
    
      mat.set(1, 2, 25.);
      System.out.println(mat.get(1,2));
      
    //  SparseMat<Double> mat2 = (SparseMat<Double>)mat.clone();
      
      for (k = 0; k < 10; k++)
      {
         mat.set(k, k, 1.);
        
         mat.set(k+10, k+10, 10.);
       
         mat.set(k, k, 100.);
         
      }
      
      mat.showSubsquare(0, 12);
     
     // mat2.showSubsquare(0, 12);
   }
}