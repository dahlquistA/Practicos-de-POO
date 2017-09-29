public class Mujer
{   private String nombre ;
    private String apellido;
    private int edad;
    private String estadoCivil;
    private Hombre esposo;
    
    public Mujer (String p_nombre, String p_apellido, int p_edad)
    {   this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Soltera");       
    }
    public Mujer (String p_nombre, String p_apellido, int p_edad, Hombre p_esposo)
    {   this.setNombre(p_nombre);
        this.setApellido(p_apellido);
        this.setEdad(p_edad);
        this.setEstadoCivil("Casada");
        this.setEsposo(p_esposo);
    }    
    // Inicio de los Setters:

    private void setNombre(String p_nombre){
        this.nombre = p_nombre;
    }
    
    private void setApellido(String p_apellido){
        this.apellido = p_apellido;
    }
    
    private void setEdad(int p_edad){
        this.edad = p_edad;
    }
    
    /**
     * Que hago acá si no recibe parámetros?
     *
     */
    private void setEstadoCivil(String p_estado){
        this.estadoCivil = p_estado;
    }

    
    private void setEsposo(Hombre p_esposo)
    {  this.esposo = p_esposo; }
    //Fin de los Setters
    
    // Inicio de los Getters:
    public String getNombre()
    { return this.nombre;   }
    
    public String getApellido()
    {  return this.apellido;  }
    
    public int getEdad()
    {  return this.edad;  }
    
    public String getEstadoCivil()
    {  return this.estadoCivil;  }
    

    public Hombre getEsposo(){
        return this.esposo;
    }
    // Fin de los Getters.
    
    // Inicio de los demás métodos:
    public void casarseCon(Hombre p_esposo){
        if (this.getEsposo() == null){
            this.setEstadoCivil("Casada"); 
            this.setEsposo(p_esposo);
            this.getEsposo().casarseCon(this);            

       }
    }
    
    public void divorcio()
    {
        /*if (this.getEstadoCivil().equals("Casada"))
        {
            this.setEstadoCivil("Divorciada");  
            this.getEsposo().divorcio();                    
            this.setEsposo(null);
        }*/
        if (this.getEsposo()!= null){  
            this.setEstadoCivil("Divorciada");
            this.getEsposo().divorcio(); 
            this.setEsposo( null );
            System.out.println("Te has divorciado tia");
        } 

        
    }
    
    public String datos()
    {
        return (this.getNombre()+" "+this.getApellido()+" de "+
                this.getEdad()+" años");
    }
    
    public void mostrarEstadoCivil()
    {
        System.out.println(this.getNombre()+" "+this.getApellido()+" de "+
                           this.getEdad()+" años - "+this.getEstadoCivil());
    }
    
    public void casadaCon()
    {
        System.out.println(this.getNombre()+" "+this.getApellido()+" de "+
                           this.getEdad()+" años está casada con "+
                           this.getEsposo().datos());
    }
    
} //Fin de la clase Mujer.
