package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Account;
import com.example.entity.Message;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your
 * controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use
 * the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations.
 * You should
 * refer to prior mini-project labs and lecture materials for guidance on how a
 * controller may be built.
 */

@RestController
public class SocialMediaController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private MessageService messageService;

    @PostMapping("register")
    public @ResponseBody ResponseEntity<Account> userRegisterHandler(@RequestBody Account account) {

        Account userAccount = accountService.userRegistration(account);

        return ResponseEntity.status(200).body(userAccount);

    }

    @PostMapping("login")
    public @ResponseBody ResponseEntity<Account> userLoginHandler(@RequestBody Account account) {

        Account userAccount = accountService.userLogin(account);

        return ResponseEntity.status(200).body(userAccount);
    }

    @PostMapping("messages")
    public @ResponseBody ResponseEntity<Message> createMessageHandler(@RequestBody Message message) {
        Message createdMessage = messageService.createMessage(message);

        return ResponseEntity.status(200).body(createdMessage);
    }

    @GetMapping("messages")
    public @ResponseBody ResponseEntity<List<Message>> getAllMessageHandler() {
        return ResponseEntity.status(200).body(messageService.getAllMessages());
    }

    @GetMapping("messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> getMessageByIdHandler(
            @PathVariable(value = "message_id") Integer message_id) {
        return ResponseEntity.ok().body(messageService.getMessageById(message_id));

    }

    @DeleteMapping("messages/{message_id}")
    public @ResponseBody ResponseEntity<String> deleteMessageByIdHandler(
            @PathVariable(value = "message_id") Integer message_id) {
        return ResponseEntity.status(200).body(messageService.deleteMessageById(message_id));
    }

    @PatchMapping("messages/{message_id}")
    public @ResponseBody ResponseEntity<String> updateMessageByIdHandler(
            @PathVariable(value = "message_id") Integer message_id, @RequestBody Message message) {
        return ResponseEntity.status(200).body(messageService.updateMessageById(message_id, message));
    }

    @GetMapping("accounts/{account_id}/messages")
    public @ResponseBody ResponseEntity<List<Message>> getAllMessageByUser(
            @PathVariable(value = "account_id") Integer account_id) {
        return ResponseEntity.status(200).body(messageService.getMessagesByUser(account_id));
    }
}
