package org.jnavarro.junit5app.ejemplos.models;

import org.jnavarro.junit5app.ejemplos.exceptions.DineroInsuficienteException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

class CuentaTest {

    Cuenta cuenta;
    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Inicializando el test..........");
    }

    @BeforeEach
    void initMetodo(TestInfo testInfo, TestReporter testReporter){
        this.cuenta = new Cuenta("pepe", new BigDecimal("1000.12345"));
        this.testInfo = testInfo;
        this.testReporter = testReporter;

        System.out.println("Iniciando el metodo.");
        /*System.out.println("ejecutando: " + testInfo.getDisplayName() + " " +
                testInfo.getTestMethod().get().getName() +
                " con las etiquetas: " + testInfo.getTags());*/

        testReporter.publishEntry("ejecutando: "+ testInfo.getDisplayName() + " "+
                testInfo.getTestMethod().get().getName() +
                " con las etiquetas: "+testInfo.getTags());

    }

    @AfterEach
    void afterEach() {
        System.out.println("Finalizando el metodo test.");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("finalizando el test....");
    }

    @Nested
    @Tag("cuenta")
    @DisplayName("Atributos de cuenta corriente")
    class CuentaTestNombreSaldo {
        @Test
        @DisplayName("Validando nombre cuenta")
        @Disabled
        void testNombreCuenta() {

            String esperado = "pepe";
            String real = cuenta.getPersona();
            //se ocupa la api Assertions para los test
            assertEquals(esperado, real, () -> "El nombre no es el que se esperaba");

            //es lo mismo de arriba practicamente.
            assertTrue(real.equals("pepe"));
        }

        @Test
        void testSaldo() {
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            //compare tu devuelve -1, 0 o 1
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        }

        @Test
        void referenciaCuenta() {
            Cuenta cuenta = new Cuenta("Mikasa Ackerman", new BigDecimal("8900.9997"));
            Cuenta cuenta2 = new Cuenta("Mikasa Ackerman", new BigDecimal("8900.9997"));

            //comparamos por instancia
            //assertNotEquals(cuenta,cuenta2);
            //falla por que son instancias distintas
            assertEquals(cuenta, cuenta2);
        }
    }

    @Nested
    class CuentaOperacionesTest {

        @Test
        @Tag("cuenta")
        void testDebitoCuenta() {
            cuenta.debito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(900, cuenta.getSaldo().intValue());
            assertEquals("900.12345", cuenta.getSaldo().toPlainString());
        }

        @Test
        @Tag("cuenta")
        void testCreditoCuenta() {
            cuenta.credito(new BigDecimal(100));
            assertNotNull(cuenta.getSaldo());
            assertEquals(1100, cuenta.getSaldo().intValue());
        }
    }

    @Test
    void testDineroInsuficienteExceptionCuenta() {
        //metodo assertThrows se ocupara para excepciones devuelve el objeto de excepxion
        Exception exception = assertThrows(DineroInsuficienteException.class, () -> {
            cuenta.debito(new BigDecimal(1500));
        });
        String actual = exception.getMessage();
        String esperado = "Dinero Insuficiente";
        assertEquals(esperado, actual);
    }

    @Test
    void testTransferirDineroCuentas() {
        Cuenta cuenta = new Cuenta("Eren Jaeger", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Mikasa Ackerman", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.setNombre("Banco del Estdo");
        banco.transferir(cuenta2, cuenta, new BigDecimal(500));
        assertEquals("1000.8989", cuenta2.getSaldo().toPlainString());
        assertEquals("3000", cuenta.getSaldo().toPlainString());

    }

    @Test
    void testRelacionesBancoCuentas() {
        Cuenta cuenta = new Cuenta("Eren Jaeger", new BigDecimal("2500"));
        Cuenta cuenta2 = new Cuenta("Mikasa Ackerman", new BigDecimal("1500.8989"));

        Banco banco = new Banco();
        banco.addCuenta(cuenta);
        banco.addCuenta(cuenta2);

        banco.setNombre("Banco del Estado");
        banco.transferir(cuenta2, cuenta, new BigDecimal(500));

        assertAll(
                () -> {
                    assertEquals("1000.8989", cuenta2.getSaldo().toPlainString(),
                            () -> "El nombre no es el que se esperaba");
                }, () -> {
                    assertEquals("3000", cuenta.getSaldo().toPlainString(),
                            () -> "El nombre no es el que se esperaba");
                }, () -> {
                    assertEquals(2, banco.getCuentas().size(),
                            () -> "El nombre no es el que se esperaba");
                }, () -> {
                    assertEquals("Banco del Estado", cuenta.getBanco().getNombre(),
                            () -> "el nombre del banco no es el esperado");
                }, () -> {
                    //probando con stream
                    assertEquals("Eren Jaeger", banco.getCuentas().stream()
                            .filter(c -> c.getPersona().equals("Eren Jaeger"))
                            .findFirst()
                            .get().getPersona(),
                            () -> "El nombre no es el que se esperaba");
                }, () -> {
                    assertTrue(banco.getCuentas().stream()
                            .anyMatch(c -> c.getPersona().equals("Mikasa Ackerman")),
                            () -> "El nombre no es el que se esperaba");
                });


    }

    //clases anidadas
    @Nested
    class SistemaOperativoTest {
        @Test
        @EnabledOnOs(OS.WINDOWS)
        void metodoEnableWindows() {
        }

        @Test
        @EnabledOnOs(OS.MAC)
        void metodoEnableMac() {
        }

        @Test
        @DisabledOnOs(OS.WINDOWS)
        void metodoDisabledWindows() {
        }

        @Test
        @DisabledOnOs(OS.MAC)
        void metodoDisabledMac() {
        }
    }

    @Nested
    class JavaVersionTest {
        @Test
        @DisabledOnJre(JRE.JAVA_8)
        void metodoDisabledJava8() {
        }

        @Test
        @EnabledOnJre(JRE.JAVA_14)
        void metodoDisabledJava14() {
        }
    }

    @Nested
    class SistemPropertiesTest {
        @Test
        void testImprimirSystemProperties() {
            Properties properties = System.getProperties();
            properties.forEach((k,v) -> System.out.println( k + ":" + v));
        }

        @Test
        @EnabledIfSystemProperty(named = "java.version", matches = "13.1.1")
        void testJavaVersion() {
        }

        @Test
        @EnabledIfSystemProperty(named = "os.arcg", matches = ".*32.*")
        void testN064() {
        }

        @Test
        @EnabledIfSystemProperty(named = "user.name", matches = "javie")
        void testUsername() {
        }
    }


    //test para variable de entorno
    //se crea en run/deb configurations
    // -ea -DENV=dev
    @Test
    @EnabledIfSystemProperty(named = "ENV", matches = "dev")
    void testDev() {
    }

    @Test
    void imprimirVariablesAmbiente() {
        Map<String, String> getenv = System.getenv();
        getenv.forEach((k,v) -> System.out.println(k+" = "+v));
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "HOMEDRIVE", matches = "C:")
    void testJavaHome() {
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "NUMBER_OF_PROCESSORS", matches = "12")
    void testProcesadores() {
    }

    //se ejecutara solo cuando no lo ocupamos
    @Test
    void testSaldoDev() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        assumeTrue(esDev);
        this.cuenta = new Cuenta("Eren Jaeger", new BigDecimal("1000.12345"));
        assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
        assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
    }

    @Test
    void testSaldoDev2() {
        boolean esDev = "dev".equals(System.getProperty("ENV"));
        //se pueden hacer pruebas solo si se cumple una condicion
        assumingThat(esDev, () -> {
            assertEquals(1000.12345, cuenta.getSaldo().doubleValue());
            assertFalse(cuenta.getSaldo().compareTo(BigDecimal.ZERO) < 0);
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO) > 0);
        });
    }

    @DisplayName("testDebitoCuentaRepetir")
    @RepeatedTest(value = 3, name = "Repeticion n° {currentRepetition} de {totalRepetitions}}")
    void testDebitoCuentaRepetir(RepetitionInfo info) {

        if (info.getCurrentRepetition() == 2){
            System.out.println("Esta es la repeticion: "+info.getCurrentRepetition());
        }

        cuenta.debito(new BigDecimal(100));
        assertNotNull(cuenta.getSaldo());
        assertEquals(900, cuenta.getSaldo().intValue());
        assertEquals("900.12345", cuenta.getSaldo().toPlainString());
    }

    @Nested
    @Tag("param")
    class PruebasParametrizadas {
        //@ParameterizedTest se puede dejar vacio, o personalizarlo como abajo
        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @DisplayName("testDebitoCuentaParametrizable")
        @ValueSource(strings = {"100", "200", "300", "500", "700","1000"})
        void testDebitoCuenta(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @DisplayName("testDebitoCuentaCsvSource")
        @CsvSource({"1,100", "2,200", "3,300", "4,500", "5,700","6,1000"})
        void testDebitoCuentaCsvSource(String index,String monto) {
            System.out.println(index + " -> "+monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @DisplayName("testDebitoCuentaCsvSource2")
        @CsvSource({"200,100", "250,200", "300,300", "510,500", "750,700","1000.12345,1000.12345"})
        void testDebitoCuentaCsvSource2(String saldo,String monto) {
            System.out.println(saldo + " -> "+monto);
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @DisplayName("testDebitoCuentaCsvFileSource")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
        }

        @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
        @DisplayName("testDebitoCuentaCsvFileSource2")
        @CsvFileSource(resources = "/data.csv")
        void testDebitoCuentaCsvFileSource2(String monto) {
            cuenta.debito(new BigDecimal(monto));
            assertNotNull(cuenta.getSaldo());
            assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
        }
    }

    @Tag("param")
    @ParameterizedTest(name = "numero {index} ejecutando con valor {0} - {argumentsWithNames}")
    @DisplayName("testDebitoCuentaMethodSource")
    @MethodSource("montoList")
    void testDebitoCuentaMethodSource(String monto) {
        cuenta.debito(new BigDecimal(monto));
        assertNotNull(cuenta.getSaldo());
        assertTrue(cuenta.getSaldo().compareTo(BigDecimal.ZERO)>0);
    }

    private static List<String> montoList(){
        return Arrays.asList("100", "200", "300", "500", "700","1000");
    }

    @Nested
    @Tag("timeout")
    class EjemploTimeOut{
        @Test
        @Timeout(5)
        void testTimeOut() throws InterruptedException {
            TimeUnit.SECONDS.sleep(5);
        }

        @Test
        @Timeout(value = 1000,unit = TimeUnit.MILLISECONDS)
        void testTimeOut2() throws InterruptedException {
            TimeUnit.MILLISECONDS.sleep(900);
        }

        @Test
        void testTimeOutAssertions() {
            assertTimeout(Duration.ofSeconds(5),()-> {
                TimeUnit.MILLISECONDS.sleep(4000);
            });
        }
    }

}