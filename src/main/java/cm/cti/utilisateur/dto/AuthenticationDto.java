package cm.cti.utilisateur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationDto implements Serializable{
    private static final long serialVersionUID = 1L;

    private String jwt;
    private String prefix;
    private HttpStatus status;
    private List<String> messages;

}
