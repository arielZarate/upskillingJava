package clases;

public class TSBNode
{
   private Comparable info;
   private SimpleList04Generico.TSBNode next;
   
   public TSBNode ( )
   {
   }
   
   public TSBNode (Comparable x, SimpleList04Generico.TSBNode p)
   {
     info = x;
     next = p;
   }
   
   public SimpleList04Generico.TSBNode getNext()
   {
     return next;
   }
   
   public void setNext(SimpleList04Generico.TSBNode p)
   {
     next = p;
   }
   
   public Comparable getInfo()
   {
     return info;
   }
   
   public void setInfo(Comparable p)
   {
     info = p;
   }

   @Override
   public String toString()
   {
     return info.toString();   
   }
}

