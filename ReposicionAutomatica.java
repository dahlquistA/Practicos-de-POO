import java.util.*;
import java.io.*;
/**
 * Write a description of class ReposicionAutomatica here.
 * 
 * @author ANALUZ DAIANA DAHLQUIST ARANA 
 * @version 1.0
 */
public class ReposicionAutomatica
{
    public static void main (String [] args)
    {
        //variables de LABORATORIO:
        String nombre = " ";
        String domicilio = " ";
        String telefono = " ";
        int compraMin = 0;
        int diaEntrega = 0;
        long tamreg = 58; // tamaño de registro
        long canreg = 0; // cantidad de registros
            
        //VARIABLE DE PRODUCTO                
        int codProd = 0;    
        String rubro = "";
        String descripcion = "";
        int existMin = 0;
        double porcPntoRepo = 0.0;
        int stock =0;
        double precio = 0.0;
        int codigoLab = 0;
        
        //variable deL ARCHIVO DE SOLICITU DE COMPRA "comprar_AAAAMMDD"        
        int cantidadCompra = 0;
        double montoCompra = 0.0;
        char razon = 'N';
        int f = 0;
        int p = 0;
        double importeTotal = 0.0;
        
        BufferedReader teclado = new BufferedReader (new InputStreamReader (System.in));
        Calendar fechaActual = Calendar.getInstance();
        try
        {   //Archivo comprar_AAAMMDD.txt que guarda el proceso de solicitudes de compra                      
            FileOutputStream compraFOS = new FileOutputStream ("compra"+fechaActual+".dat",true);
            DataOutputStream compraDOS = new DataOutputStream (compraFOS);     
                      
            FileOutputStream archiFIS = new FileOutputStream ("producto.dat", true);
            DataOutputStream archiDIS = new DataOutputStream (archiFIS); 
            
            //Modo acceso directo
            RandomAccessFile archi = new RandomAccessFile("laboratorio.dat","r");
            //calculando cantidad de registros
            canreg = archi.length()/tamreg;
              
            //BUCLE QUE LEE TODOS LOS REGISTROS DEL ARCHIVO laboratorio.dat
             for (int i = 0; i < canreg; i++)
               {
                   codigoLab = archi.readInt(); 
                 
                   //Lee los String de NOMBRE de a un caracter y concatena:
                    for (int j = 0; j < 30; j++)
                      {
                          nombre = nombre + archi.readChar();
                    }//Fin del for del j (NOMBRE)
                            
                    //Lee los String de DOMICILIO de a un caracter y concatena:
                    for (int k = 0; k < 30; k++)
                            {
                                domicilio = domicilio + archi.readChar();
                            }//Fin del for del k (DOMICILIO)
                            
                   //Lee los String de TELEFONO de a un caracter y concatena:
                    for (int l = 0; l < 30; l++)
                            {
                                telefono = telefono + archi.readChar();
                            }//Fin del for del l (TELEFONO)
                            
                     compraMin = archi.readInt();
                     diaEntrega = archi.readInt();
                            
                    /** System.out.println(" ---------------------------------------------------------------------------- ");
                     System.out.println(" DATOS DEL ARCHIVO PLABORATORIO.DAT: ");
                     System.out.println("CodLab: "+codigoLab+" Nombre: "+nombre+" Domicilio: "+domicilio+" Telefono: "+
                                               telefono + "Compra Minima: "+ compraMin+" Die de Entrega: " + diaEntrega);
                     ystem.out.println(" ---------------------------------------------------------------------------- ");
                     */
                            
                     //INSTANCIACION DE UN OBJETO LABORATORIO:
                     Laboratorio lab = new Laboratorio (nombre,domicilio,telefono,compraMin, diaEntrega);                                 
                     
                     Producto prod = new Producto (codProd,rubro,descripcion,precio,porcPntoRepo,existMin,lab);
                     prod.mostrar();
                            
                            
                     //GRABANDO EL ARCHIVO PRODUCTO.DAT                
                     archiDIS.writeInt(prod.getCodigo());
                     archiDIS.writeUTF(prod.getRubro());
                     archiDIS.writeUTF(prod.getDescripcion());
                     archiDIS.writeDouble(prod.getCosto());
                     archiDIS.writeInt(prod.getStock());
                     archiDIS.writeDouble(prod.getPorcPtoRepo());
                     archiDIS.writeInt(prod.getExistMinima());
                     archiDIS.writeInt(codigoLab);
                            
                             razon = prod.solicitar();
                         if (razon != 'N')
                         {
                            if (razon == 'F')
                            {
                                f = f +1 ;
                               }  
                                else 
                                {
                                    p = p + 1;
                                    }
                                    
                            System.out.println("Producto: "+prod.getDescripcion());
                            
                            lab.mostrar();
                            
                            System.out.println("Cantidad a comprar "+lab.getCompraMinima()+"  paquetes        Dia de entrega: "+lab.getDiaEntrega());
                            System.out.println("--------------------------------------------------------------------" );
                            cantidadCompra = cantidadCompra + 1;
                            importeTotal = importeTotal + (lab.getCompraMinima()* prod.getCosto());
                                
                             compraDOS.writeInt(prod.getCodigo());
                             compraDOS.writeInt(codigoLab);
                             compraDOS.writeInt(lab.getCompraMinima());
                             compraDOS.writeDouble(lab.getCompraMinima() * prod.getCosto());
                             compraDOS.writeChar(razon);
                        
                            }
                
               }//Fin del for del i (REGISTROS DEL ARCHIVO)
                
          archi.close();
          archiDIS.close();
          compraDOS.close();                       
                                             
         }//Fin del try del grabado de productos.dat
                
            
       catch (FileNotFoundException fnfe)
        {
            System.out.println(" > ERROR. Archivo no encontrado<");
        }
        catch (IOException ioe)
        {
            System.out.println(" > Error al grabar <");
        }
        System.out.println("\n ------- FIN DEL PROCESO -------");
    }//Fin del metodo main
}//Fin de la clase ReposicionAutomatica

