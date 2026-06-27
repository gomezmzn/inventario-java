package modelo;

import java.util.ArrayList;
import java.util.List;

// Esta clase maneja todos los productos, como una lista general del almacén
public class Inventario {

    private List<Producto> productos;
    private String nombreAlmacen;

    // Al crear el inventario solo le paso el nombre, la lista empieza vacía
    public Inventario(String nombreAlmacen) {
        this.nombreAlmacen = nombreAlmacen;
        this.productos = new ArrayList<>();
    }

    // Mete un producto a la lista
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        System.out.println("Producto agregado: " + producto.getNombre());
    }

    // Recorre la lista y busca por id, si no lo encuentra devuelve null
    public Producto buscarPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null;
    }

    // Busca productos que tengan el texto en el nombre (no importa mayúsculas)
    public List<Producto> buscarPorNombre(String texto) {
        List<Producto> resultados = new ArrayList<>();
        String textoMinusculas = texto.toLowerCase();

        for (Producto producto : productos) {
            if (producto.getNombre().toLowerCase().contains(textoMinusculas)) {
                resultados.add(producto);
            }
        }
        return resultados;
    }

    // Primero busca el producto y después lo saca de la lista
    public boolean eliminarProducto(int id) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            productos.remove(producto);
            System.out.println("Producto eliminado: " + producto.getNombre());
            return true;
        }
        System.out.println("No se encontró el producto con ID: " + id);
        return false;
    }

    // Imprime todos los productos, o un mensaje si la lista está vacía
    public void listarProductos() {
        System.out.println("\n--- Inventario: " + nombreAlmacen + " ---");
        if (productos.isEmpty()) {
            System.out.println("  (sin productos registrados)");
            return;
        }
        for (Producto producto : productos) {
            System.out.println("  " + producto);
        }
    }

    // Va sumando el valor de cada producto para tener el total del inventario
    public double calcularValorTotalInventario() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.calcularValorTotal();
        }
        return total;
    }

    // Cuántos productos hay en total
    public int obtenerCantidadProductos() {
        return productos.size();
    }

    public String getNombreAlmacen() {
        return nombreAlmacen;
    }
}
