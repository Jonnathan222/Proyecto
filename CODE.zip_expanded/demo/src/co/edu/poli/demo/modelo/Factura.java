package co.edu.poli.demo.modelo;

/**
 * Clase que representa una factura.
 * Esta clase permite gestionar el monto de una factura, aplicar descuentos
 * y calcular el monto con impuestos.
 */
public class Factura {

    /**
     * Monto de la factura.
     */
    private double monto;

    /**
     * Constructor que inicializa el monto de la factura.
     *
     * @param monto El monto inicial de la factura.
     */
    public Factura(double monto) {
        this.monto = monto;
    }

    /**
     * Método para obtener el monto de la factura.
     *
     * @return El monto de la factura.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Método para establecer o modificar el monto de la factura.
     *
     * @param monto El nuevo monto de la factura.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Método para aplicar un descuento a la factura.
     * El descuento se aplica sobre el monto actual de la factura.
     * 
     * @param porcentajeDescuento El porcentaje de descuento a aplicar.
     *                            Debe estar entre 0 y 100 (inclusive).
     *                            Si el valor está fuera de este rango, no se aplica el descuento.
     */
    public void aplicarDescuento(double porcentajeDescuento) {
        if (porcentajeDescuento > 0 && porcentajeDescuento <= 100) {
            monto -= monto * (porcentajeDescuento / 100);
        }
    }

    /**
     * Método para calcular el monto total con impuestos.
     * El monto con impuestos se calcula sumando al monto original el porcentaje
     * correspondiente de acuerdo con la tasa de impuesto indicada.
     *
     * @param tasaImpuesto La tasa de impuesto a aplicar.
     *                     Debe ser mayor que 0.
     * @return El monto total con impuestos.
     *         Si la tasa de impuesto es menor o igual a 0, se devuelve el monto original.
     */
    public double calcularMontoConImpuesto(double tasaImpuesto) {
        if (tasaImpuesto > 0) {
            return monto + (monto * tasaImpuesto / 100);
        }
        return monto;
    }

    /**
     * Método para mostrar detalles de la factura.
     * Representa la factura como una cadena, mostrando su monto actual.
     *
     * @return Una representación en forma de cadena del monto de la factura.
     */
    @Override
    public String toString() {
        return "Factura con monto: " + monto;
    }
}

