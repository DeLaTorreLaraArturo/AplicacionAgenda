import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Iterator;

public class Agenda {
    private LinkedList<Contacto> contactos;//para un acseso secuencial a los elementos

    public Agenda() {
        contactos = new LinkedList<Contacto>();//viene de la misma interface que
        // array list asi que podemos usar las mismas operaciones en colleccion puedes ver las que quieres tamnien hay
        //en la sub intergace ahi esta el get

    }

    public void agregaContacto(Contacto nuevo) {
        contactos.add(nuevo);

    }

    public void imprimeTodo()
    {
        /**for(i=0;i<=contactos.size();i++)
         {
         System.out.println(contactos.get(i));
         }*/
        //for each sintaxis:  for(Tipo var: coleccion)
        //[ acciones con la variable var que es un objeto]
        for(Contacto c : contactos)
        {
            System.out.println(c);
        }
    }

    public void guardar(String s) throws IOException {
        FileWriter archivo = new FileWriter(s);
        for(Contacto c: contactos)
        {
            archivo.write(c.toString());
            archivo.write("\n");
        }
        archivo.close();
    }

    public void cargar(String nomArchivo) throws FileNotFoundException {
        Scanner archivo = new Scanner(new File(nomArchivo));

        while(archivo.hasNextLine()){
            String Linea = archivo.nextLine();
            //String Linea = archivo.nextLine();
            String [] arreglo = Linea.split(", ");
            System.out.println("Nom: "+ arreglo[0]);
            System.out.println("Dir: "+ arreglo[1]);
            System.out.println("Tel: "+ arreglo[2]);
            long tel = Long.parseLong(arreglo[2].trim());

           Contacto nuevo = new Contacto(arreglo[0], arreglo[1], tel);
           contactos.add(nuevo);
        }
    }

    public void eliminarContacto(long telEliminar) {
    /*    for (Contacto c: contactos) {
            if (telEliminar == c.dimeTel()){
                contactos.remove(c);
                break;
            }

        }*/
    //Un iterador es un objto que nos permite acceder a los elementos de una coleccion uno po runo
        //EL iterador se declara del tipo de dato (objeto) que contiene la coleccion
        Iterator<Contacto> it;

        //El iterador se inicializa por medio del metodo Iterator() de la coleccion
        it = contactos.iterator();

        //El iterador tiene  metodos
        //1. next() - regresa el siguiente elemento d ela coleccion
        //2. hasNext() - verifica si todavia hya elementos en la coleccion
        //3. remove() - elimina el elemento actual de la coleccion
        while (it.hasNext()){
            Contacto c = it.next();
            if(telEliminar == c.dimeTel()) {
                it.remove();
            }
            }
        }
    }
}