package cm.cti.utilisateur.controleur;

import cm.cti.utilisateur.dto.AuthenticationDto;
import cm.cti.utilisateur.dto.LoginDto;
import cm.cti.utilisateur.enums.SecurityConstants;
import cm.cti.utilisateur.exceptions.DAOException;
import cm.cti.utilisateur.exceptions.FormValidationException;
import cm.cti.utilisateur.securities.jwt.JwtService;
import cm.cti.utilisateur.service.impl.UserDetailsServiceImpl;
import cm.cti.utilisateur.service.impl.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthentificationRestController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UtilisateurService userService;

    /**
     * authentification
     * @param user
     * @return AuthenticationDto
     */
    @PostMapping("/authentification")
    public AuthenticationDto  authentification(
            @RequestBody LoginDto user) {
        AuthenticationDto response = new AuthenticationDto();
        List<String> messages = new ArrayList<String>();
        try {
            if(userService.findByUsername(user.getUsername()) != null) {
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
                );
                final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
                response.setPrefix(SecurityConstants.TOKEN_PREFIX);
                response.setJwt(jwtService.generateToken(user, userDetails.getAuthorities()));
            } else throw new FormValidationException("errors.user.username-not-found");
        } catch (NullPointerException e) {
            messages.add(e.getMessage());
        } catch (DAOException e) {
            messages.add(e.getMessage());
        } catch (BadCredentialsException e) {
            messages.add(e.getMessage());
        } catch (FormValidationException e) {
            messages.add(e.getMessage());
        }
        if(!messages.isEmpty()) response.setStatus(HttpStatus.BAD_REQUEST); else response.setStatus(HttpStatus.OK);
        response.setMessages(messages);
        return response;
    }
}
