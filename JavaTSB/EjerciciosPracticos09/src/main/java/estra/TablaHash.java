package estra;

import java.io.Serializable;
import java.util.*;


public class TablaHash<K,V> implements Map<K,V>, Cloneable, Serializable
{
    //************************ Constantes (privadas o públicas).    
    
    // el tamaño máximo que podrá tener el arreglo de soprte...
    private final static int tam_maximo_arreglo = Integer.MAX_VALUE;


    //************************ Atributos privados (estructurales).
    
    // la tabla hash: el arreglo que contiene las listas de desborde...
    private  ArrayList<Map.Entry<K, V>> table[];
    
    // el tamaño inicial de la tabla (tamaño con el que fue creada)...
    private int capacidad_inicial;
    
    // la cantidad de objetos que contiene la tabla en TODAS sus listas...
    private int count;
    
    // el factor de carga para calcular si hace falta un rehashing...
    private float factor_carga;
      
    
    //************************ Atributos privados (para gestionar las vistas).

    /*
     * (Tal cual están definidos en la clase java.util.Hashtable)
     * Cada uno de estos campos se inicializa para contener una instancia de la
     * vista que sea más apropiada, la primera vez que esa vista es requerida. 
     * La vista son objetos stateless (no se requiere que almacenen datos, sino 
     * que sólo soportan operaciones), y por lo tanto no es necesario crear más 
     * de una de cada una.
     */
    private transient Set<K> keySet = null;
    private transient Set<Map.Entry<K,V>> entrySet = null;
    private transient Collection<V> values = null;

    
    //************************ Atributos protegidos (control de iteración).
    
    // conteo de operaciones de cambio de tamaño (fail-fast iterator).
    protected transient int modCount;


    //************************ Constructores.

    /**
     * Crea una tabla vacía, con la capacidad inicial igual a 11 y con factor
     * de carga igual a 0.8f.
     */
    public TablaHash()
    {
        this(11, 0.8f);
    }

    /**
     *
     * @param capacidad_inicial la capacidad inicial de la tabla.
     */
    public TablaHash(int capacidad_inicial)
    {
        this(capacidad_inicial, 0.8f);
    }

    /**
    Si la capacidad inicial indicada por capacidad_inicial
     * es menor o igual a 0, la tabla será creada de tamaño 11. Si el factor de
     * carga indicado es negativo o cero, se ajustará a 0.8f.

     */
    public TablaHash(int capacidad_inicial, float factor_carga)
    {
        if(factor_carga <= 0)
        {
            factor_carga = 0.8f;
        }
        if(capacidad_inicial <= 0)
        {
            capacidad_inicial = 11;
        }
        else
        {
            if(capacidad_inicial > TablaHash.tam_maximo_arreglo)
            {
                capacidad_inicial = TablaHash.tam_maximo_arreglo;
            }
        }

        this.table = new  ArrayList[capacidad_inicial];
        for(int i=0; i<table.length; i++)
        {
            table[i] = new  ArrayList<>();
        }

        this.capacidad_inicial = capacidad_inicial;
        this.factor_carga = factor_carga;
        this.count = 0;
        this.modCount = 0;
    }

    /**
     * Crea una tabla a partir del contenido del Map especificado.
     * @param t el Map a partir del cual se creará la tabla.
     */
    public TablaHash(Map<? extends K,? extends V> t)
    {
        this(11, 0.8f);
        this.putAll(t);
    }






    //************************ Métodos específicos de la clase.

    /**

     * @return true si alguna clave está asociada efectivamente a ese value.
     */
    public boolean contains(Object value)
    {
        if(value == null) return false;

        for( ArrayList<Map.Entry<K, V>> bucket : this.table)
        {
            //iterador
            Iterator<Map.Entry<K, V>> it = bucket.iterator();
            while(it.hasNext())
            {
                Map.Entry<K, V> entry = it.next(); //guarda el valor de cada iteracion en un objeto
                //ahora compara el value por parametro con el del objeto casteado
                if(value.equals(entry.getValue())) return true;
            }
        }
        return false;
    }

    
    protected void rehash()
    {
        int length_viejo = this.table.length;

        // nuevo tamaño: doble del anterior, más uno para llevarlo a impar...
        int nuevo_length= length_viejo * 2 + 1;

        // no permitir que la tabla tenga un tamaño mayor al límite máximo...
        // ... para evitar overflow y/o desborde de índices...
        if(nuevo_length> TablaHash.tam_maximo_arreglo)
        {
            nuevo_length= TablaHash.tam_maximo_arreglo;
        }

        // crear el nuevo arreglo con nuevo_lengthlistas vacías...
         ArrayList<Map.Entry<K, V>> temp[] = new  ArrayList[nuevo_length ];
        for(int j = 0; j < temp.length; j++) { temp[j] = new  ArrayList<>(); }

        // notificación fail-fast iterator... la tabla cambió su estructura...
        this.modCount++;

        // recorrer el viejo arreglo y redistribuir los objetos que tenia...
        for(int i = 0; i < this.table.length; i++)
        {
            // entrar en la lista numero i, y recorrerla con su iterador...
            Iterator<Map.Entry<K, V>> it = this.table[i].iterator();
            while(it.hasNext())
            {
                // obtener un objeto de la vieja lista...
                Map.Entry<K, V> x = it.next();

                // obtener su nuevo valor de dispersión para el nuevo arreglo...
                K key = x.getKey();
                int y = this.h(key, temp.length);

                // insertarlo en el nuevo arreglo, en la lista numero "y"...
                temp[y].add(x);
            }
        }

        // cambiar la referencia table para que apunte a temp...
        this.table = temp;
    }





    //************************ Redefinición de métodos heredados desde Object.

    /**
   .
     * @return una copia superficial de la tabla.
     * @throws CloneNotSupportedException si la clase no implementa la
     *         interface Cloneable.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException
    {
        TablaHash<K, V> t = (TablaHash<K, V>)super.clone();
        t.table = new  ArrayList[table.length];
        for (int i = table.length ; i-- > 0 ; )
        {
            t.table[i] = ( ArrayList<Map.Entry<K, V>>) table[i].clone();
        }
        t.keySet = null;
        t.entrySet = null;
        t.values = null;
        t.modCount = 0;
        return t;
    }

    /**
     * Determina si esta tabla es igual al objeto espeficicado.
     * @param obj el objeto a comparar con esta tabla.
     * @return true si los objetos son iguales.
     */
    @Override
    public boolean equals(Object obj)
    {
        if(!(obj instanceof Map)) { return false; }

        Map<K, V> t = (Map<K, V>) obj;
        if(t.size() != this.size()) { return false; }

        try
        {
            Iterator<Map.Entry<K,V>> i = this.entrySet().iterator();
            while(i.hasNext())
            {
                Map.Entry<K, V> e = i.next();
                K key = e.getKey();
                V value = e.getValue();
                if(t.get(key) == null) { return false; }
                else
                {
                    if(!value.equals(t.get(key))) { return false; }
                }
            }
        }

        catch (ClassCastException | NullPointerException e)
        {
            return false;
        }

        return true;
    }

    /**
     * Retorna un hash code para la tabla completa.
     * @return un hash code para la tabla.
     */
    @Override
    public int hashCode()
    {

        int hc = super.hashCode();
        return hc;
    }

    /**
     * Devuelve el contenido de la tabla en forma de String. Sólo por razones de
     * didáctica, se hace referencia explícita en esa cadena al contenido de
     * cada una de las listas de desborde o buckets de la tabla.
     * @return una cadena con el contenido completo de la tabla.
     */
    @Override
    public String toString()
    {
        StringBuilder cad = new StringBuilder("");
        for(int i = 0; i < this.table.length; i++)
        {
            cad.append("\nLista ").append(i).append(":\n\t").append(this.table[i].toString());
        }
        return cad.toString();
    }















    //************************ Métodos privados.

    /*
     * Función hash. Toma una clave entera k y calcula y retorna un índice
     * válido para esa clave para entrar en la tabla.
     */
    private int h(int k)
    {
        return h(k, this.table.length);
    }

    /*
     * Función hash. Toma un objeto key que representa una clave y calcula y
     * retorna un índice válido para esa clave para entrar en la tabla.
     */
    private int h(K key)
    {
        return h(key.hashCode(), this.table.length);
    }

    /*
     * Función hash. Toma un objeto key que representa una clave y un tamaño de
     * tabla t, y calcula y retorna un índice válido para esa clave dedo ese
     * tamaño.
     */
    private int h(K key, int t)
    {
        return h(key.hashCode(), t);
    }

    /*
     * Función hash. Toma una clave entera k y un tamaño de tabla t, y calcula y
     * retorna un índice válido para esa clave dado ese tamaño.
     */
    private int h(int k, int t)
    {
        if(k < 0) k *= -1;
        return k % t;
    }

    /**
     * Calcula la longitud promedio de las listas de la tabla.
     * @return la longitud promedio de la listas contenidas en la tabla.
     */
    private int longitud_promedio()
    {
        return this.count / this.table.length;
    }

    /*
     * Busca en la lista bucket un objeto Entry cuya clave coincida con key.
     * Si lo encuentra, retorna ese objeto Entry. Si no lo encuentra, retorna
     * null.
     */
    private Map.Entry<K, V> buscar_por_objeto_entry(K key,  ArrayList<Map.Entry<K, V>> bucket)
    {
        Iterator<Map.Entry<K, V>> it = bucket.iterator();
        while(it.hasNext())
        {
            Map.Entry<K, V> entry = it.next();
            if(key.equals(entry.getKey())) return entry;
        }
        return null;
    }

    /*
     * Busca en la lista bucket un objeto Entry cuya clave coincida con key.
     * Si lo encuentra, retorna su posicíón. Si no lo encuentra, retorna -1.
     */
    private int buscar_por_indice(K key,  ArrayList<Map.Entry<K, V>> bucket)
    {
        Iterator<Map.Entry<K, V>> it = bucket.iterator();
        for(int i=0; it.hasNext(); i++)
        {
            Map.Entry<K, V> entry = it.next();
            if(key.equals(entry.getKey())) return i;
        }
        return -1;
    }

















    //************************ Implementación de métodos especificados por Map.

    /**
     * Retorna la cantidad de elementos contenidos en la tabla.
     * @return la cantidad de elementos de la tabla.
     */
    @Override
    public int size()
    {
        return this.count;
    }

    /**
     * Determina si la tabla está vacía (no contiene ningún elemento).
     * @return true si la tabla está vacía.
     */
    @Override
    public boolean isEmpty()
    {
        return (this.count == 0);
    }

    /**
     * Determina si la clave key está en la tabla.
     
     * @throws NullPointerException si la clave es null.
     */
    @Override
    public boolean containsKey(Object key)
    {
        return (this.get((K)key) != null);
    }

    /**
     * Determina si alguna clave de la tabla está asociada al objeto value que
     * entra como parámetro. Equivale a contains().

     */
    @Override
    public boolean containsValue(Object value)
    {
        return this.contains(value);
    }

    /**
     * Retorna el objeto al cual está asociada la clave key en la tabla, o null
     * si la tabla no contiene ningún objeto asociado a esa clave.

     */
    @Override
    public V get(Object key)
    {
        if(key == null) throw new NullPointerException("get(): parámetro null");

        int ib = this.h(key.hashCode());
         ArrayList<Map.Entry<K, V>> bucket = this.table[ib];

        Map.Entry<K, V> x = this.buscar_por_objeto_entry((K)key, bucket);
        return (x != null)? x.getValue() : null;
    }

    /**
     * Asocia el valor (value) especificado, con la clave (key) especificada en
     * esta tabla. Si la tabla contenía previamente un valor asociado para la
     * clave, entonces el valor anterior es reemplazado por el nuevo (y en este
     * caso el tamaño de la tabla no cambia).

     * @throws NullPointerException si key es null o value es null.
     */
    @Override
    public V put(K key, V value)
    {
        if(key == null || value == null) throw new NullPointerException("put(): parámetro null");

        int ib = this.h(key);
         ArrayList<Map.Entry<K, V>> bucket = this.table[ib];

        V old = null;
        Map.Entry<K, V> x = this.buscar_por_objeto_entry((K)key, bucket);
        if(x != null)
        {
            old = x.getValue();
            x.setValue(value);
        }
        else
        {
            if(this.longitud_promedio() >= this.factor_carga * 10) this.rehash();
            ib = this.h(key);
            bucket = this.table[ib];

            Map.Entry<K, V> entry = new Entry<>(key, value);
            bucket.add(entry);
            this.count++;
            this.modCount++;
        }

        return old;
    }

    /**
     * Elimina de la tabla la clave key (y su correspondiente valor asociado).
     * El método no hace nada si la clave no está en la tabla.

     */
    @Override
    public V remove(Object key)
    {
        if(key == null) throw new NullPointerException("remove(): parámetro null");

        int ib = this.h(key.hashCode());
         ArrayList<Map.Entry<K, V>> bucket = this.table[ib];

        int ik = this.buscar_por_indice((K)key, bucket);
        V old = null;
        if(ik != -1)
        {
            old = bucket.remove(ik).getValue();
            this.count--;
            this.modCount++;
        }

        return old;
    }

    /**
     * Copia en esta tabla, todos los objetos contenidos en el map especificado.
     * Los nuevos objetos reemplazarán a los que ya existan en la tabla
     * asociados a las mismas claves (si se repitiese alguna)
     * @throws NullPointerException si m es null.
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m)
    {
        for(Map.Entry<? extends K, ? extends V> e : m.entrySet())
        {
            put(e.getKey(), e.getValue());
        }
    }

    /**
     * Elimina todo el contenido de la tabla, de forma de dejarla vacía. En esta

     */
    @Override
    public void clear()
    {
        this.table = new  ArrayList[this.capacidad_inicial];
        for(int i = 0; i < this.table.length; i++)
        {
            this.table[i] = new  ArrayList<>();
        }
        this.count = 0;
        this.modCount++;
    }

    /**
     * Retorna un Set (conjunto) a modo de vista de todas las claves (key)
     * contenidas en la tabla.
     */
    @Override
    public Set<K> keySet()
    {
        if(keySet == null)
        {
            // keySet = Collections.synchronizedSet(new KeySet());
            keySet = new KeySet();
        }
        return keySet;
    }

    /**
     * Retorna una Collection (colección) a modo de vista de todos los valores
     * (values) contenidos en la tabla.
     */
    @Override
    public Collection<V> values()
    {
        if(values==null)
        {
            // values = Collections.synchronizedCollection(new ValueCollection());
            values = new ValueCollection();
        }
        return values;
    }

    /**
     * Retorna un Set (conjunto) a modo de vista de todos los pares (key, value)
     * contenidos en la tabla.
     */
    @Override
    public Set<Map.Entry<K, V>> entrySet()
    {
        if(entrySet == null)
        {
            // entrySet = Collections.synchronizedSet(new EntrySet());
            entrySet = new EntrySet();
        }
        return entrySet;
    }










    
    //************************ Clases Internas.

    /*
     * Clase interna que representa los pares de objetos que se almacenan en la
     * tabla hash: son instancias de esta clase las que realmente se guardan en
     * en cada una de las listas del arreglo table que se usa como soporte de
     * la tabla. Lanzará una IllegalArgumentException si alguno de los dos
     * parámetros es null.
     */
    private class Entry<K, V> implements Map.Entry<K, V>
    {
        private K key;
        private V value;

        public Entry(K key, V value)
        {
            if(key == null || value == null)
            {
                throw new IllegalArgumentException("Entry(): parámetro null...");
            }
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey()
        {
            return key;
        }

        @Override
        public V getValue()
        {
            return value;
        }

        @Override
        public V setValue(V value)
        {
            if(value == null)
            {
                throw new IllegalArgumentException("setValue(): parámetro null...");
            }

            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public int hashCode()
        {
            int hash = 7;
            hash = 61 * hash + Objects.hashCode(this.key);
            hash = 61 * hash + Objects.hashCode(this.value);
            return hash;
        }

        @Override
        public boolean equals(Object obj)
        {
            if (this == obj) { return true; }
            if (obj == null) { return false; }
            if (this.getClass() != obj.getClass()) { return false; }

            final Entry other = (Entry) obj;
            if (!Objects.equals(this.key, other.key)) { return false; }
            if (!Objects.equals(this.value, other.value)) { return false; }
            return true;
        }

        @Override
        public String toString()
        {
            return "(" + key.toString() + ", " + value.toString() + ")";
        }
    }


    


    /*
     * Clase interna que representa una vista de todas los Claves mapeadas en la
     * tabla: si la vista cambia, cambia también la tabla que le da respaldo, y
     * viceversa. La vista es stateless: no mantiene estado alguno (es decir, no
     * contiene datos ella misma, sino que accede y gestiona directamente datos
     * de otra fuente), por lo que no tiene atributos y sus métodos gestionan en
     * forma directa el contenido de la tabla. Están soportados los metodos para
     * eliminar un objeto (remove()), eliminar todo el contenido (clear) y la
     * creación de un Iterator (que incluye el método Iterator.remove()).
     */
    private class KeySet extends AbstractSet<K>
    {
        @Override
        public Iterator<K> iterator()
        {
            return new KeySetIterator();
        }

        @Override
        public int size()
        {
            return TablaHash.this.count;
        }

        @Override
        public boolean contains(Object o)
        {
            return TablaHash.this.containsKey(o);
        }

        @Override
        public boolean remove(Object o)
        {
            return (TablaHash.this.remove(o) != null);
        }

        @Override
        public void clear()
        {
            TablaHash.this.clear();
        }




        private class KeySetIterator implements Iterator<K>
        {
            // índice de la lista actualmente recorrida...
            private int current_bucket;

            // índice de la lista anterior (si se requiere en remove())...
            private int last_bucket;

            // índice del elemento actual en el iterador (el que fue retornado
            // la última vez por next() y será eliminado por remove())...
            private int current_entry;

            // flag para controlar si remove() está bien invocado...
            private boolean next_ok;

            // el valor que debería tener el modCount de la tabla completa...
            private int expected_modCount;

            /*
             * Crea un iterador comenzando en la primera lista. Activa el
             * mecanismo fail-fast.
             */
            public KeySetIterator()
            {
                current_bucket = 0;
                last_bucket = 0;
                current_entry = -1;
                next_ok = false;
                expected_modCount = TablaHash.this.modCount;
            }

            /*
             * Determina si hay al menos un elemento en la tabla que no haya
             * sido retornado por next().
             */
            @Override
            public boolean hasNext()
            {
                // variable auxiliar t para simplificar accesos...
                 ArrayList<Map.Entry<K, V>> t[] = TablaHash.this.table;

                if(TablaHash.this.isEmpty()) { return false; }
                if(current_bucket >= t.length) { return false; }

                // bucket actual vacío o listo?...
                if(t[current_bucket].isEmpty() || current_entry >= t[current_bucket].size() - 1)
                {
                    // ... -> ver el siguiente bucket no vacío...
                    int next_bucket = current_bucket + 1;
                    while(next_bucket < t.length && t[next_bucket].isEmpty())
                    {
                        next_bucket++;
                    }
                    if(next_bucket >= t.length) { return false; }
                }

                // en principio alcanza con esto... revisar...
                return true;
            }

            /*
             * Retorna el siguiente elemento disponible en la tabla.
             */
            @Override
            public K next()
            {
                // control: fail-fast iterator...
                if(TablaHash.this.modCount != expected_modCount)
                {
                    throw new ConcurrentModificationException("next(): modificación inesperada de tabla...");
                }

                if(!hasNext())
                {
                    throw new NoSuchElementException("next(): no existe el elemento pedido...");
                }

                // variable auxiliar t para simplificar accesos...
                 ArrayList<Map.Entry<K, V>> t[] = TablaHash.this.table;

                // se puede seguir en el mismo bucket?...
                 ArrayList<Map.Entry<K, V>> bucket = t[current_bucket];
                if(!t[current_bucket].isEmpty() && current_entry < bucket.size() - 1) { current_entry++; }
                else
                {
                    // si no se puede...
                    // ...recordar el índice del bucket que se va a abandonar..
                    last_bucket = current_bucket;

                    // buscar el siguiente bucket no vacío, que DEBE existir, ya
                    // que se hasNext() retornó true...
                    current_bucket++;
                    while(t[current_bucket].isEmpty())
                    {
                        current_bucket++;
                    }

                    // actualizar la referencia bucket con el núevo índice...
                    bucket = t[current_bucket];

                    // y posicionarse en el primer elemento de ese bucket...
                    current_entry = 0;
                }

                // avisar que next() fue invocado con éxito...
                next_ok = true;

                // y retornar la clave del elemento alcanzado...
                K key = bucket.get(current_entry).getKey();
                return key;
            }

            /*
             * Remueve el elemento actual de la tabla, dejando el iterador en la
             * posición anterior al que fue removido. El elemento removido es el
             * que fue retornado la última vez que se invocó a next(). El método
             * sólo puede ser invocado una vez por cada invocación a next().
             */
            @Override
            public void remove()
            {
                if(!next_ok)
                {
                    throw new IllegalStateException("remove(): debe invocar a next() antes de remove()...");
                }

                // eliminar el objeto que retornó next() la última vez...
                Map.Entry<K, V> garbage = TablaHash.this.table[current_bucket].remove(current_entry);

                // quedar apuntando al anterior al que se retornó...
                if(last_bucket != current_bucket)
                {
                    current_bucket = last_bucket;
                    current_entry = TablaHash.this.table[current_bucket].size() - 1;
                }

                // avisar que el remove() válido para next() ya se activó...
                next_ok = false;

                // la tabla tiene un elementon menos...
                TablaHash.this.count--;

                // fail_fast iterator: todo en orden...
                TablaHash.this.modCount++;
                expected_modCount++;
            }
        }
    }


    


    /*
     * Clase interna que representa una vista de todos los PARES mapeados en la
     * tabla: si la vista cambia, cambia también la tabla que le da respaldo, y
     * viceversa. La vista es stateless: no mantiene estado alguno (es decir, no
     * contiene datos ella misma, sino que accede y gestiona directamente datos
     * de otra fuente), por lo que no tiene atributos y sus métodos gestionan en
     * forma directa el contenido de la tabla. Están soportados los metodos para
     * eliminar un objeto (remove()), eliminar todo el contenido (clear) y la
     * creación de un Iterator (que incluye el método Iterator.remove()).
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>>
    {

        @Override
        public Iterator<Map.Entry<K, V>> iterator()
        {
            return new EntrySetIterator();
        }

        /*
         * Verifica si esta vista (y por lo tanto la tabla) contiene al par
         * que entra como parámetro (que debe ser de la clase Entry).
         */
        @Override
        public boolean contains(Object o)
        {
            if(o == null) { return false; }
            if(!(o instanceof Entry)) { return false; }

            Map.Entry<K, V> entry = (Map.Entry<K,V>)o;
            K key = entry.getKey();
            int index = TablaHash.this.h(key);

             ArrayList<Map.Entry<K, V>> bucket = TablaHash.this.table[index];
            if(bucket.contains(entry)) { return true; }
            return false;
        }

        /*
         * Elimina de esta vista (y por lo tanto de la tabla) al par que entra
         * como parámetro (y que debe ser de tipo Entry).
         */
        @Override
        public boolean remove(Object o)
        {
            if(o == null) { throw new NullPointerException("remove(): parámetro null");}
            if(!(o instanceof Entry)) { return false; }

            Map.Entry<K, V> entry = (Map.Entry<K, V>) o;
            K key = entry.getKey();
            int index = TablaHash.this.h(key);
             ArrayList<Map.Entry<K, V>> bucket = TablaHash.this.table[index];

            if(bucket.remove(entry))
            {
                TablaHash.this.count--;
                TablaHash.this.modCount++;
                return true;
            }
            return false;
        }

        @Override
        public int size()
        {
            return TablaHash.this.count;
        }

        @Override
        public void clear()
        {
            TablaHash.this.clear();
        }

        private class EntrySetIterator implements Iterator<Map.Entry<K, V>>
        {
            // índice de la lista actualmente recorrida...
            private int current_bucket;

            // índice de la lista anterior (si se requiere en remove())...
            private int last_bucket;

            // índice del elemento actual en el iterador (el que fue retornado
            // la última vez por next() y será eliminado por remove())...
            private int current_entry;

            // flag para controlar si remove() está bien invocado...
            private boolean next_ok;

            // el valor que debería tener el modCount de la tabla completa...
            private int expected_modCount;

            /*
             * Crea un iterador comenzando en la primera lista. Activa el
             * mecanismo fail-fast.
             */
            public EntrySetIterator()
            {
                current_bucket = 0;
                last_bucket = 0;
                current_entry = -1;
                next_ok = false;
                expected_modCount = TablaHash.this.modCount;
            }

            /*
             * Determina si hay al menos un elemento en la tabla que no haya
             * sido retornado por next().
             */
            @Override
            public boolean hasNext()
            {
                // variable auxiliar t para simplificar accesos...
                 ArrayList<Map.Entry<K, V>> t[] = TablaHash.this.table;

                if(TablaHash.this.isEmpty()) { return false; }
                if(current_bucket >= t.length) { return false; }

                // bucket actual vacío o listo?...
                if(t[current_bucket].isEmpty() || current_entry >= t[current_bucket].size() - 1)
                {
                    // ... -> ver el siguiente bucket no vacío...
                    int next_bucket = current_bucket + 1;
                    while(next_bucket < t.length && t[next_bucket].isEmpty())
                    {
                        next_bucket++;
                    }
                    if(next_bucket >= t.length) { return false; }
                }

                // en principio alcanza con esto... revisar...
                return true;
            }

            /*
             * Retorna el siguiente elemento disponible en la tabla.
             */
            @Override
            public Map.Entry<K, V> next()
            {
                // control: fail-fast iterator...
                if(TablaHash.this.modCount != expected_modCount)
                {
                    throw new ConcurrentModificationException("next(): modificación inesperada de tabla...");
                }

                if(!hasNext())
                {
                    throw new NoSuchElementException("next(): no existe el elemento pedido...");
                }

                // variable auxiliar t para simplificar accesos...
                 ArrayList<Map.Entry<K, V>> t[] = TablaHash.this.table;

                // se puede seguir en el mismo bucket?...
                 ArrayList<Map.Entry<K, V>> bucket = t[current_bucket];
                if(!t[current_bucket].isEmpty() && current_entry < bucket.size() - 1) { current_entry++; }
                else
                {
                    // si no se puede...
                    // ...recordar el índice del bucket que se va a abandonar..
                    last_bucket = current_bucket;

                    // buscar el siguiente bucket no vacío, que DEBE existir, ya
                    // que se hasNext() retornó true...
                    current_bucket++;
                    while(t[current_bucket].isEmpty())
                    {
                        current_bucket++;
                    }

                    // actualizar la referencia bucket con el núevo índice...
                    bucket = t[current_bucket];

                    // y posicionarse en el primer elemento de ese bucket...
                    current_entry = 0;
                }

                // avisar que next() fue invocado con éxito...
                next_ok = true;

                // y retornar el elemento alcanzado...
                return bucket.get(current_entry);
            }

            /*
             * Remueve el elemento actual de la tabla, dejando el iterador en la
             * posición anterior al que fue removido. El elemento removido es el
             * que fue retornado la última vez que se invocó a next(). El método
             * sólo puede ser invocado una vez por cada invocación a next().
             */
            @Override
            public void remove()
            {
                if(!next_ok)
                {
                    throw new IllegalStateException("remove(): debe invocar a next() antes de remove()...");
                }

                // eliminar el objeto que retornó next() la última vez...
                Map.Entry<K, V> garbage = TablaHash.this.table[current_bucket].remove(current_entry);

                // quedar apuntando al anterior al que se retornó...
                if(last_bucket != current_bucket)
                {
                    current_bucket = last_bucket;
                    current_entry = TablaHash.this.table[current_bucket].size() - 1;
                }

                // avisar que el remove() válido para next() ya se activó...
                next_ok = false;

                // la tabla tiene un elementon menos...
                TablaHash.this.count--;

                // fail_fast iterator: todo en orden...
                TablaHash.this.modCount++;
                expected_modCount++;
            }
        }
    }

    /*
     * Clase interna que representa una vista de todos los VALORES mapeados en
     * la tabla: si la vista cambia, cambia también la tabla que le da respaldo,
     * y viceversa. La vista es stateless: no mantiene estado alguno (es decir,
     * no contiene datos ella misma, sino que accede y gestiona directamente los
     * de otra fuente), por lo que no tiene atributos y sus métodos gestionan en
     * forma directa el contenido de la tabla. Están soportados los metodos para
     * eliminar un objeto (remove()), eliminar todo el contenido (clear) y la
     * creación de un Iterator (que incluye el método Iterator.remove()).
     */
    private class ValueCollection extends AbstractCollection<V>
    {
        @Override
        public Iterator<V> iterator()
        {
            return new ValueCollectionIterator();
        }

        @Override
        public int size()
        {
            return TablaHash.this.count;
        }

        @Override
        public boolean contains(Object o)
        {
            return TablaHash.this.containsValue(o);
        }

        @Override
        public void clear()
        {
            TablaHash.this.clear();
        }

        private class ValueCollectionIterator implements Iterator<V>
        {
            // índice de la lista actualmente recorrida...
            private int current_bucket;

            // índice de la lista anterior (si se requiere en remove())...
            private int last_bucket;

            // índice del elemento actual en el iterador (el que fue retornado
            // la última vez por next() y será eliminado por remove())...
            private int current_entry;

            // flag para controlar si remove() está bien invocado...
            private boolean next_ok;

            // el valor que debería tener el modCount de la tabla completa...
            private int expected_modCount;

            /*
             * Crea un iterador comenzando en la primera lista. Activa el
             * mecanismo fail-fast.
             */
            public ValueCollectionIterator()
            {
                current_bucket = 0;
                last_bucket = 0;
                current_entry = -1;
                next_ok = false;
                expected_modCount = TablaHash.this.modCount;
            }

            /*
             * Determina si hay al menos un elemento en la tabla que no haya
             * sido retornado por next().
             */
            @Override
            public boolean hasNext()
            {
                // variable auxiliar t para simplificar accesos...
                 ArrayList<Map.Entry<K, V>> t[] = TablaHash.this.table;

                if(TablaHash.this.isEmpty()) { return false; }
                if(current_bucket >= t.length) { return false; }

                // bucket actual vacío o listo?...
                if(t[current_bucket].isEmpty() || current_entry >= t[current_bucket].size() - 1)
                {
                    // ... -> ver el siguiente bucket no vacío...
                    int next_bucket = current_bucket + 1;
                    while(next_bucket < t.length && t[next_bucket].isEmpty())
                    {
                        next_bucket++;
                    }
                    if(next_bucket >= t.length) { return false; }
                }

                // en principio alcanza con esto... revisar...
                return true;
            }

            /*
             * Retorna el siguiente elemento disponible en la tabla.
             */
            @Override
            public V next()
            {
                // control: fail-fast iterator...
                if(TablaHash.this.modCount != expected_modCount)
                {
                    throw new ConcurrentModificationException("next(): modificación inesperada de tabla...");
                }

                if(!hasNext())
                {
                    throw new NoSuchElementException("next(): no existe el elemento pedido...");
                }

                // variable auxiliar t para simplificar accesos...
                 ArrayList<Map.Entry<K, V>> t[] = TablaHash.this.table;

                // se puede seguir en el mismo bucket?...
                 ArrayList<Map.Entry<K, V>> bucket = t[current_bucket];
                if(!t[current_bucket].isEmpty() && current_entry < bucket.size() - 1) { current_entry++; }
                else
                {
                    // si no se puede...
                    // ...recordar el índice del bucket que se va a abandonar..
                    last_bucket = current_bucket;

                    // buscar el siguiente bucket no vacío, que DEBE existir, ya
                    // que se hasNext() retornó true...
                    current_bucket++;
                    while(t[current_bucket].isEmpty())
                    {
                        current_bucket++;
                    }

                    // actualizar la referencia bucket con el núevo índice...
                    bucket = t[current_bucket];

                    // y posicionarse en el primer elemento de ese bucket...
                    current_entry = 0;
                }

                // avisar que next() fue invocado con éxito...
                next_ok = true;

                // y retornar la clave del elemento alcanzado...
                V value = bucket.get(current_entry).getValue();
                return value;
            }

            /*
             * Remueve el elemento actual de la tabla, dejando el iterador en la
             * posición anterior al que fue removido. El elemento removido es el
             * que fue retornado la última vez que se invocó a next(). El método
             * sólo puede ser invocado una vez por cada invocación a next().
             */
            @Override
            public void remove()
            {
                if(!next_ok)
                {
                    throw new IllegalStateException("remove(): debe invocar a next() antes de remove()...");
                }

                // eliminar el objeto que retornó next() la última vez...
                Map.Entry<K, V> garbage = TablaHash.this.table[current_bucket].remove(current_entry);

                // quedar apuntando al anterior al que se retornó...
                if(last_bucket != current_bucket)
                {
                    current_bucket = last_bucket;
                    current_entry = TablaHash.this.table[current_bucket].size() - 1;
                }

                // avisar que el remove() válido para next() ya se activó...
                next_ok = false;

                // la tabla tiene un elementon menos...
                TablaHash.this.count--;

                // fail_fast iterator: todo en orden...
                TablaHash.this.modCount++;
                expected_modCount++;
            }     
        }
    }
}
