package Controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorFinanceiroTest {

    @Test
    void calcularBilheteriaCorretamente() {
        ControladorFinanceiro controlador = new ControladorFinanceiro();
        assertEquals(5000.0f, controlador.calcularBilheteria(100, 50.0f));
    }

    @Test
    void calcularBilheteriaZeroPublico() {
        ControladorFinanceiro controlador = new ControladorFinanceiro();
        assertEquals(0.0f, controlador.calcularBilheteria(0, 50.0f));
    }

    @Test
    void calcularBilheteriaZeroPreco() {
        ControladorFinanceiro controlador = new ControladorFinanceiro();
        assertEquals(0.0f, controlador.calcularBilheteria(100, 0.0f));
    }
}
