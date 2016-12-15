import java.util.ArrayList;
/**
 * Write a description of class ListaTareas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaTareas
{
    // Atributo que guarda un arrayList que contendra objetos de la clase Tarea
    private ArrayList<Tarea> listaDeTareas;

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
        // initialise instance variables
        listaDeTareas = new ArrayList<Tarea>();
    }
    
    public void addTarea(String descripcion){
        Tarea nuevaTarea = new Tarea(descripcion);
        listaDeTareas.add(nuevaTarea);
    }
}
