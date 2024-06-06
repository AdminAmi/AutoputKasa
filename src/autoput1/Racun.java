
package autoput1;


public class Racun {
   
    private Dionica d;
    private Vozilo v;
    private final double cijenaPokm=0.17;
    private double iznos=0;
    String izvjestaj="Izvještaj za vozilo: \n";

    public Racun(int gUlaz, int gIzlaz, Sati sUlaz, Sati sIzlaz, Vozilo vozilo) 
            throws IllegalArgumentException{       
        this.v=vozilo;        
        d = new Dionica(gUlaz, gIzlaz, sUlaz, sIzlaz);        
        iznos = d.getDistance()*cijenaPokm*v.getCijenaVozila() + kazna();
        izvjestaj= "Izvještaj za vozilo: \n"+
            v.toString() + d.toString() + 
            "\nKazna: " + String.format("%.02f",kazna()) +                
            "\nUkupan iznos za platiti: "+ String.format("%.02f",iznos);
        if (d.getProsjecnaBrzina()>150)  
            izvjestaj+="\nDojavljeno je policiji zbog prebrze vožnje!!!!";        
    }
       
    private double kazna(){
        double rez =0;
        if(d.getProsjecnaBrzina()>130){
            if(d.getProsjecnaBrzina()>150) rez=100.0;
            else rez = 50.0;
        }
        return rez;
    }

    @Override
    public String toString() {
        return izvjestaj;
    }
    
    
    
    
    
    
    
    
    
}
