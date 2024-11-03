package br.com.gah.todolist.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import at.favre.lib.crypto.bcrypt.BCrypt;

/**  
 * Modificador
 * public
 * private
 * protected
*/
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private iUserRepository userRepository;
    
    
    /**
     * String (Texto)
     * Integer (int) - Números inteiros
     * Double (double) - Números 0.0000
     * Float (float) - Números 0.000
     * char (A C)
     * Date (data)
     * void 
     */
    /*
     * Body 
     */
    @PostMapping ("/")
    public ResponseEntity create(@RequestBody UserModel userModel) {
        var user = this.userRepository.findByUsername(userModel.getUsername());

        if(user != null) {
            System.out.println("Usuário já existente");
            // Mensagem de erro 
            // Status Code (200 no postman)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existente");
        }

        var passwordHashred = BCrypt.withDefaults()
        .hashToString(12, userModel.getPassword().toCharArray());

        userModel.setPassword(passwordHashred);

        var userCreated = this.userRepository.save(userModel);
        return ResponseEntity.status(HttpStatus.OK).body(userCreated); 
    }
}
