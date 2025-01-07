package com.hospital.apihospital.Genero;

public enum Genero {
    MASCULINO("masculino"),
    FEMENINO("femenino");
    private final String genero;

    Genero(String genero) {
        this.genero = genero;
    }

    public static Genero ofString(String genero) {
        for (Genero value : values()) {
            if (value.genero.equalsIgnoreCase(genero)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Genero Desconocido: " + genero);
    }
}
