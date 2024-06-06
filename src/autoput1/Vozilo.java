
package autoput1;

public class Vozilo {
    private String registarskeOznake;    
    private String voziloTip;
    private int voziloTipInt;
    private double cijenaVozila;
    public static String[] vTip={"Motor","Automobil","Autobus","Kamion"};
    public static double[] cijena = {1,1.2,1.5,1.9};

    
    public Vozilo(String registarskeOznake,  int voziloTip) throws IllegalArgumentException{
        this.registarskeOznake = registarskeOznake;        
        this.voziloTip = vTip[voziloTip];
        this.voziloTipInt=voziloTip;
        this.cijenaVozila=cijena[voziloTip];
        if(registarskeOznake.equals("")) throw new 
            IllegalArgumentException("Polje za registarsku oznaku je prazno!!!");
    }
    
    public int getVoziloTipInt() {
        return voziloTipInt;
    }
    
    public double getCijenaVozila() {
        return cijenaVozila;
    }
    @Override
    public String toString() {
        return "Registarske oznake: " + registarskeOznake +
                "\nTip vozila: " + voziloTip;
    }
    
    public void setRegistarskeOznake(String registarskeOznake) {
        this.registarskeOznake = registarskeOznake;
    }
    
    
}
