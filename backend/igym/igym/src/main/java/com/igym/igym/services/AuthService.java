package com.igym.igym.services;


import com.igym.igym.dtos.LoginRequestDTO;
import com.igym.igym.dtos.LoginResponseDTO;
import com.igym.igym.security.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    public LoginResponseDTO login(LoginRequestDTO dto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getSenha())
        );
        UserDetails  userDetails = userDetailsService.loadUserByUsername(dto.getEmail());


        System.out.println("Authorities: " + userDetails.getAuthorities());

        String token = jwtService.generateTokenFromUserDetails(userDetails);
        return new LoginResponseDTO(token);
    }
}
