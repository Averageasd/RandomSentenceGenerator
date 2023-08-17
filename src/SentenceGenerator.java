import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SentenceGenerator {

    List<Production> productionList;

    public SentenceGenerator() {
        this.productionList = new ArrayList<>();
    }

    public void addProduction(Production production) {
        productionList.add(production);
    }

    public Production getProductionWithName(String productionName) {
        List<Production> allProductionsWithVar = new ArrayList<>();
        for (Production production : productionList) {
            if (production.variable.equals(productionName)) {
                allProductionsWithVar.add(production);
            }
        }

        if (allProductionsWithVar.size() == 1) {
            return allProductionsWithVar.get(0);
        }

        List<Double> acummulativeProb = new ArrayList<>();
        for (int i = 0; i < allProductionsWithVar.size(); i++) {
            double cur = allProductionsWithVar.get(i).probability;
            if (acummulativeProb.size() == 0) {
                acummulativeProb.add(cur);
            } else {
                acummulativeProb.add(cur + acummulativeProb.get(i - 1));
            }

        }


        Random random = new Random();
        double randomProb = random.nextDouble() * 90.0 + 10.0;
        for (int i = 0; i < allProductionsWithVar.size(); i++) {
            if (acummulativeProb.get(i) >= randomProb) {
                return allProductionsWithVar.get(i);
            }
        }
        return null;

    }

    public String getGenerateSentence() {
        Production startProduction = productionList.get(0);
        return getSentenceHelper(startProduction);
    }

    public void printProductions() {
        for (Production production : productionList){
            System.out.print(production);
        }
    }

    private String getSentenceHelper(Production s) {
        if (s == null) {
            return "";
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder varName = new StringBuilder();
        Production production;
        int i = 0;
        while (i < s.text.length()) {
            char cur = s.text.charAt(i);
            if (cur != '<') {
                ans.append(cur);
                i++;
            } else {
                for (int k = i; k < s.text.length(); k++) {
                    if (s.text.charAt(k) != '>') {
                        varName.append(s.text.charAt(k));
                    } else {
                        varName.append(s.text.charAt(k));
                        i = k + 1;
                        break;
                    }
                }
                production = getProductionWithName(varName.toString());
                ans.append(getSentenceHelper(production));
                varName = new StringBuilder();
            }
        }
        return ans.toString();
    }
}
