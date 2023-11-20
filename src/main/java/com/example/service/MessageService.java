package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.example.entity.Message;
import com.example.exception.MessageDeleteException;
import com.example.exception.MessageInvalidException;
import com.example.exception.MessageUpdateException;
import com.example.repository.MessageRepository;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public Message createMessage(Message message) throws MessageInvalidException {
        try {

            if (message.getMessage_text().isEmpty() || message.getMessage_text().length() >= 255) {
                throw new MessageInvalidException("Incorrect Message Format");
            }
            return messageRepository.save(message);
        } catch (DataAccessException e) {
            throw new MessageInvalidException(e.getMessage());
        }
    }

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Integer message_id) {
        return messageRepository.findById(message_id).orElse(null);
    }

    public String deleteMessageById(Integer message_id) throws MessageDeleteException {
        messageRepository.findById(message_id).orElseThrow(() -> new MessageDeleteException("Message Not Found"));
        messageRepository.deleteById(message_id);
        return "1";
    }

    public String updateMessageById(Integer message_id, Message message) throws MessageUpdateException {

        if (message.getMessage_text().isEmpty() || message.getMessage_text().length() >= 255)
            throw new MessageUpdateException("Text Message Cannot be empty");

        Message updateMessage = messageRepository.findById(message_id)
                .orElseThrow(() -> new MessageUpdateException("Message Not found"));
        updateMessage.setMessage_text(message.getMessage_text());
        messageRepository.save(message);
        return "1";
    }

    public List<Message> getMessagesByUser(Integer account_id){
        return messageRepository.findByPosted_by(account_id);
    }
}
