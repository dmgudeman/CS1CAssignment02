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
//  
     // for (k = 0; k < 10; k++)
      {  
         
         mat.set(5, 5, 55.);
         mat.set(5, 5, 58.);

         mat.set(1, 1, 0.);
         mat.set(0, 5, 8.0);
         mat.set(0, 1, 1.);
         mat.set(1, 3, 13.);
         mat.set(1, 0, 10.);
         mat.set(0, 8, 56.0);
         mat.set(1, 1, 11.);
         mat.set(2, 0, 20.);
        
         mat.set(3,3, 33.);
         mat.set(3,2, 32.);
        
         mat.set (99999, 99999, 3.);
         
//         for (k = 99989; k < 100000; k++)
//         {
//            mat.set(k, k, 1.);
//           
//            mat.set(k+10, k+10, 10.);
//          
//            mat.set(k, k, 100.);
//            
//         }  
//         
         }

      
   mat.showSubsquare(0, 12);
    //  SparseMat<Double> mat2 = (SparseMat<Double>)mat.clone();
//      
//      for (k = 9990; k < 100000; k++)
//      {
//         mat.set(k, k, 1.);
//        
//         mat.set(k+10, k+10, 10.);
//       
//         mat.set(k, k, 100.);
//         
//      }
//      
     
     
//      mat2.showSubsquare(0, 12);
   }
}