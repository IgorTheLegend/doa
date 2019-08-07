/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sangue;

import Individuo.Individuo;
import database.DBConnection;
import database.MySQLConnection;
import java.util.ArrayList;
import model.IDAO;

/**
 *
 * @author italo
 */
public class SangueDAO implements IDAO<Object>{

    protected String table = "Sangues";
    private String baseName = "doa_project";
    private DBConnection database;
    private Sangue sangue;

    public SangueDAO(Sangue e) {
        sangue = e;
        database = new MySQLConnection();
    }
    @Override
    public void save() {
        String fields[] = {"tipoSanguineo", "fatorRh"};
        String values[] = {sangue.getTipoSanguineo(), sangue.getFatorRh()};
        this.database.insert(table, fields, values);
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object find(String tipoSanguineo, String fatorRh) {
        
        ArrayList<String> result = this.getSangue(tipoSanguineo, fatorRh);
        try {
            mapToSangue(sangue, result);
        } catch (NullPointerException ex) {
            sangue = new Sangue();
        }
        return sangue;
    }
    
    public ArrayList<String> getSangue(String tipoSanguineo, String fatorRh) {
        String query = ""
                + "SELECT * from `" 
                + table + "` where `tipoSanguineo`= '"
                + tipoSanguineo +  "' AND `fatorRh`='" + fatorRh + "'";
        ArrayList<ArrayList<String>> rs = database.query(query);
        return rs.size() > 0 ? rs.get(0) : null;
    }

    @Override
    public ArrayList<Object> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mapToSangue(Sangue s, ArrayList<String> result) {
        s.setId(Integer.parseInt(result.get(0)));
        s.setTipoSanguineo(result.get(1));
        s.setFatorRh(result.get(2));
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
