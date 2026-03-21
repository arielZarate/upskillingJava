# Java Generics - Guía Práctica

## 📋 Índice

1. [¿Por qué usar Genéricos?](#por-qué-usar-genéricos)
2. [Clase Genérica Par<K,V>](#clase-genérica-parkv)
3. [Interfaz Genérica ProductDAO<T>](#interfaz-genérica-productdaot)
4. [Métodos Genéricos en Utilidades](#métodos-genéricos-en-utilidades)
5. [Wildcards](#wildcards)
6. [Bounded Wildcards](#bounded-wildcards)
7. [Convenciones de Nomenclatura](#convenciones-de-nomenclatura)

---

## ¿Por qué usar Genéricos?

Los genéricos permiten crear **clases, interfaces y métodos** que trabajan con cualquier tipo de dato, proporcionando:

- ✅ **Type Safety** - Errores detectados en tiempo de compilación
- ✅ **Reutilización de código** - Un solo código para múltiples tipos
- ✅ **Sin casteos manuales** - No necesitas `instanceof` ni cast

### Ejemplo práctico: Sin Genéricos vs Con Genéricos

```java
// ❌ Sin genéricos - permite cualquier tipo, error en runtime
List lista = new ArrayList();
lista.add("Hola");
lista.add(123); // Permite Integer

// ✅ Con genéricos - restringe el tipo, error en compilación
List<String> lista = new ArrayList<>();
lista.add("Hola");
lista.add(123); // ❌ Error de compilación
```

---

## Clase Genérica Par<K,V>

Simula una estructura clave-valor tipo JSON.

### Código fuente: `Homework/models/Par.java`

```java
public class Par<K, V> {
    private K clave;
    private V valor;

    public Par(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public K getClave() { return clave; }
    public V getValor() { return valor; }

    @Override
    public String toString() {
        return "Par{" + clave + "=" + valor + "}";
    }
}
```

### Ejemplo de uso en Main

```java
System.out.println("=== CLASE GENERICA Par<K,V> (Simula JSON) ===");
List<Par<String, Object>> usuarioJson = new ArrayList<>();
usuarioJson.add(new Par<>("nombre", "Juan"));
usuarioJson.add(new Par<>("edad", 30));
usuarioJson.add(new Par<>("activo", true));
usuarioJson.add(new Par<>("promedio", 8.5));

System.out.println("Usuario JSON:");
for (Par<String, Object> campo : usuarioJson) {
    System.out.println("  " + campo.getClave() + ": " + 
        campo.getValor() + " (" + campo.getValor().getClass().getSimpleName() + ")");
}
```

**Salida:**
```
=== CLASE GENERICA Par<K,V> (Simula JSON) ===
Usuario JSON:
  nombre: Juan (String)
  edad: 30 (Integer)
  activo: true (Boolean)
  promedio: 8.5 (Double)
```

---

## Interfaz Genérica ProductDAO<T>

Patrón DAO genérico que permite trabajar con cualquier entidad.

### Código fuente: `ProductInterfaceDAO/ProductDAO.java`

```java
public interface ProductDAO<T> {
    void guardar(T t);
    T buscarPorId(Long id);
}
```

### Implementación: `ProductInterfaceDAO/ProductoImpl.java`

```java
public class ProductoImpl implements ProductDAO<Producto> {
    private Map<Long, Producto> productos = new HashMap<>();

    @Override
    public void guardar(Producto producto) {
        productos.put(producto.getId(), producto);
    }

    @Override
    public Producto buscarPorId(Long id) {
        return productos.get(id);
    }
}
```

### Entidad: `ProductInterfaceDAO/Producto.java`

```java
public class Producto {
    private Long id;
    private String nombre;
    private Double precio;

    public Producto(Long id, String nombre, Double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }
    // getters...
}
```

### Ejemplo de uso en Main

```java
ProductDAO<Producto> repo = new ProductoImpl();

repo.guardar(new Producto(1L, "Laptop", 1500.0));
repo.guardar(new Producto(2L, "Mouse", 25.0));
repo.guardar(new Producto(3L, "Teclado", 80.0));

System.out.println("Buscar ID 1: " + repo.buscarPorId(1L));
System.out.println("Buscar ID 2: " + repo.buscarPorId(2L));
System.out.println("Buscar ID 99: " + repo.buscarPorId(99L));
```

**Salida:**
```
Buscar ID 1: Producto{id=1, nombre='Laptop', precio=1500.0}
Buscar ID 2: Producto{id=2, nombre='Mouse', precio=25.0}
Buscar ID 99: null
```

---

## Métodos Genéricos en Utilidades

### Código fuente: `Homework/Utilidades.java`

```java
public class Utilidades {

    public static <T> T obtenerElemento(List<T> lista, int indice) {
        if (indice < 0 || indice >= lista.size()) {
            throw new IndexOutOfBoundsException("Indice fuera de rango");
        }
        return lista.get(indice);
    }

    public static <T> void agregarSiNulo(List<T> lista, T elemento) {
        if (elemento == null) {
            lista.add(elemento);
        }
    }
}
```

### Ejemplo de uso en Main

```java
System.out.println("\n=== METODOS GENERICOS ===");
String nombre = Utilidades.obtenerElemento(frutas, 0);
System.out.println("Primer elemento de frutas: " + nombre);

Integer numero = Utilidades.obtenerElemento(numeros, 2);
System.out.println("Tercer numero: " + numero);

System.out.println("\n--- agregarSiNulo (solo agrega si es null) ---");
List<String> listaConNulo = new ArrayList<>();
Utilidades.agregarSiNulo(listaConNulo, null);
Utilidades.agregarSiNulo(listaConNulo, "No se agrega");
System.out.println("Lista con nulo: " + listaConNulo);
```

**Salida:**
```
=== METODOS GENERICOS ===
Primer elemento de frutas: Manzana
Tercer numero: 3

--- agregarSiNulo (solo agrega si es null) ---
Lista con nulo: [null]
```

---

## Wildcards

### Wildcard sin límite (`?`)

Acepta **cualquier tipo** de lista.

#### Código fuente

```java
public static void imprimirElementos(List<?> lista) {
    lista.forEach(System.out::println);
}
```

#### Ejemplo de uso en Main

```java
System.out.println("=== IMPRIMIR ELEMENTOS (Wildcard ?) ===");
System.out.println("\n--- Numeros ---");
Utilidades.imprimirElementos(numeros);  // List<Integer>

System.out.println("\n--- Frutas ---");
Utilidades.imprimirElementos(frutas);  // List<String>

System.out.println("\n--- Estudiantes ---");
Utilidades.imprimirElementos(estudiantes);  // List<Estudiante>
```

**Salida:**
```
=== IMPRIMIR ELEMENTOS (Wildcard ?) ===
--- Numeros ---
1
2
3
4
5
--- Frutas ---
Manzana
Banana
Naranja
--- Estudiantes ---
Estudiante{nombre='Juan', edad=20, curso='Java'}
Estudiante{nombre='Maria', edad=22, curso='Python'}
```

---

## Bounded Wildcards

### Upper Bounded: `? extends T` (Producer)

Recibe listas de **T o subtipos**. Se usa para **leer** elementos.

### Lower Bounded: `? super T` (Consumer)

Recibe listas de **T o supertipos**. Se usa para **agregar** elementos.

#### Código fuente

```java
public static <T> void copiarElementos(List<? extends T> origen, List<? super T> destino) {
    for (T elemento : origen) {
        destino.add(elemento);
    }
}
```

#### Ejemplo de uso en Main

```java
System.out.println("\n=== COPIAR ELEMENTOS (Bounded Wildcards) ===");

List<Persona> personas = new ArrayList<>();
System.out.println("--- Copiar Estudiantes a Personas ---");
System.out.println("Antes: " + personas);
Utilidades.copiarElementos(estudiantes, personas);
System.out.println("Despues: " + personas);

System.out.println("--- Copiar Profesores a Personas ---");
Utilidades.copiarElementos(profesores, personas);
System.out.println("Personas total: " + personas);

List<Number> numeros2 = new ArrayList<>();
List<Integer> enteros = Arrays.asList(10, 20, 30);
System.out.println("--- Copiar Integer a Number ---");
Utilidades.copiarElementos(enteros, numeros2);
System.out.println("Numeros: " + numeros2);
```

**Salida:**
```
=== COPIAR ELEMENTOS (Bounded Wildcards) ===
--- Copiar Estudiantes a Personas ---
Antes: []
Despues: [Estudiante{nombre='Juan', edad=20, curso='Java'}, ...]
--- Copiar Profesores a Personas ---
Personas total: [Estudiante{...}, Estudiante{...}, Profesor{...}, Profesor{...}]
--- Copiar Integer a Number ---
Numeros: [10, 20, 30]
```

#### Demostración de error de compilación

```java
List<Estudiante> listaEstudiantes = new ArrayList<>();
Utilidades.copiarElementos(personas, listaEstudiantes); // ❌ ERROR DE COMPILACION
```

```
Motivo: 'personas' es List<Persona> y 'listaEstudiantes' es List<Estudiante>
El método espera destino List<? super Estudiante>
Persona es superclase de Estudiante, pero la lista es de Personas, no de Estudiante
```

#### Regla mnemotécnica

| Situación | Wildcard | Uso |
|-----------|----------|-----|
| **Producer** (lees) | `? extends T` | Origen |
| **Consumer** (agregas) | `? super T` | Destino |

---

## Convenciones de Nomenclatura

| Letra | Significado | Uso típico |
|-------|-------------|------------|
| `T` | Type | Tipo genérico |
| `E` | Element | Elementos de colecciones |
| `K` | Key | Claves |
| `V` | Value | Valores |
| `R` | Return | Tipo de retorno |

---

## 📁 Estructura del Proyecto

```
src/main/java/
├── Homework/
│   ├── Main.java              # Demostración de genéricos
│   ├── Utilidades.java        # Métodos genéricos
│   └── models/
│       ├── Persona.java       # Clase base
│       ├── Estudiante.java    # Extiende Persona
│       ├── Profesor.java      # Extiende Persona
│       └── Par.java           # Clase genérica <K,V>
│
└── ProductInterfaceDAO/
    ├── Main.java              # Demostración de interfaz genérica
    ├── ProductDAO.java        # Interfaz genérica
    ├── ProductoImpl.java      # Implementación
    └── Producto.java          # Entidad
```

---

## 🎯 Resumen de Conceptos Cubiertos

| Concepto | Implementación | Archivo |
|----------|----------------|---------|
| Clase genérica | `Par<K,V>` | `Homework/models/Par.java` |
| Interfaz genérica | `ProductDAO<T>` | `ProductInterfaceDAO/ProductDAO.java` |
| Método genérico | `obtenerElemento(List<T>, int)` | `Homework/Utilidades.java` |
| Wildcard `?` | `imprimirElementos(List<?>)` | `Homework/Utilidades.java` |
| Bounded Wildcard | `copiarElementos(? extends T, ? super T)` | `Homework/Utilidades.java` |

---

## ▶️ Ejecutar

```bash
# Compilar todo
mvn compile

# Ejecutar demo principal (Genéricos, Wildcards, Bounded)
mvn exec:java -Dexec.mainClass="Homework.Main"

# Ejecutar demo DAO (Interfaz genérica)
mvn exec:java -Dexec.mainClass="ProductInterfaceDAO.Main"
```
