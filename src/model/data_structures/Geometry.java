package model.data_structures;

import java.util.List;

public class Geometry {
    private String type;
    private List<Double> coordinates;

    public Geometry(String pTipo, List<Double> pCoordenadas){
        type = pTipo;
        coordinates = pCoordenadas;
    }
    public List<Double> DarCoordenadas(){
        return coordinates;
    }
    public void ponerCoordenadas(List<Double> pCoord){
        coordinates = pCoord;
    }
    public String type(){
        return type;
    }
    public void ponerType(String pTipo){
        type = pTipo;
    }

}
