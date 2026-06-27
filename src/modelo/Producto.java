package modelo;

// Clase para guardar los datos de cada producto del inventario
public class Producto {

    // Datos del producto
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    // Constructor principal, recibe todo de una vez
    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Otro constructor por si el producto empieza sin stock
    public Producto(int id, String nombre, double precio) {
        this(id, nombre, precio, 0);
    }

    // Getters para leer los datos desde otras clases
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    // Solo dejé setter para el precio porque el stock se maneja con otros métodos
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Suma unidades al stock (ej: cuando llega mercancía nueva)
    public void agregarStock(int unidades) {
        if (unidades > 0) {
            this.cantidad += unidades;
        }
    }

    // Resta unidades, devuelve false si no hay suficiente stock
    public boolean reducirStock(int unidades) {
        if (unidades > 0 && this.cantidad >= unidades) {
            this.cantidad -= unidades;
            return true;
        }
        return false;
    }

    // Multiplica precio por cantidad para saber cuánto vale lo que hay en bodega
    public double calcularValorTotal() {
        return precio * cantidad;
    }

    // Para poder imprimir el producto fácil con System.out.println
    @Override
    public String toString() {
        return String.format(
            "ID: %d | %s | Precio: $%.2f | Stock: %d | Valor total: $%.2f",
            id, nombre, precio, cantidad, calcularValorTotal()
        );
    }
}
