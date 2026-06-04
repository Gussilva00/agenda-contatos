package com.agenda.controller;

import com.agenda.model.Contato;
import com.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository repository;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("contatos", repository.findAll());
        return "lista";
    }

    @GetMapping("/novo")
    public String novoFormulario(Model model) {
        model.addAttribute("contato", new Contato());
        return "formulario";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute Contato contato) {
        repository.save(contato);
        return "redirect:/contatos";
    }

    @GetMapping("/editar/{id}")
    public String editarFormulario(@PathVariable Long id, Model model) {
        model.addAttribute("contato", repository.findById(id).orElseThrow());
        return "formulario";
    }

    @GetMapping("/excluir/{id}")
    public String excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/contatos";
    }
}
