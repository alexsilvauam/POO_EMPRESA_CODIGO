import modelo.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚗 SISTEMA DE GESTIÓN DE TRANSPORTE PRIVADO 🚗\n");

        // Crear la empresa
        Empresa empresa = new Empresa("Transporte Rápido");
        
        // Registrar conductores
        Conductor conductor1 = new Conductor("Alex Silva", "001-030303-1031E", 5);
        Conductor conductor2 = new Conductor("María González", "002-040404-2022F", 3);
        Conductor conductor3 = new Conductor("Carlos López", "003-050505-3033G", 8);
        
        empresa.registrarConductor(conductor1);
        empresa.registrarConductor(conductor2);
        empresa.registrarConductor(conductor3);

        // Registrar vehículos
        Vehiculo vehiculo1 = new Vehiculo("M123456", "Honda Civic", 4, TipoVehiculo.AUTO, conductor1);
        Vehiculo vehiculo2 = new Vehiculo("M789012", "Yamaha R3", 2, TipoVehiculo.MOTO, conductor2);
        Vehiculo vehiculo3 = new Vehiculo("M345678", "Toyota Hilux", 6, TipoVehiculo.CAMIONETA, conductor3);
        
        empresa.registrarVehiculo(vehiculo1);
        empresa.registrarVehiculo(vehiculo2);
        empresa.registrarVehiculo(vehiculo3);

        // Registrar clientes
        Cliente cliente1 = new Cliente("Carlos Altamirano", "1111-2222", "carlosalt@clientes.com");
        Cliente cliente2 = new Cliente("Ana Martínez", "3333-4444", "ana.martinez@email.com");
        Cliente cliente3 = new Cliente("Luis Rodríguez", "5555-6666", "luis.rodriguez@correo.com");
        
        empresa.registrarCliente(cliente1);
        empresa.registrarCliente(cliente2);
        empresa.registrarCliente(cliente3);

        // Asignar viajes
        System.out.println("\n" + "=".repeat(60));
        System.out.println("ASIGNANDO VIAJES");
        System.out.println("=".repeat(60));
        
        empresa.asignarViaje("Managua", "Masaya", 500.0, cliente1, vehiculo1);
        empresa.asignarViaje("Granada", "León", 800.0, cliente2, vehiculo2);
        empresa.asignarViaje("Managua", "Matagalpa", 1200.0, cliente3, vehiculo3);

        // Mostrar resumen de la empresa
        empresa.mostrarResumen();

        // Mostrar todos los viajes realizados
        empresa.mostrarTodosLosViajes();

        System.out.println("\n🎉 ¡Sistema ejecutado exitosamente! 🎉");
    }
}