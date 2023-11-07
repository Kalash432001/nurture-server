package com.bal.asha.nurture.server.app.config.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.common.io.Resources;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

@Slf4j
@Service
public class FirebaseInitializer {
    public FirebaseInitializer() {
        try {
            URL resource = Resources.getResource("firebase/ServiceKey.json");
            FileInputStream serviceAccount = new FileInputStream(resource.getFile());
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

