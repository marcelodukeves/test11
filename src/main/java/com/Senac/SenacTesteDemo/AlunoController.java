package com.Senac.SenacTesteDemo;


import model.Aluno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    // Lista em memória para demonstração
    private final List<Aluno> alunos = new ArrayList<>();

    public AlunoController() {
        // Alunos iniciais
        alunos.add(new Aluno(1L, "João"));
        alunos.add(new Aluno(2L, "Maria"));
    }

    // GET – Retorna a lista de alunos
    @GetMapping
    public List<Aluno> listar() {
        return alunos;
    }

    // POST – Adiciona um novo aluno
    @PostMapping("/{id}")
    public String adicionar(@PathVariable Long id,
                            @RequestBody String novo) {
        alunos.add(new Aluno(id, novo));
        return "Aluno adicionado com sucesso!";
    }

    // PUT – Atualiza os dados de um aluno pelo id
    @PutMapping("/{id}")
    public String atualizar(@PathVariable int id, @RequestBody String atualizado) {

        alunos.get(id).setNome(atualizado);
        Aluno aluno = alunos.get(id);
        return aluno.getNome();

    }

    // DELETE – Remove um aluno pelo id
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        boolean removido = alunos.removeIf(a -> a.getId().equals(id));
        return removido ? "Aluno removido com sucesso!" : "Aluno não encontrado.";
    }
}
