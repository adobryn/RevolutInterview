import java.util.ArrayList;
import java.util.Random;

public class LoadBalancer {
    private int currentAmountOfInstances;
    private ArrayList<String> instancesArray;

    public int getCurrentAmountOfInstances() {
        return currentAmountOfInstances;
    }


    public LoadBalancer() {
        this.currentAmountOfInstances = 0;
        this.instancesArray = new ArrayList<>();
    }

    void registerNewInstance(String address) throws IllegalArgumentException{
        if(currentAmountOfInstances == 10) {
            throw new IllegalArgumentException("Amount of already registered targets is already 10");
        }

        if(!instancesArray.contains(address)){
            instancesArray.add(address);
        }
        currentAmountOfInstances++;
    }

    public ArrayList<String> getInstancesArray() {
        return instancesArray;
    }

    public String getInstance(){
        Random r = new Random();
        int randomIndex = r.nextInt(currentAmountOfInstances - 1);
        return instancesArray.get(randomIndex);
    }
}
