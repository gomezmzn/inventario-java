import modelo.Inventario;
import modelo.Producto;
import java.util.List;

// Clase main, acá se prueba todo el programa
public class AppInventario {

    public static void main(String[] args) {

        // Creo el inventario y algunos productos de ejemplo
        Inventario inventario = new Inventario("Almacén Central");

        Producto laptop = new Producto(1, "Laptop HP 15", 899.99, 10);
        Producto mouse = new Producto(2, "Mouse inalámbrico", 25.50, 50);
        Producto teclado = new Producto(3, "Teclado mecánico", 75.00, 30);

        // Este usa el otro constructor, después le agrego stock aparte
        Producto monitor = new Producto(4, "Monitor 24 pulgadas", 199.99);
        monitor.agregarStock(15);

        System.out.println("=== Sistema de Inventario ===\n");

        // Los meto al inventario
        inventario.agregarProducto(laptop);
        inventario.agregarProducto(mouse);
        inventario.agregarProducto(teclado);
        inventario.agregarProducto(monitor);

        inventario.listarProductos();

        // Pruebo buscar por id
        System.out.println("\n--- Búsqueda por ID ---");
        Producto encontrado = inventario.buscarPorId(2);
        if (encontrado != null) {
            System.out.println("  Encontrado: " + encontrado);
        }

        // Pruebo buscar por nombre
        System.out.println("\n--- Búsqueda por nombre ('teclado') ---");
        List<Producto> resultados = inventario.buscarPorNombre("teclado");
        for (Producto p : resultados) {
            System.out.println("  " + p);
        }

        // Pruebo cambiar stock y precios
        System.out.println("\n--- Operaciones de stock ---");

        // Simulo que vendieron 3 laptops
        boolean ventaExitosa = laptop.reducirStock(3);
        System.out.println("  Venta de 3 laptops: " + (ventaExitosa ? "exitosa" : "fallida"));
        System.out.println("  Stock actual de laptop: " + laptop.getCantidad());

        // Llegaron 20 mouses más
        mouse.agregarStock(20);
        System.out.println("  Stock actual de mouse tras recepción: " + mouse.getCantidad());

        // Le bajo el precio al teclado
        teclado.setPrecio(69.99);
        System.out.println("  Nuevo precio del teclado: $" + teclado.getPrecio());

        // Veo cómo quedó todo
        inventario.listarProductos();

        System.out.println("\n--- Resumen ---");
        System.out.println("  Productos registrados: " + inventario.obtenerCantidadProductos());
        System.out.printf("  Valor total del inventario: $%.2f%n",
                inventario.calcularValorTotalInventario());

        // Por último elimino un producto para probar ese método también
        System.out.println("\n--- Eliminación de producto ---");
        inventario.eliminarProducto(4);
        inventario.listarProductos();
    }
}
