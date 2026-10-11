/*
ARIEL VILLA OLIVAREZ
ANGEL EMILIANO REYNOSO LÓPEZ
JULIAN EMMANUEL MENDEZ RODRIGUEZ
 */
package back_end;

public class NodoU {
    private Persona data;
    public NodoU sig;

    public NodoU(Persona data) {
        this.data = data;
    }

    public Persona getData() {
        return data;
    }

    public void setData(Persona data) {
        this.data = data;
    }
    
    
}



