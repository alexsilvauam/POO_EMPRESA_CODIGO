package modelo;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Conductor> conductores;
    private List<Vehiculo> vehiculos;
    private List<Cliente> clientes;
    private List<Viaje> viajes;

    public Empresa(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la empresa no puede estar vacío");
        }
        
        this.nombre = nombre.trim();
        this.conductores = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.viajes = new ArrayList<>();
    }

    public void registrarConductor(Conductor conductor) {
        if (conductor == null) {
            System.out.println("Error: No se puede registrar un conductor nulo.");
            return;
        }
        
        // Verificar si ya existe un conductor con la misma licencia
        for (Conductor c : conductores) {
            if (c.getLicencia().equals(conductor.getLicencia())) {
                System.out.println("Error: Ya existe un conductor con la licencia " + conductor.getLicencia());
                return;
            }
        }
        
        conductores.add(conductor);
        System.out.println("✅ Conductor registrado exitosamente: " + conductor.getNombre());
    }

    public void registrarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            System.out.println("Error: No se puede registrar un vehículo nulo.");
            return;
        }
        
        // Verificar si ya existe un vehículo con la misma placa
        for (Vehiculo v : vehiculos) {
            if (v.getPlaca().equals(vehiculo.getPlaca())) {
                System.out.println("Error: Ya existe un vehículo con la placa " + vehiculo.getPlaca());
                return;
            }
        }
        
        vehiculos.add(vehiculo);
        System.out.println("✅ Vehículo registrado exitosamente: " + vehiculo.getModelo() + " (" + vehiculo.getPlaca() + ")");
    }

    public void registrarCliente(Cliente cliente) {
        if (cliente == null) {
            System.out.println("Error: No se puede registrar un cliente nulo.");
            return;
        }
        
        // Verificar si ya existe un cliente con el mismo email
        for (Cliente c : clientes) {
            if (c.getEmail().equals(cliente.getEmail())) {
                System.out.println("Error: Ya existe un cliente con el email " + cliente.getEmail());
                return;
            }
        }
        
        clientes.add(cliente);
        System.out.println("✅ Cliente registrado exitosamente: " + cliente.getNombre());
    }

    public boolean asignarViaje(String origen, String destino, double costo, Cliente cliente, Vehiculo vehiculo) {
        if (cliente == null) {
            System.out.println("❌ Error: El cliente no puede ser nulo.");
            return false;
        }
        
        if (vehiculo == null) {
            System.out.println("❌ Error: El vehículo no puede ser nulo.");
            return false;
        }
        
        if (!clientes.contains(cliente)) {
            System.out.println("❌ Error: El cliente no está registrado en la empresa.");
            return false;
        }
        
        if (!vehiculos.contains(vehiculo)) {
            System.out.println("❌ Error: El vehículo no está registrado en la empresa.");
            return false;
        }
        
        if (!vehiculo.isDisponible()) {
            System.out.println("❌ Error: El vehículo no está disponible.");
            return false;
        }
        
        if (costo <= 0) {
            System.out.println("❌ Error: El costo debe ser mayor a 0.");
            return false;
        }

        vehiculo.setDisponible(false);
        Viaje viaje = new Viaje(origen, destino, costo, cliente, vehiculo);
        viajes.add(viaje);
        System.out.println("✅ Viaje asignado exitosamente!");
        return true;
    }

    public void mostrarTodosLosViajes() {
        if (viajes.isEmpty()) {
            System.out.println("📋 No se han realizado viajes aún.");
            return;
        }

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    VIAJES REALIZADOS                        ║");
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
        
        for (int i = 0; i < viajes.size(); i++) {
            System.out.println("\n📌 Viaje #" + (i + 1));
            viajes.get(i).mostrarDetalles();
            if (i < viajes.size() - 1) {
                System.out.println("\n" + "─".repeat(50));
            }
        }
    }

    public List<Vehiculo> getVehiculosDisponibles() {
        List<Vehiculo> disponibles = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.isDisponible()) {
                disponibles.add(vehiculo);
            }
        }
        return disponibles;
    }

    public void mostrarResumen() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println("║                    RESUMEN DE LA EMPRESA                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════════╣");
        System.out.printf("║ Empresa: %-45s ║%n", nombre);
        System.out.printf("║ Conductores registrados: %-30s ║%n", conductores.size());
        System.out.printf("║ Vehículos registrados: %-32s ║%n", vehiculos.size());
        System.out.printf("║ Vehículos disponibles: %-31s ║%n", getVehiculosDisponibles().size());
        System.out.printf("║ Clientes registrados: %-32s ║%n", clientes.size());
        System.out.printf("║ Viajes realizados: %-34s ║%n", viajes.size());
        System.out.println("╚══════════════════════════════════════════════════════════════╝");
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Conductor> getConductores() {
        return new ArrayList<>(conductores);
    }

    public List<Vehiculo> getVehiculos() {
        return new ArrayList<>(vehiculos);
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    public List<Viaje> getViajes() {
        return new ArrayList<>(viajes);
    }
}
