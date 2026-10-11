/*
ARIEL VILLA OLIVAREZ
ANGEL EMILIANO REYNOSO LÓPEZ
JULIAN EMMANUEL MENDEZ RODRIGUEZ
 */
package back_end;

public record Persona(String curp, String nombres, String apellidos, int edad,String tipodeUsuario) {
    
    public Persona{
        if (curp == null || curp.trim().isEmpty()){
            throw new IllegalArgumentException("La CURP no puede estar vacía.");
        }
        if (nombres == null || nombres.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede estar vacía.");
        }
        if (apellidos == null || apellidos.trim().isEmpty()){
            throw new IllegalArgumentException("Los apellidos no puede estar vacía.");
        }
            if (edad <= 0){
            throw new IllegalArgumentException("La edad debe ser mayor a 0.");
        }
    }
    
    @Override
    public String toString(){
        return "CURP: "+ curp+ " | Nombre: "+ nombres + "" + apellidos + " | Edad:" +edad+ " | Rol:" + tipodeUsuario; 
    }
}
