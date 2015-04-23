import java.util.ListIterator;

import cs_1c.FHarrayList;
import cs_1c.FHlinkedList;

public class SparseMat<E extends Comparable> implements Cloneable
{
   protected int rowSize, colSize;
   protected E defaultVal;
   protected FHarrayList<FHlinkedList<MatNode>> rows;

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

      allocateEmptyMatrix();
   }

   private void allocateEmptyMatrix()
   {
      System.out.println(" rowSize: " + rowSize + "\n");
      System.out.println("sparseMat.size(): " + rows.size() + "\n");
      for (int i = 0; i < rowSize; i++)
      {
         FHlinkedList<MatNode> starter = new FHlinkedList<MatNode>();

         rows.add(starter);
      }
      System.out.println("sparseMat.size(): " + rows.size() + "\n");
      System.out.println(rows.size());
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
      if (r < 0 || c < 0 || r > rowSize || c > colSize)
         return false;

      MatNode temp;
      MatNode matNode = new MatNode(c, x);
      ListIterator<MatNode> iterS = rows.get(r).listIterator();

      while (iterS.hasNext())
      {
         temp = iterS.next();
         if (matNode.data == defaultVal)
         {
            iterS.remove();
            return true;
         }

         if (temp.col == c)
         {
            iterS.set(matNode);
            return true;
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
      rows.clear();
   }

   protected void showSubsquare(int start, int size)
   {
      MatNode prevTemp;
      MatNode temp;

      int str = start;

      for (int i = 0; i < 4; i++)
      {
         System.out.println("\n");
         ListIterator<MatNode> iterPc = rows.get(i).listIterator();

         while (iterPc.hasNext())
         {
            temp = iterPc.next();
            prevTemp = iterPc.previous();
            Double x1 = (Double) temp.data;
            if (temp.col - str > 1 || prevTemp.col - temp.col > 1)
            {
               System.out.println("    " + 0.00);
               str++;
            } else
            {
               iterPc.next();

               System.out.print("    " + x1);
            }

         }
      }
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
