package song.sprintbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String greetingTemplate = "Hello, %s!";
    private static final String greetingCasualTemplate = "What up, %s!";

    private final AtomicLong greetingCounter = new AtomicLong();
    private final AtomicLong greetingCasualCounter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

        return new Greeting(greetingCounter.incrementAndGet(), String.format(greetingTemplate, name));
    }

    @GetMapping("/greeting/casual")
    public GreetingCasual greetingCasual(@RequestParam(value = "name", defaultValue = "Bob") String name) {

        return new GreetingCasual(greetingCasualCounter.incrementAndGet(), String.format(greetingCasualTemplate, name));
    }
}
