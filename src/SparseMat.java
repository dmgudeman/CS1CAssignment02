import java.util.Iterator;
import java.util.ListIterator;

import cs_1c.FHarrayList;
import cs_1c.FHlinkedList;


public class SparseMat<E> implements Cloneable
{
  
   protected int rowSize, colSize;
   protected E defaultVal;
  // protected FHarrayList < FHlinkedList< MatNode > > rows;
 
   public SparseMat(int rowSize, int colSize, E defaultVal)
   {
      if (rowSize < 1){rowSize = 1;}
      if (colSize < 1){colSize = 1;}
      this.rowSize = rowSize;
      this.colSize = colSize;
      this.defaultVal = defaultVal;
      
//      Iterator<FHlinkedList<SparseMat<E>.MatNode>> iter = sparseMat.iterator();
      allocateEmptyMatrix();
   }
   Iterator<FHarrayList> iter;
   
   private void allocateEmptyMatrix()
   { 
      FHarrayList < FHlinkedList< MatNode > > backBone = new FHarrayList < FHlinkedList< MatNode > >(rowSize);
   
      System.out.println(" rowSize: " + rowSize + "\n");
      System.out.println("sparseMat.size(): " +backBone.size() + "\n");
      for (int i=0; i <rowSize; i++)    
      {
       FHlinkedList<MatNode> starter = new FHlinkedList<MatNode>();
       backBone.add(starter);
      }
      System.out.println("sparseMat.size(): " +backBone.size() + "\n");
    System.out.println(backBone.size());
   }
   
   protected <E> E get(int r, int c)
   {  E node = null;
     
      if (r < 0 || c < 0 || r > rowSize || c > r)
      {
         
      }
      return node;
   }
   
   protected boolean set(int r, int c, E x)
   {   int aIndex = r;
      if (r < 0 || c < 0 || r > rowSize || c > r)
         throw new IndexOutOfBoundsException();
       
      MatNode matNode = new MatNode(c, x);
       FHlinkedList<MatNode> newList = new FHlinkedList<MatNode>(); 
       newList.add(matNode); 
      if(newList != null)
      {
         
      }
      return false;
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
