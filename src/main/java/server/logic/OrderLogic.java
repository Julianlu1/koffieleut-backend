package server.logic;


public class OrderLogic {
    public String createCode(int coffeeId, int strength, int milk){
        StringBuilder generatedCode = new StringBuilder();

        if(coffeeId < 10){
            generatedCode.append(0);
        }
        generatedCode.append(coffeeId);
        generatedCode.append(strength);
        generatedCode.append(milk);

        return generatedCode.toString();
    }
}
