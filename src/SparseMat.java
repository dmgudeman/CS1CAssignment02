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
   Iterator<FHarrayList< FHlinkedList< MatNode > >> iter;
   ListIterator<FHlinkedList< MatNode > > listIter;
   
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
   
   protected <E> E get(int r, int c)
   {  E node = null;
     
      if (r < 0 || c < 0 || r > rowSize || c > r)
      {
             node = (E) rows.get(r).get(c).data;
            
         
      }
      return node;
   }
   
   protected boolean set(int r, int c, E x)
   {  
      if (r < 0 || c < 0 || r > rowSize || c > r)
         return false;
      if (x.compareTo(defaultVal) < 0)
         return false;
      if (x == defaultVal)
         x = defaultVal;
      
      MatNode matNode = new MatNode(c, x);
       FHlinkedList<MatNode> newList = new FHlinkedList<MatNode>(); 
       newList.add(matNode); 
      System.out.println("This is node "  + newList.get(c));
       System.out.println("I SEE THIS");
      return true;
   }
   
   protected void clear () {}
   
   protected void showSubsquare(int start, int size)
   {
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
