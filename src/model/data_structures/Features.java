package model.data_structures;

public class Features {
    private String type;
    private Properties properties;
    private Geometry geometry;

    public Features(String tipo, Properties properties, Geometry geometry){
        this.type = tipo;
        this.properties = properties;
        this.geometry = geometry;
    }
    public String DarTipo(){
        return type;
    }

    public void setTipo(String type) {
        this.type = type;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public Properties DarProperties(){
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Geometry getGeometry(){
        return geometry;
    }

    public Properties getProperties() {
        return properties;
    }
}
