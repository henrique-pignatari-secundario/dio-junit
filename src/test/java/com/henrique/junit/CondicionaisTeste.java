package com.henrique.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class CondicionaisTeste {

    @Test
    @EnabledIfEnvironmentVariable(named = "USER", matches = "henrique")
//    @DisabledIfEnvironmentVariable(named = "USER", matches = "root")
//    @EnabledOnOs(OS.LINUX)
    void validarAlgoSomenteNoUsuarioWylliam(){
        Assertions.assertEquals(10, 5 + 5);
    }
}
