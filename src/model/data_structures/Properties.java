package model.data_structures;

public class Properties {

    private Integer OBJECTID;

    private String FECHA_HORA;

    private String MEDIO_DETE;

    private String CLASE_VEHI;

    private String TIPO_SERVI;

    private String INFRACCION;

    private String DES_INFRAC;

    private String LOCALIDAD;

    public Integer getOBJECTID() {
        return OBJECTID;
    }

    public void setOBJECTID(Integer oBJECTID) {
        this.OBJECTID = oBJECTID;
    }

    public String getFECHA_HORA() {
        return FECHA_HORA;
    }

    public void setFECHA_HORA(String fECHAHORA) {
        this.FECHA_HORA = fECHAHORA;
    }

    public String getMEDIO_DETE() {
        return MEDIO_DETE;
    }

    public void setMEDIO_DETE(String mEDIODETE) {
        this.MEDIO_DETE = mEDIODETE;
    }

    public String getCLASE_VEHI() {
        return CLASE_VEHI;
    }

    public void setCLASE_VEHI(String cLASEVEHI) {
        this.CLASE_VEHI = cLASEVEHI;
    }

    public String getTIPO_SERVI() {
        return TIPO_SERVI;
    }

    public void setTIPO_SERVI(String tIPOSERVI) {
        this.TIPO_SERVI = tIPOSERVI;
    }

    public String getINFRACCION() {
        return INFRACCION;
    }

    public void setINFRACCION(String iNFRACCION) {
        this.INFRACCION = iNFRACCION;
    }

    public String getDES_INFRAC() {
        return DES_INFRAC;
    }

    public void setDES_INFRAC(String dESINFRAC) {
        this.DES_INFRAC = dESINFRAC;
    }

    public String getLOCALIDAD() {
        return LOCALIDAD;
    }

    public void setLOCALIDAD(String lOCALIDAD) {
        this.LOCALIDAD = lOCALIDAD;
    }

}

/*
    private Integer oBJECTID;
    private String fECHAHORA;
    private String mEDIODETE;
    private String cLASEVEHI;
    private String tIPOSERVI;
    private String iNFRACCION;
    private String dESCINFRAC;
    private String lOCALIDAD;

    public Properties(int pId,String pFecha,String pMedio,String pClase,String pTipo,String pInfraccion,String pDesc,String pLocalidad){
        oBJECTID = pId;
        fECHAHORA = pFecha;
        mEDIODETE = pMedio;
        cLASEVEHI = pClase;
        tIPOSERVI = pTipo;
        iNFRACCION = pInfraccion;
        dESCINFRAC = pDesc;
        lOCALIDAD = pLocalidad;

    }

    public Integer DarObjectID(){
        return oBJECTID;
    }
    public void ponerObjID(Integer Id){
        oBJECTID = Id;
    }
    public void ponerFecha(String pFecha){
        fECHAHORA = pFecha;
    }
    public void ponerClaseVeh(String pClase){
        cLASEVEHI = pClase;
    }
    public void ponerMedioDeteccion(String pMedio){
        mEDIODETE = pMedio;
    }
    public void ponerDescInfracccion(String pDescripcion){
        dESCINFRAC = pDescripcion;
    }
    public void ponerTipoServicio(String pTipoS){
        tIPOSERVI = pTipoS;
    }
    public void ponerLocalidad(String pLocalidad){
        lOCALIDAD = pLocalidad;
    }
    public void ponerInfraccion(String pInfraccion){
        iNFRACCION = pInfraccion;
    }
    public String DarFecha(){
        return fECHAHORA;
    }
    public String DarClaseVeh(){
        return cLASEVEHI;
    }
    public String DarMedioDeteccion(){
        return mEDIODETE;
    }
    public String DarCodInfraccion(){
        return iNFRACCION;
    }
    public String DarDescInfraccion(){
        return dESCINFRAC;
    }
    public String DarTipoServicio(){
        return tIPOSERVI;
    }
    public String DarLocalidad(){
        return lOCALIDAD;
    }

}*/
