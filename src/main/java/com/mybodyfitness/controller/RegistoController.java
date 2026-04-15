package com.mybodyfitness.controller;

import com.mybodyfitness.model.Utilizador;
import com.mybodyfitness.repository.UtilizadorRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistoController {

    private final UtilizadorRepository utilizadorRepository;
    private final PasswordEncoder passwordEncoder;

    public RegistoController(UtilizadorRepository utilizadorRepository, PasswordEncoder passwordEncoder) {
        this.utilizadorRepository = utilizadorRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registro")
    public String mostrarFormulario() {
        return "registro";
    }

    @PostMapping("/registro")
    public String registar(@RequestParam String nome,
                           @RequestParam String email,
                           @RequestParam String password,
                           Model model) {
        if (utilizadorRepository.existsByEmail(email)) {
            model.addAttribute("erro", "Este email já está registado.");
            return "registro";
        }
        Utilizador novo = new Utilizador(nome, email, passwordEncoder.encode(password));
        utilizadorRepository.save(novo);
        return "redirect:/login?registado=true";
    }
}
