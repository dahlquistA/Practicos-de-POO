import java.io.*;
/**
 * Write a description of class CreaProducto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CreaProducto
{
    public static void main (String [] args)
    {
        BufferedReader teclado = new BufferedReader (new InputStreamReader (System.in));
        
        int codProd = 0;
        String rubro = "";
        String descripcion = "";
        int existMin = 0;
        double porcPntoRepo = 0.0;
        int stock =0;
        double precio = 0.0;
        int codigoLab = 0;
        
        
        try 
        {
            FileOutputStream archiFIS = new FileOutputStream ("producto.dat", true);
            DataOutputStream archiDIS = new DataOutputStream (archiFIS);
            
            char resp = 's';            
            while (resp != 'n'&& resp != 'N')
            {
                System.out.print(" Ingrese CODIGO del producto: ");
                codProd = Integer.parseInt(teclado.readLine());
                System.out.print (" Ingrese RUBRO del producto: ");
                rubro = teclado.readLine();
                System.out.print (" Ingrese UNA DESCRIPCION del producto: ");
                descripcion = teclado.readLine();
                System.out.print (" Ingrese EXISTENCIA MINIMA del producto: ");
                existMin = Integer.parseInt(teclado.readLine());
                System.out.print (" Ingrese PORCENTAJE DEL PUNTO DE REPOSICION del producto: ");
                porcPntoRepo = Double.parseDouble(teclado.readLine());
                System.out.print (" Ingrese el STOCK del producto: ");
                stock = Integer.parseInt(teclado.readLine());
                System.out.print(" Ingrese PRECIO del producto: ");
                precio = Double.parseDouble(teclado.readLine());
                System.out.print (" Ingrese el CODIGO DEL LABORATORIO: ");
                codigoLab = Integer.parseInt(teclado.readLine());            
                               
                System.out.print("Ingresar mas productos? (S/N): ");
                resp = teclado.readLine().charAt(0);
                
                //GRABANDO EL ARCHIVO 
                archiDIS.writeInt(codProd);
                archiDIS.writeUTF(rubro);
                archiDIS.writeUTF(descripcion);
                archiDIS.writeDouble(precio);
                archiDIS.writeInt(stock);
                archiDIS.writeDouble(porcPntoRepo);
                archiDIS.writeInt(existMin);
                archiDIS.writeInt(codigoLab);
            }//Fin del while
            archiDIS.close();
        }//Fin del try
        catch(FileNotFoundException fnfe)
        {
             System.out.println("Archivo no encontrado");
        }//Fin del catch
        catch(IOException ioe)
        {
            System.out.println("Error al grabar");
        }//Fin del catch
       
        System.out.println(" ------ FIN DEL GRABADO ------");
    }//Fin del metodo main
}//Fin de la clase CreaProducto
