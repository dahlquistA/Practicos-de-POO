import java.io.*;
/**
 * Programa ejecutable de laclaseLaboratorio.
 * 
 * @author 1.0
 * @version ANALUZ DAIANA DAHLQUIST ARANA
 */
public class CreaLaboratorio
{
    public static void main(String[] args)
    {
        int codLab = 0;
        String nombre = "";
        String domicilio = "";
        String telefono;
        int compraMin = 0;
        int diaEntrega = 0;         
        int longitudReg = 192;
        
        BufferedReader teclado = new BufferedReader (new InputStreamReader(System.in));
        
        try
        {
            RandomAccessFile arch = new RandomAccessFile("Laboratorio.dat", "rw");
            char opcion = 's';
            while (opcion != 'n' && opcion != 'N')
            {
                System.out.print ("Ingrese nombre del laboratorio: ");
                nombre = teclado.readLine();
                if (nombre.length() < 30)
                {
                    for ( int i = nombre.length(); i <30; i++)
                    {
                        nombre = nombre + " ";
                    }//Fin del for
                }//Fin del if
                else 
                    {
                        nombre = nombre.substring(0,30);
                    }
                    
                System.out.print ("Ingrese el domicilio: ");
                domicilio = teclado.readLine();
                if (domicilio.length() < 30)
                {
                    for ( int i = domicilio.length(); i <30; i++)
                    {
                        domicilio = domicilio + " ";
                    }//Fin del for
                }//Fin del if
                else 
                    {
                        domicilio = domicilio.substring(0,30);
                    }
                    
                System.out.print ("Ingrese el telefono: ");
                telefono = teclado.readLine();
                if (telefono.length() < 30)
                {
                    for ( int i = telefono.length(); i <30; i++)
                    {
                        telefono = telefono + " ";
                    }//Fin del for
                }//Fin del if
                else 
                    {
                        telefono = telefono.substring(0,30);
                    }
                
                System.out.print ("Ingrese compra minima: ");
                compraMin = Integer.parseInt(teclado.readLine()); 
                System.out.print ("Ingrese dia de entrega: ");
                diaEntrega = Integer.parseInt(teclado.readLine());
                
                Laboratorio lab = new Laboratorio (nombre,domicilio,telefono,compraMin,diaEntrega);                
                lab.mostrar();
               
                if (arch.length() != 0)
                {   
                    //El codLab va a ser igual a la cantidad de registros q se hayan cargado
                    //con la facilidad de no perder el ultimo codLab y vuelva a ponerse en 0.
                    codLab = (int)arch.length()/longitudReg;                     
                    arch.seek(arch.length());
                }//Fin del if
                
                arch.writeInt(codLab);
                arch.writeChars(lab.getNombre());
                arch.writeChars(lab.getDomicilio());
                arch.writeChars(lab.getTelefono());
                arch.writeInt(lab.getCompraMinima());
                arch.writeInt(lab.getDiaEntrega());
                
                System.out.println ("CODIGO LABORATORIO: " + codLab);
                System.out.print ("Ingresar mas datos?(S/N): ");
                opcion = teclado.readLine().charAt(0);              
              
            }//Fin del while
            arch.close();            
        }//Findel TRY
        
        catch (FileNotFoundException fnfe)
        {
            System.out.println (" > Archivo no encontrado <");
        }//Fin del catch
        catch (IOException ioe)
        {
            System.out.println (" > Error al escribir <");
        }//Fin del catch
        System.out.println("\n ------ FIN DEL PROGRAMA ------");
    }//Fi del metodo main
}
