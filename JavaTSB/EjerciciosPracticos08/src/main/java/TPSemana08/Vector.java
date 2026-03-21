package TPSemana08;

/**
 *  Representa un arreglo de elementos int, y plantea diversos metodos de 
 *  ordenamiento implementados en forma directa.
 * 
 *  @author Ing. Valerio Frittelli.
 *  @version 2.0 [Agosto de 2018].
 */
public class Vector
{
    private int v[];
    
    public Vector(int n)
    {
        if(n <= 0) { n = 100; }
        v = new int[n];
    }
    
    public int get(int i)
    {
        return v[i];
    }
    
    public void set(int i, int x)
    {
        v[i] = x;
    }

    public void generate()
    {
       for(int i=0; i<v.length; i++ )
       {
            v[i] = (int)Math.round(100 * Math.random());
       }
    }

    public boolean checkOrder()
    {
       for(int i=0; i < v.length - 1; i++)
       {
            if(v[i] > v[i+1]) { return false; }
       }
       return true;
    }

    public int linearSearch(int x)
    {
        for(int i=0; i<v.length; i++)
        {
            if(x == v[i]) return i;
        }
        return -1;
    }
    
    public int binarySearch(int x)
    {
        int n = v.length;
        int izq = 0, der = n-1;
        while(izq <= der)
        {
            int c = (izq + der)/2;
            if(x == v[c]) return c;
            
            if(x < v[c]) der = c - 1;
            else izq = c + 1;
        }
        return -1;
    }   
    
    public void bubbleSort()
    {
          boolean ordenado = false;
          int n = v.length;
          for(int i=0; i<n-1 && !ordenado; i++)
          {
                ordenado = true;
                for(int j=0; j<n-i-1; j++)
                {
                     if(v[j] > v[j+1])
                     {
                           int aux = v[j];
                           v[j] = v[j+1];
                           v[j+1] = aux;
                           ordenado = false;
                     }
                }
          }           
    }

    public void selectionSort()
    {
          int n = v.length;
          for(int i=0; i<n-1; i++)
          {
                for(int j=i+1; j<n; j++)
                {
                     if(v[i] > v[j])
                     {
                        int aux = v[i];
                        v[i] = v[j];
                        v[j] = aux;
                     }
                }
          }        
    }

    public void insertionSort()
    {
          int n = v.length;
          for(int j=1; j<n; j++)
          {
                int k, y = v[j];
                for(k=j-1; k>=0 && y<v[k]; k--)
                {
                    v[k+1]= v[k];
                }
                v[k+1]= y;
          }
    }


    //Quicksort: ordenacion rapida

    public void quickSort()
    {
          quick(0, v.length-1);
    }

    private void quick(int izq, int der)
    {
          int i = izq, j = der, y;
          int x = v[(izq + der) / 2];
          do 
          {
                while(v[i]<x && i<der) { i++; }
                while(x<v[j] && j>izq) { j--; }
                if(i <= j)
                {
                      y = v[i];
                      v[i] = v[j];
                      v[j] = y;
                      i++;
                      j--;
                }
          }
          while(i <= j);
          if(izq < j) { quick( izq, j ); }
          if(i < der) { quick( i, der ); }
    }        
    
    public void heapSort()
    {
           int n = v.length;

           // crear el grupo inicial...
           for(int i=1; i<n; i++)
           {
                int e = v[i];
                int s = i;
                int f = (s-1)/2;
                while(s>0 && v[f] < e)
                {
                      v[s] = v[f];
                      s = f;
                      f = (s-1)/2;
                }
                v[s] = e;
           }

           // se extrae la raiz, y se reordena el vector y el grupo...
           for(int i = n-1; i>0; i-- )
           {
                int valori = v[i];
                v[i] = v[0];
                int f = 0, s;
                if(i==1) { s = -1; } else { s = 1; }
                if(i>2 && v[2]>v[1])  { s = 2; }
                while(s>=0 && valori<v[s])
                {
                      v[f] = v[s];
                      f = s;
                      s = 2*f + 1;
                      if(s+1<=i-1 && v[s]<v[s+1]) { s++; }
                      if(s>i-1) { s = -1; }
                }
                v[f] = valori;
           }
    }

    public void shellSort()
    {
        int h, n = v.length;
        for(h = 1; h <= n / 9; h = 3*h + 1);
        for (; h > 0; h /= 3)
        {
              for (int j = h; j < n; j++)
              {
                   int k, y = v[j];
                   for(k = j - h; k >= 0 && y < v[k]; k-=h)
                   {
                         v[k+h] = v[k];
                   }
                   v[k+h] = y;
              }
        }
    }
    
    public void mergeSort()
    {
        int n = v.length;
        int temp[] = new int[n];
        sort(0, n-1, temp);
    }

    private void sort(int izq, int der, int temp[])
    {
        if(izq < der) 
        {
            int centro = (izq + der) / 2;
            sort(izq, centro, temp);
            sort(centro + 1, der, temp);
            merge(izq, centro, der, temp);
        }    
    }       

    private void merge(int izq, int centro, int der, int temp[])
    {
        for(int i = izq; i <= der; i++) { temp[i] = v[i]; }

        int i = izq, j = centro + 1, k = izq;
        while(i <= centro && j <= der) 
        {
           if(temp[i] <= temp[j]) 
           {
             v[k] = temp[i];
             i++;
           } 
           else 
           {
             v[k] = temp[j];
             j++;
           }
           k++;
        }

        while(i <= centro) 
        {
           v[k] = temp[i];
           k++;
           i++;
        }
    }   
}
