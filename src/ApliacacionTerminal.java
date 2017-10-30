import javafx.beans.binding.StringExpression;

import java.util.Scanner;

public class AplicacionTerminal {

    private Agenda agenda;

    public void entradaUsuariio()
    {
        Scanner entrada = new Scanner(System.in);
        String opcion= "";

        do{
            try(){
                System.out.println("Opciones: agregar - imprimir - terminar");
                opcion = entrada.nextLine();

                switch (opcion) {
                    case "agregar":
                        agregar(entrada);
                        break;
                    case "imprimir":
                        agenda.imprimeTodo();
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println("ERROR");
                opcion = "";
            }
        }while(opcion != "terminar");
    }

    private void agregar(Scanner entrada){

        System.out.println("Agregar un contacto nuevo");
        System.out.println("Nombre del contacto: ");
        String nombre = entrada.nextLine();
        System.out.println("Direccion: ");
        String direccion = entrada.nextLine();
        System.out.println("Telefono: ");
        long telefono = entrada.nextLine();

        Contacto nuevo = new Contacto(nombre, direccion, telefono);
        agenda.agregaContacto(nuevo);
    }

    public static void main()
    {
        AplicacionTerminal aplicacion = new AplicacionTerminal();


    }
}
