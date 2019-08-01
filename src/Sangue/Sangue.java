/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sangue;

import java.util.ArrayList;
import model.IDAO;

/**
 *
 * @author italo
 */
public class Sangue implements IDAO<Object>{

    private SangueDAO dao;
    private String tipoSanguineo;
    private String fatorRh;
    private int Id;

    public SangueDAO getDao() {
        return dao;
    }

    public void setDao(SangueDAO dao) {
        this.dao = dao;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    public String getFatorRh() {
        return fatorRh;
    }

    public void setFatorRh(String fatorRh) {
        this.fatorRh = fatorRh;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Sangue() {
        this.dao = new SangueDAO(this);
    }
    
    
    @Override
    public void save() {
        this.dao.save();
    }

    @Override
    public void update() {
        this.dao.update();
    }

    @Override
    public void delete() {
        this.dao.delete();
    }

    @Override
    public Object find(int id) {
        return this.dao.find(id);
    }

    @Override
    public ArrayList<Object> get() {
        return this.dao.get();
    }
    
}
