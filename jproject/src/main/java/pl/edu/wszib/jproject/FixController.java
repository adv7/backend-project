package pl.edu.wszib.jproject;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api/fixes")
@AllArgsConstructor
public class FixController {
    private final FixRepository repository;

    @GetMapping("")
    public List<Fix> all() {return repository.findAll();}

    @GetMapping("/{id}")
    public Fix get(@PathVariable("id") long id) {
        List<Fix> fixes = repository.findAll()
                .stream()
                .filter(fix -> fix.getId() == id)
                .collect(Collectors.toList());

        if (!fixes.isEmpty())
            return fixes.get(0);
        else
            return null;
    }

    @PutMapping("")
    public void add(@RequestBody Fix fix) {
        repository.saveFix(fix);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        repository.deleteById(id);
    }
}
