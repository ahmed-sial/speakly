package com.ahmedhassan.speakly.modules.user.internal.domain;

import org.jspecify.annotations.NonNull;

public class User {
    private final UserId userId;
    private String fullName;
    private final Email email;
    private String passwordHash;
    private boolean isActive;

    public User(UserId userId, String fullName, Email email, String passwordHash, boolean isActive) {
        this.userId = userId;
        this.fullName = fullName;
        this.email = email;
        this.passwordHash = passwordHash;
        this.isActive = isActive;
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
                true
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

}
