package modelo;

public class Vehiculo {
    private String placa;
    private String modelo;
    private int capacidadPasajeros;
    private TipoVehiculo tipo;
    private Conductor conductor;
    private boolean disponible;

    public Vehiculo(String placa, String modelo, int capacidadPasajeros, TipoVehiculo tipo, Conductor conductor) {
        if (placa == null || placa.trim().isEmpty()) {
            throw new IllegalArgumentException("La placa no puede estar vacía");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        }
        if (capacidadPasajeros <= 0) {
            throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor a 0");
        }
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de vehículo no puede ser nulo");
        }
        if (conductor == null) {
            throw new IllegalArgumentException("El conductor no puede ser nulo");
        }
        
        this.placa = placa.trim().toUpperCase();
        this.modelo = modelo.trim();
        this.capacidadPasajeros = capacidadPasajeros;
        this.tipo = tipo;
        this.conductor = conductor;
        this.disponible = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void asignarConductor(Conductor nuevoConductor) {
        if (nuevoConductor != null) {
            this.conductor = nuevoConductor;
        }
    }

    @Override
    public String toString() {
        return String.format("Vehículo: %s %s (%s) - %s | Conductor: %s | %s", 
                           tipo, modelo, placa, 
                           capacidadPasajeros + " pasajeros",
                           conductor.getNombre(),
                           disponible ? "Disponible" : "Ocupado");
    }
}
