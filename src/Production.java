public class Production {

    String variable;
    String text;
    double probability;

    public Production(double probability, String variable, String text) {
        this.probability = probability;
        this.variable = variable;
        this.text = text;
    }

    @Override
    public String toString() {
        String textDisplay = text;
        if (text.isBlank()){
            textDisplay = "[]";
        }
        return String.format("%.2f %s = %s\n", probability, variable, textDisplay);
    }
}
