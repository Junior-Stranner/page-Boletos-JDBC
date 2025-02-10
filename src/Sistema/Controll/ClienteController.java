package Sistema.Controll;

import Sistema.Model.Cliente;
import Sistema.Model.Usuario;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ClienteController {

    public static void cadastrarCliente(List<Usuario> usuarios, List<Cliente> clientes) {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o cpf ou email de usário ");
        String cpf_cnpj_email = in.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getCpf_cnpj().equals(cpf_cnpj_email) || usuario.getEmail().equals(cpf_cnpj_email)) {
                Cliente cliente = new Cliente(usuario.getUsuarioId(), usuario.getNome(), usuario.getCpf_cnpj(), usuario.getEmail());
                clientes.add(cliente);
                System.out.println("Usuário convertido em cliente com sucesso!");
                return;
            }
        }
        System.out.println("Usuário com CPF/CNPJ ou email " + cpf_cnpj_email + " não encontrado.");
    }

    public static void mostrarClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Lista de Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.getNome() + " | CPF/CNPJ: " + cliente.getCpf_cnpj() + " | Email: " + cliente.getEmail());
        }
    }

    public static void atualizarCliente(List<Cliente> clientes, String cpfCnpj, String novoNome, String novoEmail) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf_cnpj().equals(cpfCnpj)) {
                cliente.setNome(novoNome);
                cliente.setEmail(novoEmail);
                System.out.println("Dados do cliente atualizados com sucesso!");
                return;
            }
        }
        System.out.println("Cliente com CPF/CNPJ " + cpfCnpj + " não encontrado.");
    }

    public static void deletarCliente(List<Cliente> clientes, String cpfCnpj) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o CPF/CNPJ do usuário que deseja deletar: ");
        String cpf_cnpj = in.nextLine();

        Iterator<Cliente> iterator = clientes.iterator();
        boolean clienteDeletado = false;

        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getCpf_cnpj().equals(cpfCnpj)) {
                iterator.remove();
                clienteDeletado = true;
                System.out.println("Cliente com CPF/CNPJ " + cpfCnpj + " deletado com sucesso.");
                break;
            }
        }
        if (!clienteDeletado) {
            System.out.println("Cliente com CPF/CNPJ " + cpfCnpj + " não encontrado.");
        }
    }
}
