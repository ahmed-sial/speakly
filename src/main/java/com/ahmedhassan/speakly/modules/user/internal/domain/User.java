package com.ahmedhassan.speakly.modules.user.internal.domain;

import com.ahmedhassan.speakly.common.shared.domain.UserId;
import lombok.Getter;
import org.jspecify.annotations.NonNull;

import java.time.Instant;

@Getter
public class User {
    private final UserId userId;
    private String fullName;
    private final Email email;
    private String passwordHash;
    private boolean isActive;
    private Instant lastSeen;

    public User(UserId userId, String fullName, Email email, String passwordHash, boolean isActive, Instant lastSeen) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isActive = isActive;
        this.lastSeen = lastSeen;
    }

    public static @NonNull User register(String fullName, String email, String passwordHash) {
        String normalizedName = (fullName == null ? null : fullName.trim());
        if (fullName == null || fullName.isBlank())
            throw new IllegalArgumentException("Full name is required");
        if (passwordHash == null || passwordHash.isBlank())
            throw new IllegalArgumentException("Password is required");
        return new User(
                UserId.generate(),
                normalizedName,
                Email.of(email),
                passwordHash,
                true,
                null
        );
    }

    public void changeFullName(String fullName) {
        var normalizedFullName = (fullName == null ? null : fullName.trim());
        if (normalizedFullName == null || normalizedFullName.isBlank())
            throw new IllegalArgumentException("Full name is required");
        this.fullName = fullName;
    }

   public void activate() {
        if (this.isActive)
            throw new IllegalStateException("User is already active");
        this.isActive = true;
   }

   public void deactivate() {
        if (!this.isActive)
            throw new IllegalStateException("User already inactive");
        this.isActive = false;
   }

   public void changePasswordHash(String passwordHash) {
        if (this.passwordHash == null || passwordHash.isBlank())
            throw new IllegalArgumentException("Password hash is required");
        this.passwordHash = passwordHash;
   }

   public void markSeen(Instant now) {
        this.lastSeen = now;
   }

   // Avoid validation logic when loading existing data
   public static @NonNull User reconstitute(
           UserId userId,
           String fullName,
           Email email,
           String passwordHash,
           boolean isActive,
           Instant lastSeen
   ) {
        return new User(userId, fullName, email, passwordHash, isActive, lastSeen);
   }
}
