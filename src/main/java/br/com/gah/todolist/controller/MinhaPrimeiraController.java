package br.com.gah.todolist.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gah.todolist.user.UserModel;

@RestController
@RequestMapping("/primeiraRota")
// http://localhost:8080/ --------
public class MinhaPrimeiraController {

    /**
     * Métodos de acesso HTTP
     * GET - Buscar uma informação
     * POST - Adicionar um dado/info
     * PUT - Alterar alguma info/dado
     * DELETE - Remover um dado
     * PATCH - Alterar somente uma parte do dado/info
     * 
     */

    // Método (Funcionalidade) de uma classe 
    @GetMapping("/")
    public String primeiraString() {
        return "A bagaça funciona";
    
}

@PostMapping("/")
public void create(@RequestBody UserModel userModel) {
    System.out.println(userModel.getUsername());

    }
}
