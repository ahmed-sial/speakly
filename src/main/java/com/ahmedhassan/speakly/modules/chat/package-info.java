@ApplicationModule(
        displayName = "Chat Module",
        allowedDependencies = {"modules.user :: dto", "common :: entity", "modules :: api"}
)
package com.ahmedhassan.speakly.modules.chat;

import org.springframework.modulith.ApplicationModule;