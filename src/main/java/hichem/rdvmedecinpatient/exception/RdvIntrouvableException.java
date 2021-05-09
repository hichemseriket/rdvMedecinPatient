package hichem.rdvmedecinpatient.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RdvIntrouvableException extends Throwable {
    private static final long serialVersionUID = 1L;
    public RdvIntrouvableException(String s)  {
        super(s);
    }
}
