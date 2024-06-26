import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


public class Teste {

    public static void main(String args[]) {

        Locale localeBR = new Locale("pt", "BR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", localeBR);

        List<Funcionario> funcionarios = new ArrayList<>();

        Funcionario maria = new Funcionario("Maria", "18/10/2000", "Operador", new BigDecimal("2009.44"));
        Funcionario joao = new Funcionario("João", "12/05/1990", "Operador", new BigDecimal("2284.38"));
        Funcionario caio = new Funcionario("Caio", "02/05/1961", "Coordenador", new BigDecimal("9836.14"));
        Funcionario miguel = new Funcionario("Miguel", "14/10/1988", "Diretor", new BigDecimal("19119.88"));
        Funcionario alice = new Funcionario("Alice", "05/01/1995", "Recepcionista", new BigDecimal("2234.68"));
        Funcionario heitor = new Funcionario("Heitor", "19/11/1999", "Operador", new BigDecimal("1582.72"));
        Funcionario arthur = new Funcionario("Arthur", "31/03/1993", "Contador", new BigDecimal("4071.84"));
        Funcionario laura = new Funcionario("Laura", "08/07/1994", "Gerente", new BigDecimal("3017.45"));
        Funcionario heloisa = new Funcionario("Heloisa", "24/05/2003", "Eletricista", new BigDecimal("1606.85"));
        Funcionario helena = new Funcionario("Helena", "02/09/1996", "Gerente", new BigDecimal("2799.93"));

        //3.1 Inserir todos os funcionários
        funcionarios.add(maria);
        funcionarios.add(joao);
        funcionarios.add(caio);
        funcionarios.add(miguel);
        funcionarios.add(alice);
        funcionarios.add(heitor);
        funcionarios.add(arthur);
        funcionarios.add(laura);
        funcionarios.add(heloisa);
        funcionarios.add(helena);

        //3.2 Remover funcionário João da lista
        funcionarios.remove(joao);

        //3.3 Imprime todos os funcionarios com todas as informações
        for (Funcionario funcionario : funcionarios) {
            System.out.printf(localeBR, "%s | %s | %,.2f | %s %n", funcionario.getNome(),
                    funcionario.getDataNascimento().format(formatter), funcionario.getSalario(),
                    funcionario.getFuncao());
        }

        //3.4 Os funcionarios receberam 10% de aumento de salário
        for (Funcionario funcionario : funcionarios) {
            BigDecimal salario = funcionario.getSalario();
            BigDecimal novoSalario = salario.multiply(new BigDecimal(1.1));
            funcionario.setSalario(novoSalario);
        }

        //3.5 - Não consegui
        
        //3.6 Imprime os funcionarios agrupados por função
        funcionarios.sort(Comparator.comparing(Funcionario::getFuncao));

        for (Funcionario funcionario : funcionarios) {
            System.out.printf(localeBR, "%s | %s | %,.2f | %s %n", funcionario.getNome(),
                    funcionario.getDataNascimento().format(formatter), funcionario.getSalario(),
                    funcionario.getFuncao());
        }

        //3.8 Imprime os funcionarios nascidos no mes 10 E 12
        for (Funcionario funcionario : funcionarios) {
            int mesAniversario = funcionario.getDataNascimento().getMonthValue();
            if (mesAniversario == 10 || mesAniversario == 12){
                System.out.printf(localeBR, "%s | %s | %,.2f | %s %n", funcionario.getNome(),
                    funcionario.getDataNascimento().format(formatter), funcionario.getSalario(),
                    funcionario.getFuncao());
            }
        }

        //3.9 Imprime o funcionario com a maior idade
        String nome = "";
        int idade = 0;
        int anoNascimento = 9999;

        LocalDate dataAtual = LocalDate.now();
        for (Funcionario funcionario : funcionarios) { 
            if (funcionario.getDataNascimento().getYear() < anoNascimento){
                anoNascimento = funcionario.getDataNascimento().getYear();
                nome = funcionario.getNome();
                idade = Period.between(funcionario.getDataNascimento(), dataAtual).getYears();
            }
        }
        System.out.printf("%s - %d anos %n", nome, idade);

        //3.10 Imprimir a lista de funcionarios em ordem alfabetica
        funcionarios.sort(Comparator.comparing(Funcionario::getNome));
        
        for (Funcionario funcionario : funcionarios) {
        System.out.printf(localeBR, "%s | %s | %,.2f | %s %n", funcionario.getNome(),
        funcionario.getDataNascimento().format(formatter), funcionario.getSalario(),
        funcionario.getFuncao());
        }

        //3.11 Imprimir o total dos salários dos funcionarios
        BigDecimal somatoria = new BigDecimal(0);
        for (Funcionario funcionario : funcionarios) {
            somatoria = somatoria.add(funcionario.getSalario());
        }
        System.out.printf(localeBR, "O total dos salários dos funcionários é: %,.2f. %n", somatoria);

        //3.12 Imprimir quantos salarios minimos cada funcionario recebe (Sal. minimo: R$1212,00)
        BigDecimal salarioMinimo = new BigDecimal("1212.00");
        for (Funcionario funcionario : funcionarios) {
            BigDecimal quantidadeSalarios = funcionario.getSalario().divide(salarioMinimo, 2);

            System.out.printf(localeBR, "%s: %,.2f salários mínimos. %n", funcionario.getNome(), quantidadeSalarios);
        }
    }
}