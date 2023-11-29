package com.bal.asha.nurture.server.app.tensor.service;

import com.bal.asha.nurture.server.common.exception.NurtureServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;


@Slf4j
@Service
public class TensorService {

    public String getGlobeCoOrdinates() {
        InputStream is = getClass().getResourceAsStream("/tensor/points.json");
        try {
            return new String(is.readAllBytes());
        } catch (IOException e) {
            log.error("Not able to read Co-ordinates", e);
            throw new NurtureServerException("Not able to read Co-ordinates");
        }
    }

}
