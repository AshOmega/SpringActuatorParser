package com.ActuatorBoot.Controllers;

import com.ActuatorBoot.Impl.ActuatorModel;
import com.ActuatorBoot.Impl.ActuatorParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActuatorController {

    @Value("${actuator.path}")
    String actuatorPath;

    @GetMapping(value = "/httptrace")
    public List<ActuatorModel> getHttptrace()
    {
        ActuatorParser actuatorParser = new ActuatorParser();
        return actuatorParser.getActuatorDetails(actuatorPath);
    }
}
