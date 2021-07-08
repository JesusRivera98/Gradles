package com.platzi.jobsearch.cli;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * Class used internally by JCommander to validate certain arguments.
 * In our case we use it to stop the parsing of arguments if we find
 * that the help option was requested.
 */
public class CLIHelpValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        boolean actualValue = Boolean.parseBoolean(value);
        if (actualValue) {
            throw new ParameterException("Help passed");
        }
    }
}
