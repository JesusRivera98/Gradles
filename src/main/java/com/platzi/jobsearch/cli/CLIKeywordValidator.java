package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Class used by JCommander to validate arguments.
 * <p>
 * In our case we use it to validate that the
 * requested skill (keyword) is only letters and numbers.
 */
public class CLIKeywordValidator implements IParameterValidator {
    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.matches("^[a-zA-Z]+[0-9]*$")) {
            System.err.println("Keyword: " + value + " is not a valid Keyword, keywords must be alphanumeric.\n");
            throw new ParameterException("Only alphanumerics are supported");
        }
    }
}
