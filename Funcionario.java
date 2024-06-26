import java.math.BigDecimal;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario() {

    }

    public Funcionario(String nome, String dataNascimento, String funcao, BigDecimal salario) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario(){
        return salario;
    }

    public String getFuncao(){
        return funcao;
    }

    public void setSalario(BigDecimal salario){
        this.salario = salario;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }
}
