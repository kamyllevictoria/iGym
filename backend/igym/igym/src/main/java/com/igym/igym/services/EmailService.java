package com.igym.igym.services;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;


    public void enviarEmailDeRecuperacao(String destinatario, String token){
        SimpleMailMessage mensagem = new SimpleMailMessage();
        mensagem.setTo(destinatario);
        mensagem.setSubject("iGym - recuperacao de senha");
        mensagem.setText(
                "Olá!\n\n" +
                "Recebemos uma solicitação para redefinir sua senha no iGym.\n\n" +
                "Seu token de recuperação é: " + token + "\n\n" +
                "Use este token no endpoint /auth/redefinir-senha\n" +
                "O token expira em 30 minutos.\n\n" +
                "Se você não solicitou a recuperação, ignore este email."
        );
        mailSender.send(mensagem);
    }

}
