package controller;

import entitiesFunc.Administrador;
import entitiesFunc.Entregador;
import entitiesFunc.Funcionario;
import entitiesFunc.Vendedor;

import java.util.ArrayList;

public class Empresa {
    private ArrayList<Funcionario> funcionarios;

    public Empresa(){
        funcionarios = new ArrayList<>();
    }

    public boolean addFuncionario(Funcionario funcionario){
        if(funcionarios.contains(funcionario)){
            return false;
        }
        funcionarios.add(funcionario);
        return true;
    }

    public boolean removerFuncionario(String nome){
        for(Funcionario funcionario: funcionarios){
            if(funcionario.getNome().equalsIgnoreCase(nome)){
                funcionarios.remove(funcionario);
                return true;
            }
        }
        return false;
    }

    public double fazerPagamento(String nome){
        for(Funcionario func: funcionarios){
            if(func.getNome().equalsIgnoreCase(nome)){
                double salario = func.calcularSalario();
                return salario;
            }
        }
        return 0;
    }

    public void ajustarBonificacoes(Funcionario funcionario, double modificacao) {
        if (funcionario instanceof Administrador) {
            ((Administrador) funcionario).setBonusChefia(modificacao);
        } else if (funcionario instanceof Vendedor) {
            ((Vendedor) funcionario).setComissao(modificacao);
        } else if (funcionario instanceof Entregador) {
            ((Entregador) funcionario).setPericulosidade(modificacao);
        }
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public boolean emitirDetalhamento(String nome){
        for(Funcionario func: funcionarios){
            if(nome.equalsIgnoreCase(func.getNome())){
                func.emitirDetalhamento();
                return true;
            }
        }
        return false;
    }
}
