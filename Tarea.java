import java.time.LocalDate;
import java.time.format.*;
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
    //Atributo que define la prioridad de una tarea
    private int prioridad;
    //Atributo que indica la fecha de vencimiento de la tarea
    private LocalDate fechaVencimiento;
    //Atributo que indica el id de la tarea
    private int id;

    /**
     * Constructor for objects of class Tarea
     */
    public Tarea(String nombre, int id)
    {
        // initialise instance variables
        descripcion = nombre;
        completada = false;
        prioridad = 0;
        fechaVencimiento = null;
        this.id = id;
    }
    
    public String verTarea(){
        return descripcion;
    }
    
    public boolean verTareaCompletada(){
        return completada;
    }
    
    public void marcarTareaCompletada(){
        completada = true;
    }
    
    public String toString()
    {
        String textoADevolver = "";
        if (completada){
            textoADevolver += "HECHA ";
        }
        String fechaVencimiento = "" + this.fechaVencimiento;
        if (this.fechaVencimiento == null){
            fechaVencimiento = "";
        }
        else{
            fechaVencimiento = getFechaVencimiento();
        }
        textoADevolver += id + ". " + descripcion + " (Prioridad: " + prioridad + ") " + "Fecha de vencimiento: " + fechaVencimiento;
        return textoADevolver;
    }
    
    public void setPrioridad(int nuevaPrioridad)
    {
        if (nuevaPrioridad >= 0 && nuevaPrioridad <= 5){
            prioridad = nuevaPrioridad;
        }
    }
    
    public void setFechaVencimiento(int anio, int mes, int dia)
    {
        fechaVencimiento = LocalDate.of(anio, mes, dia);
    }
    
    public String getFechaVencimiento()
    {
        String fecha = "";
        if (fechaVencimiento != null){
            String dia = "" + fechaVencimiento.getDayOfMonth();
            String mes = "" + fechaVencimiento.getMonthValue();
            String anio = "" + fechaVencimiento.getYear();
            fecha = dia + "-" + mes + "-" + anio;
        }
        return fecha;
    }
    
    public LocalDate getFecha()
    {
        return fechaVencimiento;
    }
    
    public int obtenerPrioridad()
    {
        return prioridad;
    }
    
    public int getId()
    {
        return id;
    }

}
















