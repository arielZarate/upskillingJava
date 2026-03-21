package TSBAvlSearchTree;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedSet;

/**
 * Una clase para modelar un árbol de búsqueda AVL. Los atributos sob heredados
 * directamente de clase TSBSearhTree, así como todos los métodos para buscar y
 * recorrer. Se redefinen los métodos para insertar y remover valores del árbol.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Octubre de 2017.
 * @param <E> la clase de los objetos que serán insertados en el árbol.
 */
public class TSBAVLSearchTree<E> extends TSBSearchTree<E>
{
    //********** Atributos privados.
    
    // flag auxiliar para control de altura en algunos metodos recursivos...
    private boolean h;   

    
    //********** Constructores.

    /**
     * Construye un nuevo árbol vacío, que se ordenará de acuerdo al criterio
     * natural (definido por compareTo()). La clase de los objetos insertados en 
     * el árbol DEBE implementar entonces la interface Comparable, y si no se 
     * aplica generics para hacer control de homogeneidad, entonces también se
     * debe garantizar que los objetos contenidos en el árbol sean mutuamente
     * comparables (de lo contrario, se lanzará una excepción de conversión de 
     * tipos).
     */
    public TSBAVLSearchTree() 
    {
    }

    /**
     * Construye un nuevo árbol vacío, que será ordenado de acuerdo al criterio
     * definido por el comparator especificado. Si no se aplica genercis para 
     * hacer control homogeneidas, entonces debe garantizarse que los objetos 
     * insertados sean mutuamente comparables con el comparador especificado (de    
     * lo contrario, puede ser lanzada una excepción de conversión de tipos).
     * @param comparator el comparador que será usado para ordenar el árbol. Si 
     *        su valor es null, se aplicará entonces el criterio natural basado
     *        en compareTo().
     */
    public TSBAVLSearchTree(Comparator<? super E> comparator) 
    {
        super(comparator);
    }

    /**
     * Construye un nuevo árbol conteniendo todos los elementos incluidos en la
     * colección c especificada, ordenados en forma natural (es decir, usando
     * compareTo()). La clase de los elementos insertados debe implementar 
     * entonces Comparable, y todos los elementos deben ser mutuamente 
     * comparables para evitar una excepción de conversión de tipos.
     * @param c la colección cuyos elementos serán copiados en el árbol.
     * @throws ClassCastException si los elementos de c no son Comparables, o 
     *         no son mutuamente comparables.
     * @throws NullPointerException si c es null.
     */
    public TSBAVLSearchTree(Collection<? extends E> c) 
    {
        super(c);
    }

    /**
     * Construye un nuevo árbol conteniendo los mismos elementos y usando el 
     * mismo criterio de ordenamiento del conjunto especificado por s.     *
     * @param s el conjunto ordenado cuyos elementos serán copiados en el árbol.
     * @throws NullPointerException si s es null.
     */
    public TSBAVLSearchTree(SortedSet<E> s) 
    {
        super(s);
    }
    
    
    //********** Redefinición de métodos especificados por Collection. 
    
    /**
     * Agrega el elemento especificado e al árbol, siempre y cuando no estuviese
     * ya contenido.
     * @param e el elemento a agregar al árbol.
     * @return true si el agregado pudo hacerse.
     * @throws NullPointerException si el parámetro e es null.
     */
    @Override
    public boolean add(E e)
    {
        if(e == null) { throw new NullPointerException("add(): parámetro null..."); }

        // h = false significa: la altura no ha crecido
        this.h = false; 
        
        int ca = this.size();
        this.root = this.ins_avl(this.root, e);
        return (this.size() != ca);
    }

    /**
     * Elimina del árbol el nodo que contiene al objeto o, si existía (y retorna
     * true en ese caso). Retorna false en caso contrario (y también si el 
     * objeto o es null).
     * @param o el objeto a buscar y eliminar del árbol.
     * @return true si la eliminación tuvo éxito.
     */
    @Override
    public boolean remove(Object o)
    {
        if(o == null) { return false; }

        // h = false significa: la altura no ha crecido
        this.h = false; 

        int ca = this.size();
        this.root = take_out(this.root, o);
        return (this.size() != ca);
    }
    

    //********** Métodos privados.

    /**
     * Recorre el arbol en forma recursiva, inserta y rebalancea.
     * @param p direccion del nodo actual.
     * @param x objeto a insertar.
     */
    private TreeNode<E> ins_avl(TreeNode<E> p, E x)
    {
        TreeNode<E> p1, p2;
        if(p == null) 
        {
            // la clave no existe... insertarla
            p = new AVLTreeNode<> (x, null, null);
            this.count++;
            this.modCount++;

            // la altura del subarbol creció...
            this.h = true;  
        }
        else
        {
            if(this.compare(x, p.getInfo()) < 0) 
            {
                p.setLeft(ins_avl(p.getLeft(), x) );
                if (this.h == true) 
                {
                    // la rama izquierda crecio
                    switch(((AVLTreeNode<E>)p).getFactor())
                    {
                      case  1: 
                            ((AVLTreeNode<E>)p).setFactor(0);
                            this.h = false;
                            break;

                      case  0: 
                            ((AVLTreeNode<E>)p).setFactor(-1);
                            break;

                      case -1: 
                            //reequilibrar
                            p1 = p.getLeft();
                            if(((AVLTreeNode<E>)p1).getFactor() == -1)
                            {
                                // diagonal... tirar rotacion simple
                                p.setLeft(p1.getRight());
                                p1.setRight(p);
                                ((AVLTreeNode<E>)p).setFactor(0);
                                p = p1;
                            }
                            else
                            {
                                // angulo... tirar rotacion doble...
                                p2 = p1.getRight();
                                p1.setRight(p2.getLeft());
                                p2.setLeft(p1);
                                p.setLeft(p2.getRight());
                                p2.setRight(p);
                                if(((AVLTreeNode<E>)p2).getFactor() == -1) { ((AVLTreeNode<E>)p).setFactor(1); } else { ((AVLTreeNode<E>)p).setFactor(0); }
                                if(((AVLTreeNode<E>)p2).getFactor() == 1)  { ((AVLTreeNode<E>)p1).setFactor(-1); } else { ((AVLTreeNode<E>)p1).setFactor(0); }
                                p = p2;
                            }
                            ((AVLTreeNode<E>)p).setFactor(0);
                            this.h = false;
                            break;
                    }// fin switch...
                }// fin if (h == true)
            }// fin rama true del if (x < p.cod)...
            else 
            { 
                if(this.compare(x, p.getInfo()) > 0) 
                {
                    p.setRight(ins_avl(p.getRight(), x) );
                    if(this.h == true) 
                    {
                        // la rama derecha crecio...
                        switch(((AVLTreeNode<E>)p).getFactor()) 
                        {
                            case -1: 
                                ((AVLTreeNode<E>)p).setFactor(0);
                                this.h = false;
                                break;

                            case  0: 
                                ((AVLTreeNode<E>)p).setFactor(1);
                                break;

                            case  1: 
                                //reequilibrar..
                                p1 = p.getRight();
                                if(((AVLTreeNode<E>)p1).getFactor() == 1) 
                                {
                                    p.setRight(p1.getLeft());
                                    p1.setLeft(p);
                                    ((AVLTreeNode<E>)p).setFactor(0);
                                    p = p1;
                                }
                                else 
                                {
                                    p2 = p1.getLeft();
                                    p1.setLeft(p2.getRight());
                                    p2.setRight(p1);
                                    p.setRight(p2.getLeft());
                                    p2.setLeft(p);
                                    if (((AVLTreeNode<E>)p2).getFactor() ==  1) { ((AVLTreeNode<E>)p).setFactor(-1); } else { ((AVLTreeNode<E>)p).setFactor(0); }
                                    if (((AVLTreeNode<E>)p2).getFactor() == -1) { ((AVLTreeNode<E>)p1).setFactor(1); } else { ((AVLTreeNode<E>)p1).setFactor(0); }
                                    p = p2;
                                }
                                ((AVLTreeNode<E>)p).setFactor(0);
                                this.h = false;
                                break;
                        }// fin switch...
                    }// fin del true de if (h == true)...
                } // fin rama true de if (x > p.cod)...
                else 
                {   // la clave ya existe... 
                    this.h = false;   // pues la altura no cambia...
                } // fin del else de if (x > p.cod)...
            }// fin del else de if (x < p.info)...
        }// fin del else de if (p == NULL)...
        return p;
    }

    /**
     * Recorre el arbol recursivamente, borra el nodo con el objeto x (si 
     * existe) y rebalancea si es necesario.
     * @param p direccion del nodo actual.
     * @param x objeto a borrar.
     * @return direccion de la nueva raiz del arbol.
     */
    private TreeNode<E> take_out(TreeNode<E> p, Object x)
    {
      if (p == null) 
      {
          // x no existe... no hace nada
          this.h = false;
      }
      else
      {
          if (this.compare(x, p.getInfo()) < 0)
          {
              p.setLeft(take_out (p.getLeft(), x) );
              if (this.h == true) { p = equilibrate1 (p); }
          }
          else 
          {
              if (this.compare(x, p.getInfo()) > 0) 
              {
                  p.setRight(take_out (p.getRight(), x) );
                  if (this.h == true) { p = equilibrate2(p); }
              }
              else 
              {
                  // nodo encontrado... borrarlo
                  if (p.getRight() == null) 
                  {
                       p = p.getLeft();
                       this.h = true;
                  }
                  else 
                  {
                       if (p.getLeft() == null) 
                       {
                            p = p.getRight();
                            this.h = true;
                       }
                       else 
                       {
                            // tiene dos hijos!!!
                            p.setLeft(del(p.getLeft(), p));
                            if(this.h == true) { p = equilibrate1(p); }
                       }
                  }
                  this.count--;
                  this.modCount++;
              }
          }
      }
      return p;
    }

    /**
     * Metodo auxiliar para eliminar un nodo si tiene dos hijos.
     * @param d nodo actual.
     * @param q nodo original a borrar.
     * @return direccion de la nueva raiz del arbol.
    */
    private TreeNode<E> del(TreeNode<E> d, TreeNode<E> q)
    {
        if(d.getRight() != null) 
        {
            d.setRight(del(d.getRight(), q));
            if (this.h == true) { d = equilibrate2(d); }
        }
        else
        {
            q.setInfo(d.getInfo());
            d = d.getLeft();
            this.h = true;
        }
        return d;
    }

    /**
      Auxiliar de reequilibrado.
      @param p direccion del nodo a reequilibrar.
      @return nueva raiz del arbol.
    */
    private TreeNode<E> equilibrate1(TreeNode<E> p)
    {
        TreeNode<E> p1, p2;
        int e1, e2;
        switch(((AVLTreeNode<E>)p).getFactor())
        {
            case -1:  
                ((AVLTreeNode<E>)p).setFactor(0);
                break;

            case  0:  
                ((AVLTreeNode<E>)p).setFactor(1);
                this.h = false;
                break;

            case  1:  
                p1 = p.getRight();
                e1 = ((AVLTreeNode<E>)p1).getFactor();
                if(e1 >= 0) 
                {
                    p.setRight(p1.getLeft());
                    p1.setLeft(p);
                    if (e1 == 0) 
                    {
                        ((AVLTreeNode<E>)p).setFactor(1);
                        ((AVLTreeNode<E>)p1).setFactor(-1);
                        this.h = false;
                    }
                    else 
                    {
                        ((AVLTreeNode<E>)p).setFactor(0);
                        ((AVLTreeNode<E>)p1).setFactor(0);
                    }
                    p = p1;
                }
                else 
                {
                    p2 = p1.getLeft();
                    e2 = ((AVLTreeNode<E>)p2).getFactor();
                    p1.setLeft(p2.getRight());
                    p2.setRight(p1);
                    p.setRight(p2.getLeft());
                    p2.setLeft(p);
                    if(e2 ==  1) { ((AVLTreeNode<E>)p).setFactor(-1); } else { ((AVLTreeNode<E>)p).setFactor(0); }
                    if(e2 == -1) { ((AVLTreeNode<E>)p1).setFactor(1); } else { ((AVLTreeNode<E>)p1).setFactor(0); }
                    p = p2;
                    ((AVLTreeNode<E>)p2).setFactor(0);
                }
                break;
        } // fin switch...
        return p;
    }

    /**
     * Auxiliar de reequilibrado.
     * @param p direccion del nodo a reequilibrar.
     * @return nueva raiz del arbol.
     */
    private TreeNode<E> equilibrate2(TreeNode<E> p)
    {
        TreeNode<E> p1, p2;
        int e1, e2;
        switch(((AVLTreeNode<E>)p).getFactor())
        {
            case 1:  
                ((AVLTreeNode<E>)p).setFactor(0);
                break;

            case 0:
                ((AVLTreeNode<E>)p).setFactor(-1);
                this.h = false;
                break;

            case -1:  
                p1 = p.getLeft();
                e1 = ((AVLTreeNode<E>)p1).getFactor();
                if(e1 <= 0) 
                {
                    p.setLeft(p1.getRight());
                    p1.setRight(p);
                    if(e1 == 0) 
                    {
                        ((AVLTreeNode<E>)p).setFactor(-1);
                        ((AVLTreeNode<E>)p1).setFactor(1);
                        this.h = false;
                    }
                    else 
                    {
                        ((AVLTreeNode<E>)p).setFactor(0);
                        ((AVLTreeNode<E>)p1).setFactor(0);
                    }
                    p = p1;
                }
                else 
                {
                    p2 = p1.getRight();
                    e2 = ((AVLTreeNode<E>)p2).getFactor();
                    p1.setRight(p2.getLeft());
                    p2.setLeft(p1);
                    p.setLeft(p2.getRight());
                    p2.setRight(p);
                    if(e2 == -1) { ((AVLTreeNode<E>)p).setFactor(1); } else { ((AVLTreeNode<E>)p).setFactor(0); }
                    if(e2 ==  1) { ((AVLTreeNode<E>)p1).setFactor(-1); } else { ((AVLTreeNode<E>)p1).setFactor(0); }
                    p = p2;
                    ((AVLTreeNode<E>)p2).setFactor(0);
                }
                break;
        } // fin switch...
        return p;
    }   
    
    //************************ Clases internas.
    
    /*
     * Clase interna que representa los nodos que se almacenan en el árbol AVL.
     * El constructor lanzará una IllegalArgumentException si el parámetro a 
     * asignar como info es null.
     */
    protected static class AVLTreeNode<E> extends TSBSearchTree.TreeNode<E>
    {
        // el factor de equilibrio: -1, 0, 1 segun sea el caso...
        private int factor;  

        /**
        * Inicializa los atributos tomando los valores de los parámetros, salvo 
        * el factor de equilibrio que se inicia en cero.
        * @param c el objeto a almacenar en el nodo.
        * @param left la dirección del hijo izquierdo.
        * @param right la dirección del hijo derecho.
        */
        public AVLTreeNode(E c, TreeNode<E> left, TreeNode<E> right)
        {
            super(c, left, right);
            factor = 0;
        }
        
        /**
         * Retorna el factor de equilibrio.
         * @return el valor del atributo equilibrio. 
         */
        public int getFactor ()
        {
            return factor;
        }

        /**
         * Modifica el factor de equilibrio.
         * @param e nuevo valor del factor de equilibrio.
         */
        public void setFactor(int e)
        {
            factor = e;
        }
    }
}
