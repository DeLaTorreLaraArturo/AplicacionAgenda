import java.util.LinkedList;

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
}