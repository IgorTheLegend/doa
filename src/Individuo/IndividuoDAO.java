/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuo;

import database.DBConnection;
import database.MySQLConnection;
import java.util.ArrayList;
import model.IDAO;

/**
 *
 * @author italo
 */
public class IndividuoDAO implements IDAO<Object>{

    protected String table = "Individuos";
    private String baseName = "doa_project";
    private DBConnection database;
    private Individuo individuo;

    public IndividuoDAO(Individuo e) {
        individuo = e;
        database = new MySQLConnection(baseName);
    }
    @Override
    public void save() {
        String fields[] = {
            "nome",
            "cpf",
            "rg",
            "orgaoExp",
            "dataNascimento",
            "uf",
            "doadorMedula",
            "altura",
            "peso",
            "checkUp",
            "telefone",
            "observacoes",
            "sangue_id"
        };
        String values[] = {
            individuo.getNome(),
            individuo.getCpf(),
            individuo.getRg(),
            individuo.getOrgaoExp(),
            individuo.getDataNascimento().toString(),
            individuo.getUf(),
            individuo.getDoadorMedula().toString(),
            individuo.getAltura().toString(),
            individuo.getPeso().toString(),
            individuo.getCheckUp().toString(),
            individuo.getTelefone(),
            individuo.getObservacoes(),
            individuo.getSangue_id()
        };
        database.insert(table, fields, values);
    }

    @Override
    public void update() {
        String fields[] = {
            "nome",
            "cpf",
            "rg",
            "orgaoExp",
            "dataNascimento",
            "uf",
            "doadorMedula",
            "altura",
            "peso",
            "checkUp",
            "telefone",
            "observacoes",
        };
        String values[] = {
            individuo.getNome(),
            individuo.getCpf(),
            individuo.getRg(),
            individuo.getOrgaoExp(),
            individuo.getDataNascimento().toString(),
            individuo.getUf(),
            individuo.getDoadorMedula().toString(),
            individuo.getAltura().toString(),
            individuo.getPeso().toString(),
            individuo.getCheckUp().toString(),
            individuo.getTelefone(),
            individuo.getObservacoes(),
        };
        
        database.update(table, individuo.getCpf(), fields, values);
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Object> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
