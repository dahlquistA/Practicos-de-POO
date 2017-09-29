public class Producto 
{ 
    private int codigo;
    private String rubro;
    private String descripcion;
    private double costo;
    private int stock;
    private double porcPtoRepo;
    private int existMinima;
    private Laboratorio laboratorio;
    
    public Producto (int p_codigo, String p_rubro,
                     String p_desc, double p_costo,
                     double p_porcPtoRepo, int p_existMinima,
                     Laboratorio p_lab){
           this.setCodigo(p_codigo);
           this.setRubro(p_rubro);
           this.setDescripcion(p_desc);
           this.setCosto(p_costo);
           this.setStock(0);
           this.setPorcPtoRepo(p_porcPtoRepo);
           this.setExistMinima(p_existMinima);
           this.setLaboratorio(p_lab);
        }
        
    /** Constructor que permite CARGAR los productos
       *ya existentes en el inventario.
       */
      public Producto (int p_codigo, String p_rubro,
                     String p_desc, double p_costo,                     
                     Laboratorio p_lab){
           this.setCodigo(p_codigo);
           this.setRubro(p_rubro);
           this.setDescripcion(p_desc);
           this.setCosto(p_costo);
           this.setStock(0);
           this.setPorcPtoRepo(0.0);
           this.setExistMinima(0);
           this.setLaboratorio(p_lab);
        }
        
    //Inicio de los métodos Setters:
    private void setCodigo (int p_codigo){
        this.codigo = p_codigo;
    }
    private void setRubro (String p_rubro){
        this.rubro = p_rubro;
    }
    private void setDescripcion (String p_desc){
        this.descripcion = p_desc;
    }
    private void setCosto (double p_costo){
        this.costo = p_costo;
    }
    private void setStock (int p_stock){
        this.stock = p_stock;
    }
    private void setPorcPtoRepo (double p_porcPtoRepo){
        this.porcPtoRepo = p_porcPtoRepo;
    }
    private void setExistMinima(int p_existMinima){
        this.existMinima = p_existMinima;
    }
    private void setLaboratorio(Laboratorio p_lab){
        this.laboratorio = p_lab;
    }
    //Fin de los métodos Setters.
    
    //Inicio de los métodos Getters:
    /** Método que muestra el CODIGO 
       * del producto ingresado.
       * @return Un valor de tipo entero.
       */
    public int getCodigo (){
        return this.codigo;
    }
    /** Método que muestra el RUBRO 
       * al que pertenece el producto ingresado.
       *@return Una cadena de String.
       */
    public String getRubro (){
        return this.rubro;
    }
    /** Método que muestra el NOMBRE o
     * descripción del producto se ingresó.
     *@return Una cadena de String.
     */
    public String getDescripcion (){
        return this.descripcion;
    }
    /** Método que muestra el PRECIO COSTO
     * del producto se ingresó.
     *@return Un valor doble.
     */
    public double getCosto (){
        return this.costo;
    }
    /** Método que muestra el STOCK 
     * o inventario.
     *@return Un valor entero.
     */
    public int getStock (){
        return this.stock;
    }
    /** Método que muestra el PORCENTAJE DE  
     * PUNTO DE REPOSICION.
     *@return Un valor doble.
     */
    public double getPorcPtoRepo (){
        return this.porcPtoRepo;
    }
    /** Método que muestra la EXISTENCIA MINIMA 
     * de un producto ingresado.
     *@return Un valor entero.
     */
    public int getExistMinima(){
        return this.existMinima;
    }
    /** Método que permite acceder al atributo Laboratorio.
     *@return Un tipo de dato Laboratorio.
     */
    public Laboratorio getLaboratorio(){
        return this.laboratorio;
    }
    //Fin de los métodos Getters.
    
    //Inicio de los demás métodos:
    /** Método que muestra las CARACTERISTICAS 
     * de un producto ingresado.
     *@return No retorna ningún valor.
     */
    public void mostrar (){
        this.getLaboratorio().mostrar();
        System.out.println("Rubro: "+ this.getRubro());
        System.out.println("Descripcion: "+ this.getDescripcion());
        System.out.println("Precio Costo: "+ this.getCosto());
        System.out.println("Stock: "+ this.getStock() + " - Stock Valorizado: $"
                           +this.stockValorizado()+"\n"); 
    }
    
    /** Método que permite AGREGAR o  
     * QUITAR productos del Stock .
     *@return No retorna ningún valor.
     *@param int p_cantidad.
     */
    public void ajuste(int p_cantidad){             
           this.setStock (this.getStock() + p_cantidad);        
    }
    
    /** Método que devuelve el resultado de
     * multiplicar el Stock por el Precio de Costo
     * mas una rentabilidad del 12%.
     *@return Un valor doble.
     *@param No recibe parámetros.
     */
    public double stockValorizado(){
        double porcentaje = (this.getStock() * this.getCosto()*0.12);        
        return ((this.getStock() * this.getCosto()) + porcentaje);
    }
    
    /** Método que devuelve el resultado de
     *  agregar un 12% al Precio de Costo    
     *@return Un valor doble.
     *@param No recibe parámetros.
     */
    public double precioLista(){
        double porcentaje = (this.getCosto() * 0.12);
        return (this.getCosto() + porcentaje);        
    }
    
    /** Método que devuelve el precio de
     *  pagar al contado (Precio de Lista menos 5%).    
     *@return Un valor doble.
     *@param No recibe parámetros.
     */
    public double precioContado(){
        double porcentaje = (this.precioLista() * 0.05);
        return(this.precioLista() - porcentaje);
    }
    
    /** Método que devuelve el 
     * NOMBRE - PRECIO DE LISTA - PRECIO CONTADO 
     * de un producto.
     *@return Una cadena de String.
     *@param No recibe parámetros.
     */
    public String mostrarLinea(){
        return (this.getDescripcion()+ " " + this.precioLista() + " " + this.precioContado());
    }
    
    /** Método que permite ajustar el Porcentaje
     *  de Punto de Reposición.    
     *@return No retorna ningún valor.
     *@param double p_porce.
     */
    public void ajustarPtoRepo(double p_porce){
        this.setPorcPtoRepo(p_porce);
    }
    
    /** Método que permite ajustar la Existencia
     *  Minima de los productos.    
     *@return No retorna ningún valor.
     *@param int p_cantidad.
     */
    public void ajustarExistMinima(int p_cantidad){
        this.setExistMinima(p_cantidad);
    }       
    
    public char solicitar()
    {
        if (this.getStock() <= this.getLaboratorio().getCompraMinima())
        {
            return 'F';
        } else if (this.getStock() <= this.getPorcPtoRepo()&& this.getStock() <= this.getLaboratorio().diasParaEntrega())
            {
                return 'P';
            } else
                return 'N';
    }
}//Fin de la clase Producto.
