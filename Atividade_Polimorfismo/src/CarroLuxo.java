public class CarroLuxo extends Carro{

    private int qntAirBags;
    private double tamanhoPortaMalas;
    private boolean temGPS;

    public CarroLuxo(String marca, String modelo, String placa, String ano, double valorLocacao, double valorMulta, int qntAirBags, double tamanhoPortaMalas, boolean temGPS) {
        super(marca, modelo, placa, ano, valorLocacao, valorMulta);
        this.qntAirBags = qntAirBags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.temGPS = temGPS;
    }

    @Override
    public void calcMultaTotal(int numRenovacao) {
        if(numRenovacao > 5) {
            numRenovacao -= 5;
            super.calcMultaTotal(numRenovacao);
        }
    }


    public int getQntAirBags() {
        return qntAirBags;
    }

    public void setQntAirBags(int qntAirBags) {
        this.qntAirBags = qntAirBags;
    }

    public double getTamanhoPortaMalas() {
        return tamanhoPortaMalas;
    }

    public void setTamanhoPortaMalas(double tamanhoPortaMalas) {
        this.tamanhoPortaMalas = tamanhoPortaMalas;
    }

    public boolean isTemGPS() {
        return temGPS;
    }

    public void setTemGPS(boolean temGPS) {
        this.temGPS = temGPS;
    }
}
