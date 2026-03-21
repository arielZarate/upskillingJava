package clases;

import java.util.Iterator;
import java.util.NoSuchElementException;
public class TSBSimpleList implements Iterable
{
      private TSBNode frente;
      private int cantidad;
      
      public TSBSimpleList ()
      {
          frente = null;
          cantidad = 0;
      }
      
      public void add( int index, Comparable x )
      {
          if( ! isHomogeneus( x ) ) { throw new ClassCastException( "Objeto incompatible" ); }
          if( index < 0 || index > size() ) { throw new IndexOutOfBoundsException( "Indice fuera del rango" ); }

          TSBNode nuevo = new TSBNode( x, frente );
          if( index == 0 ) { frente = nuevo; }
          else
          {
            TSBNode p = frente;
            for( int i = 0; i < index - 1; i++ ) { p = p.getNext(); }
            nuevo.setNext( p.getNext() );
            p.setNext( nuevo );
          }         
          
          cantidad++;
      }    
      
      public void addFirst( Comparable x )
      {
            if ( ! isHomogeneus( x ) ) return;
            
            TSBNode p = new TSBNode(x, frente);
            frente = p;
            cantidad++;
      }  
      
      public void addInOrder(Comparable x)
      {
            if ( ! isHomogeneus( x ) ) return;
            
            TSBNode nuevo = new TSBNode( x, null );
            TSBNode p = frente, q = null;
            while ( p != null && x.compareTo( p.getInfo() ) >= 0 )
            {
                q = p;
                p = p.getNext();
            }
            nuevo.setNext( p );
            if( q != null ) q.setNext( nuevo );
            else frente = nuevo;
            cantidad++;
      }             
      
      public void addLast( Comparable x )
      {
            if ( ! isHomogeneus( x ) ) return;
            
            TSBNode nuevo = new TSBNode( x, null );
            TSBNode p = frente;
            while ( p != null && p.getNext() != null ) { p = p.getNext(); }
            if( p != null ) p.setNext( nuevo );
            else frente = nuevo;
            cantidad++;
      }  
      
      public void clear( )
      {
         frente = null; 
         cantidad = 0;
      }
      
      public boolean contains( Comparable x )
      {
          if ( ! isHomogeneus( x ) ) return false;
          
          TSBNode p = frente;
          while ( p != null && x.compareTo( p.getInfo() ) != 0 ) { p = p.getNext(); }   
          return ( p != null );
      }

      public Comparable get( int index )
      {
          if( index < 0 || index >= size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );
         
          TSBNode p = frente;
          for( int i = 0; i < index; i++ ) { p = p.getNext(); }
          return p.getInfo();
      }
      
      public Comparable getFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         return frente.getInfo();
      }
      
      public Comparable getLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         TSBNode p = frente;
         while( p.getNext() != null ) { p = p.getNext(); }
         return p.getInfo();
      }
      
      public int indexOf( Comparable x )
      {
            if ( ! isHomogeneus( x ) )  return -1;
            
            int c = 0;
            for ( TSBNode p = frente; p != null; p = p.getNext() )
            {
                if( x.compareTo( p.getInfo() ) == 0 ) return c;
                c++;
            }
            return -1;
      }
      
      public boolean isEmpty()
      {
         return (frente == null);    
      }

      @Override
      public Iterator iterator()
      {
        return new TSBSimpleListIterator();  
      }
      
      public Comparable remove( int index )
      {
          if( index < 0 || index >= size() ) throw new IndexOutOfBoundsException( "Indice fuera del rango" );

          TSBNode p = frente, q = null;
          for( int i = 0; i < index; i++ ) 
          {
              q = p;
              p = p.getNext();
          }
          
          Comparable x = p.getInfo();
          if( q == null ) frente = p.getNext();
          else q.setNext( p.getNext() );
          
          cantidad--;
          return x; 
      }

      public boolean remove( Comparable x )
      {
          if( ! isHomogeneus( x ) ) return false;
          
          TSBNode p = frente, q = null;
          while( p != null && x.compareTo( p.getInfo() ) != 0  ) 
          {
              q = p;
              p = p.getNext();
          }
          
          if( p == null ) return false;
  
          if( q == null ) frente = p.getNext();
          else q.setNext( p.getNext() );      
          
          cantidad--;
          return true;
      }
      
      public Comparable removeFirst()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         Comparable x = frente.getInfo();
         frente = frente.getNext();
         
         cantidad--;
         return x;
      }

      public boolean removeFirstOccurrence( Comparable x )
      {
          return remove(x);
      }
      
      public Comparable removeLast()
      {
         if (frente == null) throw new NoSuchElementException("Error: la lista esta vacia...");
         
         TSBNode p = frente, q = null;
         while( p.getNext() != null )
         {
            q = p;
            p = p.getNext();
         }
         Comparable x = p.getInfo();
         if( q != null ) q.setNext( p.getNext() );
         else frente = p.getNext();
         
         cantidad--;
         return x;
      }
     
      public Comparable search (Comparable x)
      {
            if ( ! isHomogeneus( x ) )  return null;
            
            for ( TSBNode p = frente; p != null; p = p.getNext() )
            {
                if( x.compareTo( p.getInfo() ) == 0 ) return p.getInfo();
            }
            return null;
      }
            
      public Comparable set( int index, Comparable x )
      {
          if( ! isHomogeneus( x ) ) throw new ClassCastException( "Objeto incompatible" );
          if( index < 0 || index >= size() ) throw new NoSuchElementException( "Indice fuera del rango" );
         
          TSBNode p = frente;
          for( int i = 0; i < index; i++ ) { p = p.getNext(); }
          
          Comparable ant = p.getInfo();
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
             StringBuilder res = new StringBuilder( "[ " );
             for( TSBNode p = frente; p != null;  p = p.getNext() )
             {
                res.append( p.toString() );
                if ( p.getNext() != null ) res.append( " - " );
             }
             res.append( " ]" );
             return res.toString();
      }
      
      private boolean isHomogeneus (Comparable x)
      {
            if ( x == null ) return false;
            if ( frente != null && x.getClass() != frente.getInfo().getClass() ) return false;
            return true;
      }
      
      private class TSBSimpleListIterator implements Iterator
      {

          private TSBNode actual;          // patron Iterator: direccion del nodo que toca procesar.
          private TSBNode previo;          // direccion del nodo anterior al actual.
          private boolean  next_invocado;   // true: next fue invocado (usado por remove()...)
        
          public TSBSimpleListIterator()
          {
             actual = null;
             previo = null;
             next_invocado = false;
          }
        
         /**
          * Indica si queda algun objeto en el recorrido del iterador.          *
          * @return true si queda algun objeto en el recorrido - false si no
          * quedan objetos.
          */
         @Override
         public boolean hasNext()
         {
              if (frente == null) { return false; }
              if (actual != null && actual.getNext() == null) { return false; }
              return true;
         }

         /**
          * Retorna el siguiente objeto en el recorrido del iterador.          *
          * @return el siguiente objeto en el recorrido.
          * @throws NoSuchElementException si la lista esta vacia o en la lista
          * no quedan elementos por recorrer.
          */
         @Override
         public Comparable next()
         {
            if (!hasNext()) { throw new NoSuchElementException("No quedan elementos por recorrer"); }

            if (actual == null) { actual = frente; } 
            else
            {
                previo = actual;
                actual = actual.getNext();
            }
            next_invocado = true;
            
            return actual.getInfo();
         }
         
         /**
          * Elimina el ultimo elemento que retorno el iterador. Debe invocarse primero a next(). El iterador 
          * queda posicionado en el elemento anterior al eliminado. 
          * @throws IllegalStateException si se invoca a remove() sin haber invocado a next(), o si 
          * remove fue invocado mas de una vez luego de una invocacion a next().
          */
         @Override
         public void remove()
         {
            if(!next_invocado) { throw new IllegalStateException("Debe invocar a next() antes de remove()..."); }
             
            if (previo == null)
            {
                frente = actual.getNext();
            }
            else
            {
                previo.setNext(actual.getNext());
            }

            actual = previo;
            next_invocado = false;
            cantidad--;
         }
      }
}
