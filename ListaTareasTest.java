

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ListaTareasTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class ListaTareasTest
{
    private ListaTareas listaTar1;

    

    /**
     * Default constructor for test class ListaTareasTest
     */
    public ListaTareasTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        listaTar1 = new ListaTareas();
        listaTar1.addTarea("Hacer la cama");
        listaTar1.addTarea("comprar pan");
        listaTar1.addTarea("estudiar programacion");
        listaTar1.addTarea("Hacer la comida");
        listaTar1.establecerPrioridad(1, 3);
        listaTar1.establecerPrioridad(2, 3);
        listaTar1.establecerPrioridad(3, 1);
        listaTar1.verTareas();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testTareaMasViejaPendiente()
    {
        listaTar1.verTareas();
        listaTar1.marcarTareaCompletada(10);
        listaTar1.marcarTareaCompletada(11);
        listaTar1.marcarTareaCompletada(13);
        assertEquals(12, listaTar1.tareaMasViejaPendiente());
    }

    @Test
    public void testNumeroDeTareasSinTerminar()
    {
    }

    @Test
    public void testHayTareasDuplicadas()
    {
        listaTar1.verTareas();
        assertEquals(false, listaTar1.hayTareasDuplicadas());
        listaTar1.verTareas();
        listaTar1.addTarea("Hacer la cama");
        listaTar1.verTareas();
        assertEquals(true, listaTar1.hayTareasDuplicadas());
    }
}



