package empresajava;
public class Presupuesto {
    private int numpresupuesto;
    private String concepto;
    private double preciototal;
    private String estado;

    public Presupuesto(int numpresupuesto, String concepto, double preciototal, String estado) {
        this.numpresupuesto = numpresupuesto;
        this.concepto = concepto;
        this.preciototal = preciototal;
        this.estado = estado;
    }

    public int getNumpresupuesto() {
        return numpresupuesto;
    }

    public void setNumpresupuesto(int numpresupuesto) {
        this.numpresupuesto = numpresupuesto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public void setPreciototal(double preciototal) {
        this.preciototal = preciototal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
