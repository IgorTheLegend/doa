/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Individuo;

import database.DBConnection;
import database.MySQLConnection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");


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
            "altura",
            "doadorMedula",
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
            individuo.getAltura().toString(),
            Integer.toString(individuo.getDoadorMedula() ? 1 : 0),
            individuo.getPeso().toString(),
            Integer.toString(individuo.getCheckUp() ? 1 : 0),
            individuo.getTelefone(),
            individuo.getObservacoes(),
            Integer.toString(individuo.getSangue_id())
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

    public Individuo find(String cpf) {
        ArrayList<String> result = database.find(table, cpf);
        try {
            mapToInviduo(individuo, result);
        } catch (NullPointerException ex) {
            individuo = new Individuo();
        }
        return individuo;
    }
    
    public void mapToInviduo(Individuo e, ArrayList<String> linha) {
        e.setCpf(linha.get(0));
        e.setAltura(Double.parseDouble(linha.get(1)));
        e.setCheckUp(Boolean.parseBoolean(linha.get(0)));
        e.setDataNascimento(linha.get(0));
        e.setDoadorMedula(Boolean.parseBoolean(linha.get(0)));
        e.setNome(linha.get(0));
        e.setObservacoes(linha.get(0));
        e.setOrgaoExp(linha.get(0));
        e.setPeso(Double.parseDouble(linha.get(0)));
        e.setRg(linha.get(0));
        e.setSangue_id(Integer.parseInt(linha.get(0)));
        e.setTelefone(linha.get(0));
        e.setUf(linha.get(0));
    }

    @Override
    public ArrayList<Object> get() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
