# Inventario Java

Proyecto de inventario hecho en Java para practicar clases, objetos, constructores y métodos.

La idea es simular un almacén donde puedes guardar productos, buscarlos, cambiar stock y ver cuánto vale todo el inventario.

## Qué hace el programa

Cuando lo corres, el programa:

- Crea un inventario llamado "Almacén Central"
- Agrega productos de ejemplo (laptop, mouse, teclado, monitor)
- Busca productos por ID y por nombre
- Simula ventas y entradas de mercancía
- Muestra el valor total del inventario
- Elimina un producto al final

Todo se imprime en consola, no tiene menú ni interfaz gráfica.

## Estructura del proyecto

```
Inventario/
├── src/
│   ├── AppInventario.java      → main, acá arranca el programa
│   └── modelo/
│       ├── Producto.java       → datos de un producto (id, nombre, precio, stock)
│       └── Inventario.java     → lista de productos y métodos para manejarlos
├── .project
├── .classpath
└── README.md
```



## Clases principales



### Producto

Guarda la info de cada artículo. Tiene dos constructores:

- Uno con stock inicial
- Otro que empieza en 0 y después le agregas unidades

También tiene métodos como `agregarStock()`, `reducirStock()` y `calcularValorTotal()`.

### Inventario

Es como la "base de datos" del almacén. Ahí puedes:

- Agregar y eliminar productos
- Buscar por id o por nombre
- Listar todo
- Sacar el valor total



### AppInventario

Es la clase con el `main`. Instancia objetos y prueba los métodos para ver que todo funcione.

## Cómo correrlo



### En Eclipse

1. Importa el proyecto (File → Open Projects from File System)
2. Abre `AppInventario.java`
3. Clic derecho → Run As → Java Application



### En terminal

```bash
cd Inventario
javac -d bin -sourcepath src src/AppInventario.java src/modelo/*.java
java -cp bin AppInventario
```

Necesitas tener Java instalado (probé con Java 17).

## Conceptos que se usan

- Declaración de clases y atributos
- Constructores (normal y sobrecargado)
- Instanciación de objetos con `new`
- Métodos propios y getters/setters
- Uso de `ArrayList` para guardar productos
- `@Override` en `toString()` para imprimir bonito



## Notas

- La carpeta `bin/` son los `.class` compilados, no hay que subirla a GitHub
- Lo mismo con `.metadata/` e `.idea/`, son archivos del IDE



## Autor

Oliver Gómez
Proyecto de práctica en Java para la matería de programación orientada a objetos.