package com.mybodyfitness.config;

import com.mybodyfitness.model.AdminGeral;
import com.mybodyfitness.model.AdminLocal;
import com.mybodyfitness.model.Utilizador;
import com.mybodyfitness.repository.UtilizadorRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtilizadorDetailsService implements UserDetailsService {

    private final UtilizadorRepository utilizadorRepository;

    public UtilizadorDetailsService(UtilizadorRepository utilizadorRepository) {
        this.utilizadorRepository = utilizadorRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilizador utilizador = utilizadorRepository.findByEmail(email)
            .orElseThrow(() -> new UsernameNotFoundException("Utilizador não encontrado: " + email));

        String role;
        if (utilizador instanceof AdminGeral) {
            role = "ROLE_ADMIN_GERAL";
        } else if (utilizador instanceof AdminLocal) {
            role = "ROLE_ADMIN_LOCAL";
        } else {
            role = "ROLE_CLIENTE";
        }

        return User.builder()
            .username(utilizador.getEmail())
            .password(utilizador.getPassword())
            .authorities(List.of(new SimpleGrantedAuthority(role)))
            .build();
    }
}
