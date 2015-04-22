import java.util.Iterator;
import java.util.ListIterator;

import cs_1c.FHarrayList;
import cs_1c.FHlinkedList;


public class SparseMat<E extends Comparable> implements Cloneable
{  
   protected int rowSize, colSize;
   protected E defaultVal;
   protected FHarrayList < FHlinkedList< MatNode > > rows;

   public SparseMat(int rowSize, int colSize, E defaultVal)
   {
      if (rowSize < 1){rowSize = 1;}
      if (colSize < 1){colSize = 1;}
      this.rowSize = rowSize;
      this.colSize = colSize;
      this.defaultVal = defaultVal;
      rows = new FHarrayList < FHlinkedList< MatNode > >(rowSize);
//      Iterator<FHlinkedList<SparseMat<E>.MatNode>> iter = sparseMat.iterator();
      allocateEmptyMatrix();
   }
   
   private void allocateEmptyMatrix()
   { 
      System.out.println(" rowSize: " + rowSize + "\n");
      System.out.println("sparseMat.size(): " +rows.size() + "\n");
      for (int i=0; i <rowSize; i++)    
      {
       FHlinkedList<MatNode> starter = new FHlinkedList<MatNode>();
      
       rows.add(starter);
      }
      System.out.println("sparseMat.size(): " +rows.size() + "\n");
      System.out.println(rows.size());
   }
   
   
   protected  E get(int r, int c)
   {  
     MatNode node;
     
    ListIterator<MatNode> listIter = rows.get(r).listIterator();
      while (listIter.hasNext())
      {
         node = listIter.next();
        
       if (node.col == c)
            System.out.println("col " + node.col + "        c" + c);
         {
            System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXX " +node.data );
            return node.data;
         }
      }
      
      return null;
      
      
//     rows.get(r).get(c);
//     ListIterator<FHlinkedList> listIter = rows.get(r).listIterator(c);
    
       
     
   }
   
   protected boolean set(int r, int c, E x)
   {  
      if (r < 0 || c < 0 || r > rowSize || c > colSize)
         return false;
      
      if (x.compareTo(defaultVal) < 0)
         return false;
     
      if (x == defaultVal)
         x = defaultVal;
 
       MatNode matNode = new MatNode(c, x);
     
       rows.get(r).add(matNode);
   
      return true;
   }
   
   protected void clear () {}
   
   protected void showSubsquare(int start, int size)
   {  MatNode node;
      for (int i = start; i < 12; i++)
      {
     System.out.println("\n");
      ListIterator<MatNode> listIter = rows.get(i).listIterator();
      while (listIter.hasNext())
      {
         node = listIter.next();
        
     
            System.out.print( node.data + "     " );
            
         
         }
      }
      
      
      
      
      
      
      
//      int iSize = size - start;
//      int jSize = iSize;
//      
//      for (int i = start; i < 12; i++)
//      {
//         for (int j = 0; j < jSize; j ++)
//         {
//           System.out.println(rows.get(i).get(j).data:
//         }
//      }
     
   }
  
   // protected enables us to safely make col/data public
   protected class MatNode implements Cloneable
   {
      public int col;
      public E data;
      
      // we need a default constructor for lists
      MatNode()
      {
         col = 0;
         data = null;
      }

      MatNode(int cl, E dt)
      {
         col = cl;
         data = dt;
      }
      
      public Object clone() throws CloneNotSupportedException
      {
         // shallow copy
         MatNode newObject = (MatNode)super.clone();
         return (Object) newObject;
      }
   };

}
