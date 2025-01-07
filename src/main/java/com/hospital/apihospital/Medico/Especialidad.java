package com.hospital.apihospital.Medico;

public enum Especialidad {
    ORTOPEDIA("Ortopedia"),
    PEDIATRIA("Pediatria"),
    CARDIOLOGIA("Cardiologia");

    private final String especialidad;

    Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public static Especialidad ofString(String especialidad){
        for (Especialidad value : values()) {
            if(value.especialidad.equalsIgnoreCase(especialidad)){
                return value;
            }
        }
        throw new IllegalArgumentException("Especilidad no encontrada: " + especialidad);
    }
}
