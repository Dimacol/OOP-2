package repository;

import java.util.ArrayList;

import entityes.Automat;

public class AutomatRepository {
    private ArrayList<Automat> automatsList = new ArrayList<>();

    public Automat getAutomatById(int id) {
        for (Automat automat : automatsList) {
            if (automat.getId() == id) {
                return automat;
            }
        }

        return null;
    }

    public boolean AddAutomat(Automat automat) {
        if (automatsList.contains(automat)) {
            return false;
        }
        automatsList.add(automat);
        return true;
    }

    public ArrayList<Automat> getAutomatsList() {
        return automatsList;
    }
}
