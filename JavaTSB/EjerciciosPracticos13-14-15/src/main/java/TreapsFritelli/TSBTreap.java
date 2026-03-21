package TreapsFritelli;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/**
 *
 * @author Ing. Valerio Frittelli.
 * @version Noviembre de 2013.
 * @param <E> La clase de los objetos que serán insertados en el Treap.
 */
public class TSBTreap <E> extends TSBSearchTree<E>
{
    // constantes auxiliares para remove()...
    private enum Direction {ROOT, RIGHT, LEFT};
    
    // auxiliar global para remove: direccion de descenso...
    private Direction dir;
    
    // auxiliares globales para remove(): punteros de persecucion...
    private TreapNode<E> son, father;
    
    public TSBTreap() 
    {
    }

    public TSBTreap(Comparator<? super E> comparator) 
    {
        super(comparator);
    }

    public TSBTreap(Collection<? extends E> c) 
    {
        super(c);
    }

    public TSBTreap(SortedSet<E> s) 
    {
        super(s);
    }
    
    @Override
    public boolean add(E x)
    {
       int ca = this.size();
       this.root = insTreap((TreapNode<E>)this.root, x);
       return (this.size() != ca);
    }

    @Override
    public boolean remove(Object x)
    {
       this.son = (TreapNode<E>) this.root;
       this.dir = Direction.ROOT;
       if(this.son != null)
       { 
           this.father = null;
           while(son != null && this.compare(x, this.son.getInfo()) != 0) 
           { 
               this.father = this.son;
               if(this.compare(x, this.son.getInfo()) < 0) 
               {
                   dir = Direction.LEFT; 
                   this.son = (TreapNode<E>) this.son.getLeft();
               }
               else 
               {
                   dir = Direction.RIGHT; 
                   this.son = (TreapNode<E>) this.son.getRight();
               }
           }

           // si lo encontro, proceder a eliminarlo...
           if(this.son != null) 
           { 
               // mientras no sea una hoja... hundirlo...
               while(this.son.getLeft() != null || this.son.getRight() != null) 
               {  
                   // si el derecho es null subir el de la izquierda...
                   if(this.son.getRight() == null) { left_up(); }
                   else
                   {
                       // si el izquierdo es null subir el de la derecha...
                       if(this.son.getLeft() == null) { right_up();}
                       else
                       {
                           // ambos hijos son distintos de null... subir el de menor prioridad...
                           if(((TreapNode<E>)this.son.getLeft()).getPriority() < ((TreapNode<E>)this.son.getRight()).getPriority())
                           {  
                               left_up();
                           }
                           else
                           { 
                               right_up();
                           }
                       }
                   }
               }

               //this.son ahora es una hoja...
               if(this.father == null) { this.root = null; }
               else
               {
                   if(this.compare(x, father.getInfo()) < 0) { father.setLeft(null); }
                   else { father.setRight(null); }
               }
               this.count--;
               this.modCount++;
               return true;
           }
       }
       return false;
    }
     
    private TreapNode<E> insTreap(TreapNode<E> p, E x)
    { 
        if(p == null) 
        { 
            p = new TreapNode<>(x, null, null);
            this.count++;
            this.modCount++;
        } 
        else
        {
            if(this.compare(x, p.getInfo()) < 0) 
            {
                p.setLeft(insTreap((TreapNode<E>)p.getLeft(),x));
                float pl = ((TreapNode<E>)p.getLeft()).getPriority();
                if(pl < p.getPriority()) { p = with_left(p); } 
            }
            else 
            {
                if(this.compare(x, p.getInfo()) > 0)
                {
                    p.setRight(insTreap((TreapNode<E>)p.getRight(),x));
                    float pr = ((TreapNode<E>)p.getRight()).getPriority();
                    if(pr < p.getPriority()) { p = with_right(p); }                
                }
            }
        }
        return p;
    }
    
    private TreapNode<E> with_left(TreapNode<E> p)
    {
        TreapNode<E> aux = p; 
        p = (TreapNode<E>) p.getLeft(); 
        aux.setLeft(p.getRight());
        p.setRight(aux);
        return p;
    }
    
    private TreapNode<E> with_right(TreapNode<E> p)
    {
        TreapNode<E> aux = p; 
        p = (TreapNode<E>) p.getRight(); 
        aux.setRight(p.getLeft());
        p.setLeft(aux);
        return p;
    }
    
    private void right_up()
    {
        this.son = with_right(this.son); 
        adjust_father(this.dir, this.son, this.father);
        this.father = this.son; 
        this.dir = Direction.LEFT; 
        this.son = (TreapNode<E>) this.son.getLeft(); 
    }
    
    private void left_up()
    {
        this.son = with_left(this.son); 
        adjust_father(this.dir, this.son, this.father);
        this.father = this.son; 
        this.dir = Direction.RIGHT; 
        this.son = (TreapNode<E>) this.son.getRight();
    }    
    
    private void adjust_father(Direction d, TreapNode<E> p, TreapNode<E> q)
    {
        if(d == Direction.RIGHT && q != null) { q.setRight(p); }
        else 
        {
            if(d == Direction.LEFT && q != null) { q.setLeft(p); }
            else 
            {
                if(d == Direction.ROOT) { this.root = p; }
            }
        }
    }
    
    private class TreapNode <E> extends TreeNode<E>
    {
        private float priority = (float) Math.random();  // el valor aleatorio de prioridad...

        public TreapNode(E x, TreeNode<E> iz, TreeNode<E> de)
        {
            super(x, iz, de);
        }

        public float getPriority() 
        {
            return priority;
        }

        public void setPriority(float priority) 
        {
            this.priority = priority;
        } 
    }
}
