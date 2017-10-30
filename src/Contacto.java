public class Contacto {
    private String nombre;
    private String direccion;
    private long telefono; //para que quepa se usa long

    public Contacto(String nom, String dir, long tel)
    {
        if(nom.charAt(0)>= 'a' && nom.charAt(0)<='z' || nom.charAt(0)>= 'A' && nom.charAt(0)<='Z')
        {
            this.nombre = nom;
        }
        else
        {
            RuntimeException ex = new IllegalArgumentException("El nombre debe de iniciar con una letra");
            throw ex;
        }
        dir = dir.trim();
        if (dir.isEmpty())//metodo trim quita los espacios
        {
            throw new IllegalArgumentException("la direccion no debe estar vacia");
        }
        else
        {
            this.direccion = dir;
        }
        //no se puede hacer un cast pues string no es suntipo de long

        String cadTel = Long.toString(tel);
        if(cadTel.length()==10)
        {
            this.telefono = tel;

        }
        else
        {
            throw new IllegalArgumentException("el telefono debe llevar 10 digitos");
        }
    }
    @Override
    public String toString()
    {
        return nombre +","+ direccion + "," +telefono;
    }


}
