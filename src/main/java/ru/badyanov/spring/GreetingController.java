package ru.badyanov.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.badyanov.spring.domain.Message;
import ru.badyanov.spring.repos.MessageRepo;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
                           Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }

    // Урок № 2 - обработка ввода данных
    @PostMapping
    public String add(@RequestParam String text, @RequestParam String tag, Map<String, Object> model) {
        Message message = new Message(text, tag);
        messageRepo.save(message);

        //ToDo: пока что скопировал 2 строчки из метода main. Потом переделать.
        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);

        return "main";
    }
}