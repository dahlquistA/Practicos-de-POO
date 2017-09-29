import java.util.Calendar;
/**
 * Practico N°4 REUTILIZACIÓN del programa que crea y modela la
 *                              información básica de un Laboratorio.
 * 
 * @author Analuz Daiana Dahlquist Arana 
 * @version (4.1)
 */
public class Laboratorio{
    private String nombre;
    private String domicilio;
    private String telefono;
    private int compraMinima;
    private int diaEntrega; 
    
    /**Constructor que recibe todos los parámetros declarados.
      */
    public Laboratorio(String p_nombre, String p_domicilio,
                      String p_telefono, int p_compraMin,
                      int p_diaEnt){        
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(p_compraMin);
        this.setDiaEntrega(p_diaEnt);
    }
    
    /**Constructor que NO recibe todos los parámetros declarados 
     * de tipo int. 
      */ 
    public Laboratorio(String p_nombre, String p_domicilio,
                       String p_telefono){
        this.setNombre(p_nombre);
        this.setDomicilio(p_domicilio);
        this.setTelefono(p_telefono);
        this.setCompraMinima(0);
        this.setDiaEntrega(0);
    }
    
    //Inicio de los métodos Setters (mutadores).
    private void setNombre (String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setDomicilio (String p_domicilio){
        this.domicilio = p_domicilio;
    }
    
    private void setTelefono (String p_telefono){
        this.telefono = p_telefono;
    }
    
    private void setCompraMinima (int p_compraMin){
        this.compraMinima = p_compraMin;
    }
    
    private void setDiaEntrega (int p_diaEnt){
        this.diaEntrega = p_diaEnt;
    }
    //Fin de los métodos Setters.
    
    //Inicio de los métodos Getters (observadores).
    /** Devuelve el nombre.
     * @return Una cadena de String.    
     */
    public String getNombre(){
        return this.nombre;
    }
    
    /** Devuelve el domicilio.
     * @return Una cadena de String.     
     */
    public String getDomicilio(){
        return this.domicilio;
    }
    
    /** Devuelve el número de teléfono.
     * @return Una cadena de String.
         */
    public String getTelefono(){
        return this.telefono;
    }
    
    /** Devuelve la compra mínima.
     * @return Un valor de tipo int.
         */
    public int getCompraMinima(){
        return this.compraMinima;
    }
    
    /** Devuelve el día de la entrega.
     * @return Un valor de tipo int.    
     */
    public int getDiaEntrega(){
        return this.diaEntrega;
    }
    //Fin de métodos Getters.
    
    //Inicio de demás métodos
    /** Modifica y/o ajusta la compra mínima.
     * @return no devuelve ningún valor.
     * @param int p_compraMin    
     */
    //Envia el valor al método set para poder modificar el valor de compra mínima.
    public void ajusteCompraMinima(int p_compraMin){
        this.setCompraMinima(p_compraMin);
    }
     
    /** Modifica y/ajusta el día de la entrega.
     * @return No retorna ningún valor.
     * @param int p_diaEnt.    
     */
    //Envía el valor al metodo set para que éste modifique el día de la entrega.
    public void ajusteDiaEntrega(int p_diaEnt){
        this.setDiaEntrega (p_diaEnt);
    }
        
    /** Permite mostrar en pantalla las caracteristica del objeto laboratorio.    
     */
    public void mostrar (){
        System.out.println(" -----------------------------------");
        System.out.println ("Laboratorio: " + this.getNombre());
        System.out.print ("Domicilio: "+ this.getDomicilio());
        System.out.println(" - Telefono: " + this.getTelefono());
        System.out.println(" -----------------------------------\n");
        
    }
   
    public int diasParaEntrega()
    {
        Calendar fechaHoy = Calendar.getInstance();
        return 30 - fechaHoy.get(Calendar.DATE)+ this.getDiaEntrega();
    }
}//Fin de la clase Laboratorio.

