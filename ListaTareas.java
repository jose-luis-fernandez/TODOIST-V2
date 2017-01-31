import java.util.ArrayList;
import java.time.LocalDate;
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
    //Atributo que guarda el numero de tareas
    private int numeroTareas;

    /**
     * Constructor for objects of class ListaTareas
     */
    public ListaTareas()
    {
        // initialise instance variables
        listaDeTareas = new ArrayList<Tarea>();
        numeroTareas = 10;
    }

    public void addTarea(String descripcion){
        
        Tarea nuevaTarea = new Tarea(descripcion, numeroTareas);
        numeroTareas++;
        listaDeTareas.add(nuevaTarea);
    }

    public void verTareas(){
        for (int index = 0;index < listaDeTareas.size();index++)
        {
            System.out.println(listaDeTareas.get(index));
        }
    }

    public void marcarTareaCompletada(int id){
        int posicionReal = getPosicionById(id);
        if (posicionReal != -1){
            listaDeTareas.get(posicionReal).marcarTareaCompletada();
        }
        
    }

    public void mostrarTareasCoincidentes(String texto){
        int cont = 0;
        int index = 0;

        while (index < listaDeTareas.size()){
            String tareaHecha = "";
            if (listaDeTareas.get(index).verTareaCompletada()){
                tareaHecha = " Hecha. ";
            }

            if (listaDeTareas.get(index).verTarea().contains(texto)){
                System.out.println((index +1) + ". " + tareaHecha + listaDeTareas.get(index).verTarea());
                cont++;
            }
            index++;
        }

        if (cont == 0){
            System.out.println("No hay tareas coincidentes");
        }
        else{
            System.out.println(cont + " tareas encontradas con el texto " + texto);
        }
    }

    public void eliminarTarea(int id){
        int posicionReal = getPosicionById(id);
        if (posicionReal != -1){
            listaDeTareas.remove(posicionReal);
        }
    }

    public void establecerPrioridad(int id, int prioridadNueva)
    {
        int posicionReal = getPosicionById(id);
        if (posicionReal != -1){
            listaDeTareas.get(posicionReal).setPrioridad(prioridadNueva);
        }
    }

    public void fijarFechaVencimiento(int id, int anio, int mes, int dia)
    {
        int posicionReal = getPosicionById(id);
        if (posicionReal != -1){
            listaDeTareas.get(posicionReal).setFechaVencimiento(anio, mes, dia);
        }
    }

    public void mostrarVencidas()
    {
        int posicion = 1;
        LocalDate hoy = LocalDate.now();
        for (Tarea tarea : listaDeTareas){
            if (tarea.getFecha() != null){
                if (tarea.getFecha().isBefore(hoy)){
                    System.out.println(posicion + ", " + tarea.toString());
                }
            }
            posicion++;
        }
    }

    public void verTareaMasPrioritaria()
    {
        int prioridadMaxima = listaDeTareas.get(0).obtenerPrioridad();

        for (Tarea tarea : listaDeTareas){
            if (prioridadMaxima < tarea.obtenerPrioridad()){
                prioridadMaxima = tarea.obtenerPrioridad();
            }
        }

        int posicion = 0;
        while (posicion < listaDeTareas.size()){
            Tarea tareaActual = listaDeTareas.get(posicion);
            if (tareaActual.obtenerPrioridad() == prioridadMaxima){
                System.out.println((posicion + 1) + ". " + tareaActual.toString());
            }

            posicion++;
        }
    }

    public void verTareaMasPrioritaria2(){

        if (listaDeTareas.size() != 0){
            int prioridadMaxima = listaDeTareas.get(0).obtenerPrioridad();
            int posicion = 0;
            Tarea tareaConPrioridadMaxima = null;
            int indice = 0;
            while (posicion < listaDeTareas.size()){
                if (prioridadMaxima < listaDeTareas.get(posicion).obtenerPrioridad()){
                    prioridadMaxima = listaDeTareas.get(posicion).obtenerPrioridad();
                }
                Tarea tareaActual = listaDeTareas.get(posicion);
                if (tareaActual.obtenerPrioridad() == prioridadMaxima){
                    tareaConPrioridadMaxima = tareaActual;
                    indice = posicion;
                }
                posicion++;
            }
            System.out.println((indice + 1) + ". " + tareaConPrioridadMaxima .toString());
        }
    }

    public int getPosicionById(int idBuscada)
    {
        int posicionBuscada = -1;
        int cont = 0;
        boolean buscando = true;
        while ((cont < listaDeTareas.size()) && buscando == true){
            if(idBuscada == listaDeTareas.get(cont).getId()){
                posicionBuscada = cont;
                buscando = false;
            }
            cont++;
        }
        return posicionBuscada;
    }

    public int tareaMasViejaPendiente()
    {
        int idADevolver = -1;
        int cont = 0;
        boolean buscando = true;
        while (cont < listaDeTareas.size() && buscando == true){
            if (listaDeTareas.get(cont).verTareaCompletada() == false){
                idADevolver = listaDeTareas.get(cont).getId();
                buscando = false;
            }
            cont++;
        }
        
        
        return idADevolver;
    }
    
    public int numeroTareasSinTerminar()
    {
        int numeroTareasSinTerminar = 0;
        int cont = 0;
        while (cont < listaDeTareas.size()){
            if (!listaDeTareas.get(cont).verTareaCompletada()){
                numeroTareasSinTerminar++;
            }
            cont++;
        }
        return numeroTareasSinTerminar;
    }
    
    public boolean hayTareasDuplicadas()
    {
        boolean hayTareasDuplicadas = false;
        int cont = 0;
        String tareaActual = "";
        while (cont < listaDeTareas.size() && !hayTareasDuplicadas){
            tareaActual = listaDeTareas.get(cont).verTarea();
            int index = cont +1;
            while (index < listaDeTareas.size() && !hayTareasDuplicadas){
                if (tareaActual.equals(listaDeTareas.get(index).verTarea())){
                    hayTareasDuplicadas = true;
                }
                index++;
            }
            cont++;
        }
        
        return hayTareasDuplicadas;
    }
}
