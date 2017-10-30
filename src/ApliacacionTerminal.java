import javafx.beans.binding.StringExpression;

import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplicacionTerminal {

    private Agenda agenda;

    public void demo()
    {
        Contacto c1 = new Contacto("Arturo","Muñoz #312",48568972);
        Contacto c2 = new Contacto("Jorge", "Olivos #123", 444421593);
        Contacto c3 =new Contacto("Sergio", "Industrias #122", 487562326);
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void entradaUsuariio()
    {
        Scanner entrada = new Scanner(System.in);
        String opcion= "";

        do{
            try(){
                System.out.println("Opciones: agregar - guardar - imprimir - terminar");
                opcion = entrada.nextLine();

                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "guardar":
                          guardar(entrada);
                          break;
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                }
            }catch (IllegalArgumentException ex){
                System.out.println("ERROR");
                opcion = "";
            }
            catch (InputMismatchException ex) {
                System.out.println("El telefono debe tener");
                opcion="";
            }
            catch (IOException e){
                System.out.println(e.getMessage());
                e.printStackTrace();

            }
        }while(opcion != "terminar");
    }

    private void guardar(Scanner entrada) throws IOException {
        System.out.print("Nombre del archivo: ");
        String nomArchivo = entrada.nextLine();
        agenda.guardar(nomArchivo);
    }

    private void agregar(Scanner entrada){

        System.out.println("Agregar un contacto nuevo");
        System.out.println("Nombre del contacto: ");
        String nombre = entrada.nextLine();
        System.out.println("Direccion: ");
        String direccion = entrada.nextLine();
        System.out.println("Telefono: ");
        long telefono = entrada.nextLong();

        Contacto nuevo = new Contacto(nombre, direccion, telefono);
        agenda.agregaContacto(nuevo);
    }

    public static void main()
    {
        AplicacionTerminal aplicacion = new AplicacionTerminal();

        aplicacion.demo();
        aplicacion.entradaUsuariio();
    }

}
