package Controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ControladorFinanceiroTest {
    
    // 0.001 indica a margem de erro
    @Test
    void calcularBilheteriaCorreto() {
        ControladorFinanceiro cf = new ControladorFinanceiro();
        float resultado = cf.calcularBilheteria(100, 50.0f);
        assertEquals(5000.0f, resultado, 0.001);
    }

    @Test
    void calcularBilheteriaPublicoZero() {
        ControladorFinanceiro cf = new ControladorFinanceiro();
        float resultado = cf.calcularBilheteria(0, 50.0f);
        assertEquals(0.0f, resultado, 0.001);
    }

    @Test
    void calcularBilheteriaPrecoZero() {
        ControladorFinanceiro cf = new ControladorFinanceiro();
        float resultado = cf.calcularBilheteria(100, 0.0f);
        assertEquals(0.0f, resultado, 0.001);
    }
}
