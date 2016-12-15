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
    
    public void verTareas(){
        int index = 0;
        
        while (index < listaDeTareas.size()){
            String tareaHecha = "";
            if (listaDeTareas.get(index).verTareaCompletada()){
                tareaHecha = " Hecha. ";
            }

            System.out.println((index +1) + ". " + tareaHecha + listaDeTareas.get(index).verTarea());
            index++;
        }
    }
    
    public void marcarTareaCompletada(int posicion){
        if (posicion > 0 && posicion <= listaDeTareas.size()){
            listaDeTareas.get(posicion - 1).marcarTareaCompletada();
        }
    }
}
