package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String username; // [cite: 58]
    private String password; // [cite: 61]
    private String phone;    // [cite: 64]
    private String fullname; // [cite: 67]
    private String email;    // [cite: 69]
    private boolean admin;   // [cite: 71]
    private boolean active;  // [cite: 73]
    private String images;   // [cite: 75]
}