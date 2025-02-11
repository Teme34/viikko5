package main;

public class Machine {
    private String type;
    private String model;
    private Worker operator;

    public Machine(String type, String model, Worker operator) {
        this.type = type;
        this.model = model;
        this.operator = operator;
    }
// returns correctly formated string for App.java
    public String getMachineDetails() {
        String name = operator.getWorkerName();
        String role = operator.getWorkerRole();
        return type + ", " +  model + "\n" + "Työntekijän tiedot: " + name + ", " + role;
    }
}