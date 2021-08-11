package cinema;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CinemaController {

    Auditorium auditorium;

    CinemaController() {
        auditorium = new Auditorium();
    }

    @GetMapping("/seats")
    public Auditorium getAvailableSeats() {

        return auditorium;
    }

}
