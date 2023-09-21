package ar.edu.utn.frc.backend.spring.application.response;

public class TipoAutoResponse {
    private String id;

    private String nombre;

    public TipoAutoResponse(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
