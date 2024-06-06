
package autoput1;


public final class Dionica {
    private final static int [][] daljinar={{0,36,56,110,148},
                                     {36,0,33,80,116},
                                     {56,33,0,55,93},
                                     {110,80,55,0,40},
                                     {148,116,93,40,0}};
    public static final String [] gradovi={ "Velika Kladuša",
                                "Cazin",
                                "Bihać",
                                "Bosanski Petrovac",
                                "Ključ"};
    
    private int ulaz,izlaz;
    private double prosjecnaBrzina;
    Interval i;    
    
    public Dionica(int ulaz, int izlaz, Sati uSati, Sati iSati) {
        this.ulaz = ulaz;
        this.izlaz = izlaz; 
        i = new Interval(uSati, iSati);
        prosjecnaBrzina=getProsjecnaBrzina();
    }
    
    public int getDistance() throws IllegalArgumentException{
        if (ulaz==izlaz) throw new IllegalArgumentException("Odredište i dolazište je isto!!!");
        return daljinar[ulaz][izlaz];
    }
    public double getVrijemeUSatima() {
            return i.vrijemeUSatima;
        }
    public double getProsjecnaBrzina(){
        return getDistance()/i.vrijemeUSatima;
    }
    @Override
    public String toString() {
        return "\nMjesto ulaska: " + gradovi[ulaz] +
                "\nMjesto izlaska: " + gradovi[izlaz]+
                "\nUkupno pređenih kilometara : " + 
                String.valueOf(this.getDistance()) + i.toString();
    }    
    public String getGrad(int i){
        return gradovi[i];
    }
    private class Interval{
        private Sati ulazak,izlazak;
        private double vrijemeUSatima ;
        public Interval(Sati ulazak, Sati izlazak) {
            this.ulazak = ulazak;
            this.izlazak = izlazak;
            vrijemeUSatima=ulazak.vratiInterval(izlazak);
        }  
        @Override
        public String toString() {
            return "\nVrijeme ulaska: " + ulazak.toString() + 
            "\nVrijeme izlaska: "+ izlazak.toString()+
            "\nProvedeno vrijeme: "+String.format("%02d",(int)(vrijemeUSatima))
                    +":"+String.format("%02d",(int)(vrijemeUSatima*60)%60)+
            "\nProsječna brzina: "+String.format("%.02f",prosjecnaBrzina);
        } 
    }
    
    
}
