package ro.mxp.delivery.securities.providers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());
        if (userDetailsService.loadUserByUsername(username) != null) {
            if (passwordEncoder.matches(password, userDetailsService.loadUserByUsername(username).getPassword())) {
                return new UsernamePasswordAuthenticationToken(username, password, userDetailsService.loadUserByUsername(username).getAuthorities());
            } else {
                throw new BadCredentialsException("bad credential!!");
            }
        }
        throw new BadCredentialsException("bad credential!!");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.equals(aClass);
    }
}
