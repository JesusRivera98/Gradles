package com.platzi.jobsearch;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class CommanderFunctions {

    static <T> JCommander buildCommanderWithName(
            String cliName, Supplier<T> argumentsSupplier
    ) {
        JCommander jCommander = JCommander.newBuilder()
                .addCommand(argumentsSupplier.get())
                .build();
        jCommander.setProgramName(cliName);
        return jCommander;
    }
}
