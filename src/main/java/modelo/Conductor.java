package modelo;

public class Conductor {
    private String nombre;
    private String licencia;
    private int añosExperiencia;

    public Conductor(String nombre, String licencia, int añosExperiencia) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del conductor no puede estar vacío");
        }
        if (licencia == null || licencia.trim().isEmpty()) {
            throw new IllegalArgumentException("La licencia no puede estar vacía");
        }
        if (añosExperiencia < 0) {
            throw new IllegalArgumentException("Los años de experiencia no pueden ser negativos");
        }
        
        this.nombre = nombre.trim();
        this.licencia = licencia.trim();
        this.añosExperiencia = añosExperiencia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public int getAñosExperiencia() {
        return añosExperiencia;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre.trim();
        }
    }

    public void setLicencia(String licencia) {
        if (licencia != null && !licencia.trim().isEmpty()) {
            this.licencia = licencia.trim();
        }
    }

    public void setAñosExperiencia(int añosExperiencia) {
        if (añosExperiencia >= 0) {
            this.añosExperiencia = añosExperiencia;
        }
    }

    @Override
    public String toString() {
        return String.format("Conductor: %s | Licencia: %s | Experiencia: %d años", 
                           nombre, licencia, añosExperiencia);
    }
}
