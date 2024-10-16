import javax.swing.JOptionPane;
import java.text.DecimalFormat;

public class Program {

    public static void main(String[] args) {
        // Criação do formatador para duas casas decimais
        DecimalFormat df = new DecimalFormat("#,##0.00");

        // Leitura das entradas
        String rendaSalarioAnualStr = JOptionPane.showInputDialog("Informe a renda anual com salário:");
        double rendaSalarioAnual = Double.parseDouble(rendaSalarioAnualStr);

        String rendaPrestacaoServicosStr = JOptionPane.showInputDialog("Informe a renda com prestação de serviços:");
        double rendaPrestacaoServicos = Double.parseDouble(rendaPrestacaoServicosStr);

        String ganhoCapitalStr = JOptionPane.showInputDialog("Informe o ganho de capital:");
        double ganhoCapital = Double.parseDouble(ganhoCapitalStr);

        String gastosMedicosStr = JOptionPane.showInputDialog("Informe os gastos médicos:");
        double gastosMedicos = Double.parseDouble(gastosMedicosStr);

        String gastosEducacionaisStr = JOptionPane.showInputDialog("Informe os gastos educacionais:");
        double gastosEducacionais = Double.parseDouble(gastosEducacionaisStr);

        // Cálculo do imposto
        double rendaMensalSalario = rendaSalarioAnual / 12;
        double impostoSalario = calcularImpostoSalario(rendaMensalSalario);
        double impostoPrestacaoServicos = 0.15 * rendaPrestacaoServicos;
        double impostoGanhoCapital = 0.20 * ganhoCapital;

        double impostoBrutoDevido = impostoSalario + impostoPrestacaoServicos + impostoGanhoCapital;
        double abatimentoMaximo = 0.30 * impostoBrutoDevido;
        double abatimento = Math.min(abatimentoMaximo, gastosMedicos + gastosEducacionais);

        double impostoFinal = impostoBrutoDevido - abatimento;

        // Exibição do relatório com formatação
        String mensagem = "Relatório de Imposto de Renda:\n"
                + "Imposto sobre salário: R$ " + df.format(impostoSalario) + "\n"
                + "Imposto sobre prestação de serviços: R$ " + df.format(impostoPrestacaoServicos) + "\n"
                + "Imposto sobre ganho de capital: R$ " + df.format(impostoGanhoCapital) + "\n"
                + "Abatimento com gastos médicos e educacionais: R$ " + df.format(abatimento) + "\n"
                + "Imposto final devido: R$ " + df.format(impostoFinal);

        JOptionPane.showMessageDialog(null, mensagem, "Relatório de Imposto de Renda", JOptionPane.INFORMATION_MESSAGE);
    }

    // Função para calcular o imposto sobre salário
    public static double calcularImpostoSalario(double rendaMensalSalario) {
        if (rendaMensalSalario < 3000) {
            return 0; // Isento
        } else if (rendaMensalSalario < 5000) {
            return 0.10 * rendaMensalSalario;
        } else {
            return 0.20 * rendaMensalSalario;
        }
    }
}