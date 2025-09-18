package modelo;

public class Viaje {
    private String origen;
    private String destino;
    private double costo;
    private Cliente cliente;
    private Vehiculo vehiculo;

    public Viaje(String origen, String destino, double costo, Cliente cliente, Vehiculo vehiculo) {
        if (origen == null || origen.trim().isEmpty()) {
            throw new IllegalArgumentException("El origen no puede estar vacío");
        }
        if (destino == null || destino.trim().isEmpty()) {
            throw new IllegalArgumentException("El destino no puede estar vacío");
        }
        if (costo <= 0) {
            throw new IllegalArgumentException("El costo debe ser mayor a 0");
        }
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser nulo");
        }
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        
        this.origen = origen.trim();
        this.destino = destino.trim();
        this.costo = costo;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public double getCosto() {
        return costo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setOrigen(String origen) {
        if (origen != null && !origen.trim().isEmpty()) {
            this.origen = origen.trim();
        }
    }

    public void setDestino(String destino) {
        if (destino != null && !destino.trim().isEmpty()) {
            this.destino = destino.trim();
        }
    }

    public void setCosto(double costo) {
        if (costo > 0) {
            this.costo = costo;
        }
    }

    public void mostrarDetalles() {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║           DETALLES DEL VIAJE         ║");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Cliente: %-25s ║%n", cliente.getNombre());
        System.out.printf("║ Teléfono: %-23s ║%n", cliente.getTelefono());
        System.out.printf("║ Email: %-26s ║%n", cliente.getEmail());
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Vehículo: %-24s ║%n", vehiculo.getModelo());
        System.out.printf("║ Placa: %-26s ║%n", vehiculo.getPlaca());
        System.out.printf("║ Tipo: %-27s ║%n", vehiculo.getTipo());
        System.out.printf("║ Capacidad: %-22s ║%n", vehiculo.getCapacidadPasajeros() + " pasajeros");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Conductor: %-23s ║%n", vehiculo.getConductor().getNombre());
        System.out.printf("║ Licencia: %-23s ║%n", vehiculo.getConductor().getLicencia());
        System.out.printf("║ Experiencia: %-20s ║%n", vehiculo.getConductor().getAñosExperiencia() + " años");
        System.out.println("╠══════════════════════════════════════╣");
        System.out.printf("║ Ruta: %-30s ║%n", origen + " → " + destino);
        System.out.printf("║ Costo: $%-27.2f ║%n", costo);
        System.out.println("╚══════════════════════════════════════╝");
    }

    @Override
    public String toString() {
        return String.format("Viaje: %s → %s | Cliente: %s | Vehículo: %s | Costo: $%.2f", 
                           origen, destino, cliente.getNombre(), 
                           vehiculo.getModelo(), costo);
    }
}
