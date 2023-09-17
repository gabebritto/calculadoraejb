package com.gugawag.pdist.ejb.session;

import com.gugawag.pdist.modelo.Usuario;
import jakarta.ejb.EJB;
import jakarta.ejb.Stateless;


import java.util.List;

@Stateless(name = "usuarioService")
public class UsuarioService {
    @EJB
    private UsuarioDAO usuarioDAO;
    @EJB
    private MensagemService mensagemService;

    public void inserir(long id, String nome) {
        Usuario novoUsuario = new Usuario(id, nome);
        this.usuarioDAO.inserir(novoUsuario);

        if (id == 4) {
            this.mensagemService.inserir(99, "MENSAGEM u4");
        }
        if (id == 5) {
            this.mensagemService.inserir(100, "Mensagem u5");
            throw new RuntimeException("Usuário id 5");
        }
    }

    public List<Usuario> listar() {
        return this.usuarioDAO.listar();
    }
}
