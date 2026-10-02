import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class EmployeeTest {

    private Employee workerUSD;
    private Employee managerEUR;
    private Employee supervisorUSD;

    @BeforeEach
    public void setUp() {
        // Inicialización de objetos antes de la ejecución de cada test
        workerUSD = new Employee(500.0f, "USD", 0.0f, EmployeeType.Worker);
        managerEUR = new Employee(1000.0f, "EUR", 100.0f, EmployeeType.Manager);
        supervisorUSD = new Employee(800.0f, "USD", 100.0f, EmployeeType.Supervisor);
    }

    @Test
    public void testCalculateYearBonusWorker() {
        // Assertion: El bono de un Worker debe ser exactamente la RMU (386.0)
        float expectedBonus = 386.0f;
        assertEquals(expectedBonus, workerUSD.CalculateYearBonus(), 0.01f);
    }

    @Test
    public void testCalculateYearBonusManagerEURWithAssumption() {
        // Assumption: La prueba solo continúa si la moneda NO es USD
        String currency = "EUR";
        assumeTrue(!currency.equals("USD"), "La prueba requiere una moneda distinta de USD");

        // Cálculo esperado: (1000 * 0.95) + 386.0 = 1336.0
        float expectedBonus = 1336.0f;
        assertEquals(expectedBonus, managerEUR.CalculateYearBonus(), 0.01f);
    }

    @Test
    public void testCsSupervisorUSD() {
        int currentMonth = LocalDate.now().getMonthValue();
        float salarioBase = 800.0f + (100.0f * 0.35f); // 835.0
        float expectedCs = (currentMonth % 2 == 0) ? salarioBase : salarioBase + (386.0f / 12 * 2);

        assertEquals(expectedCs, supervisorUSD.cs(), 0.01f);
    }

    @Test
    public void testEmployeeInstantiation() {
        // Assertion: Comprueba que el objeto fue instanciado correctamente
        assertNotNull(workerUSD);
        assertNotNull(managerEUR);
        assertNotNull(supervisorUSD);
    }
}


