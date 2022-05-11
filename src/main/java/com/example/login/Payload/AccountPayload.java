package com.example.login.Payload;

import lombok.Data;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
public class AccountPayload {
    private String username;
    private String password;
    @ElementCollection
    private List<Long> eventList;
}
