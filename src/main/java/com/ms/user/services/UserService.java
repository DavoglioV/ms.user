package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    /**
     * Outro formato de fazer a injeçao do repository é utilizando o @autowired
     * Exemplo:
     * @Autowired
     * private UserRepository userRepository;
     * Como mostrado abaixo:
     * //TODO Entender diferença entre duas opçoes. Em teoria, usando o construtor gera menos acoplamento
     */

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional //Garantimos o rollback em caso de falhas
    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }
    //TODO Validar se já tem o mesmo email criado.
}
