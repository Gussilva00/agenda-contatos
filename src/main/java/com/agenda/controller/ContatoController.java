package com.agenda.controller;

import com.agenda.model.Contato;
import com.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public String listar(@RequestParam(required = false) String busca, Model model) {
        List<Contato> contatos;
        if (busca != null && !busca.isBlank()) {
            contatos = repository.findByNomeContainingIgnoreCase(busca);
        } else {
            contatos = repository.findAll();
        }
        model.addAttribute("contatos", contatos);
        model.addAttribute("busca", busca);
        return "lista";
    }

    @GetMapping("/novo")
    public String novoFormulario(Model model) {
        model.addAttribute("contato", new Contato());
        return "formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Contato contato, RedirectAttributes attrs) {
        boolean isNovo = (contato.getId() == null);
        repository.save(contato);
        attrs.addFlashAttribute("sucesso",
            isNovo ? "Contato cadastrado com sucesso!" : "Contato atualizado com sucesso!");
        return "redirect:/contatos";
    }

    @GetMapping("/editar/{id}")
    public String editarFormulario(@PathVariable Long id, Model model) {
        model.addAttribute("contato", repository.findById(id).orElseThrow());
        return "formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id, RedirectAttributes attrs) {
        repository.deleteById(id);
        attrs.addFlashAttribute("sucesso", "Contato excluído com sucesso!");
        return "redirect:/contatos";
    }
}