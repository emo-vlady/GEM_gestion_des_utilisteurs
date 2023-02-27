package cm.cti.utilisateur.service.impl;

import cm.cti.utilisateur.models.Autorisation;
import cm.cti.utilisateur.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UtilisateurService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Utilisateur user = userService.findByUsername(username);
        if(user==null) throw new UsernameNotFoundException(username);

        Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(Autorisation role : user.getRole().getAutorisations()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
    }

}