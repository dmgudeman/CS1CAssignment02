import java.util.Iterator;
import java.util.ListIterator;

import cs_1c.FHarrayList;
import cs_1c.FHlinkedList;


public class SparseMat<E extends Comparable> implements Cloneable
{
   protected int rowSize, colSize;
   protected E defaultVal;
   protected FHarrayList<FHlinkedList<MatNode>> rows;
  // protected double uDefaultVal;

   public SparseMat(int rowSize, int colSize, E defaultVal)
   {
      if (rowSize < 1)
      {
         rowSize = 1;
      }
      if (colSize < 1)
      {
         colSize = 1;
      }
      this.rowSize = rowSize;
      this.colSize = colSize;
      this.defaultVal = defaultVal;
      rows = new FHarrayList<FHlinkedList<MatNode>>(rowSize);
  //    uDefaultVal = ((Double)defaultVal).doubleValue();
      allocateEmptyMatrix();
   }

   private void allocateEmptyMatrix()
   {
      for (int i = 0; i < rowSize; i++)
      {
         FHlinkedList<MatNode> starter = new FHlinkedList<MatNode>();

         rows.add(starter);
      }
   }

   protected E get(int r, int c)
   {
      MatNode node;

      if (r < 0 || c < 0 || r > rowSize || c > colSize)
         throw new IndexOutOfBoundsException();

      ListIterator<MatNode> listIter = rows.get(r).listIterator();
      while (listIter.hasNext())
      {
         node = listIter.next();

         if (node.col == c)
         {
            return node.data;
         }
      }
      return defaultVal;
   }

   protected boolean set(int r, int c, E x)
   {
      if (r < 0 || c < 0 || r >= rowSize || c >= colSize)
         return false;

      MatNode temp;
      MatNode matNode = new MatNode(c, x);

      ListIterator<MatNode> iterS = rows.get(r).listIterator();

      while (iterS.hasNext())
      {
         temp = iterS.next();

         if (temp.col == matNode.col)
         {
            if (matNode.data.equals(defaultVal))

            {
               if (temp.data.equals(matNode.data))
               {
                  iterS.set(matNode);
                  return true;
               }
               iterS.remove();
               return true;
            }
            if (!temp.data.equals(matNode.data))
            {
               iterS.set(matNode);
               return true;
            }
         }

         if (temp.col > c)
         {
            iterS.previous();
            iterS.add(matNode);
            return true;
         }
      }
      iterS.add(matNode);
      return true;
   }

   protected void clear()
   {
     Iterator<FHlinkedList<SparseMat<E>.MatNode>> iterR = rows.iterator();
      
     while (iterR.hasNext())
     {
        iterR.next().clear();
     }
      
   } 

   protected void showSubsquare(int start, int size)
   {
      if(start + size >= rowSize || start + size >= colSize)
      {
        throw new IndexOutOfBoundsException();       
      }
      
      System.out.println("A matrix starting at " + start + " of " + size + " size.");

      for (int i = start; i < size + start; i++)
      { 
         System.out.println("\n");
         MatNode temp;
         int str = start;
        
         ListIterator<MatNode> iterPc = rows.get(i).listIterator();
         
         while (iterPc.hasNext())
         {   temp = iterPc.next();
            if (str < temp.col)
            {
               for(int j = str; j < temp.col; j++)
               {
                  System.out.print("\t" + defaultVal);
               }
               str = temp.col;
            } 
            if (str == temp.col)
            {
               System.out.print("\t" + temp.data);
               str++;
            }
            
          }  
          if (str < size + start) 
          {
             for (int k = str; k < size + start; k++)
             {
                System.out.print("\t" + defaultVal);
             }
           
          }        
       }
      System.out.println("\n");
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
         MatNode newObject = (MatNode) super.clone();
         return (Object) newObject;
      }
   };

}
