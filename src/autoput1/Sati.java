package autoput1;

public class Sati {
    private final int sati, minute;
    private String vrijeme;
    private int razlika=0;
    
    public Sati (String vrijeme) throws IllegalArgumentException{
        this.vrijeme=vrijeme;
        String [] temp= vrijeme.split(":");
        this.sati = Integer.parseInt(temp[0]);
        this.minute = Integer.parseInt(temp[1]); 
        if (sati>23 || minute>59) throw new 
            IllegalArgumentException("Nije tačno unešeno vrijeme");
    }    
   
    private double vratiMinute (int min1, int min2){
        int rez = 0;
        if (min1>min2){
            rez= (60-min1) + min2;
            razlika = -1;
        }
        else rez = min2-min1;        
        return rez;
    }
    
    public double vratiInterval(Sati ulaz, Sati izlaz) throws IllegalArgumentException {        
        double rez = 0;
        if(ulaz.equals(izlaz)) throw 
                new IllegalArgumentException("Vremena su ista!!!");
        if (ulaz.sati>=izlaz.sati && ulaz.minute>izlaz.minute ){            
            rez= (izlaz.sati+24) - ulaz.sati + 
                    (vratiMinute(ulaz.minute, izlaz.minute)/60) + razlika;           
        }
        else {
            rez=izlaz.sati - ulaz.sati + 
                    (vratiMinute(ulaz.minute, izlaz.minute)/60) + razlika;
        }
        return rez;        
    } 
    @Override
    public String toString() {
        return vrijeme;
    }
    public double vratiInterval(Sati other){
        return vratiInterval(this, other);
    }

    @Override
    public boolean equals(Object obj) {
        Sati temp=(Sati)obj;        
        return this.minute==temp.minute && this.sati == temp.sati; 
    }
}
