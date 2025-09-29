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
    @PostMapping
    public String adicionar(@RequestBody Aluno novo) {
        alunos.add(novo);
        return "Aluno adicionado com sucesso!";
    }

    // PUT – Atualiza os dados de um aluno pelo id
    @PutMapping("/{id}")
    public String atualizar(@PathVariable Long id, @RequestBody Aluno atualizado) {
        for (Aluno a : alunos) {
            if (a.getId().equals(id)) {
                a.setNome(atualizado.getNome());
                return "Aluno atualizado com sucesso!";
            }
        }
        return "Aluno não encontrado.";
    }

    // DELETE – Remove um aluno pelo id
    @DeleteMapping("/{id}")
    public String remover(@PathVariable Long id) {
        boolean removido = alunos.removeIf(a -> a.getId().equals(id));
        return removido ? "Aluno removido com sucesso!" : "Aluno não encontrado.";
    }
}
