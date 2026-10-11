/*
ARIEL VILLA OLIVAREZ
ANGEL EMILIANO REYNOSO LÓPEZ
JULIAN EMMANUEL MENDEZ RODRIGUEZ
 */
package back_end;

public class ListaSimple {
    private NodoU primero;
    private NodoU ultimo;
    
    public void agregarPrincipio(Persona per){
        NodoU nuevo = new NodoU(per);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            nuevo.sig = primero;
            primero = nuevo;
        }
    }
    
    public void agregarFinal(Persona per){
        NodoU nuevo = new NodoU(per);
        if(primero == null){
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
    }
    
    public void agregarPosicion(Persona per, int pos) throws Exception {
        int tam = obtenerTamaño();
        if (pos < 0 || pos > tam) {
            throw new Exception("Posición fuera de rango. La lista tiene " + tam + " elementos.");
        }
        
        if (pos == 0) {
            agregarPrincipio(per);
        } else if (pos == tam) {
            agregarFinal(per);
        } else {
            NodoU nuevo = new NodoU(per);
            NodoU actual = primero;
            for(int i = 0; i < pos - 1; i++){
                actual = actual.sig;
            }
            nuevo.sig = actual.sig;
            actual.sig = nuevo;
        }
    }
    
    public Persona quitarPrincipio(){
        if(primero == null){
            return null;
        }
        
        Persona extraida = primero.getData();
        if (primero == ultimo){
            primero = null;
            ultimo = null;
        } else {
            primero = primero.sig;
        }
        return extraida;
    }
    
    public Persona quitarFinal(){
        if (primero == null){
            return null;
        }
        
        Persona extraida = ultimo.getData();
        if (primero == ultimo){
            primero = null;
            ultimo = null;
        } else {
            NodoU actual = primero;
            while(actual.sig != ultimo){
                actual = actual.sig;
            }
            actual.sig = null;
            ultimo = actual;
        }
        return extraida;
    }
    
    public Persona quitarPosicion(int pos) throws Exception {
        int tam = obtenerTamaño();
        if (pos < 0 || pos >= tam) {
            throw new Exception("Posición fuera de rango. No hay elemento en ese índice.");
        }
        
        if (pos == 0) {
            return quitarPrincipio();
        } else if (pos == tam - 1) {
            return quitarFinal();
        } else {
            NodoU actual = primero;
            for(int i = 0; i < pos - 1; i++){
                actual = actual.sig;
            }
            NodoU aBorrar = actual.sig;
            actual.sig = aBorrar.sig;
            return aBorrar.getData();
        }
    }
    
    public String mostrarPrincipio(){
        if(primero == null){
            return null;
        }
        return primero.getData().toString();
    }
    
    public String mostrarUltimo(){
        if(ultimo == null){
            return null;
        }
        return ultimo.getData().toString();
    }
    
    public String mostrarPosicion(int pos) throws Exception {
        int tam = obtenerTamaño();
        if (pos < 0 || pos >= tam) {
            throw new Exception("Posición fuera de rango.");
        }
        NodoU actual = primero;
        for(int i = 0; i < pos; i++){
            actual = actual.sig;
        }
        return actual.getData().toString();
    }
    
    public String mostrarElementos(){
        String datos = "";
        NodoU actual = primero;
        while(actual != null){
            datos += actual.getData().toString() + "\n----------------\n";
            actual = actual.sig;
        }
        return datos;
    }
    
    public String buscarPorValor(String curpBuscada) {
        NodoU actual = primero;
        int pos = 0;
        while (actual != null) {
            if (actual.getData().curp().equalsIgnoreCase(curpBuscada.trim())) {
                return "Encontrado en la posición [" + pos + "]:\n" + actual.getData().toString();
            }
            actual = actual.sig;
            pos++;
        }
        return null;
    }
    
    public int obtenerTamaño() {
        int contador = 0;
        NodoU actual = primero;
        while(actual != null){
            contador++;
            actual = actual.sig;
        }
        return contador;
    }
}