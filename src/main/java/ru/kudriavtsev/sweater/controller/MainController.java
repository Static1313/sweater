package ru.kudriavtsev.sweater.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kudriavtsev.sweater.model.Message;
import ru.kudriavtsev.sweater.repository.MessageRepository;

@Controller
public class MainController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping("/demo")
    public @ResponseBody String addMessage(
            @RequestParam("text") String text, @RequestParam("tag") String tag
    ) {
        Message message = new Message();

        message.setText(text);
        message.setTag(tag);
        messageRepository.save(message);

        return "Saved";
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
