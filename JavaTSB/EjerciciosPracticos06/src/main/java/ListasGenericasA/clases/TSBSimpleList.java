package ListasGenericasA.clases;

import java.util.NoSuchElementException;


//clases parametrizadas

public class TSBSimpleList<E>
{
      private TSBNode<E> frente;      
      private int cantidad;
      
      public TSBSimpleList()
      {
          frente = null;
          cantidad = 0;
      }
      
      public void add(int index, E x)
      {
          if( index < 0 || index > size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );

          TSBNode <E> nuevo = new TSBNode<>( x, frente );
          if( index == 0 ) frente = nuevo;
          else
          {
            TSBNode <E> p = frente;
            for( int i = 0; i < index - 1; i++ )
                 {   p = p.getNext();
                     }
            nuevo.setNext( p.getNext() );
            p.setNext( nuevo );
          }         
          
          cantidad++;
      } 
      
      public void addFirst(E x)
      {
            if ( x == null ) return;
            
            TSBNode < E > p = new TSBNode <> (x, frente);
            frente = p;
            
            cantidad++;            
      }  
      
      public void addLast(E x)
      {
            if ( x  == null ) return;
            
            TSBNode<E> nuevo = new TSBNode<>( x, null );
            TSBNode<E> p = frente, q = null;
            while ( p != null )
            {
                q = p;
                p = p.getNext();
            }
            if( q != null ) q.setNext( nuevo );
            else frente = nuevo;
            
            cantidad++;
      } 
      
      public void clear( )
      {
         frente = null;
         cantidad = 0;
      }
      
      public E get( int index )
      {
          if( index < 0 || index >= size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );
         
          TSBNode <E> p = frente;
          for( int i = 0; i < index; i++ ) { p = p.getNext(); }
          return p.getInfo();
      }
      
      public E getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         return  (E) frente.getInfo();
      }
      
      public E getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         TSBNode <E> p = frente, q = null;
         while( p != null )
         {
            q = p;
            p = p.getNext();
         }
         return (E) (( q != null )? q.getInfo() : frente.getInfo());
      }
            
      public boolean isEmpty()
      {
         return (frente == null);    
      }
      
      public E remove( int index )
      {
          if( index < 0 || index >= size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );

          TSBNode <E> p = frente, q = null;
          for( int i = 0; i < index; i++ ) 
          {
              q = p;
              p = p.getNext();
          }
          
          E x = p.getInfo();
          if( q == null ) frente = p.getNext();
          else q.setNext( p.getNext() );
          
          cantidad--;
          return x; 
      }
      
      public E removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         TSBNode <E> p = frente, q = null;
         while( p.getNext() != null )
         {
            q = p;
            p = p.getNext();
         }
         E x = (E)p.getInfo();
         if( q != null ) q.setNext( p.getNext() );
         else frente = p.getNext();
         
         cantidad--;
         return x;
      }
      
      public E removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         E x = (E)frente.getInfo();
         frente = frente.getNext();
         
         cantidad--;
         return x;
      }
      
      public E set( int index, E x )
      {
          if( index < 0 || index >= size() ) throw new NoSuchElementException( "Indice fuera del rango" );
         
          TSBNode <E> p = frente;
          for( int i = 0; i < index; i++ ) { p = p.getNext(); }
          
          E ant = p.getInfo();
          p.setInfo( x );
          return ant;
      }
      
      public int size()
      {
          return cantidad;
      }
      
      @Override
      public String toString()
      {
             TSBNode <E> p = frente;
             String res = "[ ";
             while( p != null )
             {
                res = res + p.toString();
                if ( p.getNext() != null ) res = res + " - ";
                p = p.getNext();
             }
             res = res + " ]";
             return res;
      }
}
