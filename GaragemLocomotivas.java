import java.util.Arrays;

public class GaragemLocomotivas {
    public Locomotivas [] garagemLocomotivas;
    private int limiteMax;
    private int proximoSlot = 0;
    private int limiteMaxi;
    
    
    public GaragemLocomotivas(int limiteMaxi){
        this.limiteMaxi = limiteMaxi;
         garagemLocomotivas = new Locomotivas[limiteMaxi];
    }

    public void addLocomotiva(Locomotivas locomotiva){
        if(proximoSlot<limiteMaxi){
            garagemLocomotivas[proximoSlot] = locomotiva;
            proximoSlot++;
        }
        else{
            System.out.println("Garagem de locomotivas cheia");
        }
    }

    public Locomotivas removerLocomotivas(){
        if(proximoSlot>0){
            Locomotivas locomotivaRetirada = garagemLocomotivas[proximoSlot-1];
            garagemLocomotivas[proximoSlot-1] = null;
            proximoSlot--;
            return locomotivaRetirada;
        }
        else{
            System.out.println("Não existem mais locomotivas");
            return null;
        }
    }

    @Override
    public String toString() {
        return "GaragemLocomotivas{" +
                "garagemLocomotivas=" + Arrays.toString(garagemLocomotivas) +
                ", limiteMax=" + limiteMax +
                '}';
    }
}
