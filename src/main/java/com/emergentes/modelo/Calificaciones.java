package com.emergentes.modelo;

public class Calificaciones {
    private int id;
    private String Nombre;
    private int PrimerParcial;
    private int SegParcial;
    private int Exfinal;

    public Calificaciones() {
        
        this.id = 0;
        this.Nombre = "";
        this.PrimerParcial = 0;
        this.SegParcial = 0;
        this.Exfinal = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPrimerParcial() {
        return PrimerParcial;
    }

    public void setPrimerParcial(int PrimerParcial) {
        this.PrimerParcial = PrimerParcial;
    }

    public int getSegParcial() {
        return SegParcial;
    }

    public void setSegParcial(int SegParcial) {
        this.SegParcial = SegParcial;
    }

    public int getExfinal() {
        return Exfinal;
    }

    public void setExfinal(int Exfinal) {
        this.Exfinal = Exfinal;
    }
    

   

    
    

    
}
