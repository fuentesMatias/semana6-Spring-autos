package ar.edu.utn.frc.backend.spring.application.response;

import java.io.Serializable;

public class MarcaResponse {
    private String id;

    private String nombre;

    public MarcaResponse(String id, String nombre) {
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
