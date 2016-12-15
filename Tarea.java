
/**
 * Write a description of class Tarea here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tarea
{
    // Atributo que guarda una descripcion de la tarea
    private String descripcion;
    //Atributo que gurada si la tarea esta completada
    private boolean completada;

    /**
     * Constructor for objects of class Tarea
     */
    public Tarea(String nombre)
    {
        // initialise instance variables
        descripcion = nombre;
        completada = false;
    }
    
    public String verTarea(){
        return descripcion;
    }
    
    public boolean verTareaCompletada(){
        return completada;
    }


}
